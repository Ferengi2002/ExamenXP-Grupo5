package com.example;

import java.security.SecureRandom;

public class Cuenta {
    private String sitioWeb;
    private String contraseña;

    public Cuenta() {
        
    }

    public Cuenta(String sitioWeb, String contraseña) {
        this.sitioWeb = sitioWeb;
        this.contraseña = contraseña;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean esGenerada() {
        return true;
    }

    public String generarContraseña() {
        int longitud = 10;
        // Caracteres permitidos
        String caracteresMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String caracteresMinusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String simbolosEspeciales = "!@#$%^&*()=+[]{}|'<>/?";

        // Combinación de caracteres.
        String caracteresTotales = caracteresMayusculas + caracteresMinusculas + numeros + simbolosEspeciales;
        SecureRandom random = new SecureRandom();
        char mayuscula = caracteresMayusculas.charAt(random.nextInt(caracteresMayusculas.length()));
        char minuscula = caracteresMinusculas.charAt(random.nextInt(caracteresMinusculas.length()));
        char numero = numeros.charAt(random.nextInt(numeros.length()));
        char simbolo = simbolosEspeciales.charAt(random.nextInt(simbolosEspeciales.length()));

        // Restar 4 para dejar espacio para los caracteres ya seleccionados
        int longitudRestante = longitud - 4;

        // Generar la parte restante de la clave
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longitudRestante; i++) {
            char caracter = caracteresTotales.charAt(random.nextInt(caracteresTotales.length()));
            sb.append(caracter);
        }

        // Mezclar todos los caracteres y devolver la clave
        return ("" + mayuscula + minuscula + numero + simbolo + sb.toString());
    }

    



}
