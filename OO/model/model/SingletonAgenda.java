package model;

import java.util.ArrayList;
import java.util.List;

public class SingletonAgenda {
    private static SingletonAgenda instance;
    private List<AgendaElement> elementos;

    private SingletonAgenda() {
        elementos = new ArrayList<>();
        // Inicializar con algunos elementos precargados
        elementos.add(new ContactoT1("Juan", "Calle 123", "default@example.com"));
        elementos.add(new Evento1("Fiesta", "2023-11-08", "Salón de eventos"));
    }

    public static SingletonAgenda getInstance() {
        if (instance == null) {
            instance = new SingletonAgenda();
        }
        return instance;
    }

    public void agregarElemento(AgendaElement elemento) {
        elementos.add(elemento);
    }

    public void eliminarElemento(AgendaElement elemento) {
        elementos.remove(elemento);
    }

    public void mostrarElementos() {
        for (AgendaElement elemento : elementos) {
            elemento.mostrarDetalles();
        }
    }
}
