package frcufreedev.juegodelavida;

import java.beans.PropertyChangeSupport;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author agustin
 */
public class CelulaModel {
    public static final String PROP_ESTADO = "Estado";
    
    public static final String PROP_SIGUIENTE = "Siguiente";
    
    /**
     * Estado de vida de la célula <code>true</code>= viva.
     */
    private boolean estado = false;
    /**
     * Próximo valor a tomar por la célula.
     */
    private boolean siguiente = false;
    /**
     * Colección de clélulas vecinas
     */
    private final List<CelulaModel> vecinas = new LinkedList();
    
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    /**
     * @return the estado
     */
    public boolean getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        boolean oldEstado = this.estado;
        this.estado = estado;
        propertyChangeSupport.firePropertyChange(PROP_ESTADO, oldEstado, estado);
    }
    
    /**
     * @return the siguiente
     */
    public boolean getSiguiente() {
        return estado;
    }

    /**
     * 
     */
    public void actualizar() {
        boolean oldEstado = this.siguiente;
        // código de actualización, cálculo de la vida o muerte
        long vivas = this.vecinas.stream()
                .filter(celula -> celula.getEstado())
                .count();
        if (this.estado && (vivas < 2 || vivas > 3)) {
            this.siguiente = false;
        } else if (!this.estado && vivas == 3) {
            this.siguiente = true;
        }
        this.siguiente = this.estado;
        propertyChangeSupport.firePropertyChange(PROP_ESTADO, oldEstado, estado);
    }
    
    public void asignar() {
        this.estado = this.siguiente;
    }
    
    public void agregarVecina(CelulaModel celula) {
        this.vecinas.add(celula);
    }
    
    public void removerVecina(CelulaModel celula) {
        this.vecinas.remove(celula);
    }
}