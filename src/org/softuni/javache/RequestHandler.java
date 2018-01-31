package org.softuni.javache;

import org.softuni.javache.http.*;

class RequestHandler {
    private HttpContext httpContext;

    RequestHandler() {
    }

    byte[] handleRequest(String requestContent) {
        HttpRequest httpRequest = new HttpRequestImpl(requestContent);
        HttpResponse httpResponse = new HttpResponseImpl();

        this.httpContext = new HttpContextImpl(httpRequest, httpResponse);

        return this.generateDemoResponse();
    }

    private byte[] generateDemoResponse() {
        httpContext.getHttpResponse().setStatus(HttpStatus.OK);

        httpContext.getHttpResponse().addHeader("Content-Type", "text/html");
        httpContext.getHttpResponse().addHeader("Server", WebConstants.SERVER_NAME + "/" + WebConstants.SERVER_VERSION);

        httpContext.getHttpResponse().setContent(("<h1>Hello from " + WebConstants.SERVER_NAME + " v. " + WebConstants.SERVER_VERSION + "</h1>").getBytes());

        return httpContext.getHttpResponse().getBytes();
    }
}
