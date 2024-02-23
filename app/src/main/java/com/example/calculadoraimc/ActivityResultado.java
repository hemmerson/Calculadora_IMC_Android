package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityResultado extends AppCompatActivity {

    private TextView textViewNome;
    private TextView textViewIMC;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        textViewNome = findViewById(R.id.textViewNome);
        textViewIMC = findViewById(R.id.textViewIMC);

        Intent intent = getIntent();
        if (intent != null) {
            double imc = intent.getDoubleExtra("imc",0);
            textViewNome.setText(intent.getStringExtra("nome"));
            if (imc > 25.0){
                textViewIMC.setTextColor(R.color.orange);
            }
            else {
                textViewIMC.setTextColor(R.color.blue);
            }
            textViewIMC.setText(String.format("%.2f",imc));
        }
    }
}