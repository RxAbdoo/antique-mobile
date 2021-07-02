package com.example.gp.Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.gp.R;

import java.util.ArrayList;
import java.util.List;

public class Product_bid extends AppCompatActivity {
    ImageSlider slider;
    List<SlideModel> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_bid);
        slider = findViewById(R.id.slider);
        loadcard();

    }
    public void loadcard()
    {
        list = new ArrayList<>();

        list.add(new SlideModel(R.drawable.aa));;
        list.add(new SlideModel(R.drawable.mmk));
        list.add(new SlideModel(R.drawable.images));
        list.add(new SlideModel(R.drawable.download));

        slider.setImageList(list,true);

    }
}