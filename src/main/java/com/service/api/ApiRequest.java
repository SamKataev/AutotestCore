package com.service.api;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.client.HttpClient;

import java.util.Map;

public class ApiRequest {

    String name;
    String type;
    String url;
    Map<String, String> headers;
    String body;
    int actualCode;
    int expectedCode;
    String actualResponse;
    String expectedResponse;

    HttpClient client;

    public ApiRequest(JsonObject testData){
        name = testData.get("name").getAsString();
        type = testData.get("type").getAsString();
        url = testData.get("url").getAsString();
        expectedCode = testData.get("code").getAsInt();
        expectedResponse = testData.get("response").getAsString();
        testData.get("headers").getAsJsonArray().forEach(
                (el) -> {
                    JsonObject header = el.getAsJsonObject();
                    headers.put(header.get("name").getAsString(), header.get("value").getAsString());
                });
    }


}
