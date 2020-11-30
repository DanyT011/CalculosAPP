package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoCubo extends AppCompatActivity {
    private TextView resultadoCubo;
    Button devolverCubo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_cubo);

        resultadoCubo = findViewById(R.id.textResultadoCubo);
        devolverCubo = findViewById(R.id.btnOkCubo);

        devolverCubo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultadoCubo.this, CalcularCubo.class);
                startActivity(intent);
            }
        });
    resultadoCubo();
    }

    public void resultadoCubo(){
        Bundle param = getIntent().getExtras();
        double volumen = param.getDouble("volumen");
        resultadoCubo.setText(String.valueOf(volumen));

    }
}