package com.service;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.service.http.HttpRequestWrapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CustomJsonParser {

    public static ArrayList<HttpRequestWrapper> getApiRequestsFromFileContent(String filePath) {
        return getApiRequests(getFileContentAsJsonArray(filePath));
    }

    private static JsonArray getFileContentAsJsonArray(String filePath) {
        String fileContent;
        try {
            fileContent = String.join("\n", Files.readAllLines(Paths.get(filePath)));
        } catch (IOException e) {
            System.out.println("error reading " + filePath);
            return null;
        }

        JsonParser jsonParser = new JsonParser();
        try {
            return jsonParser.parse(fileContent).getAsJsonArray();
        } catch (Exception e) {
            System.out.println("errors in content of \"" + filePath + "\", can't read as JSON Array");
            return null;
        }
    }

    private static ArrayList<HttpRequestWrapper> getApiRequests(JsonArray testData) {
        ArrayList<HttpRequestWrapper> list = new ArrayList<>();
        if (testData != null) {
            testData.forEach((el) -> {
                JsonObject testContent = el.getAsJsonObject();
                if (validateTestContent(testContent)) {
                    HttpRequestWrapper request = new HttpRequestWrapper();
                    parseTestContentToApiRequest(request, testContent);
                    list.add(request);
                } else {
                    String testName = testContent.get("name") != null ? testContent.get("name").getAsString() : "name is missing";
                    System.out.println("test \"" + testName + "\", invalid content, can't create request wrapper instance\n");
                }
            });
        }
        return list;
    }

    private static boolean validateTestContent(JsonObject content) {
        //TODO add regex for props validation
        return content.get("name") != null && getStringFromJsonObject("name", content) != null
                && content.get("url") != null && getStringFromJsonObject("url", content) != null
                && content.get("type") != null && getStringFromJsonObject("type", content) != null
                && content.get("body") != null && getJsonObjectFromJsonObject("body", content) != null
                && content.get("headers") != null && getJsonArrayFromJsonObject("headers", content) != null
                && content.get("code") != null && getIntFromJsonObject("code", content) != 0
                && content.get("response") != null && getStringFromJsonObject("name", content) != null;
    }

    private static void parseTestContentToApiRequest(HttpRequestWrapper request, JsonObject content) {
        request.setName(getStringFromJsonObject("name", content));
        request.setUrl(getStringFromJsonObject("url", content));
        request.setType(getStringFromJsonObject("type", content));
        request.setBody(getJsonObjectFromJsonObject("body", content).toString());
        request.setExpectedStatusCode(getIntFromJsonObject("code", content));
        request.setExpectedResponseBody(getJsonObjectFromJsonObject("response", content));
        getJsonArrayFromJsonObject("headers", content).forEach((el) -> {
            JsonObject header = el.getAsJsonObject();
            request.setHeader(header.get("name").getAsString(), header.get("value").getAsString());
        });
    }

    public static JsonObject getJsonObjectFromJsonObject(String propName, JsonObject content) {
        try {
            return content.get(propName).getAsJsonObject();
        } catch (IllegalStateException e) {
            String testName = content.get("name") != null ? content.get("name").getAsString() : "name is missing";
            System.out.println("test \"" + testName + "\", error parsing JsonObject \"" + propName + "\" from JsonObject");
            return null;
        }
    }

    public static JsonArray getJsonArrayFromJsonObject(String propName, JsonObject content) {
        try {
            return content.get(propName).getAsJsonArray();
        } catch (IllegalStateException e) {
            String testName = content.get("name") != null ? content.get("name").getAsString() : "name is missing";
            System.out.println("test \"" + testName + "\", error parsing JsonArray \"" + propName + "\" from JsonObject");
            return null;
        }
    }

    public static String getStringFromJsonObject(String propName, JsonObject content) {
        try {
            return content.get(propName).getAsString();
        } catch (IllegalStateException e) {
            String testName = content.get("name") != null ? content.get("name").getAsString() : "name is missing";
            System.out.println("test \"" + testName + "\", error parsing String \"" + propName + "\" from JsonObject");
            return null;
        }
    }

    public static int getIntFromJsonObject(String propName, JsonObject content) {
        try {
            return content.get(propName).getAsInt();
        } catch (IllegalStateException e) {
            String testName = content.get("name") != null ? content.get("name").getAsString() : "name is missing";
            System.out.println("test \"" + testName + "\", error parsing int \"" + propName + "\" from JsonObject");
            return 0;
        }
    }

    public static JsonObject initJsonObject(String input){
        JsonParser jsonParser = new JsonParser();
        try {
            return jsonParser.parse(input).getAsJsonObject();
        }catch (Exception e) {
            return new JsonObject();
        }
    }

    public static void removeJsonElements(ArrayList<String> elements, JsonObject obj) {
        elements.forEach((el) -> removeJsonElement(el, obj));
    }

    public static void removeJsonElement(String el, JsonObject obj) {
        if (obj.get(el) != null) {
            obj.remove(el);
        }
    }
}
