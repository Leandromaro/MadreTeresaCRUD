/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package madreteresacrud;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author leandro
 */
@Entity
@Table(name = "logUsuario", catalog = "circuloo_francisco", schema = "")
@NamedQueries({
    @NamedQuery(name = "LogUsuario.findAll", query = "SELECT l FROM LogUsuario l"),
    @NamedQuery(name = "LogUsuario.findByIdlogUsuario", query = "SELECT l FROM LogUsuario l WHERE l.idlogUsuario = :idlogUsuario"),
    @NamedQuery(name = "LogUsuario.findByNombreUsuario", query = "SELECT l FROM LogUsuario l WHERE l.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "LogUsuario.findByActivo", query = "SELECT l FROM LogUsuario l WHERE l.activo = :activo"),
    @NamedQuery(name = "LogUsuario.findByFecha", query = "SELECT l FROM LogUsuario l WHERE l.fecha = :fecha")})
public class LogUsuario implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlogUsuario")
    private Integer idlogUsuario;
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Column(name = "activo")
    private Integer activo;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public LogUsuario() {
    }

    public LogUsuario(Integer idlogUsuario) {
        this.idlogUsuario = idlogUsuario;
    }

    public Integer getIdlogUsuario() {
        return idlogUsuario;
    }

    public void setIdlogUsuario(Integer idlogUsuario) {
        Integer oldIdlogUsuario = this.idlogUsuario;
        this.idlogUsuario = idlogUsuario;
        changeSupport.firePropertyChange("idlogUsuario", oldIdlogUsuario, idlogUsuario);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        String oldNombreUsuario = this.nombreUsuario;
        this.nombreUsuario = nombreUsuario;
        changeSupport.firePropertyChange("nombreUsuario", oldNombreUsuario, nombreUsuario);
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        Integer oldActivo = this.activo;
        this.activo = activo;
        changeSupport.firePropertyChange("activo", oldActivo, activo);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlogUsuario != null ? idlogUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogUsuario)) {
            return false;
        }
        LogUsuario other = (LogUsuario) object;
        if ((this.idlogUsuario == null && other.idlogUsuario != null) || (this.idlogUsuario != null && !this.idlogUsuario.equals(other.idlogUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "madreteresacrud.LogUsuario[ idlogUsuario=" + idlogUsuario + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
