/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
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
@Table(name = "celula", catalog = "iglesia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Celula.findAll", query = "SELECT c FROM Celula c"),
    @NamedQuery(name = "Celula.findByIdCelula", query = "SELECT c FROM Celula c WHERE c.idCelula = :idCelula"),
    @NamedQuery(name = "Celula.findByNombre", query = "SELECT c FROM Celula c WHERE c.nombre = :nombre")})
public class Celula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_celula", nullable = false)
    private Integer idCelula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombre", nullable = false, length = 15)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCelula", fetch = FetchType.LAZY)
    private List<SubCategoria> subCategoriaList;
    @JoinColumn(name = "id_iglesia", referencedColumnName = "id_iglesia")
    @ManyToOne(fetch = FetchType.LAZY)
    private Iglesia idIglesia;
    @JoinColumn(name = "id_miembro", referencedColumnName = "id_miembro")
    @ManyToOne(fetch = FetchType.LAZY)
    private Miembro idMiembro;
    @OneToMany(mappedBy = "idCelula", fetch = FetchType.LAZY)
    private List<Miembro> miembroList;

    public Celula() {
    }

    public Celula(Integer idCelula) {
        this.idCelula = idCelula;
    }

    public Celula(Integer idCelula, String nombre) {
        this.idCelula = idCelula;
        this.nombre = nombre;
    }

    public Integer getIdCelula() {
        return idCelula;
    }

    public void setIdCelula(Integer idCelula) {
        this.idCelula = idCelula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<SubCategoria> getSubCategoriaList() {
        return subCategoriaList;
    }

    public void setSubCategoriaList(List<SubCategoria> subCategoriaList) {
        this.subCategoriaList = subCategoriaList;
    }

    public Iglesia getIdIglesia() {
        return idIglesia;
    }

    public void setIdIglesia(Iglesia idIglesia) {
        this.idIglesia = idIglesia;
    }

    public Miembro getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(Miembro idMiembro) {
        this.idMiembro = idMiembro;
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
        hash += (idCelula != null ? idCelula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Celula)) {
            return false;
        }
        Celula other = (Celula) object;
        if ((this.idCelula == null && other.idCelula != null) || (this.idCelula != null && !this.idCelula.equals(other.idCelula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Celula[ idCelula=" + idCelula + " ]";
    }
    
}
