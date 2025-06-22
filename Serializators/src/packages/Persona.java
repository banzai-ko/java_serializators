/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packages;
import java.io.Serializable;

/**
 *
 * @author box
 */
public class Persona implements Serializable {
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