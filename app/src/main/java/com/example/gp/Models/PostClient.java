package com.example.gp.Models;

import com.example.gp.AuctionModel.Authentication1;
import com.example.gp.SingleAuctionModel.Authentication2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private static final String BASE_URL="https://53b0525e0f71.ngrok.io/api/";
    private ApiInterface apiInterface;
    private static PostClient instance;
    Gson gson;

    public PostClient() {
        gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static PostClient getInstance() {
        if(null==instance)
        {
            instance = new PostClient();
        }
        return instance;
    }

    public Call<Authentication> reg( String name,String email, String password1, String passwordconf)
    {
        return apiInterface.reg( name, email,password1,passwordconf);
    }

   public Call <Authentication> checkcode( String token){

        return apiInterface.checkcode("Bearer"+token);
   }
    public Call<Authentication> login( String email, String password)
    {
        return apiInterface.login( email,password);
    }

    public Call<Authentication1> getAuction(String token)
    {

        return apiInterface.getAuction("Bearer "+token);
    }


    public Call<Authentication2> getOneAuction(String token, int id)
    {

        return apiInterface.getOneAuction("Bearer "+token,id);
    }

}
