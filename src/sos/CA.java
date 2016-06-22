/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sos;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author whugo
 */
public class CA {

    private float latitud;
    private float longitud;
    private String nombre;
    private String direccion;
    private String fb;
    private String twitter;
    private int id;

    CA(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    private List<Necesidad> necesidades;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CA other = (CA) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public List<Necesidad> getNecesidades() {
        return necesidades;
    }

    public void agregarNecesidades(List<Necesidad> necesidades) {
        this.necesidades.addAll(necesidades);
    }

    public void agregarNecesidad(Necesidad necesidad) {
        this.necesidades.add(necesidad);
    }

    public CA(int id, float latitud, float longitud, String nombre, String direccion, String fb, String twitter) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fb = fb;
        this.twitter = twitter;
        this.necesidades = new LinkedList<>();
        this.id = id;
    }

    public CA(int id, float latitud, float longitud, String nombre, String direccion, String fb, String twitter, List<Necesidad> necesidades) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fb = fb;
        this.twitter = twitter;
        this.necesidades = necesidades;
        this.id = id;
    }

    public CA() {
    }

    public String forArchive() {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append("|");
        sb.append(latitud);
        sb.append("|");
        sb.append(longitud);
        sb.append("|");
        sb.append(nombre);
        sb.append("|");
        sb.append(direccion);
        sb.append("|");
        sb.append(fb);
        sb.append("|");
        sb.append(twitter);
        sb.append("|");
        this.necesidades.forEach(necesidad -> {
            sb.append(necesidad);
            sb.append(",");
        });
        return sb.toString();
    }

}
