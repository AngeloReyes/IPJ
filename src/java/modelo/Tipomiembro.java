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
@Table(name = "tipomiembro", catalog = "iglesia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipomiembro.findAll", query = "SELECT t FROM Tipomiembro t"),
    @NamedQuery(name = "Tipomiembro.findByIdtipoMiembro", query = "SELECT t FROM Tipomiembro t WHERE t.idtipoMiembro = :idtipoMiembro"),
    @NamedQuery(name = "Tipomiembro.findByDescripcion", query = "SELECT t FROM Tipomiembro t WHERE t.descripcion = :descripcion")})
public class Tipomiembro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipoMiembro", nullable = false)
    private Integer idtipoMiembro;
    @Size(max = 10)
    @Column(name = "descripcion", length = 10)
    private String descripcion;
    @OneToMany(mappedBy = "idtipoMiembro", fetch = FetchType.LAZY)
    private List<Miembro> miembroList;

    public Tipomiembro() {
    }

    public Tipomiembro(Integer idtipoMiembro) {
        this.idtipoMiembro = idtipoMiembro;
    }

    public Integer getIdtipoMiembro() {
        return idtipoMiembro;
    }

    public void setIdtipoMiembro(Integer idtipoMiembro) {
        this.idtipoMiembro = idtipoMiembro;
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
        hash += (idtipoMiembro != null ? idtipoMiembro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipomiembro)) {
            return false;
        }
        Tipomiembro other = (Tipomiembro) object;
        if ((this.idtipoMiembro == null && other.idtipoMiembro != null) || (this.idtipoMiembro != null && !this.idtipoMiembro.equals(other.idtipoMiembro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tipomiembro[ idtipoMiembro=" + idtipoMiembro + " ]";
    }
    
}
