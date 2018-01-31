package org.softuni.javache.http;

import java.util.Map;

public interface HttpRequest {

    String getMethod();

    String getRequestUrl();

    Map<String, String> getHeaders();

    Map<String, String> getQueryParameters();

    Map<String, String> getBodyParameters();

    void addHeader(String header, String value);

    void addBodyParameter(String parameter, String value);

    void addQueryParameter(String parameter, String value);
}
