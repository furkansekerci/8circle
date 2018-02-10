package com.hf_sekerci.win8.api;

import com.hf_sekerci.win8.api.Model.Explore;
import com.hf_sekerci.win8.api.Model.Model;
import com.hf_sekerci.win8.api.Model.Venue;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by WIN8 on 2.8.2017.
 */

public interface FourSquareService {

    @GET("venues/search")
    Call<Model> requestExplore(
            @Query("client_id") String client_id,
            @Query("client_secret") String client_secret,
            @Query("v") String v,
            @Query("ll") String ll);
//            @Query("radius") String radius,
//            @Query("query") String query);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.foursquare.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
