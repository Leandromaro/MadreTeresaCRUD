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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "gastos", catalog = "sistcalcuta", schema = "")
@NamedQueries({
    @NamedQuery(name = "Gastos.findAll", query = "SELECT g FROM Gastos g"),
    @NamedQuery(name = "Gastos.findByIdgastos", query = "SELECT g FROM Gastos g WHERE g.gastosPK.idgastos = :idgastos"),
    @NamedQuery(name = "Gastos.findByMonto", query = "SELECT g FROM Gastos g WHERE g.monto = :monto"),
    @NamedQuery(name = "Gastos.findByFechaGasto", query = "SELECT g FROM Gastos g WHERE g.fechaGasto = :fechaGasto"),
    @NamedQuery(name = "Gastos.findByDescripcion", query = "SELECT g FROM Gastos g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "Gastos.findByTipoGastoIdtipoGasto", query = "SELECT g FROM Gastos g WHERE g.gastosPK.tipoGastoIdtipoGasto = :tipoGastoIdtipoGasto")})
public class Gastos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GastosPK gastosPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "fechaGasto")
    @Temporal(TemporalType.DATE)
    private Date fechaGasto;
    @Column(name = "descripcion")
    private String descripcion;

    public Gastos() {
    }

    public Gastos(GastosPK gastosPK) {
        this.gastosPK = gastosPK;
    }

    public Gastos(int idgastos, int tipoGastoIdtipoGasto) {
        this.gastosPK = new GastosPK(idgastos, tipoGastoIdtipoGasto);
    }

    public GastosPK getGastosPK() {
        return gastosPK;
    }

    public void setGastosPK(GastosPK gastosPK) {
        this.gastosPK = gastosPK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gastosPK != null ? gastosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gastos)) {
            return false;
        }
        Gastos other = (Gastos) object;
        if ((this.gastosPK == null && other.gastosPK != null) || (this.gastosPK != null && !this.gastosPK.equals(other.gastosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "madreteresacrud.Gastos[ gastosPK=" + gastosPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
