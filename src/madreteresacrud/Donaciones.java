/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package madreteresacrud;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "donaciones", catalog = "sistcalcuta", schema = "")
@NamedQueries({
    @NamedQuery(name = "Donaciones.findAll", query = "SELECT d FROM Donaciones d"),
    @NamedQuery(name = "Donaciones.findByIddonaciones", query = "SELECT d FROM Donaciones d WHERE d.iddonaciones = :iddonaciones"),
    @NamedQuery(name = "Donaciones.findByNombre", query = "SELECT d FROM Donaciones d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Donaciones.findByApellido", query = "SELECT d FROM Donaciones d WHERE d.apellido = :apellido"),
    @NamedQuery(name = "Donaciones.findByMonto", query = "SELECT d FROM Donaciones d WHERE d.monto = :monto"),
    @NamedQuery(name = "Donaciones.findByFechaDonacion", query = "SELECT d FROM Donaciones d WHERE d.fechaDonacion = :fechaDonacion")})
public class Donaciones implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddonaciones")
    private Integer iddonaciones;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "fechaDonacion")
    @Temporal(TemporalType.DATE)
    private Date fechaDonacion;

    public Donaciones() {
    }

    public Donaciones(Integer iddonaciones) {
        this.iddonaciones = iddonaciones;
    }

    public Integer getIddonaciones() {
        return iddonaciones;
    }

    public void setIddonaciones(Integer iddonaciones) {
        Integer oldIddonaciones = this.iddonaciones;
        this.iddonaciones = iddonaciones;
        changeSupport.firePropertyChange("iddonaciones", oldIddonaciones, iddonaciones);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        String oldApellido = this.apellido;
        this.apellido = apellido;
        changeSupport.firePropertyChange("apellido", oldApellido, apellido);
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        BigDecimal oldMonto = this.monto;
        this.monto = monto;
        changeSupport.firePropertyChange("monto", oldMonto, monto);
    }

    public Date getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(Date fechaDonacion) {
        Date oldFechaDonacion = this.fechaDonacion;
        this.fechaDonacion = fechaDonacion;
        changeSupport.firePropertyChange("fechaDonacion", oldFechaDonacion, fechaDonacion);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddonaciones != null ? iddonaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donaciones)) {
            return false;
        }
        Donaciones other = (Donaciones) object;
        if ((this.iddonaciones == null && other.iddonaciones != null) || (this.iddonaciones != null && !this.iddonaciones.equals(other.iddonaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "madreteresacrud.Donaciones[ iddonaciones=" + iddonaciones + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
