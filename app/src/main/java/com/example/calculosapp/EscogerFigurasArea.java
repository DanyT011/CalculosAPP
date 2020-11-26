package com.example.calculosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EscogerFigurasArea extends AppCompatActivity {
    private ListView lista_figuras_area;
    private String figuras_area[];
    private ArrayAdapter<String> adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escoger_figuras_area);

        lista_figuras_area =findViewById(R.id.lstFigurasArea);
        figuras_area = getResources().getStringArray(R.array.figuras_area);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, figuras_area);
        lista_figuras_area.setAdapter(adapter);

        lista_figuras_area.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent = new Intent(EscogerFigurasArea.this, CalcularCuadrado.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(EscogerFigurasArea.this, CalcularRectangulo.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(EscogerFigurasArea.this, CalcularTriangulo.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(EscogerFigurasArea.this, CalcularCirculo.class);
                        startActivity(intent);
                }
            }
        });

    }
}