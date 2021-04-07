package com.example.httpclients.basic;

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

    public static void main(String[] args) {
        retrofit();
    }

    @SneakyThrows
    private static void retrofit() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        GithubService githubService = retrofit.create(GithubService.class);

//        Call<List<Repo>> repos = githubService.listRepos("darek1024");
//        Response<List<Repo>> response = repos.execute();

        Call<ResponseBody> call = githubService.listRepos("darek1024");

        call.enqueue(new Callback<>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println(Thread.currentThread().getName() +  ":: Received: " + response.body().string());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println(Thread.currentThread().getName() +  ":: Failed with: " + t.getMessage());
            }
        });



//        Response<ResponseBody> response = call.execute();
//        System.out.println(response.code());
//        System.out.println(response.body().string());

    }


}


interface GithubService {
//    @GET("users/{user}/repos")
//    Call<List<Repo>> listRepos(@Path("user") String user);

    @GET("users/{user}/repos")
    Call<ResponseBody> listRepos(@Path("user") String user);
}

@Data
class Repo {
    String id;
    String name;
    String fullName;
    String htmlUrl;
    String description;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
