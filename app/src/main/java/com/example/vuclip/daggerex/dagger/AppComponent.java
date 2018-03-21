package com.example.vuclip.daggerex.dagger;

import com.example.vuclip.daggerex.activities.detail.DetailActivity;
import com.example.vuclip.daggerex.activities.main.MainActivity;

import dagger.Component;

/**
 * Created by Banty on 20/03/18.
 */

@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class,
        MainActivityModule.class,
        DetailModule.class})

public interface AppComponent {
    void inject(MainActivity target);

    void inject(DetailActivity target);
}
