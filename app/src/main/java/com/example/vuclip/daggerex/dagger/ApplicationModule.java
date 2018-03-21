package com.example.vuclip.daggerex.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Banty on 20/03/18.
 */

@Module
public class ApplicationModule {
    private Context appContext;

    public ApplicationModule(Context appContext) {
        this.appContext = appContext;
    }

    @Provides
    public Context provideAppContext() {
        return appContext;
    }
}
