package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends Fragment {
    Button logout_fragment_profile;
    TextView nameUser,emailUser,phoneUser;
    String n , e , p;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile,container,false);
        nameUser=v.findViewById(R.id.name);
        emailUser=v.findViewById(R.id.email);
        phoneUser=v.findViewById(R.id.phone);
        logout_fragment_profile=v.findViewById(R.id.logout_fragment_profile);
        nameUser.setText(n);
        emailUser.setText(e);
        phoneUser.setText(p);
        logout_fragment_profile.setOnClickListener(v1 -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getContext(),Login.class));
            getActivity().finish();
        });
        return v;
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        n=(""+args.get("nameUser"));
        e=(""+args.get("emailUser"));
        p=(""+args.get("phoneUser"));
    }
}
