package com.tests.http;

import com.service.http.HttpRequestWrapper;
import com.service.CustomJsonParser;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

        @Parameters({"ignoredProps"})
        @Test
        public void runTest(@Optional("") String ignoredProps){
            Assert.assertTrue(request.send(client));
            Assert.assertTrue(request.validateStatusCode());
            Assert.assertTrue(request.validateResponseBody(getIgnoredProps(ignoredProps)));
        }


        ArrayList<String> getIgnoredProps(String ignoredProps) {
            return new ArrayList<>(Arrays.asList(ignoredProps.split(";")));
        }

        void setRequest(HttpRequestWrapper request) {
            this.request = request;
        }
    }

    @Parameters({"filePath"})
    @Factory
    public Object[] apiTestsFactory(@Optional("src/main/resources/api_tests.txt") String filePath) {
        ArrayList<HttpRequestWrapper> requests = CustomJsonParser.getHttpRequestsFromFileContent(filePath);
        ArrayList<SimpleApiTest> tests = new ArrayList<>();
        requests.forEach((request) -> tests.add(new SimpleApiTest(request)));
        return tests.toArray();
    }
}
