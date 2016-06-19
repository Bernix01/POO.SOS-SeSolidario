/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author whugo
 */
public class DatabaseHelper {

    private static final String fileName = "datos.dat";

    public static List<CA> loadCA() {
        FileReader fr;
        BufferedReader br;
        String linea;
        String datos[];
        CA r;
        ArrayList<CA> lista = new ArrayList<>();
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                datos = linea.split("\\|");
                int id = Integer.parseInt(datos[0]);
                long lat = Long.parseLong(datos[1]);
                long longi = Long.parseLong(datos[2]);
                String n = datos[3];
                String dir = datos[4];
                String fb = datos[5];
                String tw = datos[6];
                r = new CA(id, lat, longi, n, dir, fb, tw);
                lista.add(r);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Archivo con mal formato");
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe");
        } catch (IOException ex) {
            System.out.println("Error de lectura de archivo!!");
        }
        return lista;
    }

    public static int save(ArrayList<CA> nuevaData) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(fileName);
            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            nuevaData.forEach(ca -> {
                try {
                    bufferedWriter.write(ca.forArchive());
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            bufferedWriter.close();
            System.out.println("Datos guardados. \n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
