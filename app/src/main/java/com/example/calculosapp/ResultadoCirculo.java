package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultadoCirculo extends AppCompatActivity {
    private TextView resultadoCir;
    Button devolverCir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_circulo);

        resultadoCir = findViewById(R.id.txtResultadoCir);
        devolverCir = findViewById(R.id.btnOkCir);

        devolverCir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultadoCirculo.this, CalcularCirculo.class);
                startActivity(intent);
            }
        });
        resultadoTriangulo();
    }

    public void resultadoTriangulo(){
        Bundle param = getIntent().getExtras();
        double area = param.getDouble("area");
        resultadoCir.setText(String.valueOf(area));
    }
}