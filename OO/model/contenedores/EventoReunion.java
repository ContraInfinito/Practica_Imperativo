// En el paquete 'contenedores/eventos'
package contenedores;
import model.AgendaElement;
import view.GUI;

public class EventoReunion implements AgendaElement{

    private String ubicacion;

    public EventoReunion(String ubicacion){
        this.ubicacion = ubicacion;
    }
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public void mostrarDetalles() {
        GUI.output("Ubicación: "+ubicacion);
    }
}
