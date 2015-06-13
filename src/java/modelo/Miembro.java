/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Angelo
 */
@Entity
@Table(name = "miembro", catalog = "iglesia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Miembro.findAll", query = "SELECT m FROM Miembro m"),
    @NamedQuery(name = "Miembro.findByIdMiembro", query = "SELECT m FROM Miembro m WHERE m.idMiembro = :idMiembro"),
    
    
    
    @NamedQuery(name = "Miembro.findByNombre1", query = "SELECT m FROM Miembro m WHERE m.nombre1 = :nombre1"),
    @NamedQuery(name = "Miembro.findByNombre2", query = "SELECT m FROM Miembro m WHERE m.nombre2 = :nombre2"),
    @NamedQuery(name = "Miembro.findByApellido1", query = "SELECT m FROM Miembro m WHERE m.apellido1 = :apellido1"),
    @NamedQuery(name = "Miembro.findByApellido2", query = "SELECT m FROM Miembro m WHERE m.apellido2 = :apellido2"),
    
    
         //N1,N2,A1,A2 
    @NamedQuery(name = "Miembro.findByDosNombreDosApellido", query = "SELECT m FROM Miembro m WHERE m.nombre1 = :nombre1"
            + " AND m.apellido1 = :apellido1 AND m.nombre2 = :nombre2 AND m.apellido2 = :apellido2"),
    
    
    //N1,A1,A2
    @NamedQuery(name = "Miembro.findByNombre1DosApellido", query = "SELECT m FROM Miembro m WHERE m.nombre1 = :nombre1   AND m.apellido1 = :apellido1 AND m.apellido2 = :apellido2"),
           
    //N2,A1,A2
     @NamedQuery(name = "Miembro.findByNombre2DosApellido", query = "SELECT m FROM Miembro m WHERE m.nombre2 = :nombre2"
            + " AND m.apellido1 = :apellido1 AND m.apellido2 = :apellido2"),
    //N1,N2,A1
    @NamedQuery(name = "Miembro.findByDosNombreApellido1", query = "SELECT m FROM Miembro m WHERE m.nombre1 = :nombre1"
            + " AND m.nombre2 = :nombre2 AND m.apellido1 = :apellido1"),
    //3N1,N2,A2
    @NamedQuery(name = "Miembro.findByDosNombreApellido2", query = "SELECT m FROM Miembro m WHERE m.nombre1 = :nombre1"
            + " AND m.nombre2 = :nombre2 AND m.apellido2 = :apellido2"),

    
    
    //N1,N2
    @NamedQuery(name = "Miembro.findByDosNombre", query = "SELECT m FROM Miembro m WHERE m.nombre1 = :nombre1"
            + " AND m.nombre2 = :nombre2"),

    //N1,A1
    @NamedQuery(name = "Miembro.findByNombre1Apellido1", query = "SELECT m FROM Miembro m WHERE m.nombre1 = :nombre1"
            + " AND m.apellido1 = :apellido1"),
    //N1,A2
    @NamedQuery(name = "Miembro.findByNombre1Apellido2", query = "SELECT m FROM Miembro m WHERE m.nombre1 = :nombre1"
            + " AND m.apellido2 = :apellido2"),
    //N2,A1
    @NamedQuery(name = "Miembro.findByNombre2Apellido1", query = "SELECT m FROM Miembro m WHERE m.nombre2 = :nombre2"
            + " AND m.apellido1 = :apellido1"),
    //N2,A2
    @NamedQuery(name = "Miembro.findByNombre2Apellido2", query = "SELECT m FROM Miembro m WHERE m.nombre2 = :nombre2"
            + "  AND m.apellido2 = :apellido2"),
    //A1,A2
    @NamedQuery(name = "Miembro.findByDosApellido", query = "SELECT m FROM Miembro m WHERE m.apellido1 = :apellido1 "
            + " AND m.apellido2 = :apellido2"),
   

    
    
    @NamedQuery(name = "Miembro.findByDireccion", query = "SELECT m FROM Miembro m WHERE m.direccion = :direccion"),
    @NamedQuery(name = "Miembro.findByFechaNacimiento", query = "SELECT m FROM Miembro m WHERE m.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Miembro.findByFechaDecision", query = "SELECT m FROM Miembro m WHERE m.fechaDecision = :fechaDecision"),
    @NamedQuery(name = "Miembro.findByIdtipoMiembro", query = "SELECT m FROM Miembro m WHERE m.idtipoMiembro = :idtipoMiembro")})

