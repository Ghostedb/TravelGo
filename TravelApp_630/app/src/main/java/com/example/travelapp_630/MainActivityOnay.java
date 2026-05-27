package com.example.travelapp_630;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class MainActivityOnay extends AppCompatActivity {

    TextView txtToolbarBaslik, txtKartMekanAdi, txtFiyat, txtKonumUlke;
    TextView txtKullaniciAdSoyad, txtKullaniciEposta;
    TextView txtBiletTuru, txtBiletMekan, txtBiletZaman;
    ImageView imgMekanFoto;
    ImageButton btnGeri;
    MaterialButton btnOnay;
    DbHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onay_main);

        dbHelper = new DbHelper(this);

        txtToolbarBaslik = findViewById(R.id.toolbarTitleBolge);
        txtKartMekanAdi = findViewById(R.id.textViewYer);
        txtKonumUlke = findViewById(R.id.textView46);
        txtFiyat = findViewById(R.id.textView59);

        txtKullaniciAdSoyad = findViewById(R.id.textView51);
        txtKullaniciEposta = findViewById(R.id.textView55);

        txtBiletTuru = findViewById(R.id.textView510);
        txtBiletMekan = findViewById(R.id.textView550);
        txtBiletZaman = findViewById(R.id.textView580);

        imgMekanFoto = findViewById(R.id.imageView25);
        btnGeri = findViewById(R.id.btnBack1);
        btnOnay = findViewById(R.id.buttonOnay);

        String gelenMekan = getIntent().getStringExtra("mekanAdi");
        String gelenFiyat = getIntent().getStringExtra("fiyat");
        int gelenResim = getIntent().getIntExtra("resim", 0);

        if (gelenMekan != null) {
            txtToolbarBaslik.setText(gelenMekan.toUpperCase());
            txtKartMekanAdi.setText(gelenMekan);
            txtBiletMekan.setText(gelenMekan);

            String kontrol = gelenMekan.toLowerCase();
            if (kontrol.contains("roma")) {
                txtKonumUlke.setText("Roma/İtalya");
            } else if (kontrol.contains("berlin")) {
                txtKonumUlke.setText("Berlin/Almanya");
            } else if (kontrol.contains("tokyo")) {
                txtKonumUlke.setText("Tokyo/Japonya");
            } else if (kontrol.contains("madrid")) {
                txtKonumUlke.setText("Madrid/İspanya");
            } else if (kontrol.contains("new york")) {
                txtKonumUlke.setText("New York/ABD");
            } else if (kontrol.contains("londra") || kontrol.contains("london")) {
                txtKonumUlke.setText("Londra/İngiltere");
            } else if (kontrol.contains("paris") || kontrol.contains("zafer")) {
                txtKonumUlke.setText("Paris/Fransa");
            } else if (kontrol.contains("ayasofya")) {
                txtKonumUlke.setText("İstanbul/Türkiye");
            } else if (kontrol.contains("sparta")) {
                txtKonumUlke.setText("Atina/Yunanistan");
            } else if (kontrol.contains("varsailles") || kontrol.contains("versailles")) {
                txtKonumUlke.setText("Versailles/Fransa");
            } else if (kontrol.contains("bali") || kontrol.contains("ball")) {
                txtKonumUlke.setText("Bali/Endonezya");
            } else if (kontrol.contains("altın") || kontrol.contains("altin") || kontrol.contains("köprü")) {
                txtKonumUlke.setText("San Francisco/ABD");
            } else {
                txtKonumUlke.setText(gelenMekan);
            }
        }

        if (gelenFiyat != null) {
            txtFiyat.setText("€" + gelenFiyat);
        }

        if (gelenResim != 0) {
            imgMekanFoto.setImageResource(gelenResim);
        }

        txtKullaniciAdSoyad.setText("Anıl Cemre Saçak");
        txtKullaniciEposta.setText("anil.546930@gmail.com");
        txtBiletTuru.setText("Öğrenci Bileti");
        txtBiletZaman.setText("26/05/2026 21:00");

        btnGeri.setOnClickListener(v -> finish());

        btnOnay.setOnClickListener(v -> {
            SharedPreferences sp = getSharedPreferences("KullaniciOturum", MODE_PRIVATE);
            int aktifKullaniciId = sp.getInt("userId", 1);

            double fiyatCevir = 80.0;
            try {
                if (gelenFiyat != null) {
                    fiyatCevir = Double.parseDouble(gelenFiyat);
                }
            } catch (Exception e) {
                fiyatCevir = 80.0;
            }

            int dinamikMekanId = 1;
            if (gelenMekan != null) {
                String kontrolIsmi = gelenMekan.toLowerCase();
                if (kontrolIsmi.contains("roma")) {
                    dinamikMekanId = 2;
                } else if (kontrolIsmi.contains("tokyo")) {
                    dinamikMekanId = 3;
                } else if (kontrolIsmi.contains("madrid")) {
                    dinamikMekanId = 4;
                } else if (kontrolIsmi.contains("new york")) {
                    dinamikMekanId = 5;
                } else if (kontrolIsmi.contains("londra") || kontrolIsmi.contains("london")) {
                    dinamikMekanId = 6;
                } else if (kontrolIsmi.contains("dünya") || kontrolIsmi.contains("global")) {
                    dinamikMekanId = 7;
                } else if (kontrolIsmi.contains("paris")) {
                    dinamikMekanId = 8;
                } else if (kontrolIsmi.contains("zafer")) {
                    dinamikMekanId = 9;
                } else if (kontrolIsmi.contains("ayasofya")) {
                    dinamikMekanId = 10;
                } else if (kontrolIsmi.contains("sparta")) {
                    dinamikMekanId = 11;
                } else if (kontrolIsmi.contains("varsailles") || kontrolIsmi.contains("versailles")) {
                    dinamikMekanId = 12;
                } else if (kontrolIsmi.contains("bali") || kontrolIsmi.contains("ball")) {
                    dinamikMekanId = 13;
                } else if (kontrolIsmi.contains("altın") || kontrolIsmi.contains("altin") || kontrolIsmi.contains("köprü") || kontrolIsmi.contains("kopru")) {
                    dinamikMekanId = 14;
                }
            }

            dbHelper.biletSatinAl(aktifKullaniciId, dinamikMekanId, "Öğrenci Bileti", "26/05/2026", "21:00", fiyatCevir);

            Toast.makeText(MainActivityOnay.this, "Biletiniz Onaylandı ve Cüzdana Kaydedildi!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(MainActivityOnay.this, MainActivityTicket.class);
            intent.putExtra("mekanAdi", gelenMekan);
            intent.putExtra("fiyat", gelenFiyat);
            intent.putExtra("resim", gelenResim);
            startActivity(intent);
            finish();
        });
    }
}