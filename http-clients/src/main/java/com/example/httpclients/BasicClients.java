package com.example.httpclients;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

class BasicClients {
    public static void main(String[] args) throws Exception {
//        httpUrlConnection();
//        newHttpClient();
        newAsyncHttpClient();
    }

    private static void newAsyncHttpClient() {
        HttpClient client = HttpClient.newBuilder()
                                      .version(HttpClient.Version.HTTP_1_1)
                                      .followRedirects(HttpClient.Redirect.NORMAL)
                                      .connectTimeout(Duration.ofSeconds(20))
                                      .build();

        HttpRequest request = HttpRequest
            .newBuilder(URI.create("https://api.github.com/users/darek1024"))
            .timeout(Duration.ofSeconds(120))
            .header("accept", "application/json")
            .build();

        CompletableFuture<HttpResponse<String>> future = client
            .sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .whenComplete((response, throwable) -> {
                if (throwable != null) {
                    System.err.println(throwable.getMessage());
                    throwable.printStackTrace();
                } else {
                    System.out.println("Code: " + response.statusCode());
                    System.out.println("Body: " + response.body());
                }
            });

        future.join();
    }

    private static void newHttpClient() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                                      .version(HttpClient.Version.HTTP_1_1)
                                      .followRedirects(HttpClient.Redirect.NORMAL)
                                      .connectTimeout(Duration.ofSeconds(20))
                                      .build();

        HttpRequest request = HttpRequest
            .newBuilder(URI.create("https://api.github.com/users/darek1024"))
            .timeout(Duration.ofSeconds(120))
            .header("accept", "application/json")
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    private static void httpUrlConnection() throws IOException {
        URL url = new URL("https://api.github.com/users/darek1024");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");

        System.out.println(connection.getResponseCode());
        InputStream stream = connection.getInputStream();

        String responseBody = new BufferedReader(new InputStreamReader(stream))
            .lines()
            .collect(Collectors.joining("\n"));

        System.out.println(responseBody);
    }

}
