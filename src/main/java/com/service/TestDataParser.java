package com.service;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.service.http.HttpRequestWrapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TestDataParser {

    public static ArrayList<HttpRequestWrapper> getApiRequestsFromFileContent(String filePath) {
        return getApiRequests(getFileContentAsJsonArray(filePath));
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

    private static ArrayList<HttpRequestWrapper> getApiRequests(JsonArray testData){
        ArrayList<HttpRequestWrapper> list = new ArrayList<>();
        if(testData != null) {
            testData.forEach((el) -> {
                JsonObject testContent = el.getAsJsonObject();
                if(validateTestContent(testContent)) {
                    HttpRequestWrapper request = new HttpRequestWrapper();
                    parseTestContentToApiRequest(request, testContent);
                    list.add(request);
                }else{
                    String testName = testContent.get("name") != null ? testContent.get("name").getAsString() : "name is missing";
                    System.out.println("test \"" + testName + "\", invalid content, can't create request instance \n");
                }
            });
        }
        return list;
    }

    private static boolean validateTestContent(JsonObject content){
        //TODO add regex for props validation
        return content.get("name") != null
                && content.get("url") != null
                && content.get("type") != null
                && content.get("body") != null
                && content.get("headers") != null
                && content.get("code") != null
                && content.get("response") != null;
    }

    private static void parseTestContentToApiRequest(HttpRequestWrapper request, JsonObject content) {
        request.setName(content.get("name").getAsString());
        request.setBody(content.get("body").getAsString());
        request.setType(content.get("type").getAsString());
        request.setUrl(content.get("url").getAsString());
        request.setExpectedStatusCode(content.get("code").getAsInt());
        request.setExpectedResponseBody(content.get("response").getAsString());
        content.get("headers").getAsJsonArray().forEach((el) -> {
            JsonObject header = el.getAsJsonObject();
            request.setHeader(header.get("name").getAsString(), header.get("value").getAsString());
        });
    }

}
