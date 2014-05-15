/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package madreteresacrud;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leandro
 */
@Embeddable
public class GastosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idgastos")
    private int idgastos;
    @Basic(optional = false)
    @Column(name = "tipo_gasto_idtipo_gasto")
    private int tipoGastoIdtipoGasto;

    public GastosPK() {
    }

    public GastosPK(int idgastos, int tipoGastoIdtipoGasto) {
        this.idgastos = idgastos;
        this.tipoGastoIdtipoGasto = tipoGastoIdtipoGasto;
    }

    public int getIdgastos() {
        return idgastos;
    }

    public void setIdgastos(int idgastos) {
        this.idgastos = idgastos;
    }

    public int getTipoGastoIdtipoGasto() {
        return tipoGastoIdtipoGasto;
    }

    public void setTipoGastoIdtipoGasto(int tipoGastoIdtipoGasto) {
        this.tipoGastoIdtipoGasto = tipoGastoIdtipoGasto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idgastos;
        hash += (int) tipoGastoIdtipoGasto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastosPK)) {
            return false;
        }
        GastosPK other = (GastosPK) object;
        if (this.idgastos != other.idgastos) {
            return false;
        }
        if (this.tipoGastoIdtipoGasto != other.tipoGastoIdtipoGasto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "madreteresacrud.GastosPK[ idgastos=" + idgastos + ", tipoGastoIdtipoGasto=" + tipoGastoIdtipoGasto + " ]";
    }
    
}
