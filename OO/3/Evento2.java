class Evento2 extends Evento {
    private String tipo;

    public Evento2(String nombre, String fecha, String tipo) {
        super(nombre, fecha);
        this.tipo = tipo;
    }

    // Getter y Setter para tipo

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + tipo;
    }
}