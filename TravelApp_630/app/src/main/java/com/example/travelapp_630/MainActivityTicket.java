package com.example.travelapp_630;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class MainActivityTicket extends AppCompatActivity {

    TextView txtToolbarBaslik, txtMekanAdi, txtAciklama, txtFiyat, txtKonum, txtBiletZamani;
    ImageView imgMekanUstResim, imgQRCode;
    MaterialButton btnPDF, btnTakvim;
    ImageButton btnGeri;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_main);

        txtToolbarBaslik = findViewById(R.id.toolbarTitleBolge);
        txtMekanAdi = findViewById(R.id.textView61);
        txtAciklama = findViewById(R.id.textView62);
        txtFiyat = findViewById(R.id.textView6400);
        txtKonum = findViewById(R.id.textView60);
        txtBiletZamani = findViewById(R.id.textView6300);
        imgMekanUstResim = findViewById(R.id.imageView7);
        imgQRCode = findViewById(R.id.imageView33);
        btnPDF = findViewById(R.id.buttonPDF);
        btnTakvim = findViewById(R.id.buttonTakvim);
        btnGeri = findViewById(R.id.btnBack2);

        String gelenMekan = getIntent().getStringExtra("mekanAdi");
        String gelenFiyat = getIntent().getStringExtra("fiyat");
        String gelenAciklama = getIntent().getStringExtra("aciklama");
        int gelenResim = getIntent().getIntExtra("resim", 0);
        String gelenTarih = getIntent().getStringExtra("tarih");
        String gelenSaat = getIntent().getStringExtra("saat");

        if (gelenMekan != null) {
            txtToolbarBaslik.setText(gelenMekan.toUpperCase());
            txtMekanAdi.setText(gelenMekan);
            txtKonum.setText(gelenMekan + " Lokasyonu");
        }

        if (gelenFiyat != null) {
            txtFiyat.setText("€" + gelenFiyat);
        }

        if (gelenAciklama != null) {
            txtAciklama.setText(gelenAciklama);
        }

        if (gelenTarih != null && gelenSaat != null) {
            txtBiletZamani.setText(gelenTarih + " - " + gelenSaat);
        } else {
            txtBiletZamani.setText("26/05/2026 21:00");
        }

        if (gelenResim != 0) {
            ImageUtils.setSafeImage(imgMekanUstResim, gelenResim);
        }

        ImageUtils.setSafeImage(imgQRCode, R.drawable.qr_code);

        btnGeri.setOnClickListener(v -> finish());

        btnPDF.setOnClickListener(v -> {
            Toast.makeText(MainActivityTicket.this, "Biletiniz PDF olarak başarıyla indirildi!", Toast.LENGTH_SHORT).show();
        });

        btnTakvim.setOnClickListener(v -> {
            Toast.makeText(MainActivityTicket.this, "Seyahat planı takviminize eklendi!", Toast.LENGTH_SHORT).show();
        });
    }
}