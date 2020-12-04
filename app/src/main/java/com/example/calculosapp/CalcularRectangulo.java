package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcularRectangulo extends AppCompatActivity {
    private TextView operacion;
    private EditText ladoBase, ladoAltura;
    Button calcularRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_rectangulo);

        operacion = findViewById(R.id.lblCalcularRec);
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
        String op, dat;
        Intent intent = new Intent(CalcularRectangulo.this, ResultadoRectangulo.class);
        Bundle param = new Bundle();
        ladoB = Integer.parseInt(ladoBase.getText().toString());
        ladoA = Integer.parseInt(ladoAltura.getText().toString());
        double area = ladoA * ladoB;
        op = operacion.getResources().getString(R.string.area_rec);
        dat = ladoBase.getResources().getString(R.string.lado_base).concat(String.valueOf(" " + ladoB)) + "\n";
        dat += ladoAltura.getResources().getString(R.string.lado_altura).concat(String.valueOf(" " + ladoA));
        guardar(op, dat, String.valueOf(area));
        param.putDouble("area", area);
        intent.putExtras(param);
        startActivity(intent);
    }


    public void guardar(String op, String dat, String area){
        Operacion o;
        o = new Operacion(op, dat, area);
        o.guardar();
        Toast.makeText(this, R.string.guardado_exitosamente, Toast.LENGTH_LONG).show();
    }

    public void limpiar(View v){
        ladoBase.setText("");
        ladoAltura.setText("");
        ladoBase.requestFocus();
    }

}