package com.example.sunrin_08.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SunrinAniService {
    @GET("getAniAllList")
    Call<List<Item>> getAniData(

    );
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://ani.sunrin.life:3030/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
