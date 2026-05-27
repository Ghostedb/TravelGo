package com.example.travelapp_630;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TravelDb";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, email TEXT, password TEXT)");
        db.execSQL("CREATE TABLE mekanlar (id INTEGER PRIMARY KEY, mekan_adi TEXT, sehir TEXT, ulke TEXT, resim_adi TEXT)");
        db.execSQL("CREATE TABLE biletler (id INTEGER PRIMARY KEY AUTOINCREMENT, kullanici_id INTEGER, mekan_id INTEGER, bilet_turu TEXT, tarih TEXT, saat TEXT, toplam_tutar REAL)");

        mekanlariOtomatikEkle(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS mekanlar");
        db.execSQL("DROP TABLE IF EXISTS biletler");
        onCreate(db);
    }

    private void mekanlariOtomatikEkle(SQLiteDatabase db) {
        String[][] varsayilanMekanlar = {
                {"1", "Berlin Sarayı", "Berlin", "Almanya", "berlin"},
                {"2", "Kolezyum", "Roma", "İtalya", "roma_2"},
                {"3", "Sensoji Tapınağı", "Tokyo", "Japonya", "tokyo"},
                {"4", "Plaza Mayor", "Madrid", "İspanya", "madrid"},
                {"5", "Times Meydanı", "New York", "ABD", "new_york"},
                {"6", "Big Ben", "Londra", "İngiltere", "global"},
                {"7", "Dünya Turu", "Global", "Dünya", "nokta"},
                {"8", "Eyfel Kulesi", "Paris", "Fransa", "paris"},
                {"9", "Zafer Takı", "Paris", "Fransa", "paris_anit"},
                {"10", "Ayasofya", "İstanbul", "Türkiye", "ayasofya"},
                {"11", "Sparta", "Atina", "Yunanistan", "atina"},
                {"12", "Versay Sarayı", "Versailles", "Fransa", "versailles"},
                {"13", "Bali", "Bali", "Endonezya", "doga"},
                {"14", "Altın Köprü", "San Francisco", "ABD", "golden"}
        };

        for (String[] mekan : varsayilanMekanlar) {
            ContentValues cv = new ContentValues();
            cv.put("id", Integer.parseInt(mekan[0]));
            cv.put("mekan_adi", mekan[1]);
            cv.put("sehir", mekan[2]);
            cv.put("ulke", mekan[3]);
            cv.put("resim_adi", mekan[4]);
            db.insert("mekanlar", null, cv);
        }
    }

    public void biletSatinAl(int kullaniciId, int mekanId, String biletTuru, String tarih, String saat, double toplamTutar) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("kullanici_id", kullaniciId);
        cv.put("mekan_id", mekanId);
        cv.put("bilet_turu", biletTuru);
        cv.put("tarih", tarih);
        cv.put("saat", saat);
        cv.put("toplam_tutar", toplamTutar);
        db.insert("biletler", null, cv);
    }

    public ArrayList<BiletYolculuk> kullaniciBiletleriniGetir(int kullaniciId) {
        ArrayList<BiletYolculuk> liste = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String sorgu = "SELECT b.toplam_tutar, b.tarih, b.saat, m.mekan_adi, m.sehir, m.ulke, m.resim_adi " +
                "FROM biletler b " +
                "INNER JOIN mekanlar m ON b.mekan_id = m.id " +
                "WHERE b.kullanici_id = ?";

        Cursor cursor = db.rawQuery(sorgu, new String[]{String.valueOf(kullaniciId)});

        if (cursor.moveToFirst()) {
            do {
                BiletYolculuk bilet = new BiletYolculuk();
                bilet.setToplamTutar(cursor.getDouble(0));
                bilet.setTarih(cursor.getString(1));
                bilet.setSaat(cursor.getString(2));
                bilet.setMekanAdi(cursor.getString(3));
                bilet.setSehir(cursor.getString(4));
                bilet.setUlke(cursor.getString(5));
                bilet.setResimAdi(cursor.getString(6));
                liste.add(bilet);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return liste;
    }
}