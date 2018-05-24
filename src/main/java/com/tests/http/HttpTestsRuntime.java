package com.tests.http;

import com.service.CommonService;
import com.service.http.HttpRequestWrapper;
import com.service.CustomJsonParser;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;

public class HttpTestsRuntime {

    public class SimpleApiTest {

        private HttpRequestWrapper request;

        SimpleApiTest(HttpRequestWrapper request){
            setRequest(request);
        }

        @Parameters({"ignoredProps"})
        @Test
        public void runTest(@Optional("") String ignoredProps){
            Assert.assertTrue(request.send());
            Assert.assertTrue(request.validateStatusCode());
            Assert.assertTrue(request.validateResponseBody(CommonService.parseStringByDelimeter(ignoredProps)));
        }

        void setRequest(HttpRequestWrapper request) {
            this.request = request;
        }
    }

    @Parameters({"files"})
    @Factory
    public Object[] apiTestsFactory(@Optional("src/main/resources/api_tests.txt") String files) {
        ArrayList<HttpRequestWrapper> requests = new ArrayList<>();
        CommonService.parseStringByDelimeter(files).forEach((file) ->
                requests.addAll(CustomJsonParser.getHttpRequestsFromFileContent(file)));
        ArrayList<SimpleApiTest> tests = new ArrayList<>();
        requests.forEach((request) -> tests.add(new SimpleApiTest(request)));
        return tests.toArray();
    }

}
