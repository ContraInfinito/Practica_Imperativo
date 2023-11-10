package model;
import view.GUI;
// En el paquete 'model'
public class Evento implements AgendaElement {
    private String nombre;
    private String fecha;

    public Evento(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    @Override
    public void mostrarDetalles() {
        GUI.output("Evento: " + nombre + ", Fecha: " + fecha);
    }
}
