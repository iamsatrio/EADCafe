package com.example.satriowibowo.eadcafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnPilih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton(){
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        btnPilih = (Button) findViewById(R.id.button);

        btnPilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(MainActivity.this, MakananActivity.class);
//                        startActivity(i);

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();
//                RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
//                String selectedRadioButtonText = selectedRadioButton.getText().toString();
//                    Toast.makeText(MainActivity.this,
//                            selectedRadioButtonText, Toast.LENGTH_SHORT).show();
                // If nothing is selected from Radio Group, then it return -1
                if (selectedId != -1) {
                    RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
                    String selectedRadioButtonText = selectedRadioButton.getText().toString();
                    if (selectedRadioButtonText.equals("Dine In")){
                        Intent i = new Intent(MainActivity.this, DetailCustomer.class);
                        startActivity(i);
                    }else{
                        Intent i = new Intent(MainActivity.this, DetailPemesan.class);
                        startActivity(i);
                    }
                    Toast.makeText(MainActivity.this,
                            selectedRadioButtonText, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,
                            "Nothing selected", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
