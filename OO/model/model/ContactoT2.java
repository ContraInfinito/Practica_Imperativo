package model;
import view.GUI;
// En el paquete 'model'
public class ContactoT2 extends Contacto {
    private String telefono;

    public ContactoT2(String nombre, String direccion, String telefono) {
        super(nombre, direccion);
        this.telefono = telefono;
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        GUI.output("Teléfono: " + telefono);
    }
}
