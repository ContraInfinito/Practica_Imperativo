package model;

public class Evento1Factory extends AgendaFactory {
    @Override
    public Contacto crearContacto(String nombre, String direccion) {
        return null;
    }

    @Override
    public Evento crearEvento(String nombre, String fecha) {
        return new Evento1(nombre, fecha, "Lugar predeterminado");
    }
}
