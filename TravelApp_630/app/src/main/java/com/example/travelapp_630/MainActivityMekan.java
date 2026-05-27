package com.example.travelapp_630;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class MainActivityMekan extends AppCompatActivity {

    TextView txtBaslik, txtFiyat, txtFiyatAlt;
    ImageView imgMekanFoto, btnGeri;
    MaterialButton btnSatinAl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mekan_main);

        txtBaslik = findViewById(R.id.toolbarTitleBolge);
        txtFiyat = findViewById(R.id.textViewTutar);
        txtFiyatAlt = findViewById(R.id.textViewTutar2);
        imgMekanFoto = findViewById(R.id.imageViewMekanFoto);
        btnSatinAl = findViewById(R.id.buttonSatinAl);
        btnGeri = findViewById(R.id.btnBack);

        String gelenMekan = getIntent().getStringExtra("mekanAdi");
        String gelenFiyat = getIntent().getStringExtra("fiyat");
        int gelenResim = getIntent().getIntExtra("resim", 0);

        if (gelenMekan != null) {
            txtBaslik.setText(gelenMekan);
        }
        if (gelenFiyat != null) {
            txtFiyat.setText("€" + gelenFiyat);
            txtFiyatAlt.setText("€" + gelenFiyat);
        }
        if (gelenResim != 0) {
            ImageUtils.setSafeImage(imgMekanFoto, gelenResim);
            imgMekanFoto.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        btnGeri.setOnClickListener(v -> finish());

        btnSatinAl.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityMekan.this, MainActivityOnay.class);
            intent.putExtra("mekanAdi", gelenMekan);
            intent.putExtra("fiyat", gelenFiyat);
            intent.putExtra("resim", gelenResim);
            startActivity(intent);
        });
    }

}
