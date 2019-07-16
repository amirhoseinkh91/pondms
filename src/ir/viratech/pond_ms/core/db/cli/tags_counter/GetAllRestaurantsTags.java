package ir.viratech.pond_ms.core.db.cli.tags_counter;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.tags.AllTags;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
@SuppressWarnings("Duplicates")
public class GetAllRestaurantsTags {
    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        try {
            AllTags allTags = new AllTags();
            Set<String> tags = allTags.getAllTagsForRestaurant("Restaurant");
            File file=new File("/opt/PondMS/restaurants_tag.txt");
            FileWriter writer = new FileWriter(file);
            int i = 1;
            for (String tag : tags) {
                writer.write(i++ + "_ " + tag + "\n");
            }
            writer.flush();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
