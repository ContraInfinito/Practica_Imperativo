// En el paquete 'model'
package model;

public abstract class AgendaFactory {
    public abstract Contacto crearContacto(String nombre, String direccion);
    public abstract Evento crearEvento(String nombre, String fecha);
}
