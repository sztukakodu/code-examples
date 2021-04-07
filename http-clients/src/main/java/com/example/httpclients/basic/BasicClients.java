package com.example.httpclients.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

class BasicClients {

    public static final String githubProfileAddress = "https://api.github.com/users/darek1024";

    public static void main(String[] args) throws IOException, InterruptedException {
//        httpUrlConnection();
//        newHttpClient();
        asyncHttpClient();
    }

    private static void asyncHttpClient() {
        HttpClient client = HttpClient
            .newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(20))
            .build();

        HttpRequest request = HttpRequest
            .newBuilder()
            .uri(URI.create(githubProfileAddress))
            .timeout(Duration.ofMinutes(2))
            .header("accept", "application/json")
            .build();

        CompletableFuture<HttpResponse<String>> completableFuture = client
            .sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .whenComplete((response, throwable) -> {
                if (throwable != null) {
                    System.err.println(throwable.getMessage());
                    throwable.printStackTrace();
                } else {
                    System.out.println("Code: " + response.statusCode());
                    System.out.println("Message: " + response.body());
                }
            });
        completableFuture.join();
    }

    private static void newHttpClient() throws IOException, InterruptedException {
        HttpClient client = HttpClient
            .newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(20))
            .build();

        HttpRequest request = HttpRequest
            .newBuilder()
            .uri(URI.create(githubProfileAddress))
            .timeout(Duration.ofMinutes(2))
            .header("accept", "application/json")
            .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    private static void httpUrlConnection() throws IOException {
        URL url = new URL(githubProfileAddress);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        System.out.println(connection.getResponseCode());
        InputStream responseStream = connection.getInputStream();


        String response = new BufferedReader(new InputStreamReader(responseStream, StandardCharsets.UTF_8))
            .lines()
            .collect(Collectors.joining("\n"));
        System.out.println(response);
    }
}
