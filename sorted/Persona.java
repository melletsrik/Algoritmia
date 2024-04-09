package sorted;

public class Persona implements Comparable<Persona> {
    private int codigo;
    private String nombre;
    private float peso;

    public Persona(int codigo, String nombre, float peso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.peso = peso;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPeso() {
        return peso;
    }

    @Override
    public int compareTo(Persona otraPersona) {
        return this.nombre.compareTo(otraPersona.getNombre());
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}