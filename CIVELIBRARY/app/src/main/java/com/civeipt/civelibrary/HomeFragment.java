package com.civeipt.civelibrary;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    Button btnprofile, btnbooks, btnAbout, btnmore, btnhelp,btnlogout;
    private String registrationNo=null;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        btnprofile = v.findViewById(R.id.btnprofile);
        btnbooks = v.findViewById(R.id.btnbooks);
        btnAbout = v.findViewById(R.id.btnAbout);
        btnmore = v.findViewById(R.id.btnmore);
        btnhelp = v.findViewById(R.id.btnhelp);
        btnlogout = v.findViewById(R.id.btnlogout);

        assert this.getArguments() != null;
        registrationNo = this.getArguments().getString("reg_no");


        btnprofile.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("reg_no", String.valueOf(registrationNo));
            Fragment fragment = new ProfileFragment();
            fragment.setArguments(bundle);
            getParentFragmentManager()
                    .beginTransaction()
                    .add(R.id.drawlayout, fragment, null)
                    .addToBackStack(null)
                    .commit();
        });

        btnbooks.setOnClickListener(view -> {
            Intent i = new Intent(getContext(), BooksActivity.class);
            startActivity(i);
        });

        btnAbout.setOnClickListener(view -> {
            getParentFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.navHostFragment, AboutFragment.class, null)
                    .commit();
        });

        btnmore.setOnClickListener(view -> {
            Intent i = new Intent(getContext(), WebsiteActivity.class);
            startActivity(i);
        });

        btnhelp.setOnClickListener(view -> {
            getParentFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.navHostFragment, HelpFragment.class, null)
                    .commit();
        });

        btnlogout.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            builder.setTitle("Confirm");
            builder.setMessage("Are you sure?");

            builder.setPositiveButton("YES", (dialog, which) -> {
                Intent i = new Intent(getContext(), MainActivity.class);
                startActivity(i);
                requireActivity().finish();
            });

            builder.setNegativeButton("NO", (dialog, which) -> dialog.dismiss());

            AlertDialog alert = builder.create();
            alert.show();
        });

        return v;
    }
}