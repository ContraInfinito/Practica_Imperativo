// En el paquete 'model'
package model;

public class ContactoFactory extends AgendaFactory {
    @Override
    public Contacto crearContacto(String nombre, String direccion) {
        return new Contacto(nombre, direccion);
    }

    @Override
    public Evento crearEvento(String nombre, String fecha) {
        return null;
    }
}
