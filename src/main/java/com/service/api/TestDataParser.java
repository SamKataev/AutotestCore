package com.service.api;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class TestDataParser {

    public static JsonArray parseTestsFromFile(String filePath) {
        String fileContent = "";
        try {
            fileContent = String.join("\n", Files.readAllLines(Paths.get(filePath)));
        } catch (IOException e) {
            System.out.println("error opening " + filePath);
        }

        if (fileContent.length() > 0 ){
            JsonParser jsonParser = new JsonParser();
            return jsonParser.parse(fileContent).getAsJsonArray();
        }
        return null;
    }

}
