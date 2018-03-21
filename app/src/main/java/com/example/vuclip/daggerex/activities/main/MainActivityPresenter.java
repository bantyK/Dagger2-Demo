package com.example.vuclip.daggerex.activities.main;

import com.example.vuclip.daggerex.models.Superhero;
import com.example.vuclip.daggerex.network.NetworkListener;
import com.example.vuclip.daggerex.network.NetworkManager;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Banty on 20/03/18.
 */

public class MainActivityPresenter implements MainActivityMVP.Presenter, NetworkListener {

    @Inject
    NetworkManager networkManager;

    MainActivityMVP.View view;

    public MainActivityPresenter(NetworkManager networkManager) {
        this.networkManager = networkManager;
        this.networkManager.setNetworkListener(this);
    }

    @Override
    public void setView(MainActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        networkManager.getData();
    }

    @Override
    public void setData(List<Superhero> list) {
        if (view == null)
            throw new IllegalArgumentException("View cannot be null");

        view.updateList(list);
    }

    @Override
    public void cancelRequest() {
        networkManager.cancelRequest();
    }

    @Override
    public void dataLoaded(List<Superhero> data) {
        setData(data);
    }
}
