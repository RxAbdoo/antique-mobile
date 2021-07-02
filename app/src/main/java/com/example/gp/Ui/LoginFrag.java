package com.example.gp.Ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.example.gp.Models.Authentication;
import com.example.gp.Models.PostClient;
import com.example.gp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFrag extends Fragment {
    EditText t1,t2;
    TextView t3;
    String email,password,token,name;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    AppCompatButton b;
    float v=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup group=(ViewGroup)inflater.inflate(R.layout.login_fragment, container, false);
        t1 = group.findViewById(R.id.email);
        t2 = group.findViewById(R.id.password);
        t3 = group.findViewById(R.id.forget);
        b= group.findViewById(R.id.login);
        t1.setTranslationX(800);
        t2.setTranslationX(800);
        t3.setTranslationX(800);
        b.setTranslationX(800);
        t1.setAlpha(v);
        t2.setAlpha(v);
        b.setAlpha(v);
        t1.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        t2.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        t3.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        b.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        login();
        return group;
    }
    public void login()
    {

        b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            email = t1.getText().toString().trim();
            password = t2.getText().toString().trim();
            PostClient.getInstance().login(email,password).enqueue(new Callback<Authentication>() {
                @Override
                public void onResponse(Call<Authentication> call, Response<Authentication> response) {
                    if(response.isSuccessful()) {
                        token  = response.body().getData().getToken();
                        name = response.body().getData().getName();
                        email = response.body().getData().getEmail();
                        Log.d("TAG222222", email);
                        preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                        editor=preferences.edit();
                        editor.putString("token",token);
                        editor.putString("email",email);
                        editor.putString("name",name);
                        editor.apply();
                        Log.d("ddddddddd", preferences.getString("token","45f45g45f")+preferences.getString("name","Ahmed")+preferences.getString("email","a4@gm.com"));

                    }
                    else
                    {
                        Toast.makeText(getContext(), "doneeeeeeee", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<Authentication> call, Throwable t) {
                    Log.d("TAG3", t.getMessage());
                    Toast.makeText(getContext(), "nnnnnnoneeeeeeee", Toast.LENGTH_SHORT).show();

                }
            });

        }
    });


    }
}
