package com.example.calculosapp;

import java.util.ArrayList;

public class Datos {
    private static ArrayList<Operacion> operaciones = new ArrayList();

    public static void guardar(Operacion o){
        operaciones.add(o);
    }

    public static ArrayList<Operacion> obtener(){return operaciones;}
}
