package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcularTriangulo extends AppCompatActivity {
    private TextView operacion;
    private EditText ladoBase, ladoAltura;
    Button calcularTri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_triangulo);

        operacion = findViewById(R.id.lblTituloTri);
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
        String op, dat;
        Intent intent = new Intent(CalcularTriangulo.this, ResultadoTriangulo.class);
        Bundle param = new Bundle();
        ladoB = Integer.parseInt(ladoBase.getText().toString());
        ladoA = Integer.parseInt(ladoAltura.getText().toString());
        double area = (ladoA * ladoB)/2;
        op = operacion.getResources().getString(R.string.area_tri);
        dat = ladoBase.getResources().getString(R.string.lado_base).concat(String.valueOf(" " + ladoB)) + "\n";
        dat += ladoAltura.getResources().getString(R.string.lado_altura).concat(String.valueOf(" " + ladoA));
        guardar(op, dat, String.valueOf(area));
        param.putDouble("area", area);
        intent.putExtras(param);
        startActivity(intent);
    }

    public void limpiar(View v){
        ladoBase.setText("");
        ladoAltura.setText("");
        ladoBase.requestFocus();
    }

    public void guardar(String op, String dat, String area){
        Operacion o;
        o = new Operacion(op, dat, area);
        o.guardar();
        Toast.makeText(this, R.string.guardado_exitosamente, Toast.LENGTH_LONG).show();
    }
}