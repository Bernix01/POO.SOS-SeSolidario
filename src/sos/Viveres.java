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
public class Viveres extends Necesidad{
    
    public Viveres( int cantidad, String nombre) {
        super(Necesidad.tipos_necesidad.viveres, cantidad, nombre);
    }
    
}