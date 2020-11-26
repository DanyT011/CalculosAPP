package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalcularCirculo extends AppCompatActivity {
    private EditText radio;
    Button calcularCir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_circulo);

        radio = findViewById(R.id.txtRadio);
        calcularCir = findViewById(R.id.btnCalcularcirculo);

        calcularCir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularcirculo();
            }
        });
    }

    public void calcularcirculo(){
        double rad;
        Intent intent = new Intent(CalcularCirculo.this, ResultadoCirculo.class);
        Bundle param = new Bundle();
        rad = Double.parseDouble(radio.getText().toString());
        double area = (Math.PI * (Math.pow(rad,2)))/2;
        param.putDouble("area", area);
        intent.putExtras(param);
        startActivity(intent);
    }

    public void limpiar(View v){
        radio.setText("");
    }
}