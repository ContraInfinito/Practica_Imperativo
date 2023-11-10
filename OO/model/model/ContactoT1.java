// En el paquete 'model'
package model;
import view.GUI;

public class ContactoT1 extends Contacto {
    private String email;

    public ContactoT1(String nombre, String direccion, String email) {
        super(nombre, direccion);
        this.email = email;
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        GUI.output("Email: " + email);
    }
}
