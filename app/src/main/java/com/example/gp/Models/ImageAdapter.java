package com.example.gp.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.gp.R;

import java.util.ArrayList;

public class ImageAdapter extends PagerAdapter {
    Context c;
   ArrayList<Integer> mImage;

    public ImageAdapter(Context c, ArrayList<Integer> mImage) {
        this.c = c;
        this.mImage = mImage;
    }

    @Override
    public int getCount() {
        return mImage.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
     View view = LayoutInflater.from(c).inflate(R.layout.viewpager_image_adapter,null);
     container.addView(view,0);
     ImageView imageView = view.findViewById(R.id.iv_adapter);
        Glide.with(c).asBitmap().load(mImage.get(position)).into(imageView);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((ImageView)object);
    }
}
