package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Archivo {
    String rutaArchivo;
    List<Cuenta> lista = new ArrayList<>();

    public Archivo(String rutaDelArchivo) {
        this.rutaArchivo = rutaDelArchivo;
    }

    public List<Cuenta> getLista() {
        return lista;
    }

    public void leerArchivo() {
        try {
            File archivo = new File(rutaArchivo);
            FileReader fileReader = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Leer cada línea del archivo y mostrarla en la consola
            String linea;
            lista = new ArrayList<>();

            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarArchivo(Cuenta cuenta) {
        lista.add(cuenta);
        System.out.println(lista);
        try {
            FileWriter fileWriter = new FileWriter(this.rutaArchivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println(cuenta.getSitioWeb().toUpperCase() + ": " + cuenta.getContraseña());
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Contraseña guardada");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actualizarArchivo(String sitioWeb, String nuevaContraseña) {
        boolean encontrado = false;

        try {
            File archivo = new File(rutaArchivo);
            File archivoTemporal = new File(rutaArchivo + ".tmp");

            FileReader fileReader = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(archivoTemporal, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split(": ");
                if (partes.length == 2 && partes[0].equalsIgnoreCase(sitioWeb)) {
                    // Si se encuentra el sitio web, actualizar la contraseña
                    encontrado = true;
                    printWriter.println(sitioWeb.toUpperCase() + ": " + nuevaContraseña);
                } else {
                    printWriter.println(linea);
                }
            }

            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
            bufferedReader.close();
            fileReader.close();

            if (!encontrado) {
                System.out.println("¡Sitio web no encontrado!");
            } else {
                // Renombrar el archivo temporal al original
                archivo.delete();
                archivoTemporal.renameTo(archivo);

                System.out.println("Contraseña actualizada para el sitio web: " + sitioWeb);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

        public void eliminarCuenta(String sitioWeb) {
            try {
                File archivo = new File(rutaArchivo);
                File archivoTemporal = new File(rutaArchivo + ".tmp");
                FileReader fileReader = new FileReader(archivo);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                FileWriter fileWriter = new FileWriter(archivoTemporal, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
    
                boolean eliminado = false;
                String linea;
                while ((linea = bufferedReader.readLine()) != null) {
                    String[] partes = linea.split(": ");
                    if (partes.length == 2 && partes[0].equalsIgnoreCase(sitioWeb)) {
                        eliminado = true;
                        System.out.println("Cuenta eliminada para el sitio web: " + sitioWeb);
                    } else {
                        printWriter.println(linea);
                    }
                }
    
                if (!eliminado) {
                    System.out.println("No se encontró la cuenta para el sitio web: " + sitioWeb);
                }
    
                printWriter.close();
                bufferedWriter.close();
                fileWriter.close();
                bufferedReader.close();
                fileReader.close();
    
                // Renombrar el archivo temporal al original
                archivo.delete();
                archivoTemporal.renameTo(archivo);
    
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
