/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package madreteresacrud.floresVida;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import utilidades.Localidades;

/**
 *
 * @author francis
 */
@Entity
@Table(name = "florVida")
@NamedQueries({
    @NamedQuery(name = "FlorVida.findAll", query = "SELECT f FROM FlorVida f"),
    @NamedQuery(name = "FlorVida.findByApellido", query = "SELECT f FROM FlorVida f WHERE f.apellido = :apellido"),
    @NamedQuery(name = "FlorVida.findByNombre", query = "SELECT f FROM FlorVida f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "FlorVida.findByLocalidad", query = "SELECT f FROM FlorVida f WHERE f.localidad = :localidad"),
    @NamedQuery(name = "FlorVida.findByDireccion", query = "SELECT f FROM FlorVida f WHERE f.direccion = :direccion"),
    @NamedQuery(name = "FlorVida.findByFechaDefuncion", query = "SELECT f FROM FlorVida f WHERE f.fechaDefuncion = :fechaDefuncion"),
    @NamedQuery(name = "FlorVida.findByTelefono", query = "SELECT f FROM FlorVida f WHERE f.telefono = :telefono"),
    @NamedQuery(name = "FlorVida.findByIdFV", query = "SELECT f FROM FlorVida f WHERE f.idFV = :idFV")})
public class FlorVida implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "localidad", referencedColumnName = "codLoc")
    @ManyToOne(optional = false)
    private Localidades localidad;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "fechaDefuncion")
    @Temporal(TemporalType.DATE)
    private Date fechaDefuncion;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFV")
    private Integer idFV;

    public FlorVida() {
    }

    public FlorVida(Integer idFV) {
        this.idFV = idFV;
    }

    public FlorVida(Integer idFV, Localidades localidad, String telefono) {
        this.idFV = idFV;
        this.localidad = localidad;
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        String oldApellido = this.apellido;
        this.apellido = apellido;
        changeSupport.firePropertyChange("apellido", oldApellido, apellido);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public Localidades getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidades localidad) {
        Localidades oldLocalidad = this.localidad;
        this.localidad = localidad;
        changeSupport.firePropertyChange("localidad", oldLocalidad, localidad);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        String oldDireccion = this.direccion;
        this.direccion = direccion;
        changeSupport.firePropertyChange("direccion", oldDireccion, direccion);
    }

    public Date getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(Date fechaDefuncion) {
        Date oldFechaDefuncion = this.fechaDefuncion;
        this.fechaDefuncion = fechaDefuncion;
        changeSupport.firePropertyChange("fechaDefuncion", oldFechaDefuncion, fechaDefuncion);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        String oldTelefono = this.telefono;
        this.telefono = telefono;
        changeSupport.firePropertyChange("telefono", oldTelefono, telefono);
    }

    public Integer getIdFV() {
        return idFV;
    }

    public void setIdFV(Integer idFV) {
        Integer oldIdFV = this.idFV;
        this.idFV = idFV;
        changeSupport.firePropertyChange("idFV", oldIdFV, idFV);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFV != null ? idFV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FlorVida)) {
            return false;
        }
        FlorVida other = (FlorVida) object;
        if ((this.idFV == null && other.idFV != null) || (this.idFV != null && !this.idFV.equals(other.idFV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "madreteresacrud.floresVida.FlorVida[ idFV=" + idFV + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
