package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoCuadrado extends AppCompatActivity {
    private TextView resultado;
    Button devolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_cuadrado);

        resultado = findViewById(R.id.txtResultado);
        devolver = findViewById(R.id.btnOkCuadrado);

        devolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultadoCuadrado.this, CalcularCuadrado.class);
                startActivity(intent);
            }
        });

        resultadoCuadrado();
    }

    public void resultadoCuadrado(){
        Bundle param = getIntent().getExtras();
        double area = param.getDouble("area");
        resultado.setText(String.valueOf(area));

    }
}