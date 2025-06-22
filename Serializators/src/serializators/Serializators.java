/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serializators;
import java.io.BufferedOutputStream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import packages.*;

/**
 *
 * @author box
 */
public class Serializators {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // <editor-fold defaultstate="collapsed" desc="BINARIO">
                
        //SERIALIZACION BINARIA Y ARCHIVO
        Persona persona = new Persona("Juan", 30);
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream("persona.dat")))) {
            
            oos.writeObject(persona);
            
            System.out.println("Objeto serializado en binario.");
            System.out.println("");
            
        } catch (IOException e) {
            System.out.println("Ocurrio un error al serializar BINARIO: " + e.getMessage());
            System.out.println("");
        }
        
        //DESERIALIZACION BINARIA
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persona.dat"))) {
            
            Persona personaBinaria = (Persona) ois.readObject();
            
            System.out.println(persona);
            
            System.out.println("");
            
        } catch (Exception e) {
            System.out.println("Ocurrio un error al deserializar BINARIO: " + e.getMessage());
            System.out.println("");
        }
        
        //SERIALIZAR LISTA BINARIO
        List<Persona> personasBinario = new ArrayList<>();
        
        personasBinario.add(new Persona("Jose", 30));
        personasBinario.add(new Persona("Federico", 25));
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("personas.dat"))) {
            
            oos.writeObject(personasBinario); // la lista debe ser Serializable y los objetos también
            
            System.out.println("Lista binaria serializada con exito");
            System.out.println("");
            
        } catch (IOException e) {
            
            System.out.println("Ocurrio un error al serializar lista BINARIO: " + e.getMessage());
            System.out.println("");
        }
        
        //DESERIALIZAR LISTA BINARIO
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personas.dat"))) {
            
            List<Persona> personas = (List<Persona>) ois.readObject();
            personas.forEach(System.out::println);
            System.out.println("");
            
        } catch (IOException | ClassNotFoundException e) {
             System.out.println("Ocurrio un error al deserializar lista BINARIO: " + e.getMessage());
             System.out.println("");
        }
 // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="JSON">

        //SERIALIZACION JSON Y ARCHIVO
        PersonaJSON personaJSON = new PersonaJSON("Carlos", 35);

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // JSON bien formateado
        
        String json = gson.toJson(personaJSON); // Convertir objeto a JSON

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("persona.json"))) {
            
            writer.write(json);
            
            System.out.println("Objeto serializado a JSON con Gson.");
            System.out.println("");
            
        } catch (IOException e) {
            
            System.out.println("Ocurrio un error al serializar JSON: " + e.getMessage());
            System.out.println("");
        }
        
        //DESERIALIZACION JSON
        try (BufferedReader br = new BufferedReader(new FileReader("persona.json"))) {
            
            Gson gsonReader = new Gson();
            
            PersonaJSON personaDeserializa = gsonReader.fromJson(br, PersonaJSON.class);
            
            System.out.println(personaDeserializa.getNombre());
            System.out.println("");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al deserializar JSON: " + e.getMessage());
            System.out.println("");
        }
        
        
        //SERIALIZAR LISTA JSON
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Ana", 30));
        personas.add(new Persona("Luis", 25));

        Gson gson2 = new GsonBuilder().setPrettyPrinting().create(); // JSON bien formateado
        
        String json2 = gson2.toJson(personas); // Convertir objeto a JSON

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("personas.json"))) {
            
            writer.write(json2);
            
            System.out.println("Lista serializada a JSON con Gson.");
            System.out.println("");
            
        } catch (IOException e) {
            
            System.out.println("Ocurrio un error al serializar la lista JSON: " + e.getMessage());
            System.out.println("");
        }
        
        
        //DESERIALIZACION LISTA JSON
        try (BufferedReader br = new BufferedReader(new FileReader("personas.json"))) {
            
            java.lang.reflect.Type listType = new TypeToken<List<PersonaJSON>>() {}.getType();

            List<PersonaJSON> personasLista = gson2.fromJson(br, listType);

            for (PersonaJSON p : personasLista) {
                System.out.println("Nombre: " + p.getNombre() + ", Edad: " + p.getEdad());
            }
            System.out.println("");
        } catch (Exception e) {
            System.out.println("Ocurrió un error al deserializar JSON: " + e.getMessage());
            System.out.println("");
        }
        // </editor-fold>
        
        
        
        
        // <editor-fold defaultstate="collapsed" desc="XML">
        
        //SERIALIZACION XML Y ARCHIVO
        PersonaXML personaXML = new PersonaXML("Lucía", 28);
        
        try {
            JAXBContext context = JAXBContext.newInstance(PersonaXML.class);
            
            Marshaller marshaller = context.createMarshaller();
            
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Serializa directamente con BufferedWriter
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("persona.xml"))) {
                marshaller.marshal(personaXML, writer);
            }

            System.out.println("Objeto guardado como XML.");
            System.out.println("");
        } catch (Exception e) {
            
            System.out.println("Ocurrio un error al serializar XML: " + e.getMessage());
            System.out.println("");
        }
        
        //DESERIALIZACION
         try {
            JAXBContext context = JAXBContext.newInstance(PersonaXML.class);
            
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            PersonaXML personaDeseXML = (PersonaXML) unmarshaller.unmarshal(new File("persona.xml"));
            
            System.out.println(personaDeseXML);
            System.out.println("");
            
        } catch (Exception e) {
            System.out.println("Ocurrio un error al deserializar XML: " + e.getMessage());
            System.out.println("");
        }
        // </editor-fold>
    }
}
