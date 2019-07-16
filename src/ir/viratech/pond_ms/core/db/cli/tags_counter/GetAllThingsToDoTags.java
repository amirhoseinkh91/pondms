package ir.viratech.pond_ms.core.db.cli.tags_counter;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.tags.AllTags;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class GetAllThingsToDoTags {
    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        AllTags allTags = new AllTags();
        Set<String> tags = allTags.getAllTagsForThingsToDo("Things_To_Do");
        File file=new File("/opt/PondMS/things_to_do_tags.txt");
        try {
            FileWriter writer = new FileWriter(file);
            int i = 1;
            for (String tag : tags) {
                writer.write(i++ + "_ " + tag + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
