/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packages;

/**
 *
 * @author box
 */
public class PersonaJSON {
    private String nombre;
    private int edad;

    public PersonaJSON(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters (opcional)
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    
}