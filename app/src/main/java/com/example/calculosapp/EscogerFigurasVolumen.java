package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EscogerFigurasVolumen extends AppCompatActivity {
    private ListView lista_figura_volumen;
    private String figuras_volumen [];
    private ArrayAdapter<String> adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escoger_figuras_volumen);

        lista_figura_volumen = findViewById(R.id.lstFigurasVolumen);
        figuras_volumen = getResources().getStringArray(R.array.figuras_volumen);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, figuras_volumen);
        lista_figura_volumen.setAdapter(adapter);

        lista_figura_volumen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent = new Intent(EscogerFigurasVolumen.this, CalcularEsferas.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(EscogerFigurasVolumen.this, CalcularCilindro.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(EscogerFigurasVolumen.this, CalcularCono.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(EscogerFigurasVolumen.this, CalcularCubo.class);
                        startActivity(intent);
                }
            }
        });
    }
}