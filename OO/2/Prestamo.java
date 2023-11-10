class Prestamo {
    private Libro libro;
    private Socio socio;
    private String fechaPrestamo;

    public Prestamo(Libro libro, Socio socio, String fechaPrestamo) {
        this.libro = libro;
        this.socio = socio;
        this.fechaPrestamo = fechaPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public Socio getSocio() {
        return socio;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }
}