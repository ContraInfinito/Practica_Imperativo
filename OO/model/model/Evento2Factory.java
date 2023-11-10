package model;

public class Evento2Factory extends AgendaFactory {
    @Override
    public Contacto crearContacto(String nombre, String direccion) {
        return null;
    }

    @Override
    public Evento crearEvento(String nombre, String fecha) {
        return new Evento2(nombre, fecha, "Tipo predeterminado");
    }
}
