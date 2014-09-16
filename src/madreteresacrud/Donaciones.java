/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package madreteresacrud;

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
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leandro
 */
@Entity
@Table(name = "donaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donaciones.findAll", query = "SELECT d FROM Donaciones d"),
    @NamedQuery(name = "Donaciones.findByIddonaciones", query = "SELECT d FROM Donaciones d WHERE d.iddonaciones = :iddonaciones"),
    @NamedQuery(name = "Donaciones.findByNombre", query = "SELECT d FROM Donaciones d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Donaciones.findByApellido", query = "SELECT d FROM Donaciones d WHERE d.apellido = :apellido"),
    @NamedQuery(name = "Donaciones.findByMonto", query = "SELECT d FROM Donaciones d WHERE d.monto = :monto"),
    @NamedQuery(name = "Donaciones.findByFechaDonacion", query = "SELECT d FROM Donaciones d WHERE d.fechaDonacion = :fechaDonacion"),
    @NamedQuery(name = "Donaciones.findByDni", query = "SELECT d FROM Donaciones d WHERE d.dni = :dni")})
public class Donaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddonaciones")
    private Integer iddonaciones;
    //@Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    //@Size(max = 50)
    @Column(name = "apellido")
    private String apellido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "fechaDonacion")
    @Temporal(TemporalType.DATE)
    private Date fechaDonacion;
    @Column(name = "DNI")
    private Integer dni;

    public Donaciones() {
    }

    public Donaciones(Integer iddonaciones) {
        this.iddonaciones = iddonaciones;
    }

    public Integer getIddonaciones() {
        return iddonaciones;
    }

    public void setIddonaciones(Integer iddonaciones) {
        this.iddonaciones = iddonaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(Date fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
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
    
}
