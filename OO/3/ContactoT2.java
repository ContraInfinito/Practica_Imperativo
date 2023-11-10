class ContactoT2 extends Contacto {
    private String telefono;

    public ContactoT2(String nombre, String direccion, String telefono) {
        super(nombre, direccion);
        this.telefono = telefono;
    }

    // Getter y Setter para teléfono

    @Override
    public String toString() {
        return super.toString() + ", Teléfono: " + telefono;
    }
}