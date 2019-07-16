package ir.viratech.pond_ms.core.db.cli.images;

import ir.viratech.commons.file.cli.FileCli;
import ir.viratech.commons.file.model.AbstractFile;
import ir.viratech.commons.file.model.logic.AbstractFileMgr;
import ir.viratech.commons.model.search.SearchQuery;
import ir.viratech.commons.paged_list.api.PagedList;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImageWaterMark {
    private static File imageHashCode = new File("/opt/PondMS/image_hash_code.txt");
    private static String imageHashCodeAbsolutePath = imageHashCode.getAbsolutePath();
    private long startFrom = 0;
    private int itemPerRequest = 500;

    public static void main(String... args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        ImageWaterMark waterMark = new ImageWaterMark();
        try {
            FileWriter fileWriter = new FileWriter(imageHashCodeAbsolutePath, true);
            List<String> saveList = waterMark.imageHashCodeList(imageHashCode);
            File watermark = new File("/opt/PondMS/watermark");
            if (!watermark.exists()) {
                watermark.mkdir();
            }
            waterMark.getAllImagesFromAbstractFiles(watermark);
            File[] files = watermark.listFiles();
            if (files != null) {
                int length = files.length;
                int i = 0;
                for (File file : files) {
                    try {
                        String baseName = FilenameUtils.getBaseName(file.getAbsolutePath());
                        if (saveList.contains(baseName)) {
                            i++;
                            continue;
                        }
                        i++;
                        String absolutePath = file.getParent();
                        File overlay = new File("/opt/PondMS/logo.png");
                        File pngFile = new File(absolutePath + "2.png");
                        File output = new File(absolutePath + "3.png");
                        waterMark.convertTo("png", file.getAbsoluteFile(), pngFile);
                        waterMark.addImageWatermark(overlay, "png", pngFile, output);
                        waterMark.convertTo(FilenameUtils.getExtension(file.getAbsolutePath()), output, file);
                        if (output.exists())
                            FileUtils.forceDelete(output);
                        if (pngFile.exists())
                            FileUtils.forceDelete(pngFile);
                        waterMark.upload(FilenameUtils.getName(file.getAbsolutePath()), file);
                        fileWriter.write(baseName + "\n");
                        Runtime.getRuntime().gc();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (i == length) {
                    System.out.println("Success");
                } else {
                    System.out.println("Failed!");
                }
            }
            FileUtils.deleteDirectory(watermark);
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addImageWatermark(File watermark, String type, File source, File destination) {
        try {
            BufferedImage image = ImageIO.read(source);
            BufferedImage overlay = resize(ImageIO.read(watermark), image);
            // determine image type and handle correct transparency
            int imageType = "png".equalsIgnoreCase(type) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
            BufferedImage watermarked = new BufferedImage(image.getWidth(), image.getHeight(), imageType);
            // initializes necessary graphic properties
            Graphics2D w = (Graphics2D) watermarked.getGraphics();
            w.drawImage(image, 0, 0, null);
            AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
            w.setComposite(alphaChannel);
            int centerX;
            int centerY;
            Random random = new Random();
            int i = randomOneToFour(random);
            switch (i) {
                case 1:
                    centerX = 5;
                    centerY = 5;
                    break;
                case 2:
                    centerX = 5;
                    centerY = image.getHeight() - overlay.getHeight() - 10;
                    break;
                case 3:
                    centerX = image.getWidth() - overlay.getWidth() - 10;
                    centerY = 5;
                    break;
                default:
                    centerX = image.getWidth() - overlay.getWidth() - 10;
                    centerY = image.getHeight() - overlay.getHeight() - 10;
                    break;
            }
            w.drawImage(overlay, centerX, centerY, null);
            ImageIO.write(watermarked, type, destination);
            w.dispose();
            Runtime.getRuntime().gc();
        } catch (Exception e) {
            System.err.println("Watermark Error!.....");
        }
    }

    private int randomOneToFour(Random random) {
        return random.nextInt((4 - 1) + 1) + 1;
    }

    private BufferedImage resize(BufferedImage img, BufferedImage source) {
        int height = (source.getHeight() / 9);
        int width = ((int) (height * 2.5));
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

    private void convertTo(String type, File inputFile, File outputFile) {
        try {
            BufferedImage bufferedImage = ImageIO.read(inputFile);
            BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
            ImageIO.write(newBufferedImage, type, outputFile);
            Runtime.getRuntime().gc();
        } catch (Exception e) {
            System.err.println("Convert Error!....");
        }
    }


    private void getAllImagesFromAbstractFiles(File watermark) {
        SearchQuery query = new SearchQuery();
        try {
            PagedList<AbstractFile> pageList = AbstractFileMgr.getInstance().search(query);
            long totalSize = pageList.getTotalSize();
            while (startFrom < totalSize) {
                List<AbstractFile> abstractFilesList = pageList.getItems(startFrom, itemPerRequest);
                for (AbstractFile file : abstractFilesList) {
                    try {
                        if (fileCorruptedChecker(file)) continue;
                        File outputFile = new File(watermark, file.getHashCodeString() + "." + FilenameUtils.getExtension(file.getName()));
                        FileCli.writeFile(file, outputFile);
                        Runtime.getRuntime().gc();
                    } catch (Exception ignored) {

                    }
                }
                startFrom += abstractFilesList.size() + 1;
                System.out.println(startFrom + "\t files recovered");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean fileCorruptedChecker(AbstractFile file) {
        boolean flag = false;
        if (file == null) {
            System.out.println("no file was found.");
            flag = true;
        }
        long length = file.getSize();
        if (length == 0) {
            System.out.println("file is corrupted!");
            flag = true;
        }
        return flag;
    }

    private void upload(String hashCode, File changedImage) {
        try {
            hashCode = hashCode.replaceAll(".jpg", "");
            AbstractFile abstractFile = AbstractFileMgr.getInstance().getByHashCodeString(hashCode);
            abstractFile.setContent(Files.readAllBytes(changedImage.toPath()));
            AbstractFileMgr.getInstance().update(abstractFile);
        } catch (Exception e) {
            System.err.println("Upload Error!.....");
        }
    }

    @SuppressWarnings("Duplicates")
    private List<String> imageHashCodeList(File file) {
        String path = file.getAbsolutePath();
        String line;
        List<String> imageHashCode = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (null != (line = bufferedReader.readLine())) {
                imageHashCode.add(line);
            }
            bufferedReader.close();
            Runtime.getRuntime().gc();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + path + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file\t" + path);

        } catch (NumberFormatException e) {
            System.out.println("format number");
        }
        return imageHashCode;
    }


}
