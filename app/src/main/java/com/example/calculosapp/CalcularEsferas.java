package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalcularEsferas extends AppCompatActivity {
    private EditText radio;
    Button calcularEsfera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_esferas);

        radio = findViewById(R.id.txtRadioEsfera);
        calcularEsfera = findViewById(R.id.btnCalcularEsfera);

        calcularEsfera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularEsfera();
            }
        });
    }

    public void calcularEsfera(){
        double rad;
        Intent intent = new Intent(CalcularEsferas.this, ResultadoEsfera.class);
        Bundle param = new Bundle();
        rad = Double.parseDouble(radio.getText().toString());
        double volumen = (4*(Math.PI * (Math.pow(rad,3)))/3);
        param.putDouble("volumen", volumen);
        intent.putExtras(param);
        startActivity(intent);
    }

    public void limpiar(View v){
        radio.setText("");
    }
}