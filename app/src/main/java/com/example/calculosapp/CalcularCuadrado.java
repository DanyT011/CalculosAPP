package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class CalcularCuadrado extends AppCompatActivity {
    private TextView operacion;
    private EditText lado;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_cuadrado);

        operacion = findViewById(R.id.txtCuadrado);
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
        String op, dat;
        Intent intent = new Intent(CalcularCuadrado.this, ResultadoCuadrado.class);
        Bundle param = new Bundle();
        lad = Integer.parseInt(lado.getText().toString());
        double area = lad * lad;
        op = operacion.getResources().getString(R.string.area_cuadrado);
        dat = lado.getResources().getString(R.string.lado_cuadrado).concat(String.valueOf(" " + lad));
        guardar(op, dat, String.valueOf(area));
        param.putDouble("area", area);
        intent.putExtras(param);
        startActivity(intent);
    }

    public void limpiar(View v){
        lado.setText("");
    }

    public void guardar(String op, String dat, String area){
        Operacion o;
        o = new Operacion(op, dat, area);
        o.guardar();
        Toast.makeText(this, R.string.guardado_exitosamente, Toast.LENGTH_LONG).show();
    }
}