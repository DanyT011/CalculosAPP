package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CalcularCuadrado extends AppCompatActivity {
    private TextView operacion, resultado;
    private EditText lado;
    Button calcular, guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_cuadrado);

        operacion = findViewById(R.id.txtCuadrado);
        lado = findViewById(R.id.txtLado);
        calcular = findViewById(R.id.btnCalcular);
        guardar = findViewById(R.id.btnGuardarCuadrado);
        resultado = findViewById(R.id.txtResultado);


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

    public void limpiar(View v){
        lado.setText("");
    }

    public void guardar(View v){
        String op,dat,res;
        Operacion o;

        op = operacion.getText().toString();
        dat = lado.getText().toString();
        res = resultado.getText().toString();
        o = new Operacion(op, dat, res);
        o.guardar();
        Toast.makeText(this, "Persona Guardada éxitosamente", Toast.LENGTH_LONG).show();
    }
}