class Contacto {
    private String nombre;
    private String direccion;
    
    public Contacto(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // Getters y Setters para nombre y dirección

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Dirección: " + direccion;
    }
}
