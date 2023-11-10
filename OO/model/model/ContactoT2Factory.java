package model;

// En el paquete 'model'
public class ContactoT2Factory extends AgendaFactory {
    @Override
    public Contacto crearContacto(String nombre, String direccion) {
        return new ContactoT2(nombre, direccion, "555-555-5555");
    }

    @Override
    public Evento crearEvento(String nombre, String fecha) {
        return null;
    }
}
