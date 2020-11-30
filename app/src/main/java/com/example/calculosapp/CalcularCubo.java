package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalcularCubo extends AppCompatActivity {
    private EditText lado;
    Button calcularCubo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_cubo);

        lado = findViewById(R.id.txtLadoCubo);
        calcularCubo = findViewById(R.id.btnCalcularCubo);

        calcularCubo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularCubo();
            }
        });
    }

    public void calcularCubo(){
        int lad = 1;
        Intent intent = new Intent(CalcularCubo.this, ResultadoCubo.class);
        Bundle param = new Bundle();
        lad = Integer.parseInt(lado.getText().toString());
        double volumen = lad * lad * lad;
        param.putDouble("volumen", volumen);
        intent.putExtras(param);
        startActivity(intent);
    }

    public void limpiar(View v){
        lado.setText("");
    }
}