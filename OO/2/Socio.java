import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Socio {
    private int numeroSocio;
    private String nombre;
    private String direccion;
    private List<Prestamo> prestamos;

    public Socio(int numeroSocio, String nombre, String direccion) {
        this.numeroSocio = numeroSocio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.prestamos = new ArrayList<>();
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNumeroLibrosPrestados() {
        return prestamos.size();
    }

    public void tomarPrestado(Libro libro, String fechaPrestamo) {
        Prestamo prestamo = new Prestamo(libro, this, fechaPrestamo);
        prestamos.add(prestamo);
        libro.setDisponible(false);
    }

    public void devolver(Libro libro) {
        prestamos = prestamos.stream()
                .filter(p -> p.getLibro() != libro)
                .collect(Collectors.toList());
        libro.setDisponible(true);
    }
}