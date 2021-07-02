package com.example.gp.Ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gp.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.adapterHolder> {
    Context c;
    private ArrayList<HomeModel> ho = new ArrayList<>();

    public HomeAdapter(Context c, ArrayList<HomeModel> ho) {
        this.c = c;
        this.ho = ho;
    }

    public HomeAdapter(Context c) {
        this.c = c;
    }

    @NonNull
    @Override
    public adapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new adapterHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_home, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull adapterHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return ho.size();
    }

    public class adapterHolder extends RecyclerView.ViewHolder {


        public adapterHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
