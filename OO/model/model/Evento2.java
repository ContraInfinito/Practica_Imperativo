package model;
import view.GUI;

public class Evento2 extends Evento {
    private String tipo;

    public Evento2(String nombre, String fecha, String tipo) {
        super(nombre, fecha);
        this.tipo = tipo;
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        GUI.output("Tipo: " + tipo);
    }
}
