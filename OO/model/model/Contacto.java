// En el paquete 'model'
package model;
import view.GUI;

public class Contacto implements AgendaElement {
    private String nombre;
    private String direccion;

    public Contacto(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public void mostrarDetalles() {
        GUI.output("Nombre: " + nombre + ", Dirección: " + direccion);
    }
}
