package com.example.travelapp_630;

public class BiletYolculuk {
    private int biletId;
    private String mekanAdi;
    private String sehir;
    private String ulke;
    private  String biletTuru;
    private String tarih;
    private  String saat;
    private double toplamTutar;
    private String resimAdi;

    public int getBiletId(){
        return biletId;
    }

    public void setBiletId(int biletId1){
        this.biletId = biletId1;
    }

    public String getMekanAdi(){
        return mekanAdi;
    }

    public void setMekanAdi(String mekanAdi){
        this.mekanAdi = mekanAdi;
    }

    public String getSehir(){
        return sehir;
    }

    public void setSehir(String sehir){
        this.sehir = sehir;
    }

    public String getUlke(){
        return  ulke;
    }

    public void setUlke(String ulke){
        this.ulke = ulke;
    }

    public String getBiletTuru(){
        return biletTuru;
    }

    public void setBiletTuru(String biletTuru){
        this.biletTuru = biletTuru;
    }

    public String getTarih(){
        return tarih;
    }

    public void setTarih(String tarih){
        this.tarih = tarih;
    }

    public String getSaat(){
        return  saat;
    }

    public void setSaat(String saat){
        this.saat = saat;
    }

    public double getToplamTutar(){
        return toplamTutar;
    }

    public void setToplamTutar(double toplamTutar){
        this.toplamTutar = toplamTutar;
    }

    public String getResimAdi(){
        return  resimAdi;
    }

    public void setResimAdi(String resimAdi){
        this.resimAdi = resimAdi;
    }
}
