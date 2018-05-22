package com.service.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ApiRequest {

    String name;
    HttpRequestBase request;
    String body;
    HttpResponse response;
    int expectedStatusCode;
    String expectedResponseBody;

    public ApiRequest(JsonObject testData){
        name = testData.get("name").getAsString();
        body = testData.get("body").getAsString();
        request = getRequestByType(testData.get("type").getAsString(), testData.get("url").getAsString());
        setHeaders(testData.get("headers").getAsJsonArray());
        expectedStatusCode = testData.get("code").getAsInt();
        expectedResponseBody = testData.get("response").getAsString();
    }

    private HttpRequestBase getRequestByType(String type, String url){
        switch(type){
            case "get":
                return new HttpGet(url);
            case "put":
                HttpPut put = new HttpPut(url);
                setEntity(put);
                return put;
            case "post":
                HttpPost post = new HttpPost(url);
                setEntity(post);
                return post;
            case "delete":
                return new HttpDelete(url);
            default:
                System.out.println("test \"" + name + "\", invalid request type: " + type);
                return null;
        }
    }

    private void setEntity(HttpEntityEnclosingRequestBase request) {
        try {
            request.setEntity(new StringEntity(body));
        } catch (UnsupportedEncodingException e) {
            System.out.println("test \"" + name + "\", invalid body format");
        }
    }

    private void setHeaders(JsonArray headers) {
        headers.forEach((el) -> {
            JsonObject header = el.getAsJsonObject();
            request.addHeader(header.get("name").getAsString(), header.get("value").getAsString());
        });
    }

    public boolean execute(HttpClient client){
        try {
            System.out.println("test \"" + name + "\", sending request");
            response = client.execute(request);
        } catch (IOException e) {
            System.out.println("test \"" + name + "\", error sending request");
            return false;
        }
        return true;
    }

    public boolean validateStatusCode(){
        if(response != null){
            return expectedStatusCode == response.getStatusLine().getStatusCode();
        }
        return false;
    }

    public boolean validateResponseBody(){
        if(response != null){
            try {
                return expectedResponseBody.equals(response.getEntity().getContent().toString());
            } catch (IOException e) {
                System.out.println("test \"" + name + "\", error reading response body");
            }
        }
        return false;
    }
}
