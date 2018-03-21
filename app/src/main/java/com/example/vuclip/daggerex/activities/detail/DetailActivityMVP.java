package com.example.vuclip.daggerex.activities.detail;

import com.example.vuclip.daggerex.models.Superhero;

/**
 * Created by Banty on 20/03/18.
 */

public interface DetailActivityMVP {
    interface View {
        Superhero getDataFromIntent();

        void setViews(Superhero superhero);
    }

    interface Presenter {
        void setView(View view);

        void setData();
    }
}
