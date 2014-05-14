/*
 * To change this template, choose Tools | Templates
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
 * @author francis
 */
@Entity
@Table(name = "cuotaSocial", catalog = "sistcalcuta", schema = "")
@NamedQueries({
    @NamedQuery(name = "CuotaSocial.findAll", query = "SELECT c FROM CuotaSocial c"),
    @NamedQuery(name = "CuotaSocial.findByIdCuotaSocial", query = "SELECT c FROM CuotaSocial c WHERE c.idCuotaSocial = :idCuotaSocial"),
    @NamedQuery(name = "CuotaSocial.findByIdSocio", query = "SELECT c FROM CuotaSocial c WHERE c.idSocio = :idSocio"),
    @NamedQuery(name = "CuotaSocial.findByFechaActivacion", query = "SELECT c FROM CuotaSocial c WHERE c.fechaActivacion = :fechaActivacion"),
    @NamedQuery(name = "CuotaSocial.findByFechaPago", query = "SELECT c FROM CuotaSocial c WHERE c.fechaPago = :fechaPago"),
    @NamedQuery(name = "CuotaSocial.findByMonto", query = "SELECT c FROM CuotaSocial c WHERE c.monto = :monto")})
public class CuotaSocial implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCuotaSocial")
    private Integer idCuotaSocial;
    @Basic(optional = false)
    @Column(name = "idSocio")
    private int idSocio;
    @Basic(optional = false)
    @Column(name = "fechaActivacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActivacion;
    @Column(name = "fechaPago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;

    public CuotaSocial() {
    }

    public CuotaSocial(Integer idCuotaSocial) {
        this.idCuotaSocial = idCuotaSocial;
    }

    public CuotaSocial(Integer idCuotaSocial, int idSocio, Date fechaActivacion) {
        this.idCuotaSocial = idCuotaSocial;
        this.idSocio = idSocio;
        this.fechaActivacion = fechaActivacion;
    }

    public Integer getIdCuotaSocial() {
        return idCuotaSocial;
    }

    public void setIdCuotaSocial(Integer idCuotaSocial) {
        Integer oldIdCuotaSocial = this.idCuotaSocial;
        this.idCuotaSocial = idCuotaSocial;
        changeSupport.firePropertyChange("idCuotaSocial", oldIdCuotaSocial, idCuotaSocial);
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        int oldIdSocio = this.idSocio;
        this.idSocio = idSocio;
        changeSupport.firePropertyChange("idSocio", oldIdSocio, idSocio);
    }

    public Date getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(Date fechaActivacion) {
        Date oldFechaActivacion = this.fechaActivacion;
        this.fechaActivacion = fechaActivacion;
        changeSupport.firePropertyChange("fechaActivacion", oldFechaActivacion, fechaActivacion);
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        Date oldFechaPago = this.fechaPago;
        this.fechaPago = fechaPago;
        changeSupport.firePropertyChange("fechaPago", oldFechaPago, fechaPago);
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        BigDecimal oldMonto = this.monto;
        this.monto = monto;
        changeSupport.firePropertyChange("monto", oldMonto, monto);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuotaSocial != null ? idCuotaSocial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuotaSocial)) {
            return false;
        }
        CuotaSocial other = (CuotaSocial) object;
        if ((this.idCuotaSocial == null && other.idCuotaSocial != null) || (this.idCuotaSocial != null && !this.idCuotaSocial.equals(other.idCuotaSocial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "madreteresacrud.CuotaSocial[ idCuotaSocial=" + idCuotaSocial + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
