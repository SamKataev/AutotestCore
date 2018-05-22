package com.service.api;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TestDataParser {

    public static ArrayList<ApiRequest> getApiRequestsFromFileContent(String filePath) {
        return getApiRequestsAsArray(getFileContentAsJsonArray(filePath));
    }

    private static JsonArray getFileContentAsJsonArray(String filePath) {
        String fileContent;
        try {
            fileContent = String.join("\n", Files.readAllLines(Paths.get(filePath)));
        }catch(IOException e) {
            System.out.println("error reading " + filePath);
            return null;
        }

        JsonParser jsonParser = new JsonParser();
        try {
            return jsonParser.parse(fileContent).getAsJsonArray();
        }catch (IllegalStateException e) {
            System.out.println("content of \"" + filePath + "\"  is not a JSON Array");
            return null;
        }
    }

    private static ArrayList<ApiRequest> getApiRequestsAsArray(JsonArray testData){
        ArrayList<ApiRequest> list = new ArrayList<>();
        if(testData != null) {
            testData.forEach((el) -> {
                JsonObject obj = el.getAsJsonObject();
                if(validateApiTestJson(obj)) {
                    list.add(new ApiRequest(obj));
                }else{
                    String testName = obj.get("name") != null ? obj.get("name").getAsString() : "name is missing";
                    System.out.println("test \"" + testName + "\", invalid content, can't create request instance");
                }
            });
        }
        return list;
    }

    private static boolean validateApiTestJson(JsonObject obj){
        return obj.get("name") != null
                && obj.get("url") != null
                && obj.get("type") != null
                && obj.get("body") != null
                && obj.get("headers") != null
                && obj.get("code") != null
                && obj.get("response") != null;
    }

}
