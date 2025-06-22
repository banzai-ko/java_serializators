/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packages;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author box
 */
@XmlRootElement
public class PersonaXML {
    private String nombre;
    private int edad;
    

    // Constructor vacío requerido por JAXB
    public PersonaXML() {}

    public PersonaXML(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    
    
    @Override
    public String toString()
    {
        return "Nombre: " + this.nombre + ", " + "Edad: " + this.edad;
    }
}