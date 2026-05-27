package com.example.travelapp_630;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;

public class UserFragment extends Fragment {

    MaterialButton btnCikis;
    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        btnCikis = view.findViewById(R.id.btnLogout);
        btnCikis.setOnClickListener(v -> {
            SharedPreferences sp = requireActivity().getSharedPreferences("KullaniciOturum", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.clear();
            editor.apply();

            Intent intent = new Intent(getActivity(), MainActivityLogin.class);
            startActivity(intent);
            requireActivity().finish();
        });

        return view;
    }
}