package com.example.httpclients.basic;

import lombok.SneakyThrows;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

class ApacheAsyncClient {
    @SneakyThrows
    public static void main(String[] args) {
        CloseableHttpAsyncClient asyncClient = HttpAsyncClients.createDefault();
        asyncClient.start();
        HttpGet request = new HttpGet("https://api.github.com/users/darek1024");


        Future<HttpResponse> execute = asyncClient.execute(request, null);
        HttpResponse response = execute.get();
        System.out.println(response.getStatusLine().getStatusCode());
        InputStream content = response.getEntity().getContent();
        String body = new BufferedReader(new InputStreamReader(content))
            .lines()
            .collect(Collectors.joining("\n"));
        System.out.println(body);

    }
}
