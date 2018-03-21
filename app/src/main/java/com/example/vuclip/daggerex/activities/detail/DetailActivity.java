package com.example.vuclip.daggerex.activities.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vuclip.daggerex.App;
import com.example.vuclip.daggerex.R;
import com.example.vuclip.daggerex.models.Superhero;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

/**
 * Created by Banty on 20/03/18.
 */

public class DetailActivity extends AppCompatActivity implements DetailActivityMVP.View {
    public static String INTENT_KEY = "detail.image.intent.key";

    @Inject
    Superhero defaultObject;

    @Inject
    Picasso picasso;

    @Inject
    DetailActivityMVP.Presenter presenter;

    private TextView name, playedBy;
    private ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ((App) getApplication()).getAppComponent().inject(this);

        initViews();

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.setData();
    }

    private void initViews() {
        name = findViewById(R.id.detail_name);
        playedBy = findViewById(R.id.detail_played_by);
        image = findViewById(R.id.detail_image);
    }

    @Override
    public Superhero getDataFromIntent() {
        Intent intent = getIntent();

        if (intent != null) {
            return (Superhero) intent.getExtras().get(INTENT_KEY);
        }
        return defaultObject;
    }

    @Override
    public void setViews(Superhero superhero) {
        name.setText(superhero.getName());
        playedBy.setText(superhero.getPlayed_by());

        picasso.load(superhero.getImage_url())
                .into(image);

    }

}
