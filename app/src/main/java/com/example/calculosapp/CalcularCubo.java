package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcularCubo extends AppCompatActivity {
    private TextView operacion;
    private EditText lado;
    Button calcularCubo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_cubo);
        operacion = findViewById(R.id.lblCalcularCubo);
        lado = findViewById(R.id.txtLadoCubo);
        calcularCubo = findViewById(R.id.btnCalcularCubo);

        calcularCubo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularCubo();
            }
        });
    }

    public void calcularCubo(){
        int lad = 1;
        String op, dat;
        Intent intent = new Intent(CalcularCubo.this, ResultadoCubo.class);
        Bundle param = new Bundle();
        lad = Integer.parseInt(lado.getText().toString());
        double volumen = lad * lad * lad;
        op = operacion.getResources().getString(R.string.volumnen_cubo);
        dat = lado.getResources().getString(R.string.lado_cuadrado).concat(String.valueOf(" " + lad));
        guardar(op, dat, String.valueOf(volumen));
        param.putDouble("volumen", volumen);
        intent.putExtras(param);
        startActivity(intent);
    }

    public void limpiar(View v){
        lado.setText("");
    }

    public void guardar(String op, String dat, String volumen){
        Operacion o;
        o = new Operacion(op, dat, volumen);
        o.guardar();
        Toast.makeText(this, R.string.guardado_exitosamente, Toast.LENGTH_LONG).show();
    }
}