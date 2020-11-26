package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultadoRectangulo extends AppCompatActivity {
    private TextView resultadoRec;
    Button devolverRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_rectangulo);

        resultadoRec = findViewById(R.id.txtResultadoRec);
        devolverRec = findViewById(R.id.btnOkRec);

        devolverRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultadoRectangulo.this, CalcularRectangulo.class);
                startActivity(intent);
            }
        });
        resultadoRec();
    }

    public void resultadoRec(){
        Bundle param = getIntent().getExtras();
        double area = param.getDouble("area");
        resultadoRec.setText(String.valueOf(area));
    }
}