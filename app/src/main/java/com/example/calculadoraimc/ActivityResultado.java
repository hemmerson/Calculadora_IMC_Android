package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityResultado extends AppCompatActivity {

    private TextView textViewNome;
    private TextView textViewIMC;
    private ImageView imageViewIMC;
    private TextView textViewResultado;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        textViewNome = findViewById(R.id.textViewNome);
        textViewIMC = findViewById(R.id.textViewIMC);
        imageViewIMC = findViewById(R.id.imageViewIMC);
        textViewResultado = findViewById(R.id.textViewResultado);

        Intent intent = getIntent();
        if (intent != null) {
            double imc = intent.getDoubleExtra("imc",0);
            textViewNome.setText(intent.getStringExtra("nome"));
            textViewIMC.setText(String.format("%.2f",imc));
            if (imc < 18.5){
                textViewIMC.setTextColor(getResources().getColor(R.color.green, null));
                imageViewIMC.setImageResource(R.drawable.____underweight);
                textViewResultado.setText(R.string.abaixo_do_peso);
                textViewResultado.setTextColor(getResources().getColor(R.color.green, null));
            }
            else if(imc >= 18.5 && imc < 25){
                textViewIMC.setTextColor(getResources().getColor(R.color.blue, null));
                imageViewIMC.setImageResource(R.drawable.____normal);
                textViewResultado.setText(R.string.peso_normal);
                textViewResultado.setTextColor(getResources().getColor(R.color.blue, null));
            }
            else if(imc >= 25 && imc < 30){
                textViewIMC.setTextColor(getResources().getColor(R.color.yellow, null));
                imageViewIMC.setImageResource(R.drawable.____overweight);
                textViewResultado.setText(R.string.sobrepeso);
                textViewResultado.setTextColor(getResources().getColor(R.color.yellow, null));
            }
            else if(imc >= 30 && imc < 35){
                textViewIMC.setTextColor(getResources().getColor(R.color.orange, null));
                imageViewIMC.setImageResource(R.drawable.____obese);
                textViewResultado.setText(R.string.obeso_I);
                textViewResultado.setTextColor(getResources().getColor(R.color.orange, null));
            }
            else if(imc >= 35 && imc < 40){
                textViewIMC.setTextColor(getResources().getColor(R.color.red, null));
                imageViewIMC.setImageResource(R.drawable.____extremaly_obese);
                textViewResultado.setText(R.string.obeso_II);
                textViewResultado.setTextColor(getResources().getColor(R.color.red, null));
            }
            else{
                textViewIMC.setTextColor(getResources().getColor(R.color.dark_red, null));
                imageViewIMC.setImageResource(R.drawable.____extremaly_obese);
                textViewResultado.setText(R.string.obeso_III);
                textViewResultado.setTextColor(getResources().getColor(R.color.dark_red, null));
            }
        }
    }
}