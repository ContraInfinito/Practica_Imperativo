class Evento1 extends Evento {
    private String lugar;

    public Evento1(String nombre, String fecha, String lugar) {
        super(nombre, fecha);
        this.lugar = lugar;
    }

    // Getter y Setter para lugar

    @Override
    public String toString() {
        return super.toString() + ", Lugar: " + lugar;
    }
}