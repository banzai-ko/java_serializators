package javaapplication10;

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