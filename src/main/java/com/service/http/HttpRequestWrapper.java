package com.service.http;

import com.google.gson.JsonObject;
import com.service.CustomJsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HttpRequestWrapper {

    private String name;
    private String body;
    private String type;
    private String enpoint;
    private String method;
    private String headersSetName;
    private HashMap<String, String> headers = new HashMap<>();
    private int expectedStatusCode;
    private JsonObject expectedResponseBody;
    private HttpResponse response;

    public boolean send(){
        RequestConfig config= RequestConfig.custom().setSocketTimeout(60000).build();
        HttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();

        System.out.println("test \"" + name + "\", send request: " + type + " " + getUrl());
        if(type.equals("get") || type.equals("delete")){
            return sendWithoutEntity(client, initRequestWithoutEntity());
        }
        if(type.equals("post") || type.equals("put")){
            return sendWithEntity(client, initRequestWithEntity());
        }
        System.out.println("test \"" + name + "\", invalid request type: " + type);
        return false;

    }

    private boolean sendWithoutEntity(HttpClient client, HttpRequestBase request){
        return request != null
                && addHeaders(request)
                && execute(client, request);
    }

    private boolean sendWithEntity(HttpClient client, HttpEntityEnclosingRequestBase request){
        return request != null
                && addHeaders(request)
                && setEntity(request)
                && execute(client, request);
    }

    private boolean addHeaders(HttpRequestBase request){
        if (headers.size() > 0) {
            headers.forEach(request::addHeader);
            return true;
        }
        System.out.println("test \"" + name + "\", headers are missing");
        return false;
    }

    private boolean execute(HttpClient client, HttpRequestBase request) {
        try {
            response = client.execute(request);
            if(response != null) {
                return true;
            }
        } catch (IOException e) {
            System.out.println("test \"" + name + "\", error sending request: " + type);
        }
        return false;
    }

    private HttpRequestBase initRequestWithoutEntity(){
        switch(type){
            case "get":
                return new HttpGet(getUrl());
            case "delete":
                return new HttpDelete(getUrl());
            default:
                System.out.println("test \"" + name + "\", invalid request type: " + type);
                return null;
        }
    }

    private HttpEntityEnclosingRequestBase initRequestWithEntity(){
        switch(type){
            case "put":
                return new HttpPut(getUrl());
            case "post":
                return new HttpPost(getUrl());
            default:
                System.out.println("test \"" + name + "\", invalid request type: " + type);
                return null;
        }
    }

    private boolean setEntity(HttpEntityEnclosingRequestBase request) {
        if(body.length() > 0) {
            try {
                request.setEntity(new StringEntity(body));
                return true;
            } catch (UnsupportedEncodingException e) {
                System.out.println("test \"" + name + "\", invalid request body format");
            }
        }
        return false;
    }

    public boolean validateStatusCode(){
        boolean valid = false;
        if(response != null){
            valid = expectedStatusCode == response.getStatusLine().getStatusCode();
        }
        System.out.println("test \"" + name + "\", validate status code: " + valid);
        return valid;
    }

    public boolean validateResponseBody(ArrayList<String> ignoredProps){
        if(expectedResponseBody != null){
            String responseBodyContent = "";
            try {
                responseBodyContent = new Scanner(response.getEntity().getContent()).useDelimiter("\\Z").next();
            } catch (Exception e) {
                System.out.println("test \"" + name + "\", error reading entity from response");
            }
            JsonObject responseBody = CustomJsonParser.initJsonObject(responseBodyContent);
            CustomJsonParser.removeJsonElements(ignoredProps, responseBody);
            boolean valid = responseBody.toString().equals(expectedResponseBody.toString());
            System.out.println("test \"" + name + "\", validate response body: " + valid);
            return valid;
        }
        return true;
    }

    public boolean validateResponseBody(){
        return validateResponseBody(new ArrayList<>());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHeadersSetName(String headersSetName) {
        this.headersSetName = headersSetName;
    }

    public String getHeadersSetName() {
        return this.headersSetName;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setEndpoint(String endpoint) {
        this.enpoint = endpoint;
    }

    public String getEndpoint() {
        return this.enpoint;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setExpectedStatusCode(int expectedStatusCode) {
        this.expectedStatusCode = expectedStatusCode;
    }

    public void setExpectedResponseBody(JsonObject expectedResponseBody) {
        this.expectedResponseBody = expectedResponseBody;
    }

    public void setHeader(String name, String value) {
        this.headers.put(name, value);
    }

    public void setHeaders(HashMap<String, String> headers) {
        clearHeaders();
        this.headers.putAll(headers);
    }

    public HashMap<String, String> getHeaders() {
        return this.headers;
    }

    public void clearHeaders() {
        this.headers.clear();
    }

    private String getUrl(){
        String url = enpoint + method;
        return url.replaceAll("\\/{2,}","/").replaceAll(":\\/", "://");
    }
}
