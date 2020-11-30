package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoCono extends AppCompatActivity {
    private TextView resultadoCono;
    Button devolverCono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_cono);

        resultadoCono = findViewById(R.id.txtResultadoCono);
        devolverCono = findViewById(R.id.btnOkCono);

        devolverCono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultadoCono.this, CalcularCono.class);
                startActivity(intent);
            }
        });

        resultadoCono();
    }

    public void resultadoCono(){
        Bundle param = getIntent().getExtras();
        double volumen = param.getDouble("volumen");
        resultadoCono.setText(String.valueOf(volumen));
    }
}