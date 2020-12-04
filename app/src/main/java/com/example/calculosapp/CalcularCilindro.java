package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcularCilindro extends AppCompatActivity {
    private TextView operacion;
    private EditText radio, altura;
    Button calcularCilindro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_cilindro);

        operacion = findViewById(R.id.lblCalcularCilindro);
        radio = findViewById(R.id.txtRadioCilindro);
        altura = findViewById(R.id.txtAlturaCilindro);
        calcularCilindro = findViewById(R.id.btnCalcularCilindro);

        calcularCilindro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             calcularCilindro();
            }
        });
    }

    public void calcularCilindro(){
        double rad = 1, alt = 1;
        String op, dat;
        Intent intent = new Intent(CalcularCilindro.this, ResultadoCilindro.class);
        Bundle param = new Bundle();
        rad = Double.parseDouble(radio.getText().toString());
        alt = Double.parseDouble(altura.getText().toString());
        double volumen = Math.PI * Math.pow(rad,2) * alt;
        op = operacion.getResources().getString(R.string.volumnen_cilindro);
        dat = radio.getResources().getString(R.string.radio).concat(String.valueOf(" " + rad)) + "\n";
        dat += altura.getResources().getString(R.string.altura).concat(String.valueOf(" " + alt));
        guardar(op, dat, String.valueOf(volumen));
        param.putDouble("volumen", volumen);
        intent.putExtras(param);
        startActivity(intent);
    }

    public void limpiar(View v){
        radio.setText("");
        altura.setText("");
        radio.requestFocus();
    }

    public void guardar(String op, String dat, String volumen){
        Operacion o;
        o = new Operacion(op, dat, volumen);
        o.guardar();
        Toast.makeText(this, R.string.guardado_exitosamente, Toast.LENGTH_LONG).show();
    }
}