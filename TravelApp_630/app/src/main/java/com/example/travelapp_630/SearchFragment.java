package com.example.travelapp_630;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {
    ImageView btnParis, btnZaferTaki, btnAyasofya, btnSparta, btnVarsailles, btnTarih, btnLife, btnAlinKopru, btnFestival;
    Button onerilen, tarihi, ulke, onemliYer;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        btnParis = view.findViewById(R.id.imageButtonParis);
        btnZaferTaki = view.findViewById(R.id.imageButtonZaferTaki);
        btnAyasofya = view.findViewById(R.id.imageButtonAyasofya);
        btnSparta = view.findViewById(R.id.imageButtonSparta);
        btnVarsailles = view.findViewById(R.id.imageButtonVerSailles);
        btnTarih = view.findViewById(R.id.imageButtonTarihRoma);
        btnLife = view.findViewById(R.id.imageButtonSaglik);
        btnAlinKopru = view.findViewById(R.id.imageButtonAltinKopru);
        btnFestival = view.findViewById(R.id.imageButtonFestivalTokyo);

        btnParis.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivityMekan.class);
            intent.putExtra("mekanAdi","Paris");
            intent.putExtra("fiyat","71.99");
            intent.putExtra("resim",R.drawable.paris);
            startActivity(intent);
        });

        btnZaferTaki.setOnClickListener(v->{
            Intent intent  = new Intent(getActivity(), MainActivityMekan.class);
            intent.putExtra("mekanAdi","ZaferTaki");
            intent.putExtra("fiyat","120.99");
            intent.putExtra("rasim",R.drawable.paris_anit);
            startActivity(intent);
        });

        btnAyasofya.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), MainActivityMekan.class);
            intent.putExtra("mekanAdi","Ayasofya");
            intent.putExtra("fiyat","57.79");
            intent.putExtra("resim",R.drawable.ayasofya);
            startActivity(intent);
        });
        btnSparta.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), MainActivityMekan.class);
            intent.putExtra("mekanAdi","Sparta");
            intent.putExtra("fiyat","165.10");
            intent.putExtra("resim",R.drawable.atina);
            startActivity(intent);
        });

        btnVarsailles.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), MainActivityMekan.class);
            intent.putExtra("mekanAdi","Varsailles");
            intent.putExtra("fiyat","105.60");
            intent.putExtra("resim",R.drawable.versailles);
            startActivity(intent);
        });

        btnTarih.setOnClickListener(v->{
            Intent intent =  new Intent(getActivity(), MainActivityMekan.class);
            intent.putExtra("mekanAdi","Roma");
            intent.putExtra("fiyat","50.00");
            intent.putExtra("resim",R.drawable.roma_2);
            startActivity(intent);
        });

        btnLife.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), MainActivityMekan.class);
            intent.putExtra("mekanAdi","Ball");
            intent.putExtra("fiyat","234.99");
            intent.putExtra("resim",R.drawable.doga);
            startActivity(intent);
        });

        btnAlinKopru.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), MainActivityMekan.class);
            intent.putExtra("mekanAdi","Altın Köprü");
            intent.putExtra("fiyat","67.00");
            intent.putExtra("resim",R.drawable.golden);
            startActivity(intent);
        });

        btnFestival.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), MainActivityMekan.class);
            intent.putExtra("mekanAdi","Tokyo");
            intent.putExtra("fiyat","120.00");
            intent.putExtra("resim",R.drawable.tokyo);
            startActivity(intent);
        });
        
        return view;
    }
}