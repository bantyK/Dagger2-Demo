package com.example.vuclip.daggerex.dagger;

import com.example.vuclip.daggerex.network.NetworkManager;
import com.example.vuclip.daggerex.retrofit.RetrofitClient;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Banty on 20/03/18.
 */

@Module
public class NetworkModule {
    @Provides
    public NetworkManager provideRetrofit(Retrofit retrofit) {
        return new NetworkManager(retrofit);
    }

    @Provides
    public Retrofit provideRetrofitClient() {
        return new RetrofitClient().getRetrofitClient();
    }
}
