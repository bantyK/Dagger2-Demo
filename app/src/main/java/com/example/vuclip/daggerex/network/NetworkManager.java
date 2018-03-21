package com.example.vuclip.daggerex.network;

import android.util.Log;

import com.example.vuclip.daggerex.models.ApiResponse;
import com.example.vuclip.daggerex.retrofit.ApiService;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Banty on 20/03/18.
 */

public class NetworkManager {
    private static final String TAG = "NetworkManager";
    private Call<ApiResponse> mCall;
    private NetworkListener networkListener;

    @Inject
    public Retrofit retrofit;


    public NetworkManager(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public void getData() {
        ApiService apiService = retrofit.create(ApiService.class);

        mCall = apiService.getData();

        mCall.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Log.d(TAG, "onResponse: response : " + response);
                if (networkListener == null)
                    throw new IllegalArgumentException("Network listener cannot be null");

                networkListener.dataLoaded(response.body().getData());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: failure" + t.getMessage());
            }
        });
    }

    public void cancelRequest() {
        if (mCall != null)
            mCall.cancel();
    }

    public void setNetworkListener(NetworkListener networkListener) {
        this.networkListener = networkListener;
    }

}
