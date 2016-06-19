/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sos;
  import java.util.*;
/**
 *
 * @author whugo
 */
public class SOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       System.out.println("SOS: Se Solidario");     
       System.out.println("Menu de Opciones");
       System.out.println("1. Ingresar como administrador");
       System.out.println("2. Ingresar como usuario");
       System.out.println("3. Salir");
       Scanner sc = new Scanner(System.in);
       System.out.print("Introduzca La opcion a ejecutar: ");
       int n = sc.nextInt();
       if (n==1){
            
            boolean a= true;
            String usuario="adm@hotmail.com";
            String contraseña="@ministrador";
            while (a==true){   
            System.out.println("Introduzca Usuario: ");
            String us = sc.next(); 
            System.out.println("Introduzca contraseña: ");
            String cont = sc.next();
            if (usuario.equals(us) && contraseña.equals(cont)){
               a=false;
            }else{
               System.out.println("true");}
            }
            
       }
       else if (n==2){
           boolean a= true;
            String usuario="usu@hotmail.com";
            String contraseña="@usuario";
            while (a==true){   
            System.out.println("Introduzca Usuario: ");
            String us = sc.next(); 
            System.out.println("Introduzca contraseña: ");
            String cont = sc.next();
            if (usuario.equals(us) && contraseña.equals(cont)){
               a=false;
            }else{
               System.out.println("true");}
            }
       }
       
       
    }
    
}
