/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package madreteresacrud.floresVida;

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
@Table(name = "cuotaFlorDeVida")
@NamedQueries({
    @NamedQuery(name = "CuotaFlorDeVida.findAll", query = "SELECT c FROM CuotaFlorDeVida c"),
    @NamedQuery(name = "CuotaFlorDeVida.findByIdcuotaFlorDeVida", query = "SELECT c FROM CuotaFlorDeVida c WHERE c.idcuotaFlorDeVida = :idcuotaFlorDeVida"),
    @NamedQuery(name = "CuotaFlorDeVida.findByMonto", query = "SELECT c FROM CuotaFlorDeVida c WHERE c.monto = :monto"),
    @NamedQuery(name = "CuotaFlorDeVida.findByFechaPago", query = "SELECT c FROM CuotaFlorDeVida c WHERE c.fechaPago = :fechaPago"),
    @NamedQuery(name = "CuotaFlorDeVida.findByIdSocioFV", query = "SELECT c FROM CuotaFlorDeVida c WHERE c.idSocioFV = :idSocioFV"),
    @NamedQuery(name = "CuotaFlorDeVida.findByIdFV", query = "SELECT c FROM CuotaFlorDeVida c WHERE c.idFV = :idFV")})
public class CuotaFlorDeVida implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuotaFlorDeVida")
    private Integer idcuotaFlorDeVida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "fechaPago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Basic(optional = false)
    @Column(name = "idSocioFV")
    private int idSocioFV;
    @Basic(optional = false)
    @Column(name = "idFV")
    private int idFV;

    public CuotaFlorDeVida() {
    }

    public CuotaFlorDeVida(Integer idcuotaFlorDeVida) {
        this.idcuotaFlorDeVida = idcuotaFlorDeVida;
    }

    public CuotaFlorDeVida(Integer idcuotaFlorDeVida, int idSocioFV, int idFV) {
        this.idcuotaFlorDeVida = idcuotaFlorDeVida;
        this.idSocioFV = idSocioFV;
        this.idFV = idFV;
    }

    public Integer getIdcuotaFlorDeVida() {
        return idcuotaFlorDeVida;
    }

    public void setIdcuotaFlorDeVida(Integer idcuotaFlorDeVida) {
        Integer oldIdcuotaFlorDeVida = this.idcuotaFlorDeVida;
        this.idcuotaFlorDeVida = idcuotaFlorDeVida;
        changeSupport.firePropertyChange("idcuotaFlorDeVida", oldIdcuotaFlorDeVida, idcuotaFlorDeVida);
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        BigDecimal oldMonto = this.monto;
        this.monto = monto;
        changeSupport.firePropertyChange("monto", oldMonto, monto);
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        Date oldFechaPago = this.fechaPago;
        this.fechaPago = fechaPago;
        changeSupport.firePropertyChange("fechaPago", oldFechaPago, fechaPago);
    }

    public int getIdSocioFV() {
        return idSocioFV;
    }

    public void setIdSocioFV(int idSocioFV) {
        int oldIdSocioFV = this.idSocioFV;
        this.idSocioFV = idSocioFV;
        changeSupport.firePropertyChange("idSocioFV", oldIdSocioFV, idSocioFV);
    }

    public int getIdFV() {
        return idFV;
    }

    public void setIdFV(int idFV) {
        int oldIdFV = this.idFV;
        this.idFV = idFV;
        changeSupport.firePropertyChange("idFV", oldIdFV, idFV);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuotaFlorDeVida != null ? idcuotaFlorDeVida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuotaFlorDeVida)) {
            return false;
        }
        CuotaFlorDeVida other = (CuotaFlorDeVida) object;
        if ((this.idcuotaFlorDeVida == null && other.idcuotaFlorDeVida != null) || (this.idcuotaFlorDeVida != null && !this.idcuotaFlorDeVida.equals(other.idcuotaFlorDeVida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "madreteresacrud.floresVida.CuotaFlorDeVida[ idcuotaFlorDeVida=" + idcuotaFlorDeVida + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
