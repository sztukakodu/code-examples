package com.example.httpclients;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

class SpringClients {

    public static void main(String[] args) {
//        restTemplate();
        webClient();
    }

    private static void webClient() {
        WebClient client = WebClient
            .builder()
            .baseUrl("https://api.github.com/users")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();
        WebClient.RequestHeadersSpec<?> requestHeadersSpec = client.get().uri("/darek1024");

        Mono<String> mono = requestHeadersSpec.retrieve().bodyToMono(String.class);
        mono
            .doOnNext(System.out::println)
            .subscribe();
    }

    private static void restTemplate() {
        RestTemplate template = new RestTemplateBuilder()
            .rootUri("https://api.github.com/users")
            .build();
        ResponseEntity<String> response = template.getForEntity("/darek1024", String.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
    }

}
