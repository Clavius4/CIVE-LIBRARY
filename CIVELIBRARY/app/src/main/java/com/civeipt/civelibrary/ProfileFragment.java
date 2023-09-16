package com.civeipt.civelibrary;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    public static ArrayList<profileDetails> profileDetailsArrayList = new ArrayList<>();

    private String registrationNo=null;
    TextView regNo, edtProgram, edtEmail, edtname, edtphone;
    ImageButton btnback;
    URLs urLs;

    public static String reg_no, firstname, secondname, lastname, programme, phonenumber, email;


    public ProfileFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        regNo = v.findViewById(R.id.edtregistration);
        edtProgram = v.findViewById(R.id.edtProgram);
        edtEmail = v.findViewById(R.id.edtEmail);
        edtname = v.findViewById(R.id.edtname);
        edtphone = v.findViewById(R.id.edtphone);
        btnback = v.findViewById(R.id.btnimage);
        urLs = new URLs();

        assert this.getArguments() != null;
        registrationNo = this.getArguments().getString("reg_no");

        getData(registrationNo);

        btnback.setOnClickListener(view -> {
            Intent i = new Intent(getActivity(), HomeActivity.class);
            i.putExtra(HomeActivity.reg_no, String.valueOf(registrationNo));
            startActivity(i);
        });

        return v;
    }

    private void profileDisplay(String reg_no, String firstname, String secondname, String lastname, String email, String phonenumber, String programme) {
        regNo.setText(reg_no);
        edtname.setText(String.format("%s, %s %s", lastname, firstname, secondname));
        edtProgram.setText(programme);
        edtphone.setText(phonenumber);
        edtEmail.setText(email);
    }

    private void getData(String registrationNo) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urLs.URLProfile(), response -> {

            profileDetailsArrayList.clear();
            JSONObject jsonObject;
            try {
                jsonObject = new JSONObject(response);
                String success = jsonObject.getString("Success");
                JSONArray jsonArray = jsonObject.getJSONArray("data");

                if (success.equalsIgnoreCase("1")){
                    for(int i=0; i<jsonArray.length(); i++){
                        JSONObject object = jsonArray.getJSONObject(i);
                        reg_no = object.getString("reg_no");
                        firstname = object.getString("firstname");
                        secondname = object.getString("secondname");
                        lastname = object.getString("lastname");
                        programme = object.getString("programme");
                        email = object.getString("email");
                        phonenumber = object.getString("phonenumber");

                    }
                    profileDisplay(reg_no, firstname, secondname, lastname, email, phonenumber, programme);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> Toast.makeText(getContext(), "No Network Connection", Toast.LENGTH_LONG).show()){

            @NonNull
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params= new HashMap<>();
                params.put("reg_no", String.valueOf(registrationNo));
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }
}