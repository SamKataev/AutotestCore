package com.tests.http;

import com.service.CommonService;
import com.service.http.HttpRequestWrapper;
import com.service.CustomJsonParser;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;

public class HttpTestsRuntime {

    public class SimpleHttpTest {

        private HttpRequestWrapper request;

        SimpleHttpTest(HttpRequestWrapper request){
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

    @Parameters({"requestsFiles", "headersFile", "endpoint"})
    @Factory
    public Object[] httpTestsFactory(@Optional("src/main/resources/api_tests.txt") String requestsFiles,
                                     @Optional("src/main/resources/headers.txt") String headersFile,
                                     @Optional("https://slemma.com/api/v1/") String endpoint) {

        ArrayList<HttpRequestWrapper> requests = new ArrayList<>();
        CommonService.parseStringByDelimeter(requestsFiles).forEach((file) ->
                requests.addAll(getHttpRequestsFromFileContent(file)));

        setDefaultEndpoint(requests, endpoint);
        setDefaultHeaders(requests, getHttpHeadersFromFileContent(headersFile));

        ArrayList<SimpleHttpTest> tests = new ArrayList<>();
        requests.forEach((request) -> tests.add(new SimpleHttpTest(request)));

        return tests.toArray();
    }

    private ArrayList<HttpRequestWrapper> getHttpRequestsFromFileContent(String filePath) {
        return CustomJsonParser.parseHttpRequests(CustomJsonParser.getFileContentAsJsonArray(filePath));
    }

    private HashMap<String, String> getHttpHeadersFromFileContent(String filePath) {
        return CustomJsonParser.parseHttpHeaders(CustomJsonParser.getFileContentAsJsonArray(filePath));
    }

    /**
     *
     * default headers will be set only if there were no headers set in http requests file
     * i.e. headers set in http requests file override default headers
     */
    private void setDefaultHeaders(ArrayList<HttpRequestWrapper> requests, HashMap<String, String> defaultHeaders){
        requests.forEach(request -> {
            if (request.getHeaders().size() == 0) {
                request.setHeaders(defaultHeaders);
            }
        });
    }

    /**
     *
     * default endpoint will be set only if there were no endpoint set in http requests file
     * i.e. endpoint set in http requests file override default endpoint
     */
    private void setDefaultEndpoint(ArrayList<HttpRequestWrapper> requests, String defaultEndpoint){
        requests.forEach(request -> {
            if (request.getEndpoint() == null || request.getEndpoint().isEmpty()) {
                request.setEndpoint(defaultEndpoint);
            }
        });
    }

}
