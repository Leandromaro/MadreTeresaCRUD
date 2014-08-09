/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author francis
 */
@Entity
@Table(name = "provincias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincias.findAll", query = "SELECT p FROM Provincias p"),
    @NamedQuery(name = "Provincias.findByCodProv", query = "SELECT p FROM Provincias p WHERE p.codProv = :codProv"),
    @NamedQuery(name = "Provincias.findByProvincia", query = "SELECT p FROM Provincias p WHERE p.provincia = :provincia")})
public class Provincias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codProv")
    private Integer codProv;
    @Basic(optional = false)
    @Column(name = "provincia")
    private String provincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provincias")
    private List<Localidades> localidadesList;

    public Provincias() {
    }

    public Provincias(Integer codProv) {
        this.codProv = codProv;
    }

    public Provincias(Integer codProv, String provincia) {
        this.codProv = codProv;
        this.provincia = provincia;
    }

    public Integer getCodProv() {
        return codProv;
    }

    public void setCodProv(Integer codProv) {
        this.codProv = codProv;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @XmlTransient
    public List<Localidades> getLocalidadesList() {
        return localidadesList;
    }

    public void setLocalidadesList(List<Localidades> localidadesList) {
        this.localidadesList = localidadesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProv != null ? codProv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincias)) {
            return false;
        }
        Provincias other = (Provincias) object;
        if ((this.codProv == null && other.codProv != null) || (this.codProv != null && !this.codProv.equals(other.codProv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilidades.Provincias[ codProv=" + codProv + " ]";
    }
    
}
