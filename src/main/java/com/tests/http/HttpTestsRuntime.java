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
                                     @Optional("https://beta.slemma.com/api/v1/") String endpoint) {

        ArrayList<HttpRequestWrapper> requests = new ArrayList<>();
        CommonService.parseStringByDelimeter(requestsFiles).forEach((file) ->
                requests.addAll(getHttpRequestsFromFileContent(file)));

        setDefaultEndpoint(requests, endpoint);
        setHeaders(requests, getHttpHeadersSetFromFileContent(headersFile));

        ArrayList<SimpleHttpTest> tests = new ArrayList<>();
        requests.forEach((request) -> tests.add(new SimpleHttpTest(request)));

        return tests.toArray();
    }

    private ArrayList<HttpRequestWrapper> getHttpRequestsFromFileContent(String filePath) {
        return CustomJsonParser.parseHttpRequests(CustomJsonParser.getFileContentAsJsonArray(filePath));
    }

    private HashMap<String, HashMap<String, String>> getHttpHeadersSetFromFileContent(String filePath) {
        return CustomJsonParser.parseHttpHeaders(CustomJsonParser.getFileContentAsJsonObject(filePath));
    }

    /**
     *
     * headers will be set according to headers-set prop from http requests file
     */
    private void setHeaders(ArrayList<HttpRequestWrapper> requests, HashMap<String, HashMap<String, String>> headersSet){
        requests.forEach(request -> request.setHeaders(headersSet.get(request.getHeadersSetName())));
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
