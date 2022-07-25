package com.rachad.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rachad.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //setContentView(R.layout.activity_main)
        val post = Post("body content", "title content", 5)
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiInterface: ApiInterface = retrofit.create(ApiInterface::class.java)


        val call: Call<Post> = apiInterface.storedPost(post)
        call.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
              binding.title.text= response.body()!!.title
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                binding.title.text=t.message

            }

        })

    }
}