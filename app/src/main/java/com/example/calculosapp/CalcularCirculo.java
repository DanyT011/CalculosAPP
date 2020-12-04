package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcularCirculo extends AppCompatActivity {
    private TextView operacion;
    private EditText radio;
    Button calcularCir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_circulo);

        operacion = findViewById(R.id.lblCrearCirculo);
        radio = findViewById(R.id.txtRadio);
        calcularCir = findViewById(R.id.btnCalcularcirculo);

        calcularCir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularcirculo();
            }
        });
    }

    public void calcularcirculo(){
        double rad;
        String op, dat;
        Intent intent = new Intent(CalcularCirculo.this, ResultadoCirculo.class);
        Bundle param = new Bundle();
        if(validar()){
            rad = Double.parseDouble(radio.getText().toString());
            double area = (Math.PI * (Math.pow(rad,2)))/2;
            op = operacion.getResources().getString(R.string.area_circulo);
            dat = radio.getResources().getString(R.string.radio).concat(String.valueOf(" " + rad));
            guardar(op, dat, String.valueOf(area));
            param.putDouble("area", area);
            intent.putExtras(param);
            startActivity(intent);
        }
    }

    public void guardar(String op, String dat, String area){
        Operacion o;
        o = new Operacion(op, dat, area);
        o.guardar();
        Toast.makeText(this, R.string.guardado_exitosamente, Toast.LENGTH_LONG).show();
    }

    public void limpiar(View v){
        radio.setText("");
    }

    public boolean validar(){
        if(radio.getText().toString().isEmpty()){
            radio.setError(getString(R.string.ingrese_radio));
            radio.requestFocus();
            return false;
        }

        return true;
    }
}