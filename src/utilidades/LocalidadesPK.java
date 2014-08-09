/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author francis
 */
@Embeddable
public class LocalidadesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "codLoc")
    private int codLoc;
    @Basic(optional = false)
    @Column(name = "codProv")
    private int codProv;

    public LocalidadesPK() {
    }

    public LocalidadesPK(int codLoc, int codProv) {
        this.codLoc = codLoc;
        this.codProv = codProv;
    }

    public int getCodLoc() {
        return codLoc;
    }

    public void setCodLoc(int codLoc) {
        this.codLoc = codLoc;
    }

    public int getCodProv() {
        return codProv;
    }

    public void setCodProv(int codProv) {
        this.codProv = codProv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codLoc;
        hash += (int) codProv;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalidadesPK)) {
            return false;
        }
        LocalidadesPK other = (LocalidadesPK) object;
        if (this.codLoc != other.codLoc) {
            return false;
        }
        if (this.codProv != other.codProv) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilidades.LocalidadesPK[ codLoc=" + codLoc + ", codProv=" + codProv + " ]";
    }
    
}
