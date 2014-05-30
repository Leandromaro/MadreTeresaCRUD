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
@Table(name = "eventos", catalog = "sistcalcuta", schema = "")
@NamedQueries({
    @NamedQuery(name = "Eventos.findAll", query = "SELECT e FROM Eventos e"),
    @NamedQuery(name = "Eventos.findByIdEvento", query = "SELECT e FROM Eventos e WHERE e.idEvento = :idEvento"),
    @NamedQuery(name = "Eventos.findByMotivo", query = "SELECT e FROM Eventos e WHERE e.motivo = :motivo"),
    @NamedQuery(name = "Eventos.findByFecha", query = "SELECT e FROM Eventos e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Eventos.findByMontoPublic", query = "SELECT e FROM Eventos e WHERE e.montoPublic = :montoPublic"),
    @NamedQuery(name = "Eventos.findByMontoRifas", query = "SELECT e FROM Eventos e WHERE e.montoRifas = :montoRifas"),
    @NamedQuery(name = "Eventos.findByMontoTarjetas", query = "SELECT e FROM Eventos e WHERE e.montoTarjetas = :montoTarjetas")})
public class Eventos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEvento")
    private Integer idEvento;
    @Column(name = "motivo")
    private String motivo;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montoPublic")
    private BigDecimal montoPublic;
    @Column(name = "montoRifas")
    private BigDecimal montoRifas;
    @Column(name = "montoTarjetas")
    private BigDecimal montoTarjetas;

    public Eventos() {
    }

    public Eventos(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Eventos(Integer idEvento, Date fecha) {
        this.idEvento = idEvento;
        this.fecha = fecha;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        Integer oldIdEvento = this.idEvento;
        this.idEvento = idEvento;
        changeSupport.firePropertyChange("idEvento", oldIdEvento, idEvento);
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        String oldMotivo = this.motivo;
        this.motivo = motivo;
        changeSupport.firePropertyChange("motivo", oldMotivo, motivo);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public BigDecimal getMontoPublic() {
        return montoPublic;
    }

    public void setMontoPublic(BigDecimal montoPublic) {
        BigDecimal oldMontoPublic = this.montoPublic;
        this.montoPublic = montoPublic;
        changeSupport.firePropertyChange("montoPublic", oldMontoPublic, montoPublic);
    }

    public BigDecimal getMontoRifas() {
        return montoRifas;
    }

    public void setMontoRifas(BigDecimal montoRifas) {
        BigDecimal oldMontoRifas = this.montoRifas;
        this.montoRifas = montoRifas;
        changeSupport.firePropertyChange("montoRifas", oldMontoRifas, montoRifas);
    }

    public BigDecimal getMontoTarjetas() {
        return montoTarjetas;
    }

    public void setMontoTarjetas(BigDecimal montoTarjetas) {
        BigDecimal oldMontoTarjetas = this.montoTarjetas;
        this.montoTarjetas = montoTarjetas;
        changeSupport.firePropertyChange("montoTarjetas", oldMontoTarjetas, montoTarjetas);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventos)) {
            return false;
        }
        Eventos other = (Eventos) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "madreteresacrud.Eventos[ idEvento=" + idEvento + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
