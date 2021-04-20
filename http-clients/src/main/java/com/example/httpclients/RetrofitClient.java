package com.example.httpclients;

import lombok.Data;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

class RetrofitClient {

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        GithubService githubService = retrofit.create(GithubService.class);
        Call<List<Repository>> call = githubService.listRepos("darek1024");
//
//        Response<List<Repository>> response = call.execute();
//
//        System.out.println(response.code());
//        System.out.println(response.body());

        call.enqueue(new Callback<>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                System.out.println(Thread.currentThread().getName() +  ":: Received: " + response.body());
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                System.out.println(Thread.currentThread().getName() +  ":: Failed with: " + t.getMessage());
            }
        });
    }

}

interface GithubService {
    @GET("users/{user}/repos")
    Call<List<Repository>> listRepos(@Path("user") String user);
}

@Data
class Repository {
    String id;
    String name;
    String fullName;
    String htmlUrl;
    String description;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
