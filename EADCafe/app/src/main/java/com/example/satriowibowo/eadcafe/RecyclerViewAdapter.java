package com.example.satriowibowo.eadcafe;

/**
 * Created by monyonk on 1/29/18.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

//Class Adapter ini Digunakan Untuk Mengatur Bagaimana Data akan Ditampilkan
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> arrayList; //Digunakan untuk Judul
    private ArrayList<Integer> menuList; //Digunakan untuk Image/Gambar
    private ArrayList<String> hargaList; //Digunakan untuk Harga
    private ArrayList<String> desList; //Digunakan untuk Harga
    //Membuat Konstruktor pada Class RecyclerViewAdapter
    RecyclerViewAdapter(ArrayList<String> arrayList, ArrayList<Integer> memeList, ArrayList<String> hargaList, ArrayList<String> desList){
        this.arrayList = arrayList;
        this.menuList = memeList;
        this.hargaList = hargaList;
        this.desList = desList;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView JudulMenu, SubMenu;
        private ImageView Meme;
        private RelativeLayout ItemList;

        ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi View-View untuk kita gunakan pada RecyclerView
            JudulMenu = (TextView) itemView.findViewById(R.id.memetitle);
            SubMenu = (TextView) itemView.findViewById(R.id.sub_meme);
            Meme = (ImageView) itemView.findViewById(R.id.meme);
            ItemList = (RelativeLayout) itemView.findViewById(R.id.item_list);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_design, parent, false);
        ViewHolder VH = new ViewHolder(V);
        return VH;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //Memanggil Nilai/Value Pada View-View Yang Telah Dibuat pada Posisi Tertentu
        final String Nama = arrayList.get(position);//Mengambil data sesuai dengan posisi yang telah ditentukan
        final String harga = hargaList.get(position);
        final String desc = desList.get(position);
        holder.JudulMenu.setText(Nama);
        holder.SubMenu.setText("Harga: "+harga);
        final int imgMenu = menuList.get(position);
        holder.Meme.setImageResource(menuList.get(position)); // Mengambil gambar sesuai posisi yang telah ditentukan
        //Membuat Aksi Saat Judul Pada List ditekan

        //Membuat Aksi Saat List Ditekan

        holder.ItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = view.getContext();
                Class destinationActivity = DetailMenu.class;
                Intent startChildActivityIntent = new Intent(context, destinationActivity);
                startChildActivityIntent.putExtra("namaMenu",Nama);
                startChildActivityIntent.putExtra("hargaMenu",harga);
                startChildActivityIntent.putExtra("imgMenu",imgMenu);
                startChildActivityIntent.putExtra("descMenu",desc);
                //startChildActivityIntent.putExtra("desMenu",intsoal_hint);

                context.startActivity(startChildActivityIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        //Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return arrayList.size();
    }

}