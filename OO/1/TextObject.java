// Clase para objetos de texto
class TextObject extends RepresentableObject {
    private String text;

    public TextObject(int x, int y, String text) {
        super(x, y);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void draw() {
        System.out.println("Dibujando texto: " + text + " en (" + getX() + ", " + getY() + ")");
    }
}