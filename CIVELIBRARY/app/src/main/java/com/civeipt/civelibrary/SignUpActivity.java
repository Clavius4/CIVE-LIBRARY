package com.civeipt.civelibrary;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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


public class SignUpActivity extends AppCompatActivity {


    Button submit, btnBack;
    EditText Fname, Mname, Lname, RegNo, Program, Email, Phone,  CreatedPassword, ConfirmPassword;
    Validation valid;
    URLs urLs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        submit = findViewById(R.id.btnRegister);
        btnBack = findViewById(R.id.btnBack);
        Fname = findViewById(R.id.edtFname);
        Mname = findViewById(R.id.edtMname);
        Lname = findViewById(R.id.edtLname);
        RegNo = findViewById(R.id.edtRegNo);
        Program = findViewById(R.id.edtProgram);
        Email = findViewById(R.id.edtEmail);
        Phone = findViewById(R.id.edtPhone);
        CreatedPassword = findViewById(R.id.edtCreatepassword);
        ConfirmPassword = findViewById(R.id.edtConfirmpassword);
        valid = new Validation();
        urLs = new URLs();

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(intent);
        });

        submit.setOnClickListener(view -> {


            if(Fname.getText().toString().isEmpty()){
                Fname.setHintTextColor(Color.RED);
                Fname.setHint("First name");

            }
            else if(Mname.getText().toString().isEmpty()){
                Mname.setHintTextColor(Color.RED);
                Mname.setHint("Middle name");

            }
            else if(Lname.getText().toString().isEmpty()){
                Lname.setHintTextColor(Color.RED);
                Lname.setHint("Last name");

            }
            else if(RegNo.getText().toString().isEmpty() || !valid.reg_no_Validation(RegNo.getText().toString())){
                RegNo.setHintTextColor(Color.RED);
                RegNo.setText("");
                RegNo.setHint("Incorrect UDOM reg No");

            }
            else if(Program.getText().toString().isEmpty()){
                Program.setHintTextColor(Color.RED);
                Program.setHint("Program");

            }
            else if(Email.getText().toString().isEmpty() || !valid.isValidEmail(Email.getText().toString())){
                Email.setHintTextColor(Color.RED);
                Email.setText("");
                Email.setHint("Invalid Email");
            }

            else if(Phone.getText().toString().isEmpty() || !valid.phone_no_validation(Phone.getText().toString())){
                Phone.setHintTextColor(Color.RED);
                Phone.setText("");
                Phone.setHint("Format +255-888-888-888");
            }
            else if(CreatedPassword.getText().toString().isEmpty()){
                CreatedPassword.setHintTextColor(Color.RED);
                CreatedPassword.setHint("Create password");

            }
            else if(ConfirmPassword.getText().toString().isEmpty()){
                ConfirmPassword.setHintTextColor(Color.RED);
                ConfirmPassword.setHint("Confirm password");

            }else{

                if(valid.isValidPassword(CreatedPassword.getText().toString())){
                    if(CreatedPassword.getText().toString().equals(ConfirmPassword.getText().toString())){

                        StringRequest stringRequest= new StringRequest(Request.Method.POST, urLs.URLSignUp(), response -> {
                            if (response.equalsIgnoreCase("Registration successfully")){
                                Toast.makeText(SignUpActivity.this, response+"\nUser name: "+
                                        RegNo.getText().toString()+"\nPassword: "+
                                        CreatedPassword.getText().toString(), Toast.LENGTH_LONG).show();
                                Intent i = new Intent(SignUpActivity.this, MainActivity.class);
                                startActivity(i);
                            }
                            else{
                                Toast.makeText(SignUpActivity.this, "User already exist! please login", Toast.LENGTH_SHORT).show();
                            }
                        }, error -> Toast.makeText(SignUpActivity.this, "No network Connection", Toast.LENGTH_LONG).show()){

                            @Override
                            protected Map<String, String> getParams() {
                                Map<String, String> params= new HashMap<>();
                                params.put("reg_no",RegNo.getText().toString().trim());
                                params.put("firstname",Fname.getText().toString().trim());
                                params.put("secondname",Mname.getText().toString().trim());
                                params.put("lastname",Lname.getText().toString().trim());
                                params.put("programme",Program.getText().toString().trim());
                                params.put("email",Email.getText().toString().trim());
                                params.put("phonenumber",Phone.getText().toString().trim());
                                params.put("password",CreatedPassword.getText().toString());
                                return params;
                            }
                        };

                        RequestQueue requestQueue = Volley.newRequestQueue(SignUpActivity.this);
                        requestQueue.add(stringRequest);


                    }
                    else{
                        Toast.makeText(SignUpActivity.this, "Password not matching", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(SignUpActivity.this, "Weak password! Password must contain\n" +
                            "LowerCase, UpperCase, Digits and Special Characters", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}