package com.rachad.retrofit;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    // @GET("posts/1")
    @GET("posts/{id}")
    public Call<Post> getPost(@Path("id") String PostId);

    @POST("posts")
    public Call<Post> storedPost(@Body Post post);
//    public Call<Post> storedPost(@Body HashMap<Object,Object> hashMap);
    //map.put("name exactly same as server ","value")
}
