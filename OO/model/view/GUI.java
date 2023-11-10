package view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.AgendaElement;
import model.ContactoT1;
import model.ContactoT2;
import model.Evento1;
import model.Evento2;
import model.SingletonAgenda;

public class GUI {

    private static List<Class<? extends AgendaElement>> tiposCargados = new ArrayList<>();

    private static final String DESTINATION_FOLDER = "C:\\Users\\mathe\\Documents\\TEC\\II Semestre\\Lenguajes de Programación\\Laboratorios\\OO\\model\\contenedores";

    public static void output(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    private static void createAndShowGUI() {
        String directorio = "C:\\Users\\mathe\\Documents\\TEC\\II Semestre\\Lenguajes de Programación\\Laboratorios\\OO\\model\\contenedores";
        directorio = directorio.replace("\\", "\\\\");
        cargarTiposDesdeDirectorio(directorio);
        JFrame frame = new JFrame("Agenda GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton addButton = new JButton("Agregar Elemento");
        JButton loadButton = new JButton("Cargar Tipos desde Directorio");
        JButton showButton = new JButton("Mostrar Información");
        panel.add(addButton);
        panel.add(loadButton);
        panel.add(showButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialogoAgregarElemento();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarTiposDesdeDirectorioUsuario();
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInformacionElementos();
            }
        });

        frame.getContentPane().add(panel);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void mostrarDialogoAgregarElemento() {
        String directorio = "C:\\Users\\mathe\\Documents\\TEC\\II Semestre\\Lenguajes de Programación\\Laboratorios\\OO\\model\\contenedores";
        directorio = directorio.replace("\\", "\\\\");
        cargarTiposDesdeDirectorio(directorio);
    
        // Agrega los tipos básicos a la lista tiposCargados
        tiposCargados.add(ContactoT1.class);
        tiposCargados.add(ContactoT2.class);
        tiposCargados.add(Evento1.class);
        tiposCargados.add(Evento2.class);
    
        List<Class<? extends AgendaElement>> opciones = new ArrayList<>(tiposCargados);
    
        // Asegurémonos de que haya opciones disponibles antes de mostrar el diálogo
        if (!opciones.isEmpty()) {
            String tipoElemento = mostrarDialogo(opciones, "Selecciona el tipo de elemento a agregar");
    
            if (tipoElemento != null) {
                agregarElemento(tipoElemento);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay tipos de elementos disponibles para agregar.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    

    private static void cargarTiposDesdeDirectorioUsuario() {
        String directorio = JOptionPane.showInputDialog(null, "Ingrese la ruta del directorio:");

        if (directorio != null && !directorio.isEmpty()) {
            directorio = directorio.replace("\\", "\\\\");
            System.out.println(directorio);

            List<Class<? extends AgendaElement>> tipos = cargarTiposDesdeDirectorio(directorio);

            if (!tipos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tipos cargados exitosamente desde el directorio.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron tipos en el directorio especificado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada o no se especificó un directorio.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static List<Class<? extends AgendaElement>> cargarTiposDesdeDirectorio(String directorio) {
        try {
            File carpeta = new File(directorio);

            if (carpeta.isDirectory()) {
                compilarArchivosJava(carpeta);

                URLClassLoader classLoader = new URLClassLoader(new java.net.URL[]{carpeta.toURI().toURL()});

                File[] archivos = carpeta.listFiles(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        return name.endsWith(".class");
                    }
                });

                if (archivos != null) {
                    for (File archivo : archivos) {
                        String nombreClase = archivo.getName().replace(".class", "");
                        System.out.println(nombreClase);
                        String nombreCompletoClase = "contenedores." + nombreClase;
                        System.out.println(nombreCompletoClase);

                        // Guardar el archivo en la carpeta de destino antes de cargar la clase
                        Path destino = Path.of(DESTINATION_FOLDER, archivo.getName());
                        Files.copy(archivo.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);

                        try {
                            Class<?> clase = classLoader.loadClass(nombreCompletoClase);
                            System.out.println("Clase cargada");

                            if (!tiposCargados.contains(clase)) {
                                tiposCargados.add((Class<? extends AgendaElement>) clase);
                            }
                        } catch (ClassNotFoundException e) {
                            JOptionPane.showMessageDialog(null, "Error: " + "clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        eliminarRepetidos();
        return tiposCargados;
    }

    private static void compilarArchivosJava(File carpeta) {
        // Implementa la lógica de compilación aquí si es necesario
    }

    private static void eliminarRepetidos() {
        tiposCargados = tiposCargados.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private static String mostrarDialogo(List<Class<? extends AgendaElement>> opciones, String mensaje) {
        if (opciones.isEmpty()) {
            return null;
        }

        String[] arrayOpciones = opciones.stream().map(Class::getSimpleName).toArray(String[]::new);
        return (String) JOptionPane.showInputDialog(
                null,
                mensaje,
                "Seleccionar",
                JOptionPane.QUESTION_MESSAGE,
                null,
                arrayOpciones,
                arrayOpciones[0]);
    }

    private static void agregarElemento(String tipoElemento) {
        try {
            List<Class<? extends AgendaElement>> opciones = new ArrayList<>(tiposCargados);
            opciones.addAll(tiposCargados);

            Class<? extends AgendaElement> clase = opciones.stream()
                    .filter(c -> c.getSimpleName().equals(tipoElemento))
                    .findFirst()
                    .orElseThrow(ClassNotFoundException::new);

            // Obtener los constructores de la clase
            Constructor<?>[] constructores = clase.getDeclaredConstructors();

            // Seleccionar el constructor adecuado (en este caso, el primer constructor)
            Constructor<?> constructor = constructores[0];

            // Obtener los tipos de parámetros del constructor
            Class<?>[] parameterTypes = constructor.getParameterTypes();

            // Pedir al usuario la información necesaria para crear la instancia del elemento
            Object[] parametros = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                // Pedir al usuario cada parámetro
                String valor = JOptionPane.showInputDialog("Ingrese el valor para " + parameterTypes[i].getSimpleName() + ":");
                // Convertir el valor al tipo correcto
                parametros[i] = convertirValor(valor, parameterTypes[i]);
            }

            // Crear una nueva instancia del elemento
            Object objeto = constructor.newInstance(parametros);

            if (objeto instanceof AgendaElement) {
                AgendaElement elemento = (AgendaElement) objeto;
                SingletonAgenda.getInstance().agregarElemento(elemento);
                JOptionPane.showMessageDialog(null, "Agregado: " + tipoElemento, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "La clase no es una instancia de AgendaElement.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Clase no encontrada - " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al instanciar el objeto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void mostrarInformacionElementos() {
        JOptionPane.showMessageDialog(null, "Información de Elementos en la Ejecución:");
    
        for (Class<? extends AgendaElement> clase : tiposCargados) {
            mostrarInformacionDeClase(clase);
        }
    
        JOptionPane.showMessageDialog(null, "\nInformación de Elementos por Defecto en el Paquete Model:");
        SingletonAgenda.getInstance().mostrarElementos();
    }

    private static void mostrarInformacionElementosEnPaqueteModel() {
        for (Class<? extends AgendaElement> clase : tiposCargados) {
            JOptionPane.showMessageDialog(null,"Información: ");
            mostrarInformacionDeClase(clase);
        }
    }

    private static Object convertirValor(String valor, Class<?> tipo) {
        // Método para convertir el valor del usuario al tipo correcto
        // Puedes personalizar este método según tus necesidades
        if (tipo.equals(String.class)) {
            return valor;
        } else if (tipo.equals(int.class) || tipo.equals(Integer.class)) {
            return Integer.parseInt(valor);
        } else if (tipo.equals(double.class) || tipo.equals(Double.class)) {
            return Double.parseDouble(valor);
        } else {
            // Agrega conversiones para otros tipos según sea necesario
            return valor;
        }
    }

    private static void mostrarInformacionDeClase(Class<? extends AgendaElement> clase) {
        JOptionPane.showMessageDialog(null, "Nombre del tipo: " + clase.getSimpleName());
        // Puedes agregar más detalles según sea necesario
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
