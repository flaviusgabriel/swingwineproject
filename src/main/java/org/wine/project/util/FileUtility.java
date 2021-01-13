package org.wine.project.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.wine.project.Wine;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtility {

    public static void writeToFile(List<Wine> personList){
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        File file = new File("src/main/resources/wineList.json");

        try {
            writer.writeValue(file,personList);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static List<Wine> readFromFile(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = new String(Files.readAllBytes(Paths.get("src/main/resources/wineList.json")));
            List<Wine>subscriptionPlan = mapper.readValue(json, new TypeReference<List<Wine>>(){});

            return subscriptionPlan;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
