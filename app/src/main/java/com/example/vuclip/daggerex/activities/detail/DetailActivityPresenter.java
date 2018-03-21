package com.example.vuclip.daggerex.activities.detail;

import com.example.vuclip.daggerex.models.Superhero;

/**
 * Created by Banty on 21/03/18.
 */

public class DetailActivityPresenter implements DetailActivityMVP.Presenter {

    DetailActivityMVP.View view;

    @Override
    public void setView(DetailActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void setData() {
        if(view == null)
            throw new IllegalArgumentException("View cannot be null");

        view.setViews(view.getDataFromIntent());
    }
}
