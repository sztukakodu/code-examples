package com.example.httpclients.basic;

import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Data;
import retrofit2.http.Path;

import java.time.LocalDateTime;
import java.util.List;

class FeignClient {

    public static void main(String[] args) {
        GitHub gitHub = Feign.builder()
                             .client(new OkHttpClient())
                             .encoder(new GsonEncoder())
                             .decoder(new GsonDecoder())
                             .logger(new Slf4jLogger(FeignClient.class))
                             .target(GitHub.class, "https://api.github.com");

        List<Repo2> repos = gitHub.contributors("darek1024");
        System.out.println(repos);
    }


}

interface GitHub {
    @RequestLine("GET /users/{user}/repos")
    List<Repo2> contributors(@Param("user") String user);
}


@Data
class Repo2 {
    String id;
    String name;
    String fullName;
    String htmlUrl;
    String description;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
