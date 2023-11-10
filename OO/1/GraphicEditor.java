public class GraphicEditor {
    public static void main(String[] args) {
        // Crear instancias de objetos representables
        GeometricObject circle = new GeometricObject(10, 10, "circle");
        TextObject text = new TextObject(20, 20, "Hello, World!");
        GroupObject group = new GroupObject(30, 30);

        // Agregar objetos al grupo
        group.addObject(circle);
        group.addObject(text);

        // Crear un grupo anidado
        GroupObject nestedGroup = new GroupObject(40, 40);
        nestedGroup.addObject(new GeometricObject(5, 5, "rectangle"));
        group.addObject(nestedGroup);

        // Dibujar todos los objetos
        circle.draw();
        text.draw();
        group.draw();
    }
}