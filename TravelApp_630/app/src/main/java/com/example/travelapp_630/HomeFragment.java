package com.example.travelapp_630;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    ImageView btnBerlin, btnRoma, btnTokyo ,btnMadrid , btnTokyo2, btnNewYork, btnLandon, btnGlobal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnBerlin = view.findViewById(R.id.imageButtonBerlin);
        btnRoma = view.findViewById(R.id.imageButtonRoma);
        btnTokyo = view.findViewById(R.id.imageButtonTokyo);
        btnMadrid = view.findViewById(R.id.imageButtonMadrid);
        btnTokyo2 = view.findViewById(R.id.imageButtonTokyoCity);
        btnNewYork = view.findViewById(R.id.imageButtonNewYork);
        btnLandon = view.findViewById(R.id.imageButtonLondon);
        btnGlobal = view.findViewById(R.id.imageButtonGlobal);

        ImageView imgRoma = view.findViewById(R.id.imageView6);
        ImageView imgBerlin = view.findViewById(R.id.imageViewBerlin);
        ImageView imgTokyo = view.findViewById(R.id.imageViewTokyo);

        ImageUtils.setSafeImage(imgRoma, R.drawable.roma_2);
        ImageUtils.setSafeImage(imgBerlin, R.drawable.berlin);
        ImageUtils.setSafeImage(imgTokyo, R.drawable.tokyo);

        btnBerlin.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivityMekan.class);
            intent.putExtra("mekanAdi", "Berlin");
            intent.putExtra("fiyat", "80.00");
            intent.putExtra("resim", R.drawable.berlin);
            startActivity(intent);
        });

        btnRoma.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivityMekan.class);
            intent.putExtra("mekanAdi", "ROMA");
            intent.putExtra("fiyat", "50.00");
            intent.putExtra("resim", R.drawable.roma_2);
            startActivity(intent);
        });

        btnTokyo.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivityMekan.class);
            intent.putExtra("mekanAdi", "Tokyo");
            intent.putExtra("fiyat", "120.00");
            intent.putExtra("resim", R.drawable.tokyo);
            startActivity(intent);
        });

        btnTokyo2.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivityMekan.class);
            intent.putExtra("mekanAdi", "Tokyo");
            intent.putExtra("fiyat", "120.00");
            intent.putExtra("resim", R.drawable.tokyo);
            startActivity(intent);
        });

        btnMadrid.setOnClickListener( v -> {
            Intent intent = new Intent(getActivity(), MainActivityMekan.class);
            intent.putExtra("mekanAdi", "Madrid");
            intent.putExtra("fiyat", "170.00");
            intent.putExtra("resim", R.drawable.madrid);
            startActivity(intent);
        });

        btnNewYork.setOnClickListener( v -> {
            Intent intent = new Intent(getActivity(), MainActivityMekan.class);
            intent.putExtra("mekanAdi", "New York");
            intent.putExtra("fiyat", "210.00");
            intent.putExtra("resim", R.drawable.new_york);
            startActivity(intent);
        });

        btnLandon.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivityMekan.class);
            intent.putExtra("mekanAdi", "Londra");
            intent.putExtra("fiyat", "95.00");
            intent.putExtra("resim", R.drawable.london);
            startActivity(intent);
        });

        btnGlobal.setOnClickListener(v -> {
            if (getActivity() instanceof HomeActivity) {
                ((HomeActivity) getActivity()).altMenu.setSelectedItemId(R.id.tab_search);
            }
        });

        return view;
    }
}