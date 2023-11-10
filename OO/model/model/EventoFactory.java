package model;

public class EventoFactory extends AgendaFactory {
    @Override
    public Contacto crearContacto(String nombre, String direccion) {
        return null;
    }

    @Override
    public Evento crearEvento(String nombre, String fecha) {
        return new Evento(nombre, fecha);
    }
}

