/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package madreteresacrud;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import static java.util.Collections.list;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author leandro
 */
@Entity
@Table(name = "tipoGasto", catalog = "sistcalcuta", schema = "")
@NamedQueries({
    @NamedQuery(name = "TipoGasto.findAll", query = "SELECT t FROM TipoGasto t"),
    @NamedQuery(name = "TipoGasto.findByIdtipoGasto", query = "SELECT t FROM TipoGasto t WHERE t.idtipoGasto = :idtipoGasto"),
    @NamedQuery(name = "TipoGasto.findByDescripcion", query = "SELECT t FROM TipoGasto t WHERE t.descripcion = :descripcion")})
public class TipoGasto implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_gasto")
    private Integer idtipoGasto;
    @Column(name = "descripcion")
    private String descripcion;

    public TipoGasto() {
    }

    public TipoGasto(Integer idtipoGasto) {
        this.idtipoGasto = idtipoGasto;
    }

    public Integer getIdtipoGasto() {
        return idtipoGasto;
    }

    public void setIdtipoGasto(Integer idtipoGasto) {
        Integer oldIdtipoGasto = this.idtipoGasto;
        this.idtipoGasto = idtipoGasto;
        changeSupport.firePropertyChange("idtipoGasto", oldIdtipoGasto, idtipoGasto);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String oldDescripcion = this.descripcion;
        this.descripcion = descripcion;
        changeSupport.firePropertyChange("descripcion", oldDescripcion, descripcion);
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoGasto != null ? idtipoGasto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoGasto)) {
            return false;
        }
        TipoGasto other = (TipoGasto) object;
        if ((this.idtipoGasto == null && other.idtipoGasto != null) || (this.idtipoGasto != null && !this.idtipoGasto.equals(other.idtipoGasto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "madreteresacrud.TipoGasto[ idtipoGasto=" + idtipoGasto + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
    
    
}
