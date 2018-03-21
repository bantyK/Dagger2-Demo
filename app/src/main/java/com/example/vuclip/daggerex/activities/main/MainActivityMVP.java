package com.example.vuclip.daggerex.activities.main;

import com.example.vuclip.daggerex.models.Superhero;

import java.util.List;

/**
 * Created by Banty on 20/03/18.
 */

public interface MainActivityMVP {
    interface View {
        void updateList(List<Superhero> data);
    }

    interface Presenter {
        void setView(MainActivityMVP.View view);

        void loadData();

        void setData(List<Superhero> list);

        void cancelRequest();
    }
}
