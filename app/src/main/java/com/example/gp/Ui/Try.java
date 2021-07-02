package com.example.gp.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gp.R;

import java.util.ArrayList;

public class Try extends AppCompatActivity {
    RecyclerView r;
    ArrayList<HomeModel> models ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try);
        r = findViewById(R.id.rv1);
        models = new ArrayList<>();
        models.add(new HomeModel("Hello"));
        models.add(new HomeModel("Hello"));
        models.add(new HomeModel("Hello"));
        models.add(new HomeModel("Hello"));
        HomeAdapter homeAdapter = new HomeAdapter(this,models);
        r.setAdapter(homeAdapter);
        r.setHasFixedSize(true);
        r.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
    }
}