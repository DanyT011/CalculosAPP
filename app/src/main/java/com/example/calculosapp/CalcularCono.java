package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalcularCono extends AppCompatActivity {
    private EditText radio, altura;
    Button calcularCono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_cono);

        radio = findViewById(R.id.txtRadioCono);
        altura = findViewById(R.id.txtAlturaCono);
        calcularCono = findViewById(R.id.btnCalcularCono);

        calcularCono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularCono();
            }
        });
    }

    public void calcularCono(){
        double rad, alt;
        Intent intent = new Intent(CalcularCono.this, ResultadoCono.class);
        Bundle param = new Bundle();
        rad = Double.parseDouble(radio.getText().toString());
        alt = Double.parseDouble(altura.getText().toString());
        double volumen = (Math.PI * Math.pow(rad,2) * alt) / 3;
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