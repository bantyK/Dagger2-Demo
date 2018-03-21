package com.example.vuclip.daggerex.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Banty on 20/03/18.
 */

public class ApiResponse {
    @SerializedName("data")
    List<Superhero> data;

    public List<Superhero> getData() {
        return data;
    }

    public void setData(List<Superhero> data) {
        this.data = data;
    }
}
