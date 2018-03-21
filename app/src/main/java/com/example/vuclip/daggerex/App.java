package com.example.vuclip.daggerex;

import android.app.Application;

import com.example.vuclip.daggerex.dagger.AppComponent;
import com.example.vuclip.daggerex.dagger.ApplicationModule;
import com.example.vuclip.daggerex.dagger.DaggerAppComponent;
import com.example.vuclip.daggerex.dagger.DetailModule;
import com.example.vuclip.daggerex.dagger.MainActivityModule;
import com.example.vuclip.daggerex.dagger.NetworkModule;

/**
 * Created by Banty on 20/03/18.
 */

public class App extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule())
                .mainActivityModule(new MainActivityModule())
                .detailModule(new DetailModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
