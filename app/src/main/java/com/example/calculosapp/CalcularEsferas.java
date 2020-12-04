package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcularEsferas extends AppCompatActivity {
    private TextView operacion;
    private EditText radio;
    Button calcularEsfera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_esferas);

        operacion = findViewById(R.id.lblCalcularEsfera);
        radio = findViewById(R.id.txtRadioEsfera);
        calcularEsfera = findViewById(R.id.btnCalcularEsfera);

        calcularEsfera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularEsfera();
            }
        });
    }

    public void calcularEsfera(){
        double rad;
        String op, dat;
        Intent intent = new Intent(CalcularEsferas.this, ResultadoEsfera.class);
        Bundle param = new Bundle();
        rad = Double.parseDouble(radio.getText().toString());
        double volumen = (4*(Math.PI * (Math.pow(rad,3)))/3);
        op = operacion.getResources().getString(R.string.volumnen_esfera);
        dat = radio.getResources().getString(R.string.radio).concat(String.valueOf(" " + rad));
        guardar(op, dat, String.valueOf(volumen));
        param.putDouble("volumen", volumen);
        intent.putExtras(param);
        startActivity(intent);
    }

    public void limpiar(View v){
        radio.setText("");
    }

    public void guardar(String op, String dat, String volumen){
        Operacion o;
        o = new Operacion(op, dat, volumen);
        o.guardar();
        Toast.makeText(this, R.string.guardado_exitosamente, Toast.LENGTH_LONG).show();
    }

    private double rad;
}