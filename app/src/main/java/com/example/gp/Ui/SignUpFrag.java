package com.example.gp.Ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.example.gp.Models.ApiInterface;
import com.example.gp.Models.Authentication;
import com.example.gp.Models.PostClient;
import com.example.gp.R;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpFrag extends Fragment {
    TextInputLayout t1, t2, t3, t4;
    AppCompatButton b;
    String name, email, password1, passwordconf,token;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    boolean isloggedin=false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup group = (ViewGroup) inflater.inflate(R.layout.signup_fragment, container, false);
        b = group.findViewById(R.id.signup);
        t1 = group.findViewById(R.id.FullName);
        t2 = group.findViewById(R.id.email_et1);
        t3 = group.findViewById(R.id.pa_et1);
        t4 = group.findViewById(R.id.pa_et2);


        reg();
        return group;

    }

    public void reg() {
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = t1.getEditText().toString().trim();
                email = t2.getEditText().getText().toString().trim();
                password1 = t3.getEditText().getText().toString().trim();
                passwordconf = t4.getEditText().getText().toString().trim();
                preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                editor=preferences.edit();
                PostClient.getInstance().reg(name,email,password1,passwordconf).enqueue(new Callback<Authentication>() {
                    @Override
                    public void onResponse(Call<Authentication> call, Response<Authentication> response) {
                        if(response.isSuccessful()) {
                            Log.d("TAG", response.body().getData().getToken());
                            token = response.body().getData().getToken();
                            editor.putString("token",token);
                            isloggedin=true;
                            editor.putBoolean("isloggedin",isloggedin);
                            editor.apply();
                            startActivity(new Intent(getContext(),MainHostFragment.class));

                        }
                        else
                        {
                            Log.d("TAG", response.body().getData().getToken());
                        }


                    }

                    @Override
                    public void onFailure(Call<Authentication> call, Throwable t) {
                        Log.d("TAG1", t.getMessage());
                        Toast.makeText(getContext(), "nnnnnnoneeeeeeee", Toast.LENGTH_SHORT).show();
                    }


                });
            }
        });



    }
}







