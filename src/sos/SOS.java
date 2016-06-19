/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sos;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author whugo
 */
public class SOS {

    static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
    static int select = -1;
    static String nom, dir, fb, twi;
    static int id;
    static long lat, lon;
    static List nec;

    /**
     * @param args the command line arguments
     */
    public static int mostrarMenuAdmin(ArrayList<CA> centros) {

        while (select != 0) {

            StringBuilder jv = new StringBuilder();
            jv.append("ELIGE UNA OPCION:");
            jv.append("1. Registrar Centro de Acopio");
            jv.append("2. Administrar Centro de Acopio");
            jv.append("3. Volver");
            jv.append("0. Salir");
            try {
                select = Integer.parseInt(JOptionPane.showInputDialog(null, jv.toString(), "Opción", 1));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error!");
            }
            switch (select) {
                case 1:
                    return registrarCentroAcopio(centros);
                case 2:
                    return administrarCentroAcopio(centros);
                case 3:
                    return 5;
                case 0:
                    return 0;
                default:
                    System.out.println("Por favor, elegir otro número!\n");
                    break;

            }

        }
        return 0;
    }

    public static int registrarCentroAcopio(ArrayList<CA> centros) {
        StringBuilder vj = new StringBuilder();
        System.out.println("Introduzca nombre :");
        nom = scanner.next();
        System.out.println("Introduzca direccion :");
        dir = scanner.next();
        System.out.println("Introduzca cuenta de Facebook :");
        fb = scanner.next();
        System.out.println("Introduzca cuenta de Twitter :");
        twi = scanner.next();
        System.out.println("Introduzca latitud :");
        lat = scanner.nextLong();
        System.out.println("Introduzca longitud :");
        lon = scanner.nextLong();
        int idtmp= 0;
        System.out.println(lon);
        while(centros.contains(new CA(idtmp))){
            System.out.println(idtmp);
            idtmp = ThreadLocalRandom.current().nextInt();
        }
        CA centro = new CA(idtmp);
        centro.setNombre(nom);
        centro.setDireccion(dir);
        centro.setFb(fb);
        centro.setTwitter(twi);
        centro.setLatitud(lat);
        centro.setLongitud(lon);
        centros.add(centro);
        DatabaseHelper.save(centros);
        return 0;

    }
    
    public static int administrarCentroAcopio(ArrayList<CA> centros){
        enlistar(centros);
        int aca = -1;
        while (aca != 0){
            StringBuilder va = new StringBuilder();
            va.append("¿QUÉ INFORMACIÓN DESEA MODIFICAR?:");
            va.append("1. Centro de Acopio");
            va.append("2. Necesidades del Centro de Acopio");
            va.append("3. Volver");
            va.append("0. Salir");
              try {
                select = Integer.parseInt(JOptionPane.showInputDialog(null, va.toString(), "Opción", 1));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error!");
            }
        }    
            
        return 0;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<CA> centros = (ArrayList<CA>) DatabaseHelper.loadCA();
        int op = 5;
        while (op == 5) {
            System.out.println("SOS: Se Solidario");
            System.out.println("Menu de Opciones");
            System.out.println("1. Ingresar como administrador");
            System.out.println("2. Ingresar como usuario");
            System.out.println("3. Salir");
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduzca La opcion a ejecutar: ");
            int n = sc.nextInt();
            if (n == 1) {
                System.out.println("Administrador");
                boolean a = true;
                String usuario = "adm@hotmail.com";
                String contraseña = "@ministrador";
                while (a == true) {
                    System.out.println("Introduzca Usuario: ");
                    String us = sc.next();
                    System.out.println("Introduzca contraseña: ");
                    String cont = sc.next();
                    if (usuario.equals(us) && contraseña.equals(cont)) {
                        a = false;
                        
                        System.out.println("Inicio sesion exitosamente");
                    } else {
                        System.out.println("Usuario o contraseña incorrecta");
                        System.out.println("Intentelo de nuevo");
                        System.out.println(" ");
                    }
                }
                int b = mostrarMenuAdmin(centros);
                if (b == 5) {
                    op = 5;
                }else if (b==0){
                    op=0;
                }

            } else if (n == 2) {
                System.out.println("Usuario");
                boolean a = true;
                String usuario = "usu@hotmail.com";
                String contraseña = "@usuario";
                while (a == true) {
                    System.out.println("Introduzca Usuario: ");
                    String us = sc.next();
                    System.out.println("Introduzca contraseña: ");
                    String cont = sc.next();
                    if (usuario.equals(us) && contraseña.equals(cont)) {
                        a = false;
                        System.out.println("Inicio sesion exitosamente");
                    } else {
                        System.out.println("Usuario o contraseña incorrecta");
                        System.out.println("Intentelo de nuevo");
                        System.out.println(" ");
                    }
                }
              int b=mostrarMenuUsuario(centros);
               if (b == 5) {
                    op = 5;
                }else if (b==0){
                    op=0;
                }
              
            }
            else{
                op=3;
            }
        }
        System.out.println("Chao");

    }

    public static int mostrarMenuUsuario(ArrayList<CA> centros) {
        int opt = -1;
        while (opt != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(" 1. Ver centros de acopios \n");
            sb.append(" 2. Donar                  ");
            sb.append(" 3. Volver                  ");
            sb.append(" 0. Salir                  ");
            System.out.println(sb.toString());
            Scanner sc = new Scanner(System.in);
            opt = sc.nextInt();
            switch(opt){
                case 1:
                    return enlistar(centros);
                case 2:
                    return donar(escogerCentro(centros));
                case 3:
                    return 5;
                default:
                    break;
                    
            }
        }

        return 0;
    }
    
    public static int donar(CA centro){
        System.out.println("El centro de acopio "+ centro.getNombre()+" requiere de:\n");
        centro.getNecesidades().forEach(necesidad -> {
            System.out.println(necesidad);
        });
        int opt = -1;
        while(opt <0 && opt > centro.getNecesidades().size()){
            System.out.println("Escoga el item que desea donar: \n");
            opt = new Scanner(System.in).nextInt();
        }
        System.out.println("Su donación fue realizada con éxito! Gracias por ser solidario.");
        return 5;
    }
    
    public static CA escogerCentro(ArrayList<CA> centros){
        enlistar(centros);
        int opt= -1;
        while(opt <0 && opt > centros.size()){
        System.out.println("Escoge un centro:");
        opt = (new Scanner(System.in)).nextInt();
        }
        return centros.get(opt);
    }

    private static int enlistar(ArrayList<CA> centros) {
        centros.forEach(centro -> {
            System.out.println(centro);
        });
        System.out.println("Presione cualquier letra para salir");
        (new Scanner(System.in)).next();
        return 555;
    }

}
