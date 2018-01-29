package com.example.satriowibowo.eadcafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetailPemesan extends AppCompatActivity {
private EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemesan);

        Button btn = (Button)findViewById(R.id.buttonSelesai);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed = (EditText) findViewById(R.id.editText);
                String ez = ed.getText().toString();
                Intent i = new Intent(DetailPemesan.this, MenuActivity.class);
                startActivity(i);
                Toast.makeText(DetailPemesan.this,
                        "Terima kasih "+ez+" telah memesan", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
