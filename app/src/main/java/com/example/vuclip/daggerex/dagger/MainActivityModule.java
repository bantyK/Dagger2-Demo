package com.example.vuclip.daggerex.dagger;

import com.example.vuclip.daggerex.activities.main.MainActivityMVP;
import com.example.vuclip.daggerex.activities.main.MainActivityPresenter;
import com.example.vuclip.daggerex.activities.main.RecyclerAdapter;
import com.example.vuclip.daggerex.network.NetworkManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Banty on 20/03/18.
 */

@Module
public class MainActivityModule {

    @Provides
    public RecyclerAdapter provideRecyclerAdapter() {
        return new RecyclerAdapter();
    }

    @Provides
    public MainActivityMVP.Presenter providePresenter(NetworkManager networkManager) {
        return new MainActivityPresenter(networkManager);
    }

}
