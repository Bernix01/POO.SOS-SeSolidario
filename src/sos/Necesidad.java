/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sos;

/**
 *
 * @author whugo
 */
public class Necesidad {
    
    private tipos_necesidad tipo;
    private int cantidad;
    private String nombre;
    
    public tipos_necesidad getTipo() {
        return tipo;
    }

    public void setTipo(tipos_necesidad tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Necesidad(tipos_necesidad tipo, int cantidad, String nombre) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }
static enum tipos_necesidad{
    aseo,ropa,viveres;
}

}
