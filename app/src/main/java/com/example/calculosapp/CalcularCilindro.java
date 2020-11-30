package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalcularCilindro extends AppCompatActivity {
    private EditText radio, altura;
    Button calcularCilindro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_cilindro);

        radio = findViewById(R.id.txtRadioCilindro);
        altura = findViewById(R.id.txtAlturaCilindro);
        calcularCilindro = findViewById(R.id.btnCalcularCilindro);

        calcularCilindro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             calcularCilindro();
            }
        });
    }

    public void calcularCilindro(){
        double rad, alt;
        Intent intent = new Intent(CalcularCilindro.this, ResultadoCilindro.class);
        Bundle param = new Bundle();
        rad = Double.parseDouble(radio.getText().toString());
        alt = Double.parseDouble(altura.getText().toString());
        double volumen = Math.PI * Math.pow(rad,2) * alt;
        param.putDouble("volumen", volumen);
        intent.putExtras(param);
        startActivity(intent);
    }

    public void limpiar(View v){
        radio.setText("");
        altura.setText("");
        radio.requestFocus();
    }
}