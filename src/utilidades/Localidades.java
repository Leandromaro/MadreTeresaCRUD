/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author francis
 */
@Entity
@Table(name = "localidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidades.findAll", query = "SELECT l FROM Localidades l"),
    @NamedQuery(name = "Localidades.findByCodLoc", query = "SELECT l FROM Localidades l WHERE l.localidadesPK.codLoc = :codLoc"),
    @NamedQuery(name = "Localidades.findByCodProv", query = "SELECT l FROM Localidades l WHERE l.localidadesPK.codProv = :codProv"),
    @NamedQuery(name = "Localidades.findByLocalidad", query = "SELECT l FROM Localidades l WHERE l.localidad = :localidad")})
public class Localidades implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LocalidadesPK localidadesPK;
    @Basic(optional = false)
    @Column(name = "localidad")
    private String localidad;
    @JoinColumn(name = "codProv", referencedColumnName = "codProv", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Provincias provincias;

    public Localidades() {
    }

    public Localidades(LocalidadesPK localidadesPK) {
        this.localidadesPK = localidadesPK;
    }

    public Localidades(LocalidadesPK localidadesPK, String localidad) {
        this.localidadesPK = localidadesPK;
        this.localidad = localidad;
    }

    public Localidades(int codLoc, int codProv) {
        this.localidadesPK = new LocalidadesPK(codLoc, codProv);
    }

    public LocalidadesPK getLocalidadesPK() {
        return localidadesPK;
    }

    public void setLocalidadesPK(LocalidadesPK localidadesPK) {
        this.localidadesPK = localidadesPK;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        String oldLocalidad = this.localidad;
        this.localidad = localidad;
        changeSupport.firePropertyChange("localidad", oldLocalidad, localidad);
    }

    public Provincias getProvincias() {
        return provincias;
    }

    public void setProvincias(Provincias provincias) {
        Provincias oldProvincias = this.provincias;
        this.provincias = provincias;
        changeSupport.firePropertyChange("provincias", oldProvincias, provincias);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localidadesPK != null ? localidadesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidades)) {
            return false;
        }
        Localidades other = (Localidades) object;
        if ((this.localidadesPK == null && other.localidadesPK != null) || (this.localidadesPK != null && !this.localidadesPK.equals(other.localidadesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilidades.Localidades[ localidadesPK=" + localidadesPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
