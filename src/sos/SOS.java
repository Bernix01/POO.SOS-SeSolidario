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
    
     	static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
	static int select = -1;  

    /**
     * @param args the command line arguments
     */
    private int mostrarMenuAdmin(){
 
    while(select != 0){
        try{
            System.out.println("ELIGE UNA OPCION:  \n");
            System.out.println("1. Registrar Centro de Acopio\n");
            System.out.println("2. Administrar Centro de Acopio\n");    
            System.out.println("3. Volver\n");
            System.out.println("0. Salir\n");
            select = Integer.parseInt(scanner.nextLine());
            switch(select){
				case 1: 
                                        return 3;
				case 2: 
                                        return 22;
				case 3: 
                                        return 5;
                                case 0: 
					return 0;
				default:
					System.out.println("Por favor, elegir otro número!");break;
				}
            
                                System.out.println("\n"); //
                                
                            }catch(Exception e){
				System.out.println("Error!");
			}
            }
    
        }
    
    private int registrarCentroAcopio(){
    
        
    
    }
    
    
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
