/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package madreteresacrud.floresVida;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author francis
 */
@Entity
@Table(name = "relacSocDifuntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelacSocDifuntos.findAll", query = "SELECT r FROM RelacSocDifuntos r"),
    @NamedQuery(name = "RelacSocDifuntos.findByIdSocioFV", query = "SELECT r FROM RelacSocDifuntos r WHERE r.idSocioFV = :idSocioFV"),
    @NamedQuery(name = "RelacSocDifuntos.findByIdFV", query = "SELECT r FROM RelacSocDifuntos r WHERE r.idFV = :idFV")})
public class RelacSocDifuntos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idSocioFV")
    private Integer idSocioFV;
    @Basic(optional = false)
    @Column(name = "idFV")
    private int idFV;

    public RelacSocDifuntos() {
    }

    public RelacSocDifuntos(Integer idSocioFV) {
        this.idSocioFV = idSocioFV;
    }

    public RelacSocDifuntos(Integer idSocioFV, int idFV) {
        this.idSocioFV = idSocioFV;
        this.idFV = idFV;
    }

    public Integer getIdSocioFV() {
        return idSocioFV;
    }

    public void setIdSocioFV(Integer idSocioFV) {
        this.idSocioFV = idSocioFV;
    }

    public int getIdFV() {
        return idFV;
    }

    public void setIdFV(int idFV) {
        this.idFV = idFV;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSocioFV != null ? idSocioFV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelacSocDifuntos)) {
            return false;
        }
        RelacSocDifuntos other = (RelacSocDifuntos) object;
        if ((this.idSocioFV == null && other.idSocioFV != null) || (this.idSocioFV != null && !this.idSocioFV.equals(other.idSocioFV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "madreteresacrud.floresVida.RelacSocDifuntos[ idSocioFV=" + idSocioFV + " ]";
    }
    
}
