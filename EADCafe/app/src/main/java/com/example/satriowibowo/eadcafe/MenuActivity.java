package com.example.satriowibowo.eadcafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
//import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.ActionBar;
import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> JudulMenu;
    private ArrayList<String> HargaMenu;
    private ArrayList<Integer> GambarMenu;
    private ArrayList<String> DeskripsiMenu;
    //Daftar Judul
    private String[] Judul = {"Nasi Goreng", "Mie Goreng Spesial","Mie kuah Spesial","Sate Madura","Nasi Wagyu","Mie Kuah Upnormal","Nasi goreng bawang","Orange Ice Cream","Lemon Tea","Es teh"};
    //Daftar Gambar
    private int[] Gambar = {R.drawable.nasigoreng, R.drawable.miespecial,R.drawable.miekuah,R.drawable.sate,R.drawable.nasiwagyu,R.drawable.miekuah,R.drawable.nasigorengbawang,R.drawable.orangeice,R.drawable.lemontea,R.drawable.estea};
    private String[] harga = {"Rp 15.000","Rp 10.000","Rp 10.000","Rp 25.000","Rp 30.000","Rp 15.000","Rp 25.000","Rp 30.000","Rp 5.000","Rp 4.000"};
    private String[] deskripsi = {"Nasi, Bawang, Sayur, Ayam, Daging, Telur", "Mie Indomie, Cabe, Sayur, Telur","Mie kuah, Sayur, Daging","Nasi, Daging Kambing","Nasi, Daging Kambing, Telur","Mie Indomie, Telur","Nasi, Bumbu Pilihan, Bawang, Sayur","Ice Cream, Jeruk, Susu","Es Tea, Lemon","Tea, Es Batu"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        JudulMenu = new ArrayList<>();
        GambarMenu = new ArrayList<>();
        HargaMenu = new ArrayList<>();
        DeskripsiMenu = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        DaftarItem();
        //Menggunakan Layout Manager, Dan Membuat List Secara Vertical
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(JudulMenu, GambarMenu, HargaMenu, DeskripsiMenu);
        //Memasang Adapter pada RecyclerView
        recyclerView.setAdapter(adapter);
    }

    private void DaftarItem(){
        for (int w=0; w<Judul.length; w++){
            GambarMenu.add(Gambar[w]);
            JudulMenu.add(Judul[w]);
            HargaMenu.add(harga[w]);
            DeskripsiMenu.add(deskripsi[w]);

        }
    }
}
