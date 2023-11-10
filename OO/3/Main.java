public class Main {
    public static void main(String[] args) {
        Agenda agenda1 = new Agenda();
        Agenda agenda2 = new Agenda();

        ContactoT1 contacto1 = new ContactoT1("Juan", "Calle 123", "juan@example.com");
        ContactoT2 contacto2 = new ContactoT2("Maria", "Avenida 456", "555-123-4567");

        Evento1 evento1 = new Evento1("Fiesta de cumpleaños", "2023-11-15", "Casa de Juan");
        Evento2 evento2 = new Evento2("Reunión de trabajo", "2023-11-20", "Virtual");

        agenda1.agregarContacto(contacto1);
        agenda1.agregarEvento(evento1);

        agenda2.agregarContacto(contacto2);
        agenda2.agregarEvento(evento2);

        System.out.println("Agenda 1 - Contactos:");
        agenda1.mostrarContactos();
        System.out.println("Agenda 1 - Eventos:");
        agenda1.mostrarEventos();

        System.out.println("Agenda 2 - Contactos:");
        agenda2.mostrarContactos();
        System.out.println("Agenda 2 - Eventos:");
        agenda2.mostrarEventos();
    }
}
