package com.civeipt.civelibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    Button btnLogin, btnSignup;
    EditText txtUsername, txtPassword;
    URLs urLs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (Button) findViewById(R.id.btnlogin);
        btnSignup = (Button) findViewById(R.id.btnsignup);
        txtUsername = (EditText) findViewById(R.id.edtloginusername);
        txtPassword = (EditText) findViewById(R.id.edtLoginPassword);
        urLs = new URLs();

        btnSignup.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(i);
        });

        btnLogin.setOnClickListener(view -> {

            StringRequest stringRequest = new StringRequest(Request.Method.POST, urLs.URLogin(), response -> {
                  if (response.equalsIgnoreCase("login successfully")){
                      Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                      intent.putExtra(HomeActivity.reg_no, String.valueOf(txtUsername.getText()));
                      startActivity(intent);

                      finish();
                  }
                  else{
                      Toast.makeText(MainActivity.this, "Username Or Password Not Correct", Toast.LENGTH_SHORT).show();
                  }
            }, error -> Toast.makeText(MainActivity.this, "No Network Connection", Toast.LENGTH_LONG).show()){

                @NonNull
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params= new HashMap<>();
                    params.put("reg_no", txtUsername.getText().toString());
                    params.put("password",txtPassword.getText().toString());
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
            requestQueue.add(stringRequest);

        });
    }
}