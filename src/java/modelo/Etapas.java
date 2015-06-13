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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Angelo
 */
@Entity
@Table(name = "etapas", catalog = "iglesia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etapas.findAll", query = "SELECT e FROM Etapas e"),
    @NamedQuery(name = "Etapas.findByIdEtapa", query = "SELECT e FROM Etapas e WHERE e.idEtapa = :idEtapa"),
    @NamedQuery(name = "Etapas.findByDescripcion", query = "SELECT e FROM Etapas e WHERE e.descripcion = :descripcion")})
public class Etapas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_etapa", nullable = false)
    private Integer idEtapa;
    @Size(max = 50)
    @Column(name = "descripcion", length = 50)
    private String descripcion;
    @JoinTable(name = "miembroxetapas", joinColumns = {
        @JoinColumn(name = "id_etapa", referencedColumnName = "id_etapa", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_miembro", referencedColumnName = "id_miembro", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Miembro> miembroList;
    @JoinColumn(name = "id_catalogo", referencedColumnName = "id_catalogo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Catalogo idCatalogo;

    public Etapas() {
    }

    public Etapas(Integer idEtapa) {
        this.idEtapa = idEtapa;
    }

    public Integer getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Integer idEtapa) {
        this.idEtapa = idEtapa;
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

    public Catalogo getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Catalogo idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtapa != null ? idEtapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etapas)) {
            return false;
        }
        Etapas other = (Etapas) object;
        if ((this.idEtapa == null && other.idEtapa != null) || (this.idEtapa != null && !this.idEtapa.equals(other.idEtapa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Etapas[ idEtapa=" + idEtapa + " ]";
    }
    
}
