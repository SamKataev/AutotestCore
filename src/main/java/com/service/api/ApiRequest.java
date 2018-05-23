package com.service.api;

import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class ApiRequest {

    private String name;
    private String body;
    private String type;
    private String url;
    private final HashMap<String, String> headers = new HashMap<>();
    private int expectedStatusCode;
    private String expectedResponseBody;

    private HttpResponse response;

    public boolean send(HttpClient client){
        if(type.equals("get") || type.equals("delete")){
            return sendWithoutEntity(client, initRequest());
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
        return false;
    }

    private boolean execute(HttpClient client, HttpRequestBase request) {
        try {
            response = client.execute(request);
            return true;
        } catch (IOException e) {
            System.out.println("test \"" + name + "\", error sending request: " + type);
        }
        return false;
    }

    private HttpRequestBase initRequest(){
        switch(type){
            case "get":
                return new HttpGet(url);
            case "delete":
                return new HttpDelete(url);
            default:
                System.out.println("test \"" + name + "\", invalid request type: " + type);
                return null;
        }
    }

    private HttpEntityEnclosingRequestBase initRequestWithEntity(){
        switch(type){
            case "put":
                return new HttpPut(url);
            case "post":
                return new HttpPost(url);
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

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setExpectedStatusCode(int expectedStatusCode) {
        this.expectedStatusCode = expectedStatusCode;
    }

    public void setExpectedResponseBody(String expectedResponseBody) {
        this.expectedResponseBody = expectedResponseBody;
    }

    public void setHeader(String name, String value) {
        this.headers.put(name, value);
    }

    public void clearHeaders() {
        this.headers.clear();
    }

}
