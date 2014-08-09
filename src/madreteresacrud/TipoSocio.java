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
@Table(name = "tipoSocio")
@NamedQueries({
    @NamedQuery(name = "TipoSocio.findAll", query = "SELECT t FROM TipoSocio t"),
    @NamedQuery(name = "TipoSocio.findByIdTipoSocio", query = "SELECT t FROM TipoSocio t WHERE t.idTipoSocio = :idTipoSocio"),
    @NamedQuery(name = "TipoSocio.findByTipoSocio", query = "SELECT t FROM TipoSocio t WHERE t.tipoSocio = :tipoSocio"),
    @NamedQuery(name = "TipoSocio.findByMonto", query = "SELECT t FROM TipoSocio t WHERE t.monto = :monto"),
    @NamedQuery(name = "TipoSocio.findByFechaModif", query = "SELECT t FROM TipoSocio t WHERE t.fechaModif = :fechaModif")})
public class TipoSocio implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoSocio")
    private Integer idTipoSocio;
    @Basic(optional = false)
    @Column(name = "tipoSocio")
    private String tipoSocio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @Column(name = "fechaModif")
    @Temporal(TemporalType.DATE)
    private Date fechaModif;

    public TipoSocio() {
    }

    public TipoSocio(Integer idTipoSocio) {
        this.idTipoSocio = idTipoSocio;
    }

    public TipoSocio(Integer idTipoSocio, String tipoSocio, BigDecimal monto, Date fechaModif) {
        this.idTipoSocio = idTipoSocio;
        this.tipoSocio = tipoSocio;
        this.monto = monto;
        this.fechaModif = fechaModif;
    }

    public Integer getIdTipoSocio() {
        return idTipoSocio;
    }

    public void setIdTipoSocio(Integer idTipoSocio) {
        Integer oldIdTipoSocio = this.idTipoSocio;
        this.idTipoSocio = idTipoSocio;
        changeSupport.firePropertyChange("idTipoSocio", oldIdTipoSocio, idTipoSocio);
    }

    public String getTipoSocio() {
        return tipoSocio;
    }

    public void setTipoSocio(String tipoSocio) {
        String oldTipoSocio = this.tipoSocio;
        this.tipoSocio = tipoSocio;
        changeSupport.firePropertyChange("tipoSocio", oldTipoSocio, tipoSocio);
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        BigDecimal oldMonto = this.monto;
        this.monto = monto;
        changeSupport.firePropertyChange("monto", oldMonto, monto);
    }

    public Date getFechaModif() {
        return fechaModif;
    }

    public void setFechaModif(Date fechaModif) {
        Date oldFechaModif = this.fechaModif;
        this.fechaModif = fechaModif;
        changeSupport.firePropertyChange("fechaModif", oldFechaModif, fechaModif);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSocio != null ? idTipoSocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSocio)) {
            return false;
        }
        TipoSocio other = (TipoSocio) object;
        if ((this.idTipoSocio == null && other.idTipoSocio != null) || (this.idTipoSocio != null && !this.idTipoSocio.equals(other.idTipoSocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "madreteresacrud.TipoSocio[ idTipoSocio=" + idTipoSocio + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
