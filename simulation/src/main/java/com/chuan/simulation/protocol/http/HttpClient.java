package com.chuan.simulation.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.chuan.simulation.framework.Invocation;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author hechuan
 */
public class HttpClient {

    public String send(String host, int port, Invocation invocation) {
        try {
            var request = HttpRequest.newBuilder()
                    .uri(new URI("http", null, host, port, "/", null, null))
                    .POST(HttpRequest.BodyPublishers.ofString(JSONObject.toJSONString(invocation)))
                    .build();
            var client = java.net.http.HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
