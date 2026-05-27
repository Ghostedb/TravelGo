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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PalmFragment extends Fragment {

    RecyclerView recyclerView;
    BiletAdapter adapter;
    DbHelper dbHelper;


    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_palm, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewBiletler);
        dbHelper = new DbHelper(getContext());


        SharedPreferences sp = requireActivity().getSharedPreferences("KullaniciOturum", Context.MODE_PRIVATE);
        int aktifKullaniciId = sp.getInt("userId", 1);

        ArrayList<BiletYolculuk> biletler = dbHelper.kullaniciBiletleriniGetir(aktifKullaniciId);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new BiletAdapter(biletler);
        recyclerView.setAdapter(adapter);



        return view;
    }
}