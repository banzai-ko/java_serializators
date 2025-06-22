package javaapplication10;

import java.io.Serializable;

class Persona implements Serializable {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y Setters (opcional para binario)
    
    @Override
    public String toString()
    {
        return "Nombre: " + this.nombre + ", " + "Edad: " + this.edad;
    }
}