package com.example.gp.Ui;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.gp.R;
import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;


public class MainHostFragment extends AppCompatActivity {
    DrawerLayout d;
    ChipNavigationBar b1;
    NavigationView n;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_host_fragment);
        b1 = findViewById(R.id.bo);

        b1.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment f =null;
                switch(i)
                {
                    case R.id.Home:
                    f = new HomeFrag();
                    break;

                    case R.id.Cart:
                        f = new Cart();
                        break;
                    case R.id.Favourite:
                        f = new Fav();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,f).commit();

            }
        });



    }

}