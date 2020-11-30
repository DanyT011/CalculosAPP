package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoCilindro extends AppCompatActivity {
    private TextView resultadoCilindro;
    Button devolverCilindro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_cilindro);

        resultadoCilindro = findViewById(R.id.txtResultadoCilindro);
        devolverCilindro = findViewById(R.id.btnOkCilindro);

        devolverCilindro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultadoCilindro.this, CalcularCilindro.class);
                startActivity(intent);
            }
        });

        resultadoCilindro();
    }

    public void resultadoCilindro(){
        Bundle param = getIntent().getExtras();
        double volumen = param.getDouble("volumen");
        resultadoCilindro.setText(String.valueOf(volumen));
    }
}