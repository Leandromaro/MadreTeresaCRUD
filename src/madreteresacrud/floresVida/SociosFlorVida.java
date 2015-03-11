/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package madreteresacrud.floresVida;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import utilidades.Localidades;

/**
 *
 * @author francis
 */
@Entity
@Table(name = "sociosFlorVida")
@NamedQueries({
    @NamedQuery(name = "SociosFlorVida.findAll", query = "SELECT s FROM SociosFlorVida s"),
    @NamedQuery(name = "SociosFlorVida.findByIdSocio", query = "SELECT s FROM SociosFlorVida s WHERE s.idSocio = :idSocio"),
    @NamedQuery(name = "SociosFlorVida.findByApellido", query = "SELECT s FROM SociosFlorVida s WHERE s.apellido = :apellido"),
    @NamedQuery(name = "SociosFlorVida.findByNombre", query = "SELECT s FROM SociosFlorVida s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SociosFlorVida.findByLocalidad", query = "SELECT s FROM SociosFlorVida s WHERE s.localidad = :localidad"),
    @NamedQuery(name = "SociosFlorVida.findByDireccion", query = "SELECT s FROM SociosFlorVida s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "SociosFlorVida.findByTelefono", query = "SELECT s FROM SociosFlorVida s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "SociosFlorVida.findByCuil", query = "SELECT s FROM SociosFlorVida s WHERE s.cuil = :cuil")})
public class SociosFlorVida implements Serializable {

    @Column(name = "sexo")
    private String sexo;
    @Column(name = "email")
    private String email;
    @Column(name = "celular")
    private String celular;
    @Column(name = "dni")
    private Integer dni;
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSocio")
    private Integer idSocio;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "nombre")
    private String nombre;

    @JoinColumn(name = "localidad", referencedColumnName = "codLoc")
    @ManyToOne(optional = false)
    private Localidades localidad;

    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "cuil")
    private String cuil;

    public SociosFlorVida() {
    }

    public SociosFlorVida(Integer idSocio) {
        this.idSocio = idSocio;
    }

    public Integer getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Integer idSocio) {
        Integer oldIdSocio = this.idSocio;
        this.idSocio = idSocio;
        changeSupport.firePropertyChange("idSocio", oldIdSocio, idSocio);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        String oldApellido = this.apellido;
        this.apellido = apellido;
        changeSupport.firePropertyChange("apellido", oldApellido, apellido);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public Localidades getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidades localidad) {
        Localidades oldLocalidad = this.localidad;
        this.localidad = localidad;
        changeSupport.firePropertyChange("localidad", oldLocalidad, localidad);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        String oldDireccion = this.direccion;
        this.direccion = direccion;
        changeSupport.firePropertyChange("direccion", oldDireccion, direccion);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        String oldTelefono = this.telefono;
        this.telefono = telefono;
        changeSupport.firePropertyChange("telefono", oldTelefono, telefono);
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        String oldCuil = this.cuil;
        this.cuil = cuil;
        changeSupport.firePropertyChange("cuil", oldCuil, cuil);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSocio != null ? idSocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SociosFlorVida)) {
            return false;
        }
        SociosFlorVida other = (SociosFlorVida) object;
        if ((this.idSocio == null && other.idSocio != null) || (this.idSocio != null && !this.idSocio.equals(other.idSocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "madreteresacrud.SociosFlorVida[ idSocio=" + idSocio + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

}
