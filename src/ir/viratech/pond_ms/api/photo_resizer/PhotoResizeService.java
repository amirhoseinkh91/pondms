package ir.viratech.pond_ms.api.photo_resizer;

import ir.viratech.commons.file.model.AbstractFile;
import ir.viratech.commons.file.model.logic.AbstractFileMgr;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@SuppressWarnings("All")
public class PhotoResizeService {
    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        getSize(100, 500);
    }

    private static void getSize(int userHeight, int userWidth) {
        try {
            AbstractFile abstractFile = AbstractFileMgr.getInstance().getByHashCodeString("7FV2E2C7YEDKDKLI9XNRLAQNY52OO0ZD89V4BLLR");
            BufferedImage primaryImage = ImageIO.read(abstractFile.getBinaryStream());
            int imageHeight = primaryImage.getHeight();
            int imageWidth = primaryImage.getWidth();
            int imageFactor = greatestCommonFactor(imageWidth, imageHeight);
            int userFactor = greatestCommonFactor(userWidth, userHeight);
            //if image factor = user factors; resize
            //if image factor != user factors; crop
            BufferedImage resizedPhoto = resize(primaryImage, imageHeight, imageWidth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int greatestCommonFactor(int width, int height) {
        return (height == 0) ? width : greatestCommonFactor(height, width % height);
    }

    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

    private static BufferedImage cropImage(BufferedImage src,int height, int width){
        return src.getSubimage(0,0,width,height);
    }

    private static Graphics2D convertImageTo2D(BufferedImage imageToScale, int imageType) {
        int dHeight = imageToScale.getHeight();
        int dWidth = imageToScale.getWidth();
        BufferedImage scaledImage = new BufferedImage(dWidth, dHeight, imageType);
        Graphics2D graphics2D = scaledImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(imageToScale, 0, 0, dWidth, dHeight, null);
        graphics2D.dispose();
        return graphics2D;
    }
}
