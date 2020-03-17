package com.example.project;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class drink {
    @SerializedName("drinks")
    @Expose
    private List<drink_> drink = null;

    public List<drink_> getDrink() {
        return drink;
    }

    public void setDrink(List<drink_> drink) {
        this.drink = drink;
    }
}
