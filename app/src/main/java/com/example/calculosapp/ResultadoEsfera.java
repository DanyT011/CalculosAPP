package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoEsfera extends AppCompatActivity {
    private TextView resultadoEsfera;
    Button devolverEsfera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_esfera);

        resultadoEsfera = findViewById(R.id.txtResultadoEsfera);
        devolverEsfera = findViewById(R.id.btnOkEsfera);

        devolverEsfera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultadoEsfera.this, CalcularEsferas.class);
                startActivity(intent);
            }
        });
        resultadoEsfera();
    }

    public void resultadoEsfera(){
        Bundle param = getIntent().getExtras();
        double volumen = param.getDouble("volumen");
        resultadoEsfera.setText(String.valueOf(volumen));
    }
}