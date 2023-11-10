class ContactoT1 extends Contacto {
    private String email;

    public ContactoT1(String nombre, String direccion, String email) {
        super(nombre, direccion);
        this.email = email;
    }

    // Getter y Setter para email

    @Override
    public String toString() {
        return super.toString() + ", Email: " + email;
    }
}