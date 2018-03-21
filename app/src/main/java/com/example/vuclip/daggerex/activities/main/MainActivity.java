package com.example.vuclip.daggerex.activities.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.vuclip.daggerex.App;
import com.example.vuclip.daggerex.R;
import com.example.vuclip.daggerex.models.Superhero;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityMVP.View {

    private static final String TAG = "MainActivity";

    @Inject
    MainActivityMVP.Presenter mPresenter;

    @Inject
    RecyclerAdapter mRecyclerAdapter;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getAppComponent().inject(this);

        initUIElements();
    }

    private void initUIElements() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.setView(this);
        mPresenter.loadData();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.cancelRequest();
    }

    @Override
    public void updateList(List<Superhero> data) {
        mRecyclerAdapter.updateList(data);
    }
}
