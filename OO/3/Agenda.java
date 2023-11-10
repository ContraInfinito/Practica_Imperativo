import java.util.ArrayList;
import java.util.List;

class Agenda {
    private List<Contacto> contactos;
    private List<Evento> eventos;

    public Agenda() {
        contactos = new ArrayList<>();
        eventos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void eliminarContacto(Contacto contacto) {
        contactos.remove(contacto);
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void eliminarEvento(Evento evento) {
        eventos.remove(evento);
    }

    public void mostrarContactos() {
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    public void mostrarEventos() {
        for (Evento evento : eventos) {
            System.out.println(evento);
        }
    }
}