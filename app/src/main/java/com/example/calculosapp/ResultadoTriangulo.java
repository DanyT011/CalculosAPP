package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoTriangulo extends AppCompatActivity {
    private TextView resultadoTri;
    Button devolverTri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_triangulo);

        resultadoTri = findViewById(R.id.txtResultadoTri);
        devolverTri = findViewById(R.id.btnOkTri);

        devolverTri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultadoTriangulo.this, CalcularTriangulo.class);
                startActivity(intent);
            }
        });
        resultadoTriangulo();
    }

    public void resultadoTriangulo(){
        Bundle param = getIntent().getExtras();
        double area = param.getDouble("area");
        resultadoTri.setText(String.valueOf(area));
    }
}