package com.tests.http;

import com.service.http.HttpRequestWrapper;
import com.service.CustomJsonParser;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;


public class HttpTestsRuntime {

    private HttpClient client;

    @BeforeSuite
    public void start(){
        RequestConfig config= RequestConfig.custom().setSocketTimeout(60000).build();
        client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
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
            ArrayList<String> ignoredProps = new ArrayList<>();
            ignoredProps.add("CreatedAt");
            ignoredProps.add("SIG");
            ignoredProps.add("Token");
            ignoredProps.add("Key");
            Assert.assertTrue(request.validateResponseBody(ignoredProps));
        }

        void setRequest(HttpRequestWrapper request) {
            this.request = request;
        }
    }

    @Parameters({"filePath"})
    @Factory
    public Object[] apiTestsFactory(@Optional("src/main/resources/api_tests.txt") String filePath) {
        ArrayList<HttpRequestWrapper> requests = CustomJsonParser.getApiRequestsFromFileContent(filePath);
        ArrayList<SimpleApiTest> tests = new ArrayList<>();
        requests.forEach((request) -> tests.add(new SimpleApiTest(request)));
        return tests.toArray();
    }
}
