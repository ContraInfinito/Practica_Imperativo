// Clase para objetos geométricos
class GeometricObject extends RepresentableObject {
    private String type;

    public GeometricObject(int x, int y, String type) {
        super(x, y);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void draw() {
        System.out.println("Dibujando objeto geométrico (" + type + ") en (" + getX() + ", " + getY() + ")");
    }
}