package com.example.vuclip.daggerex.dagger;

import android.content.Context;

import com.example.vuclip.daggerex.activities.detail.DetailActivityMVP;
import com.example.vuclip.daggerex.activities.detail.DetailActivityPresenter;
import com.example.vuclip.daggerex.models.Superhero;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Banty on 20/03/18.
 */

@Module
public class DetailModule {

    @Provides
    public Picasso providePicasso(Context context) {
        return new Picasso.Builder(context).build();
    }

    @Provides
    public Superhero provideDefaultValue() {
        Superhero superhero = new Superhero("Default", "Default", "https://upload.wikimedia.org/wikipedia/commons/1/1e/Default-avatar.jpg");
        return superhero;
    }

    @Provides
    public DetailActivityMVP.Presenter providePresenter() {
        return new DetailActivityPresenter();
    }
}
