/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Angelo
 */
@Entity
@Table(name = "sub_categoria", catalog = "iglesia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubCategoria.findAll", query = "SELECT s FROM SubCategoria s"),
    @NamedQuery(name = "SubCategoria.findByIdsubCategoria", query = "SELECT s FROM SubCategoria s WHERE s.idsubCategoria = :idsubCategoria"),
    @NamedQuery(name = "SubCategoria.findByDescripcion", query = "SELECT s FROM SubCategoria s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SubCategoria.findByMonto", query = "SELECT s FROM SubCategoria s WHERE s.monto = :monto"),
    @NamedQuery(name = "SubCategoria.findByFecha", query = "SELECT s FROM SubCategoria s WHERE s.fecha = :fecha")})
public class SubCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_subCategoria", nullable = false)
    private Integer idsubCategoria;
    @Size(max = 50)
    @Column(name = "descripcion", length = 50)
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto", precision = 12)
    private Float monto;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_celula", referencedColumnName = "id_celula", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Celula idCelula;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria idCategoria;
    @JoinColumn(name = "id_miembro", referencedColumnName = "id_miembro", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Miembro idMiembro;

    public SubCategoria() {
    }

    public SubCategoria(Integer idsubCategoria) {
        this.idsubCategoria = idsubCategoria;
    }

    public Integer getIdsubCategoria() {
        return idsubCategoria;
    }

    public void setIdsubCategoria(Integer idsubCategoria) {
        this.idsubCategoria = idsubCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Celula getIdCelula() {
        return idCelula;
    }

    public void setIdCelula(Celula idCelula) {
        this.idCelula = idCelula;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Miembro getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(Miembro idMiembro) {
        this.idMiembro = idMiembro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubCategoria != null ? idsubCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubCategoria)) {
            return false;
        }
        SubCategoria other = (SubCategoria) object;
        if ((this.idsubCategoria == null && other.idsubCategoria != null) || (this.idsubCategoria != null && !this.idsubCategoria.equals(other.idsubCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SubCategoria[ idsubCategoria=" + idsubCategoria + " ]";
    }
    
}
