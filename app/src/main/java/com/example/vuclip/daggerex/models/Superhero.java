package com.example.vuclip.daggerex.models;

import android.os.Parcel;
import android.os.Parcelable;

import javax.inject.Inject;

/**
 * Created by Banty on 20/03/18.
 */

public class Superhero implements Parcelable {
    String name;
    String image_url;
    String played_by;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getPlayed_by() {
        return played_by;
    }

    public void setPlayed_by(String played_by) {
        this.played_by = played_by;
    }

    protected Superhero(Parcel in) {
        name = in.readString();
        image_url = in.readString();
        played_by = in.readString();
    }

    @Inject
    public Superhero(String name, String played_by, String image_url) {
        this.name = name;
        this.played_by = played_by;
        this.image_url = image_url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(image_url);
        dest.writeString(played_by);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Superhero> CREATOR = new Parcelable.Creator<Superhero>() {
        @Override
        public Superhero createFromParcel(Parcel in) {
            return new Superhero(in);
        }

        @Override
        public Superhero[] newArray(int size) {
            return new Superhero[size];
        }
    };
}
