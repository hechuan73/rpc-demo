package com.chuan.simulation.protocol.http;

import com.chuan.simulation.framework.Invocation;
import com.chuan.simulation.framework.Protocol;

import com.chuan.simulation.framework.URL;


/**
 * @author hechuan
 */
public class HttpProtocol implements Protocol {
    @Override
    public void start(URL url) {
        HttpServer server = new HttpServer();
        server.start(url.getHost(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(url.getHost(), url.getPort(), invocation);
    }
}
