class Evento {
    private String nombre;
    private String fecha;

    public Evento(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    // Getters y Setters para nombre y fecha

    @Override
    public String toString() {
        return "Evento: " + nombre + ", Fecha: " + fecha;
    }
}