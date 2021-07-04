package com.example.gp.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;

import com.example.gp.AuctionModel.Authentication1;
import com.example.gp.Models.ImageAdapter;
import com.example.gp.Models.PostClient;
import com.example.gp.R;
import com.example.gp.SingleAuctionModel.Authentication2;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetail extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        t1 = findViewById(R.id.textView4);
        t2 = findViewById(R.id.textView6);
        t3 = findViewById(R.id.textView22);
        t4 = findViewById(R.id.textView24);
        t5 = findViewById(R.id.tvb1);
        t6 = findViewById(R.id.tvb2);
        ViewPager viewPager = findViewById(R.id.pa);
         ArrayList<Integer> mImage = new ArrayList<Integer>();
        ImageAdapter adapter = new ImageAdapter(this,mImage);
        mImage.add(R.drawable.n11);
        mImage.add(R.drawable.n22);
        mImage.add(R.drawable.n33);
        viewPager.setPadding(100,0,100,0);
        viewPager.setAdapter(adapter);
        preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        editor=preferences.edit();
        token="eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNjJhNjA2ODYwNjYzZDM4OGJiMzlmM2EzMWYxZjg5OTY1ZDgzODc0NDRhODUwM2U2ODQ0MTc5NmM2NGE2OTU0NjU4YjU0MzFhNDExOWU2YTciLCJpYXQiOjE2MjUzMjcyODAuMzc4OTgxLCJuYmYiOjE2MjUzMjcyODAuMzc4OTg3LCJleHAiOjE2NTY4NjMyODAuMTQ4NzE2LCJzdWIiOiIxNTYwIiwic2NvcGVzIjpbXX0.UfgLEpVTH4Gy70Dc48_y1ub2o3iGCQiAt_eBYS6wKzpq0QyZhDEGfeX45HCPDbChGWw0QLLKyvbANdTP-7W3_zC8rwQOLQKrayAlYKBAO16Lu0-6sSB8rRprm2fMAVj-G1H4AnQvUq5Ppif1IhmjVEN8fW3DkM-4xpI_5Nj9qnair3QVyr9ZXbiBu6mMmvluxBAaPF0_s_0LS6g98brBPfut426AsUKdwi3PsZQhyV5fuJT_8mX7L_YMwMMqakyAkD5HcmRyLee29iFvu8Gjprye8dM5UmW_-pCKKPBOdKQqbG1Geocns-u7ejmZBYEGqtkkSzDl8MUrcjFKC92soUIO-7La4wlOkpXM1eGRebVcrKNh1f81kLaQF3GhoxDLeuiDiQ2mrJegdKELVufg0SDPJohkj5miPiG5miNLb0jG2iQTUKAKBVPp93bey3Qe4hgo18kspb4TEsKHb0PNMykIni1TQQ_Ww5fRYxFOj5gGsqsxd_go7CPNPfk70ng96Zq3SNNif7x7fV_3GOoSyrBj7exfJBK07NQwLGzbboz78-5MagoLPHv1JD4NqfTikPBg8cvN1evZWtgPZWYepwYcJUvOpAq9r4290ZkUVbsGeCbGHMqzZ5VKrMINgbRSktmLRMkD6jUpom3dGqjiDVhpbQGwhVKl0Y-gmbGcjFM";
     getOneAuction();
    }
    public void getOneAuction(){
        PostClient.getInstance().getOneAuction(token,1).enqueue(new Callback<Authentication2>() {
            @Override
            public void onResponse(Call<Authentication2> call, Response<Authentication2> response) {
                if(response.isSuccessful())
                {
                    t1.setText(response.body().getSingleAuction().getName());
                    t2.setText(response.body().getSingleAuction().getDescription());
                    t3.setText(response.body().getSingleAuction().getStartPrice()+"");
                    t4.setText(response.body().getSingleAuction().getBiddingPrice()+"");
                    t5.setText(response.body().getSingleAuction().getStartAt()+"");
                    t6.setText(response.body().getSingleAuction().getEndAt()+"");

                }

            }

            @Override
            public void onFailure(Call<Authentication2> call, Throwable t) {
                Log.d("badawyyyyy",t.getMessage());

            }
        });
    }
}