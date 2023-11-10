// Clase para grupos de objetos representables

import java.util.ArrayList;
import java.util.List;

class GroupObject extends RepresentableObject {
    private List<RepresentableObject> objects;

    public GroupObject(int x, int y) {
        super(x, y);
        objects = new ArrayList<>();
    }

    public List<RepresentableObject> getObjects() {
        return objects;
    }

    public void addObject(RepresentableObject object) {
        objects.add(object);
    }

    public void removeObject(RepresentableObject object) {
        objects.remove(object);
    }

    @Override
    public void draw() {
        System.out.println("Dibujando grupo en (" + getX() + ", " + getY() + ")");
        for (RepresentableObject object : objects) {
            object.draw();
        }
    }
}