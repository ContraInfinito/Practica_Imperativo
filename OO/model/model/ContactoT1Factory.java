package model;

// En el paquete 'model'
public class ContactoT1Factory extends AgendaFactory {
    @Override
    public Contacto crearContacto(String nombre, String direccion) {
        return new ContactoT1(nombre, direccion, "default@example.com");
    }

    @Override
    public Evento crearEvento(String nombre, String fecha) {
        return null;
    }
}
