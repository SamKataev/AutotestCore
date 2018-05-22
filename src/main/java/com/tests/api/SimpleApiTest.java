package com.tests.api;

import com.service.api.ApiRequest;
import org.apache.http.client.HttpClient;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleApiTest {

    HttpClient client;
    ApiRequest request;

    public SimpleApiTest(ApiRequest r, HttpClient c){
        request = r;
        client = c;
    }

    @Test
    public void runTest(ApiRequest request){
        Assert.assertTrue(request.execute(client));
        Assert.assertTrue(request.validateStatusCode());
//            Assert.assertTrue(request.validateResponseBody());
    }

}
