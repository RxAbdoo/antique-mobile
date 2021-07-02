package com.example.gp.Ui;

import android.os.Bundle;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpFrag extends Fragment {
    EditText t1, t2, t3, t4;
   String token;
    AppCompatButton b;
    REgModel rEgModel;
    String msg;;
    boolean status;
    ApiInterface apiInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup group = (ViewGroup) inflater.inflate(R.layout.signup_fragment, container, false);
        t1 = group.findViewById(R.id.name);
        t2 = group.findViewById(R.id.email1);
        t3 = group.findViewById(R.id.password1);
        t4 = group.findViewById(R.id.passwordconf);
        b = group.findViewById(R.id.signup);
        reg();
        return group;

    }

    public void reg() {
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, email, password1, passwordconf;
                name = t1.getText().toString().trim();
                email = t2.getText().toString().trim();
                password1 = t3.getText().toString().trim();
                passwordconf = t4.getText().toString().trim();
                rEgModel = new REgModel(name, email, password1, passwordconf);

                PostClient.getInstance().reg(name,email,password1,passwordconf).enqueue(new Callback<Authentication>() {
                    @Override
                    public void onResponse(Call<Authentication> call, Response<Authentication> response) {
                        if(response.isSuccessful())
                        Log.d("TAG", response.body().getData().getToken());
                        else
                        {
                           token  = response.body().getData().getToken();
                            Toast.makeText(getContext(), "doneeeeeeee", Toast.LENGTH_SHORT).show();
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







