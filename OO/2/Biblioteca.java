import java.util.ArrayList;
import java.util.List;  // Importa la clase List del paquete java.util

public class Biblioteca {
    public static void main(String[] args) {
        // Crear socios
        Socio socio1 = new Socio(1, "Juan Perez", "Calle 123");
        Socio socio2 = new Socio(2, "Maria Lopez", "Avenida 456");

        // Crear libros
        Libro libro1 = new Libro(101, "El Libro 1", "Autor 1");
        Libro libro2 = new Libro(102, "El Libro 2", "Autor 2");
        Libro libro3 = new Libro(103, "El Libro 3", "Autor 3");
        Libro libro4 = new Libro(104, "El Libro 4", "Autor 4");

        // Realizar préstamos
        socio1.tomarPrestado(libro1, "2023-11-08");
        System.out.println(socio1.getNumeroLibrosPrestados());
        socio1.tomarPrestado(libro2, "2023-11-09");
        System.out.println(socio1.getNumeroLibrosPrestados());
        socio1.tomarPrestado(libro3, "2023-11-10");
        System.out.println(socio1.getNumeroLibrosPrestados());
        socio2.tomarPrestado(libro1, "2023-11-11");

        // Devolver un libro
        socio1.devolver(libro2);

        socio1.tomarPrestado(libro2, "2023-11-21");
        socio1.tomarPrestado(libro4, "2023-11-21");
        // Mostrar socios con más de 3 libros prestados
        List<Socio> sociosConMasDe3Libros = new ArrayList<>();
        sociosConMasDe3Libros.add(socio1);
        sociosConMasDe3Libros.add(socio2);

        for (Socio socio : sociosConMasDe3Libros) {
            if (socio.getNumeroLibrosPrestados() > 3) {
                System.out.println(socio.getNombre() + " tiene más de 3 libros prestados.");
            }
        }
    }
}
