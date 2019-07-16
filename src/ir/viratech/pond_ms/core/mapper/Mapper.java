package ir.viratech.pond_ms.core.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Mapper {

    private static Gson gson;

    static {
        gson = new GsonBuilder().create();
    }

    private Mapper() {
    }

    public static <T> Object map(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static <T> Object map(FileReader reader, Class<T> clazz) {
        return gson.fromJson(reader, clazz);
    }

    public static <T> Object map(File file, Class<T> clazz) throws FileNotFoundException {
        FileReader reader = new FileReader(file);
        try {
            return gson.fromJson(new FileReader(file), clazz);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String map(Object object) {
        return gson.toJson(object);
    }
}
