package pojos;

public class Acciones {
    
    private String tiempo;
    private String nombre;

    public Acciones() {
    }

    public Acciones(String nombre, String tiempo) {
        this.tiempo = tiempo;
        this.nombre = nombre;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
