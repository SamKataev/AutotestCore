package com.tests.api;

import com.service.api.ApiRequest;
import com.service.TestDataParser;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;


public class ApiTestsRuntime {

    private static HttpClient client;

    @BeforeSuite
    public void startSuite(){
        client = HttpClientBuilder.create().build();
    }

    public class SimpleApiTest {

        private ApiRequest request;

        SimpleApiTest(ApiRequest request){
            setRequest(request);
        }

        @Test
        public void runTest(){
            Assert.assertTrue(request.send(client));
            Assert.assertTrue(request.validateStatusCode());
//            Assert.assertTrue(request.validateResponseBody());
        }

        void setRequest(ApiRequest request) {
            this.request = request;
        }
    }

    @Parameters({"filePath"})
    @Factory
    public Object[] apiTestsFactory(@Optional("src/main/resources/api_tests.txt") String filePath) {
        ArrayList<ApiRequest> requests = TestDataParser.getApiRequestsFromFileContent(filePath);
        ArrayList<SimpleApiTest> tests = new ArrayList<>();
        requests.forEach((request) -> tests.add(new SimpleApiTest(request)));
        return  tests.toArray();
    }
}
