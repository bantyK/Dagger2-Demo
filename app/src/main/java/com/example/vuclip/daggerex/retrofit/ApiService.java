package com.example.vuclip.daggerex.retrofit;

import com.example.vuclip.daggerex.models.ApiResponse;
import com.example.vuclip.daggerex.models.Superhero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Banty on 20/03/18.
 */

public interface ApiService {
    @GET("/b/5ab0db81aba566611f3338dd")
    Call<ApiResponse> getData();
}
