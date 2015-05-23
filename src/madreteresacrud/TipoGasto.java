/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package madreteresacrud;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
@Table(name = "tipoGasto")
@NamedQueries({
    @NamedQuery(name = "TipoGasto.findAll", query = "SELECT t FROM TipoGasto t"),
    @NamedQuery(name = "TipoGasto.findByIdtipoGasto", query = "SELECT t FROM TipoGasto t WHERE t.idtipoGasto = :idtipoGasto"),
    @NamedQuery(name = "TipoGasto.findByDescripcion", query = "SELECT t FROM TipoGasto t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoGasto.findByTipoGasto", query = "SELECT t FROM TipoGasto t WHERE t.tipoGasto = :tipoGasto"),
    @NamedQuery(name = "TipoGasto.findByElemento", query = "SELECT t FROM TipoGasto t WHERE t.elemento = :elemento")})
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
    @Basic(optional = false)
    @Column(name = "TipoGasto")
    private String tipoGasto;
    @Basic(optional = false)
    @Column(name = "Elemento")
    private String elemento;

    public TipoGasto() {
    }

    public TipoGasto(Integer idtipoGasto) {
        this.idtipoGasto = idtipoGasto;
    }

    public TipoGasto(Integer idtipoGasto, String tipoGasto, String elemento) {
        this.idtipoGasto = idtipoGasto;
        this.tipoGasto = tipoGasto;
        this.elemento = elemento;
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

    public String getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(String tipoGasto) {
        String oldTipoGasto = this.tipoGasto;
        this.tipoGasto = tipoGasto;
        changeSupport.firePropertyChange("tipoGasto", oldTipoGasto, tipoGasto);
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        String oldElemento = this.elemento;
        this.elemento = elemento;
        changeSupport.firePropertyChange("elemento", oldElemento, elemento);
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
        return elemento;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
