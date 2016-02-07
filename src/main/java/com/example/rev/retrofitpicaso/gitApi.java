package com.example.rev.retrofitpicaso;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

//import com.example.rev.retrofitpicaso.gitModel;

/**
 * Created by REVANT on 07-02-2016.
 */
public interface gitApi {
    @GET("/users/{user}")
    public void getFeed(@Path("user") String user, Callback<gitModel> response);
}
