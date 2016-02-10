package com.example.rev.retrofitpicaso;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

import com.example.rev.retrofitpicaso.gitModel;
import com.example.rev.retrofitpicaso.repoModel;

import java.util.List;

/**
 * Created by REVANT on 07-02-2016.
 */
public interface gitApi {
    @GET("/users/{user}")
    public void getFeed(@Path("user") String user, Callback<gitModel> response);

    @GET("/users/{user}/repos")
    public void getRepo(@Path("user") String user , Callback<List<repoModel>> response);
}