public class Miembro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_miembro", nullable = false)
    private Integer idMiembro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombre1", nullable = false, length = 10)
    private String nombre1;
    @Size(max = 10)
    @Column(name = "nombre2", length = 10)
    private String nombre2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "apellido1", nullable = false, length = 10)
    private String apellido1;
    @Size(max = 10)
    @Column(name = "apellido2", length = 10)
    private String apellido2;
    @Size(max = 50)
    @Column(name = "direccion", length = 50)
    private String direccion;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "fecha_decision")
    @Temporal(TemporalType.DATE)
    private Date fechaDecision;
    @ManyToMany(mappedBy = "miembroList", fetch = FetchType.LAZY)
    private List<Etapas> etapasList;
    @OneToMany(mappedBy = "idMiembro", fetch = FetchType.LAZY)
    private List<Iglesia> iglesiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMiembro", fetch = FetchType.LAZY)
    private List<SubCategoria> subCategoriaList;
    @OneToMany(mappedBy = "idMiembro", fetch = FetchType.LAZY)
    private List<Celula> celulaList;
    @JoinColumn(name = "id_tipoMiembro", referencedColumnName = "id_tipoMiembro")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tipomiembro idtipoMiembro;
    @JoinColumn(name = "id_estadoCivil", referencedColumnName = "id_estadoCivil")
    @ManyToOne(fetch = FetchType.LAZY)
    private Estadocivil idestadoCivil;
    @JoinColumn(name = "id_iglesia", referencedColumnName = "id_iglesia")
    @ManyToOne(fetch = FetchType.LAZY)
    private Iglesia idIglesia;
    @JoinColumn(name = "id_celula", referencedColumnName = "id_celula")
    @ManyToOne(fetch = FetchType.LAZY)
    private Celula idCelula;

    public Miembro() {
    }

    public Miembro(Integer idMiembro) {
        this.idMiembro = idMiembro;
    }

    public Miembro(Integer idMiembro, String nombre1, String apellido1) {
        this.idMiembro = idMiembro;
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
    }

    public Integer getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(Integer idMiembro) {
        this.idMiembro = idMiembro;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaDecision() {
        return fechaDecision;
    }

    public void setFechaDecision(Date fechaDecision) {
        this.fechaDecision = fechaDecision;
    }

    @XmlTransient
    public List<Etapas> getEtapasList() {
        return etapasList;
    }

    public void setEtapasList(List<Etapas> etapasList) {
        this.etapasList = etapasList;
    }

    @XmlTransient
    public List<Iglesia> getIglesiaList() {
        return iglesiaList;
    }

    public void setIglesiaList(List<Iglesia> iglesiaList) {
        this.iglesiaList = iglesiaList;
    }

    @XmlTransient
    public List<SubCategoria> getSubCategoriaList() {
        return subCategoriaList;
    }

    public void setSubCategoriaList(List<SubCategoria> subCategoriaList) {
        this.subCategoriaList = subCategoriaList;
    }

    @XmlTransient
    public List<Celula> getCelulaList() {
        return celulaList;
    }

    public void setCelulaList(List<Celula> celulaList) {
        this.celulaList = celulaList;
    }

    public Tipomiembro getIdtipoMiembro() {
        return idtipoMiembro;
    }

    public void setIdtipoMiembro(Tipomiembro idtipoMiembro) {
        this.idtipoMiembro = idtipoMiembro;
    }

    public Estadocivil getIdestadoCivil() {
        return idestadoCivil;
    }

    public void setIdestadoCivil(Estadocivil idestadoCivil) {
        this.idestadoCivil = idestadoCivil;
    }

    public Iglesia getIdIglesia() {
        return idIglesia;
    }

    public void setIdIglesia(Iglesia idIglesia) {
        this.idIglesia = idIglesia;
    }

    public Celula getIdCelula() {
        return idCelula;
    }

    public void setIdCelula(Celula idCelula) {
        this.idCelula = idCelula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMiembro != null ? idMiembro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Miembro)) {
            return false;
        }
        Miembro other = (Miembro) object;
        if ((this.idMiembro == null && other.idMiembro != null) || (this.idMiembro != null && !this.idMiembro.equals(other.idMiembro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Miembro[ idMiembro=" + idMiembro + " ]";
    }
    
}
