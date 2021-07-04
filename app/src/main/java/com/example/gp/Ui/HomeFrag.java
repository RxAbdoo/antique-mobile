package com.example.gp.Ui;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.L;
import com.example.gp.All_f;
import com.example.gp.AuctionModel.Authentication1;
import com.example.gp.Cat_f;
import com.example.gp.Models.PostClient;
import com.example.gp.MyProfile;
import com.example.gp.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFrag extends Fragment {
    DrawerLayout d;
    ChipNavigationBar b1;
    String token;
    HomeAdapter homeAdapter;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;




    public HomeFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v;

        v=inflater.inflate(R.layout.fragment_home, container, false);
        TabLayout tabLayout = v.findViewById(R.id.tabLayout1);
        ViewPager pager2=  v.findViewById(R.id.PagerHome);
        PagerAdapter adapter = new PagerAdapter(getParentFragmentManager());
        ArrayList<MyTab> myTabs = new ArrayList<>();
        myTabs.add(new MyTab("All",new All_f()));
        myTabs.add(new MyTab("All",new All_f()));
        myTabs.add(new MyTab("All",new All_f()));
        myTabs.add(new MyTab("All",new All_f()));
        myTabs.add(new MyTab("Cat2",new Cat_f()));
        adapter.setMyTabs(myTabs);
        pager2.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager2);


        preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        editor=preferences.edit();
        token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiODM0OTliMDc3OGVhMWEwZTcwMTYzOGVmNGUxMzdlYzEzNTYxZTE2ZWU2ZDQ5MjY1NTVlYTc2ZmVmZmMzOGNmMjRmMTQ4M2FkZWIzMjUzOGMiLCJpYXQiOjE2MjUyNjkyNTkuMzMyMTY2LCJuYmYiOjE2MjUyNjkyNTkuMzMyMTc3LCJleHAiOjE2NTY4MDUyNTkuMjA4ODE3LCJzdWIiOiIxNTU3Iiwic2NvcGVzIjpbXX0.sJ-vlKPIYfXZSESuzx7AXY-9XeEoyXxFx4fHCzJ1S417PpIIP-kbvjyZK6k7JzfqEA1BzyUPU9SU1qmdo9GHNhqFa51pChrVfM8zFGUrPhGzvIGP-FkUyShHLRK9X6K7gGUgU9o_JqYAG7QJgC9WyPURrda9ZvL_pZ6PJy5M4cVZGxVXpDLYx_5hOxi65gdQuq74cKW5ne6hgCaPOP9S1RoWD07R7LwmJ5U1cNfgPA8zW17gZCkjP3pIwpEPdhiZCTEXP01QkRpHN2LHRmLpXa4juM6lbc4_0A-FRgfdhSghaZm_KQyiuPPAvTk4Ea6oXDGnv2JjCgTj_HyQ7IuB6stNnyjkQU4mQ8QzZAqz_1FNKnW8ohEh8W-vuw7XNZRG3LuykUkg7KqpnJxjSxFW8mpew00Pfk2ZL2Z-0vnyRRL8lZimJFhj6CQS2wnIE3CrSXCwjf_-zNs_aaWzEU6pJ6Cr7lksjJfCgoPAXY9m7PNkubB7hbRiAwde_wWwH-B_pOsEQnCmqNFKX_ztfdr-dtNCWdii8ysdVkDkhPJgd6Fe9G7CsdHi4PVrKui-ANYpsWGB3AOWi6MK0DPJIc08N3D57_lo8nH8gSnNNEYVmfBCDFJMcimHh8B0Bk87BK5OcVeyfi2Ack2bDobVVHvXYwhHHNKHBkaLOBAJyr10Pmk";

     return v;
    }
   public void getAuction()
   {
      PostClient.getInstance().getAuction(token).enqueue(new Callback<Authentication1>() {
          @Override
          public void onResponse(Call<Authentication1> call, Response<Authentication1> response) {
              if(response.isSuccessful()){

                  ArrayList<Authentication1> authentication1s = new ArrayList<>();




                  homeAdapter = new HomeAdapter(getActivity());


                  Log.e("lollllllllllllllll",new Gson().toJson(response.body()));
              }
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

