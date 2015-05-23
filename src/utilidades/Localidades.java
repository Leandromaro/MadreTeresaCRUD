/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author francis
 */
@Entity
@Table(name = "localidades")
@XmlRootElement
public class Localidades implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codLoc")
    private Integer idLocalidad;

    @Basic(optional = false)
    @Column(name = "localidad")
    private String localidad;

    @JoinColumn(name = "codProv", referencedColumnName = "codProv")
    @ManyToOne(optional = false)
    private Provincias provincias;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localidad")
//    private List<Socios> sociosList;
//    

    public Localidades() {
    }

    public Integer getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setProvincias(Provincias provincias) {
        this.provincias = provincias;
    }

    public Provincias getProvincias() {
        return provincias;
    }

//    @XmlTransient
//    public List<Socios> getSociosList() {
//        return sociosList;
//    }
//
//    public void setSociosList(List<Socios> sociosList) {
//        this.sociosList = sociosList;
//    }

    @Override
    public String toString() {
        return localidad+" - "+provincias.getProvincia();
    }

}
