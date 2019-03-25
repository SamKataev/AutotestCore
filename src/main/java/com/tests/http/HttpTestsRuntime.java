package com.tests.http;

import com.service.CommonService;
import com.service.http.HttpRequestWrapper;
import com.service.CustomJsonParser;
import com.service.http.HttpTestListener;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import java.util.*;

@Listeners(HttpTestListener.class)
public class HttpTestsRuntime {

    /**
     *
     * order - indicates order of test to be runned by testRunner (TestNG)
     */
    

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

        ArrayList<HttpTest> tests = new ArrayList<>();
        requests.forEach((request) -> {
            HttpTest test = new HttpTest(request);
            test.setOrder(tests.size());
            tests.add(test);
        });

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
