package contenedores;
import model.AgendaElement;
import view.GUI;
public class ContactoAmigo implements AgendaElement{

    private String nivelAmistad;

    public ContactoAmigo(String nivelAmistad){
        this.nivelAmistad = nivelAmistad;
        return;
    }
    public String getNivelAmistad() {
        return nivelAmistad;
    }

    public void setNivelAmistad(String nivelAmistad) {
        this.nivelAmistad = nivelAmistad;
    }

    @Override
    public void mostrarDetalles() {
        GUI.output("Nivel de Amistad:" +nivelAmistad);
    }
}