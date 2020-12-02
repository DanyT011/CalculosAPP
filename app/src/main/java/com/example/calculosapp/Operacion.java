package com.example.calculosapp;

public class Operacion {
    private String op;
    private String datos;
    private String resultado;

    public Operacion(String op, String datos, String resultado){
        this.op = op;
        this.datos = datos;
        this.resultado = resultado;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public  void guardar(){
        Datos.guardar(this);
     }
}
