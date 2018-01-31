package org.softuni.javache.http;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

public class HttpRequestImpl implements HttpRequest {
    private String method;

    private String requestUrl;

    private HashMap<String, String> headers;

    private HashMap<String, String> bodyParameters;

    private HashMap<String, String> queryParameters;

    public HttpRequestImpl(String requestContent) {
        this.initMethod(requestContent);
        this.initRequestUrl(requestContent);
        this.initHeaders(requestContent);
        this.initBodyParameters(requestContent);
        this.initQueryParameters(requestContent);
    }

    private void initMethod(String requestContent) {
        this.method = requestContent.split("\\s")[0];
    }

    private void initRequestUrl(String requestContent) {
        this.requestUrl = requestContent.split("[\\s\\?]")[1];
    }

    private void initHeaders(String requestContent) {
        this.headers = new HashMap<>();

        List<String> requestParams = Arrays.asList(
                requestContent.split("\\r\\n"));

        int i = 1;

        while(i < requestParams.size() && requestParams.get(i).length() > 0) {
            String[] headerKeyValuePair = requestParams.get(i).split("\\:\\s");

            this.addHeader(headerKeyValuePair[0], headerKeyValuePair[1]);

            i++;
        }
    }

    private void initBodyParameters(String requestContent) {
        if(this.getMethod().equals("POST")) {
            this.bodyParameters = new HashMap<>();

            List<String> requestParams = Arrays.asList(requestContent.split("\\r\\n"));

            if(requestParams.size() > this.headers.size() + 2) {
                List<String> bodyParams = Arrays.asList(requestParams.get(this.headers.size() + 2).split("\\&"));

                for (int i = 0; i < bodyParams.size(); i++) {
                    String[] bodyKeyValuePair = bodyParams.get(i).split("\\=");

                    try {
                        this.addBodyParameter(bodyKeyValuePair[0], URLDecoder.decode(bodyKeyValuePair[1], "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void initQueryParameters(String requestContent) {
        if(this.getMethod().equals("GET")) {
            this.queryParameters = new HashMap<>();

            List<String> requestLineParams = Arrays.asList(requestContent.split("[\\s\\?]"));


            if(requestLineParams.size() > 3) {
                List<String> queryParams = Arrays.asList(requestLineParams.get(2).split("\\&"));

                for (int i = 0; i < queryParams.size(); i++) {
                    String[] queryKeyValuePair = queryParams.get(i).split("\\=");

                    try {
                        this.addQueryParameter(queryKeyValuePair[0], URLDecoder.decode(queryKeyValuePair[1], "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public String getRequestUrl() {
        return this.requestUrl;
    }

    @Override
    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(this.headers);
    }

    @Override
    public Map<String, String> getBodyParameters() {
        return Collections.unmodifiableMap(this.bodyParameters);
    }

    @Override
    public Map<String, String> getQueryParameters() {
        return Collections.unmodifiableMap(this.queryParameters);
    }

    @Override
    public void addHeader(String header, String value) {
        this.headers.putIfAbsent(header, value);
    }

    @Override
    public void addBodyParameter(String parameter, String value) {
        this.bodyParameters.putIfAbsent(parameter, value);
    }

    @Override
    public void addQueryParameter(String parameter, String value) { this.queryParameters.putIfAbsent(parameter, value); }
}
