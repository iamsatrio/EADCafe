package com.example.satriowibowo.eadcafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMenu extends AppCompatActivity {

    private ImageView tam_img;
    private TextView tam_judul;
    private TextView tam_harga;
    private TextView tam_desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tam_img = (ImageView)findViewById(R.id.img_gambar);
        tam_judul = (TextView)findViewById(R.id.txt_nama);
        tam_harga = (TextView)findViewById(R.id.txt_harga);
        tam_desc = (TextView)findViewById(R.id.txt_desc);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String nama = bundle.getString("namaMenu");
        int img = bundle.getInt("imgMenu");
        String harga = bundle.getString("hargaMenu");
        String desc = bundle.getString("descMenu");
        tam_judul.setText(nama);
        tam_harga.setText(harga);
        tam_img.setImageResource(img);
        tam_desc.setText(desc);
    }
}
