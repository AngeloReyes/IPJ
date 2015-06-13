/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Angelo
 */
@Entity
@Table(name = "iglesia", catalog = "iglesia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Iglesia.findAll", query = "SELECT i FROM Iglesia i"),
    @NamedQuery(name = "Iglesia.findByIdIglesia", query = "SELECT i FROM Iglesia i WHERE i.idIglesia = :idIglesia"),
    @NamedQuery(name = "Iglesia.findByNombre", query = "SELECT i FROM Iglesia i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Iglesia.findByDireccion", query = "SELECT i FROM Iglesia i WHERE i.direccion = :direccion")})
public class Iglesia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_iglesia", nullable = false)
    private Integer idIglesia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
    @JoinColumn(name = "id_miembro", referencedColumnName = "id_miembro")
    @ManyToOne(fetch = FetchType.LAZY)
    private Miembro idMiembro;
    @OneToMany(mappedBy = "idIglesia", fetch = FetchType.LAZY)
    private List<Celula> celulaList;
    @OneToMany(mappedBy = "idIglesia", fetch = FetchType.LAZY)
    private List<Miembro> miembroList;

    public Iglesia() {
    }

    public Iglesia(Integer idIglesia) {
        this.idIglesia = idIglesia;
    }

    public Iglesia(Integer idIglesia, String nombre, String direccion) {
        this.idIglesia = idIglesia;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Integer getIdIglesia() {
        return idIglesia;
    }

    public void setIdIglesia(Integer idIglesia) {
        this.idIglesia = idIglesia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Miembro getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(Miembro idMiembro) {
        this.idMiembro = idMiembro;
    }

    @XmlTransient
    public List<Celula> getCelulaList() {
        return celulaList;
    }

    public void setCelulaList(List<Celula> celulaList) {
        this.celulaList = celulaList;
    }

    @XmlTransient
    public List<Miembro> getMiembroList() {
        return miembroList;
    }

    public void setMiembroList(List<Miembro> miembroList) {
        this.miembroList = miembroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIglesia != null ? idIglesia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iglesia)) {
            return false;
        }
        Iglesia other = (Iglesia) object;
        if ((this.idIglesia == null && other.idIglesia != null) || (this.idIglesia != null && !this.idIglesia.equals(other.idIglesia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Iglesia[ idIglesia=" + idIglesia + " ]";
    }
    
}
