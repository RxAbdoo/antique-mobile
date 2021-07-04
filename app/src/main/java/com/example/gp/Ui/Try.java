package com.example.gp.Ui;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.gp.AuctionModel.AuctionsDatum;
import com.example.gp.AuctionModel.Authentication1;
import com.example.gp.Models.PostClient;
import com.example.gp.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Try extends AppCompatActivity {
    RecyclerView r;
    String token;

    HomeAdapter homeAdapter;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    List<AuctionsDatum> authentication1s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try);
        r = findViewById(R.id.rv1);
        preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        editor = preferences.edit();
        authentication1s= new ArrayList<>();


        Log.d("Goooooooood", preferences.getString("token", "45f45g45f"));

        token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiODM0OTliMDc3OGVhMWEwZTcwMTYzOGVmNGUxMzdlYzEzNTYxZTE2ZWU2ZDQ5MjY1NTVlYTc2ZmVmZmMzOGNmMjRmMTQ4M2FkZWIzMjUzOGMiLCJpYXQiOjE2MjUyNjkyNTkuMzMyMTY2LCJuYmYiOjE2MjUyNjkyNTkuMzMyMTc3LCJleHAiOjE2NTY4MDUyNTkuMjA4ODE3LCJzdWIiOiIxNTU3Iiwic2NvcGVzIjpbXX0.sJ-vlKPIYfXZSESuzx7AXY-9XeEoyXxFx4fHCzJ1S417PpIIP-kbvjyZK6k7JzfqEA1BzyUPU9SU1qmdo9GHNhqFa51pChrVfM8zFGUrPhGzvIGP-FkUyShHLRK9X6K7gGUgU9o_JqYAG7QJgC9WyPURrda9ZvL_pZ6PJy5M4cVZGxVXpDLYx_5hOxi65gdQuq74cKW5ne6hgCaPOP9S1RoWD07R7LwmJ5U1cNfgPA8zW17gZCkjP3pIwpEPdhiZCTEXP01QkRpHN2LHRmLpXa4juM6lbc4_0A-FRgfdhSghaZm_KQyiuPPAvTk4Ea6oXDGnv2JjCgTj_HyQ7IuB6stNnyjkQU4mQ8QzZAqz_1FNKnW8ohEh8W-vuw7XNZRG3LuykUkg7KqpnJxjSxFW8mpew00Pfk2ZL2Z-0vnyRRL8lZimJFhj6CQS2wnIE3CrSXCwjf_-zNs_aaWzEU6pJ6Cr7lksjJfCgoPAXY9m7PNkubB7hbRiAwde_wWwH-B_pOsEQnCmqNFKX_ztfdr-dtNCWdii8ysdVkDkhPJgd6Fe9G7CsdHi4PVrKui-ANYpsWGB3AOWi6MK0DPJIc08N3D57_lo8nH8gSnNNEYVmfBCDFJMcimHh8B0Bk87BK5OcVeyfi2Ack2bDobVVHvXYwhHHNKHBkaLOBAJyr10Pmk";
        getAuction();

    }

    public void getAuction()
    {
        PostClient.getInstance().getAuction(token).enqueue(new Callback<Authentication1>() {
            @Override
            public void onResponse(Call<Authentication1> call, Response<Authentication1> response) {
                if(response.isSuccessful()) {
                    authentication1s.clear();
                    Authentication1 authentication1 = response.body();
                    authentication1s = new ArrayList<>(Arrays.asList(authentication1.getAuctionsData()));
                    HomeAdapter homeAdapter = new HomeAdapter(getBaseContext(), authentication1s);
                    r.setAdapter(homeAdapter);
                    Log.d("TTTTTT",response.code()+"");
                }



                    r.setHasFixedSize(true);
                    r.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));





            }

            @Override
            public void onFailure(Call<Authentication1> call, Throwable t) {
                {
                    Log.d("yuyuyuy",t.getMessage());
                }

            }
        });
    }
}