package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextPeso;
    private EditText editTextAltura;
    private Button buttonCalcular;

    private double imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        buttonCalcular = findViewById(R.id.buttonCalcular);

        buttonCalcular.setOnClickListener(v -> {
            calcular();
        });
    }

    private void calcular() {
        double peso, altura;
        peso = Double.parseDouble(editTextPeso.getText().toString());
        altura = Double.parseDouble(editTextAltura.getText().toString());
        imc = (peso / (altura * altura));

        Intent intent = new Intent(MainActivity.this, ActivityResultado.class);
        intent.putExtra("nome", editTextNome.getText().toString());
        intent.putExtra("imc", imc);
        startActivity(intent);
    }
}