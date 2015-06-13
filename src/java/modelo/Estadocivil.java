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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Angelo
 */
@Entity
@Table(name = "estadocivil", catalog = "iglesia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadocivil.findAll", query = "SELECT e FROM Estadocivil e"),
    @NamedQuery(name = "Estadocivil.findByIdestadoCivil", query = "SELECT e FROM Estadocivil e WHERE e.idestadoCivil = :idestadoCivil"),
    @NamedQuery(name = "Estadocivil.findByDescripcion", query = "SELECT e FROM Estadocivil e WHERE e.descripcion = :descripcion")})
public class Estadocivil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estadoCivil", nullable = false)
    private Integer idestadoCivil;
    @Size(max = 10)
    @Column(name = "descripcion", length = 10)
    private String descripcion;
    @OneToMany(mappedBy = "idestadoCivil", fetch = FetchType.LAZY)
    private List<Miembro> miembroList;

    public Estadocivil() {
    }

    public Estadocivil(Integer idestadoCivil) {
        this.idestadoCivil = idestadoCivil;
    }

    public Integer getIdestadoCivil() {
        return idestadoCivil;
    }

    public void setIdestadoCivil(Integer idestadoCivil) {
        this.idestadoCivil = idestadoCivil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idestadoCivil != null ? idestadoCivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadocivil)) {
            return false;
        }
        Estadocivil other = (Estadocivil) object;
        if ((this.idestadoCivil == null && other.idestadoCivil != null) || (this.idestadoCivil != null && !this.idestadoCivil.equals(other.idestadoCivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Estadocivil[ idestadoCivil=" + idestadoCivil + " ]";
    }
    
}
