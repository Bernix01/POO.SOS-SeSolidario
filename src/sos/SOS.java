/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sos;

import java.util.Scanner;

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

    }
    
}
