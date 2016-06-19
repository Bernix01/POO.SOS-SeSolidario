/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sos;

import java.util.*;
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
    public static int mostrarMenuAdmin() {

        while (select != 0) {

            System.out.println("ELIGE UNA OPCION:  \n");
            System.out.println("1. Registrar Centro de Acopio\n");
            System.out.println("2. Administrar Centro de Acopio\n");
            System.out.println("3. Volver\n");
            System.out.println("0. Salir\n");
            try {
                select = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Error!");
            }
            switch (select) {
                case 1:
                    return registrarCentroAcopio();
                case 2:
                    return 22;
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

    public static int registrarCentroAcopio() {
        System.out.println("Introduzca nombre :\n");
        nom = scanner.next();
        System.out.println("Introduzca direccion :\n");
        dir = scanner.next();
        System.out.println("Introduzca cuenta de Facebook :\n");
        fb = scanner.next();
        System.out.println("Introduzca cuenta de Twitter :\n");
        twi = scanner.next();
        System.out.println("Introduzca latitud :\n");
        lat = Long.parseLong(scanner.nextLine());
        System.out.println("Introduzca longitud :\n");
        lon = Long.parseLong(scanner.nextLine());
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
                    } else {
                        System.out.println("Usuario o contraseña incorrecta");
                        System.out.println("Intentelo de nuevo");
                        System.out.println(" ");
                    }
                }
                int b = mostrarMenuAdmin();
                if (b == 5) {
                    op = 5;
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
                    } else {
                        System.out.println("Usuario o contraseña incorrecta");
                        System.out.println("Intentelo de nuevo");
                        System.out.println(" ");
                    }
                }
                mostrarMenuUsuario();
            }
        }

    }

    public static int mostrarMenuUsuario() {
        int opt = -1;
        while (opt != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(" 1. Ver centros de acopios ");
            sb.append(" 2. Donar                  ");
            opt = Integer.parseInt(JOptionPane.showInputDialog(null, sb.toString(), "Usuario", 1));
        }

        return 0;
    }

}
