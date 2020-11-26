package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CalcularCuadrado extends AppCompatActivity {
    private EditText lado;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_cuadrado);

        lado = findViewById(R.id.txtLado);
        calcular = findViewById(R.id.btnCalcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularCuadrado();
            }
        });
    }

    public void calcularCuadrado(){
        int lad = 1;
        Intent intent = new Intent(CalcularCuadrado.this, ResultadoCuadrado.class);
        Bundle param = new Bundle();
        lad = Integer.parseInt(lado.getText().toString());
        double area = lad * lad;
        param.putDouble("area", area);
        intent.putExtras(param);
        startActivity(intent);
    }
}