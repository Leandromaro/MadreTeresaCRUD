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
@Table(name = "gastos", catalog = "sistcalcuta", schema = "")
@NamedQueries({
    @NamedQuery(name = "Gastos.findAll", query = "SELECT g FROM Gastos g"),
    @NamedQuery(name = "Gastos.findByIdgastos", query = "SELECT g FROM Gastos g WHERE g.idgastos = :idgastos"),
    @NamedQuery(name = "Gastos.findByMonto", query = "SELECT g FROM Gastos g WHERE g.monto = :monto"),
    @NamedQuery(name = "Gastos.findByFechaGasto", query = "SELECT g FROM Gastos g WHERE g.fechaGasto = :fechaGasto"),
    @NamedQuery(name = "Gastos.findByDescripcion", query = "SELECT g FROM Gastos g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "Gastos.findByTipoGastoIdtipoGasto", query = "SELECT g FROM Gastos g WHERE g.tipoGastoIdtipoGasto = :tipoGastoIdtipoGasto")})
public class Gastos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgastos")
    private Integer idgastos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "fechaGasto")
    @Temporal(TemporalType.DATE)
    private Date fechaGasto;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "tipo_gasto_idtipo_gasto")
    private int tipoGastoIdtipoGasto;

    public Gastos() {
    }

    public Gastos(Integer idgastos) {
        this.idgastos = idgastos;
    }

    public Gastos(Integer idgastos, int tipoGastoIdtipoGasto) {
        this.idgastos = idgastos;
        this.tipoGastoIdtipoGasto = tipoGastoIdtipoGasto;
    }

    public Integer getIdgastos() {
        return idgastos;
    }

    public void setIdgastos(Integer idgastos) {
        Integer oldIdgastos = this.idgastos;
        this.idgastos = idgastos;
        changeSupport.firePropertyChange("idgastos", oldIdgastos, idgastos);
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        BigDecimal oldMonto = this.monto;
        this.monto = monto;
        changeSupport.firePropertyChange("monto", oldMonto, monto);
    }

    public Date getFechaGasto() {
        return fechaGasto;
    }

    public void setFechaGasto(Date fechaGasto) {
        Date oldFechaGasto = this.fechaGasto;
        this.fechaGasto = fechaGasto;
        changeSupport.firePropertyChange("fechaGasto", oldFechaGasto, fechaGasto);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String oldDescripcion = this.descripcion;
        this.descripcion = descripcion;
        changeSupport.firePropertyChange("descripcion", oldDescripcion, descripcion);
    }

    public int getTipoGastoIdtipoGasto() {
        return tipoGastoIdtipoGasto;
    }

    public void setTipoGastoIdtipoGasto(int tipoGastoIdtipoGasto) {
        int oldTipoGastoIdtipoGasto = this.tipoGastoIdtipoGasto;
        this.tipoGastoIdtipoGasto = tipoGastoIdtipoGasto;
        changeSupport.firePropertyChange("tipoGastoIdtipoGasto", oldTipoGastoIdtipoGasto, tipoGastoIdtipoGasto);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgastos != null ? idgastos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gastos)) {
            return false;
        }
        Gastos other = (Gastos) object;
        if ((this.idgastos == null && other.idgastos != null) || (this.idgastos != null && !this.idgastos.equals(other.idgastos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "madreteresacrud.Gastos[ idgastos=" + idgastos + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
