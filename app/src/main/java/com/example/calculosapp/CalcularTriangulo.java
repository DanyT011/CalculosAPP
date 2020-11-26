package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcularTriangulo extends AppCompatActivity {
    private EditText ladoBase, ladoAltura;
    Button calcularTri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_triangulo);

        ladoBase = findViewById(R.id.textLadoBaseT);
        ladoAltura = findViewById(R.id.txtLadoAlturaT);
        calcularTri = findViewById(R.id.btnCalcularTri);

        calcularTri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             calcularTriangulo();;
            }
        });
    }
    public void calcularTriangulo(){
        int ladoB, ladoA;
        Intent intent = new Intent(CalcularTriangulo.this, ResultadoTriangulo.class);
        Bundle param = new Bundle();
        ladoB = Integer.parseInt(ladoBase.getText().toString());
        ladoA = Integer.parseInt(ladoAltura.getText().toString());
        double area = (ladoA * ladoB)/2;
        param.putDouble("area", area);
        intent.putExtras(param);
        startActivity(intent);
    }

    public void limpiar(View v){
        ladoBase.setText("");
        ladoAltura.setText("");
        ladoBase.requestFocus();
    }
}