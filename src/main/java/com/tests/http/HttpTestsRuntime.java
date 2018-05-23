package com.tests.http;

import com.service.http.HttpRequestWrapper;
import com.service.TestDataParser;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;


public class HttpTestsRuntime {

    private static HttpClient client;

    @BeforeSuite
    public void startSuite(){
        client = HttpClientBuilder.create().build();
    }

    public class SimpleApiTest {

        private HttpRequestWrapper request;

        SimpleApiTest(HttpRequestWrapper request){
            setRequest(request);
        }

        @Test
        public void runTest(){
            Assert.assertTrue(request.send(client));
            Assert.assertTrue(request.validateStatusCode());
//            Assert.assertTrue(request.validateResponseBody());
        }

        void setRequest(HttpRequestWrapper request) {
            this.request = request;
        }
    }

    @Parameters({"filePath"})
    @Factory
    public Object[] apiTestsFactory(@Optional("src/main/resources/api_tests.txt") String filePath) {
        ArrayList<HttpRequestWrapper> requests = TestDataParser.getApiRequestsFromFileContent(filePath);
        ArrayList<SimpleApiTest> tests = new ArrayList<>();
        requests.forEach((request) -> tests.add(new SimpleApiTest(request)));
        return  tests.toArray();
    }
}
