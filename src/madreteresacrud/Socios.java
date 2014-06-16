/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package madreteresacrud;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author francis
 */
@Entity
@Table(name = "socios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Socios.findAll", query = "SELECT s FROM Socios s"),
    @NamedQuery(name = "Socios.findByIdSocio", query = "SELECT s FROM Socios s WHERE s.idSocio = :idSocio"),
    @NamedQuery(name = "Socios.findByIdTipoSocio", query = "SELECT s FROM Socios s WHERE s.idTipoSocio = :idTipoSocio"),
    @NamedQuery(name = "Socios.findByDocumento", query = "SELECT s FROM Socios s WHERE s.documento = :documento"),
    @NamedQuery(name = "Socios.findBySexo", query = "SELECT s FROM Socios s WHERE s.sexo = :sexo"),
    @NamedQuery(name = "Socios.findByNombre", query = "SELECT s FROM Socios s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Socios.findByApellido", query = "SELECT s FROM Socios s WHERE s.apellido = :apellido"),
    @NamedQuery(name = "Socios.findByCuil", query = "SELECT s FROM Socios s WHERE s.cuil = :cuil"),
    @NamedQuery(name = "Socios.findByNumSoc", query = "SELECT s FROM Socios s WHERE s.numSoc = :numSoc"),
    @NamedQuery(name = "Socios.findByEmail", query = "SELECT s FROM Socios s WHERE s.email = :email"),
    @NamedQuery(name = "Socios.findByTelefono", query = "SELECT s FROM Socios s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "Socios.findByCelular", query = "SELECT s FROM Socios s WHERE s.celular = :celular"),
    @NamedQuery(name = "Socios.findByFechaNacimiento", query = "SELECT s FROM Socios s WHERE s.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Socios.findByLocalidad", query = "SELECT s FROM Socios s WHERE s.localidad = :localidad"),
    @NamedQuery(name = "Socios.findByDireccion", query = "SELECT s FROM Socios s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Socios.findByFechaBaja", query = "SELECT s FROM Socios s WHERE s.fechaBaja = :fechaBaja"),
    @NamedQuery(name = "Socios.findBySocio", query = "SELECT s FROM Socios s WHERE s.socio = :socio"),
    @NamedQuery(name = "Socios.findByAdherente", query = "SELECT s FROM Socios s WHERE s.adherente = :adherente"),
    @NamedQuery(name = "Socios.findByDonante", query = "SELECT s FROM Socios s WHERE s.donante = :donante")})
public class Socios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSocio")
    private Integer idSocio;
    @Basic(optional = false)
    @Column(name = "idTipoSocio")
    private int idTipoSocio;
    @Basic(optional = false)
    @Column(name = "documento")
    private int documento;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "cuil")
    private String cuil;
    @Column(name = "numSoc")
    private Integer numSoc;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "localidad")
    private String localidad;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "fechaBaja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    @Basic(optional = false)
    @Column(name = "socio")
    private boolean socio;
    @Basic(optional = false)
    @Column(name = "adherente")
    private boolean adherente;
    @Basic(optional = false)
    @Column(name = "donante")
    private boolean donante;

    public Socios() {
    }

    public Socios(Integer idSocio) {
        this.idSocio = idSocio;
    }

    public Socios(Integer idSocio, int idTipoSocio, int documento, String sexo, String nombre, String apellido, String email, String telefono, String celular, Date fechaNacimiento, String localidad, String direccion, boolean socio, boolean adherente, boolean donante) {
        this.idSocio = idSocio;
        this.idTipoSocio = idTipoSocio;
        this.documento = documento;
        this.sexo = sexo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.celular = celular;
        this.fechaNacimiento = fechaNacimiento;
        this.localidad = localidad;
        this.direccion = direccion;
        this.socio = socio;
        this.adherente = adherente;
        this.donante = donante;
    }

    public Integer getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Integer idSocio) {
        this.idSocio = idSocio;
    }

    public int getIdTipoSocio() {
        return idTipoSocio;
    }

    public void setIdTipoSocio(int idTipoSocio) {
        this.idTipoSocio = idTipoSocio;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public Integer getNumSoc() {
        return numSoc;
    }

    public void setNumSoc(Integer numSoc) {
        this.numSoc = numSoc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public boolean getSocio() {
        return socio;
    }

    public void setSocio(boolean socio) {
        this.socio = socio;
    }

    public boolean getAdherente() {
        return adherente;
    }

    public void setAdherente(boolean adherente) {
        this.adherente = adherente;
    }

    public boolean getDonante() {
        return donante;
    }

    public void setDonante(boolean donante) {
        this.donante = donante;
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
        if (!(object instanceof Socios)) {
            return false;
        }
        Socios other = (Socios) object;
        if ((this.idSocio == null && other.idSocio != null) || (this.idSocio != null && !this.idSocio.equals(other.idSocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "madreteresacrud.Socios[ idSocio=" + idSocio + " ]";
    }
    
}
