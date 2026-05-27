package com.example.travelapp_630;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class BiletAdapter extends RecyclerView.Adapter<BiletAdapter.BiletHolder> {

    ArrayList<BiletYolculuk> biletListesi;

    public BiletAdapter(ArrayList<BiletYolculuk> biletListesi) {
        this.biletListesi = biletListesi;
    }

    @NonNull
    @Override
    public BiletHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bilet, parent, false);
        return new BiletHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BiletHolder holder, int position) {
        BiletYolculuk bilet = biletListesi.get(position);
        holder.txtMekan.setText(bilet.getMekanAdi());
        holder.txtUlke.setText(bilet.getSehir() + "/" + bilet.getUlke());
        holder.txtFiyat.setText(bilet.getToplamTutar() + "€");

        int resimId = holder.itemView.getContext().getResources().getIdentifier(
                bilet.getResimAdi(), "drawable", holder.itemView.getContext().getPackageName());

        if (resimId != 0) {
            holder.imgMekan.setImageResource(resimId);
        } else {
            resimId = R.drawable.berlin;
            holder.imgMekan.setImageResource(resimId);
        }

        int finalResimId = resimId;
        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, MainActivityTicket.class);
            intent.putExtra("mekanAdi", bilet.getMekanAdi());
            intent.putExtra("fiyat", String.valueOf(bilet.getToplamTutar()));
            intent.putExtra("resim", finalResimId);
            intent.putExtra("tarih", bilet.getTarih());
            intent.putExtra("saat", bilet.getSaat());

            String aciklama = "";
            String mekan = bilet.getMekanAdi().toLowerCase();
            if (mekan.contains("roma")) {
                aciklama = "Roma mekanlarına bilet alın. Antik Kolezyum, tarihi tapınaklar ve İtalyan kültürünün kalbinde benzersiz bir yolculuk.";
            } else if (mekan.contains("berlin")) {
                aciklama = "Berlin mekanlarına bilet alın. Tarihi dokusu, modern yaşamı ve büyüleyici müzeleriyle unutulmaz bir Avrupa seyahati sunuyor.";
            } else if (mekan.contains("tokyo")) {
                aciklama = "Tokyo mekanlarına bilet alın. Geleneksel tapınakların gölgesinde yükselen neon ışıklı gökdelenler ve bambaşka bir dünya kültürü.";
            } else if (mekan.contains("madrid")) {
                aciklama = "Madrid'in tarihi sokakları, muhteşem meydanları ve ünlü müzelerini keşfetmek için harika bir bilet.";
            } else if (mekan.contains("new york")) {
                aciklama = "Özgürlük Anıtı ve Times Meydanı gibi ikonik lokasyonları içeren New York seyahat bileti.";
            } else if (mekan.contains("londra") || mekan.contains("london")) {
                aciklama = "Big Ben, London Eye and Thames Nehri kıyısındaki eşsiz tarihi mekanlara erişim biletiniz.";
            } else if (mekan.contains("paris")) {
                aciklama = "Eyfel Kulesi ve Paris'in romantik sokaklarında sanatsal bir tura çıkın.";
            } else if (mekan.contains("zafer")) {
                aciklama = "Şanzelize caddesinin başında yer alan tarihi Zafer Takı anıtı giriş bileti.";
            } else if (mekan.contains("ayasofya")) {
                aciklama = "İstanbul'un kalbinde, yüzyıllara meydan okuyan mimari şaheser Ayasofya Camii turu.";
            } else if (mekan.contains("sparta")) {
                aciklama = "Antik Yunan medeniyetinin ve savaşçı Sparta ruhunun tarihi kalıntılarını keşfedin.";
            } else if (mekan.contains("varsailles") || mekan.contains("versailles")) {
                aciklama = "Fransız ihtişamının simgesi, göz alıcı bahçeleriyle ünlü Versay Sarayı giriş kartı.";
            } else if (mekan.contains("bali") || mekan.contains("ball")) {
                aciklama = "Egzotik plajları, pirinç tarlaları ve huzur veren tapınaklarıyla Bali seyahat paketi.";
            } else if (mekan.contains("altın") || mekan.contains("altin") || mekan.contains("köprü")) {
                aciklama = "San Francisco'nun simgesi olan dünyaca ünlü Altın Köprü (Golden Gate) gezi rotası.";
            } else {
                aciklama = "Tüm popüler destinasyonları kapsayan genel etkinlik ve lokasyon giriş paketi.";
            }

            intent.putExtra("aciklama", aciklama);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return biletListesi.size();
    }

    class BiletHolder extends RecyclerView.ViewHolder {
        ImageView imgMekan;
        TextView txtMekan, txtUlke, txtFiyat;

        public BiletHolder(@NonNull View itemView) {
            super(itemView);
            imgMekan = itemView.findViewById(R.id.imgBiletFoto);
            txtMekan = itemView.findViewById(R.id.txtBiletMekanAdi);
            txtUlke = itemView.findViewById(R.id.txtBiletUlke);
            txtFiyat = itemView.findViewById(R.id.txtBiletFiyat);
        }
    }
}