package ir.viratech.pond_ms.api.review;

import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.map_object.vector.logic.GISVectorObjectMgr;
import ir.viratech.pond_ms.model.review.Review;
import ir.viratech.pond_ms.model.review.logic.ReviewMgr;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FindReviewsCount {
    public static void main(String[] args) throws IOException {
        ApplicationContextUtil.initializeCliApplicationContext();
        AbstractEntityDAO.touchSession();

        File file = new File("/opt/PondMS/Review_GisID.txt");
        FileWriter writer = new FileWriter(file.getAbsolutePath(), true);

        List<Review> reviewList = ReviewMgr.getInstance().list();
        for (Review review : reviewList) {
            List<String> list = readList(file);
            if (list.contains(review.getId() + "")) {
                System.out.println(review.getId() + "\t exist!");
                continue;
            }
            String uid = review.getGisVectorObject().getExtuid();
            GISVectorObjectMgr.getInstance().incReviewCountToObject(uid);
            System.out.println("Gis id is:\t" + review.getGisVectorObject().getId());
            String id = review.getId() + "";
            writer.write(id + "\r\n");

        }
        writer.flush();
        writer.close();
    }

    private static List<String> readList(File file) {
        String path = file.getAbsolutePath();
        String line;
        List<String> reviewID = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (null != (line = bufferedReader.readLine())) {
                reviewID.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + path + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file\t" + path);

        } catch (NumberFormatException e) {
            System.out.println("format number");
        }
        return reviewID;
    }

}
