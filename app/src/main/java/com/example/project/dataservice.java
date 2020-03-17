package com.example.project;


import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Header;

public interface dataservice {

    @GET("search.php?s=margarita&apiKey=1")
    Call<drink> getAllDrink();

    @GET("search.php?f=a&apiKey=1")
    Call<drink> getDrinksByFL();

}
