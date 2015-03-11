/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package madreteresacrud;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author francis
 */
@Entity
@Table(name = "tipoSocio")
public class TipoSocio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
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

    public TipoSocio() {
    }

    public TipoSocio(Integer idTipoSocio) {
        this.idTipoSocio = idTipoSocio;
    }

    public TipoSocio(Integer idTipoSocio, String tipoSocio, BigDecimal monto, Date fechaModif) {
        this.idTipoSocio = idTipoSocio;
        this.tipoSocio = tipoSocio;
        this.monto = monto;
    }

    public Integer getIdTipoSocio() {
        return idTipoSocio;
    }

    public void setIdTipoSocio(Integer idTipoSocio) {

        this.idTipoSocio = idTipoSocio;
    }

    public String getTipoSocio() {
        return tipoSocio;
    }

    public void setTipoSocio(String tipoSocio) {
        this.tipoSocio = tipoSocio;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
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
        return tipoSocio;
    }

}
