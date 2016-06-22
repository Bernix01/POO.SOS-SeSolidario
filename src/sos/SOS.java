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
    static String nom, dir, fb, twi, nnom, ndir;
    static int id;
    static float lat, lon, nlat, nlon;
    static List nec;

    /**
     * @param args the command line arguments
     */
    public static int mostrarMenuAdmin(ArrayList<CA> centros) {

        while (select != 0) {

            System.out.println("ELIGE UNA OPCION:\n");
            System.out.println("1. Registrar Centro de Acopio\n");
            System.out.println("2. Administrar Centro de Acopio\n");
            System.out.println("3. Volver\n");
            System.out.println("0. Salir\n");
            select = scanner.nextInt();
            scanner.nextLine();
            
            switch (select) {
                case 1:
                    registrarCentroAcopio(centros);
                    break;
                case 2:
                    administrarCentroAcopio(centros);
                    break;
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
        System.out.println("Introduzca nombre:\n");
        nom = scanner.nextLine();
        System.out.println("Introduzca direccion:\n");
        dir = scanner.nextLine();
        System.out.println("Introduzca cuenta de Facebook:\n");
        fb = scanner.nextLine();
        System.out.println("Introduzca cuenta de Twitter:\n");
        twi = scanner.nextLine();
        System.out.println("Introduzca latitud:\n");
        lat = scanner.nextFloat();
        System.out.println("Introduzca longitud:\n");
        lon = scanner.nextFloat();
        
        int idtmp = 0;
        System.out.println(lon);
        while (centros.contains(new CA(idtmp))) {
            System.out.println(idtmp);
            idtmp = ThreadLocalRandom.current().nextInt();
            scanner.nextLine();
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
        return 5;

    }

    public static int administrarCentroAcopio(ArrayList<CA> centros) {
        int aca = -1;
        while (aca != 0) {
            System.out.println("¿QUÉ INFORMACIÓN DESEA MODIFICAR?:\n");
            System.out.println("1. Centro de Acopio\n");
            System.out.println("2. Necesidades del Centro de Acopio\n");
            System.out.println("3. Volver\n");
            System.out.println("0. Salir\n");
            try {
                aca = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("OOPS! Error!\n");
            }
            switch (aca) {

                case 1:
                    CA dd = escogerCentro(centros);
                    System.out.println("Introduzca nuevo nombre:\n");
                    nnom = scanner.nextLine();
                    System.out.println("Introduzca nueva direccion:\n");
                    ndir = scanner.nextLine();
                    System.out.println("Introduzca nueva latitud:\n");
                    nlat = scanner.nextFloat();
                    System.out.println("Introduzca nueva longitud:\n");
                    nlon = scanner.nextFloat();
                    dd.setNombre(nnom);
                    dd.setDireccion(ndir);
                    dd.setLatitud(nlat);
                    dd.setLongitud(nlon);
                    DatabaseHelper.save(centros);
                case 2:
                    int cau = -1;
                    while (cau != 0) {
                        System.out.println("¿DESEA AGREGAR O ELIMINAR NECESIDAD?:\n");
                        System.out.println("1. Agregar\n");
                        System.out.println("2. Eliminar\n");
                        System.out.println("3. Volver\n");
                        System.out.println("0. Salir\n");
                        cau = scanner.nextInt();
            scanner.nextLine();
                        switch (cau) {
                            case 1:
                                int gui = -1;
                                Necesidad ne = new Necesidad(Necesidad.tipos_necesidad.standard, 0, null);
                                while (cau != 0) {
                                    StringBuilder tu = new StringBuilder();
                                    System.out.println("Elija el tipo de necesidad: \n");
                                    System.out.println("1. Aseo\n");
                                    System.out.println("2. Ropa\n");
                                    System.out.println("3. Viveres\n");
                                    System.out.println("4. Volver\n");
                                    System.out.println("0. Salir\n");
                                    gui = scanner.nextInt();
            scanner.nextLine();
                                    
                                    switch (gui) {

                                        case 1:
                                            ne.setTipo(Necesidad.tipos_necesidad.aseo);
                                            break;
                                        case 2:
                                            ne.setTipo(Necesidad.tipos_necesidad.ropa);
                                            break;
                                        case 3:
                                            ne.setTipo(Necesidad.tipos_necesidad.viveres);
                                            break;
                                        case 4:
                                            
                                            return 5;
                                        case 0:
                                            
                                            return 0;
                                    }
                                    System.out.println("INGRESE EL ITEM QUE DESEA AGREGAR:\n");
                                    String nomb = scanner.nextLine();
                                    ne.setNombre(nomb);
                                    System.out.println("INGRESE LA CANTIDAD QUE DESEA AGREGAR:\n");
                                    int cant = scanner.nextInt();
                                    scanner.nextLine();
                                    ne.setCantidad(cant);
                                }
                                CA ty = escogerCentro(centros);
                                ty.getNecesidades().add(ne);
                            case 2:
                                CA cc = escogerCentro(centros);
                                cc.getNecesidades().forEach(necesidad -> {
                                    System.out.println(necesidad);
                                });
                                int bau = -1;
                                while (bau < 0 && bau > cc.getNecesidades().size()) {
                                    System.out.println("Escoga el item que desea eliminar: \n");
                                    bau = scanner.nextInt();
                                    scanner.nextLine();
                                }
                                
                                cc.getNecesidades().remove(bau);
                        }
                    }

                case 3:
                    return 5;
                case 0:
                    return 0;

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
            
            System.out.print("Introduzca La opcion a ejecutar: ");
            int n = scanner.nextInt();
                                    scanner.nextLine();
            switch (n) {
                case 1: {
                    System.out.println("Administrador");
                    boolean a = true;
                    String usuario = "adm@hotmail.com";
                    String contraseña = "@ministrador";
                    while (a == true) {
                        System.out.println("Introduzca Usuario: ");
                        String us = scanner.nextLine();
                        System.out.println("Introduzca contraseña: ");
                        String cont = scanner.nextLine();
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
                    } else if (b == 0) {
                        op = 0;
                    }
                    break;
                }
                case 2: {
                    System.out.println("Usuario");
                    boolean a = true;
                    String usuario = "usu@hotmail.com";
                    String contraseña = "@usuario";
                    while (a == true) {
                        System.out.println("Introduzca Usuario: ");
                        String us = scanner.nextLine();
                        System.out.println("Introduzca contraseña: ");
                        String cont = scanner.nextLine();
                        if (usuario.equals(us) && contraseña.equals(cont)) {
                            a = false;
                            System.out.println("Inicio sesion exitosamente");
                        } else {
                            System.out.println("Usuario o contraseña incorrecta");
                            System.out.println("Intentelo de nuevo");
                            System.out.println(" ");
                        }
                        
                    }
                    int b = mostrarMenuUsuario(centros);
                    if (b == 5) {
                        op = 5;
                    } else if (b == 0) {
                        op = 0;
                    }
                    break;
                }
                default:
                    op = 3;
                    break;
            }
        }
        System.out.println("Chao");
        scanner.close();

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
            
            opt = scanner.nextInt();
            
                                    scanner.nextLine();
            switch (opt) {
                case 1:
                    return enlistar(centros);
                case 2:
                    donar(escogerCentro(centros));
                case 3:
                    return 5;
                default:
                    break;

            }
        }

        return 0;
    }

    public static int donar(CA centro) {
        System.out.println("El centro de acopio " + centro.getNombre() + " requiere de:\n");
        centro.getNecesidades().forEach(necesidad -> {
            System.out.println(necesidad);
        });
        int opt = -1;
        while (opt < 0 && opt > centro.getNecesidades().size()) {
            System.out.println("Escoga el item que desea donar: \n");
            
            opt = scanner.nextInt();
            scanner.nextLine();
            
        }
        System.out.println("Su donación fue realizada con éxito! Gracias por ser solidario.");
        return 5;
    }

    public static CA escogerCentro(ArrayList<CA> centros) {
        enlistar(centros);
        int opt = -1;
        while (opt < 0 && opt > centros.size()) {
            System.out.println("Escoge un centro:");
            
            opt = scanner.nextInt();
            scanner.nextLine();
            
        }
        return centros.get(opt);
    }

    private static int enlistar(ArrayList<CA> centros) {
        centros.forEach(centro -> {
            System.out.println(centro);
        });
        System.out.println("Presione cualquier letra para salir");
        
        scanner.nextLine();
        
        return 555;
    }

}
