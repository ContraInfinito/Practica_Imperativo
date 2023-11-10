package model;
import view.GUI;

public class Evento1 extends Evento {
    private String lugar;

    public Evento1(String nombre, String fecha, String lugar) {
        super(nombre, fecha);
        this.lugar = lugar;
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        GUI.output("Lugar: " + lugar);
    }
}
