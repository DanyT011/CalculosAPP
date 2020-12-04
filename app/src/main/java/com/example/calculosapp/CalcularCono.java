package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcularCono extends AppCompatActivity {
    private TextView operacion;
    private EditText radio, altura;
    Button calcularCono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_cono);

        operacion = findViewById(R.id.lblCalcularCono);
        radio = findViewById(R.id.txtRadioCono);
        altura = findViewById(R.id.txtAlturaCono);
        calcularCono = findViewById(R.id.btnCalcularCono);

        calcularCono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularCono();
            }
        });
    }

    public void calcularCono(){
        double rad, alt;
        String op, dat;
        Intent intent = new Intent(CalcularCono.this, ResultadoCono.class);
        Bundle param = new Bundle();
        rad = Double.parseDouble(radio.getText().toString());
        alt = Double.parseDouble(altura.getText().toString());
        double volumen = (Math.PI * Math.pow(rad,2) * alt) / 3;
        op = operacion.getResources().getString(R.string.volumnen_cono);
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