package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalcularRectangulo extends AppCompatActivity {
    private EditText ladoBase, ladoAltura;
    Button calcularRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_rectangulo);

        ladoBase = findViewById(R.id.txtLadoBase);
        ladoAltura = findViewById(R.id.txtLadoAltura);
        calcularRec = findViewById(R.id.btnCalcularRec);

        calcularRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularRectangulo();
            }
        });
    }

    public void calcularRectangulo(){
        int ladoB, ladoA;
        Intent intent = new Intent(CalcularRectangulo.this, ResultadoRectangulo.class);
        Bundle param = new Bundle();
        ladoB = Integer.parseInt(ladoBase.getText().toString());
        ladoA = Integer.parseInt(ladoAltura.getText().toString());
        double area = ladoA * ladoB;
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