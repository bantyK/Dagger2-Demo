package com.example.vuclip.daggerex.network;

import com.example.vuclip.daggerex.models.Superhero;

import java.util.List;

/**
 * Created by Banty on 20/03/18.
 */

public interface NetworkListener {
    void dataLoaded(List<Superhero> data);
}
