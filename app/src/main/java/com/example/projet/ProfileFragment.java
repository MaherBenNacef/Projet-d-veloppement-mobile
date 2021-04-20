package com.example.projet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    TextView nameUser,emailUser,phoneUser;
    String n , e , p;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile,container,false);
        nameUser=v.findViewById(R.id.name);
        emailUser=v.findViewById(R.id.email);
        phoneUser=v.findViewById(R.id.phone);
        nameUser.setText(n);
        emailUser.setText(e);
        phoneUser.setText(p);
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
