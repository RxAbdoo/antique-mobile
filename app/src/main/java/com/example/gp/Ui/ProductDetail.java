package com.example.gp.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.gp.Models.ImageAdapter;
import com.example.gp.R;

import java.util.ArrayList;

public class ProductDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ViewPager viewPager = findViewById(R.id.pa);
         ArrayList<Integer> mImage = new ArrayList<Integer>();
        ImageAdapter adapter = new ImageAdapter(this,mImage);
        mImage.add(R.drawable.n11);
        mImage.add(R.drawable.n22);
        mImage.add(R.drawable.n33);
        viewPager.setPadding(100,0,100,0);
        viewPager.setAdapter(adapter);
    }
}