package com.rachad.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
   // @GET("posts/1")
    @GET("posts/{id}")
    public Call<Post> getPost(@Path("id") String PostId);
}
