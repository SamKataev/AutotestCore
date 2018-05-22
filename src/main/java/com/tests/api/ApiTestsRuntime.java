package com.tests.api;

import com.service.api.ApiRequest;
import com.service.api.TestDataParser;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.*;
import java.util.ArrayList;


public class ApiTestsRuntime {

    HttpClient client;

    @BeforeSuite
    public void startSuite(){
        client = HttpClientBuilder.create().build();
    }

    @Parameters({"filePath"})
    @Factory
    public Object[] apiTestsFactory(@Optional("src/main/resources/api_tests.txt") String filePath) {
        ArrayList<ApiRequest> requests = TestDataParser.getApiRequestsFromFileContent(filePath);
        ArrayList<SimpleApiTest> tests = new ArrayList<>();
        requests.forEach((request) -> tests.add(new SimpleApiTest(request, client)));
        return  tests.toArray();
    }
}
