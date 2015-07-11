/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Angelo
 */
@Entity
@Table(name = "users", catalog = "iglesia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByIdUsers", query = "SELECT u FROM Users u WHERE u.idUsers = :idUsers"),
    @NamedQuery(name = "Users.findByUsuario", query = "SELECT u FROM Users u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Users.findByUsuarioContraseña", query = "SELECT u FROM Users u WHERE u.usuario = :usuario AND u.contrase\u00f1a = :contrase\u00f1a"),
    @NamedQuery(name = "Users.findByContrase\u00f1a", query = "SELECT u FROM Users u WHERE u.contrase\u00f1a = :contrase\u00f1a")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_users", nullable = false)
    private Integer idUsers;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contrase\u00f1a", nullable = false, length = 50)
    private String contraseña;
    @JoinColumn(name = "id_iglesia", referencedColumnName = "id_iglesia")
    @ManyToOne(fetch = FetchType.LAZY)
    private Iglesia idIglesia;

    public Users() {
    }

    public Users(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public Users(Integer idUsers, String usuario, String contraseña) {
        this.idUsers = idUsers;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Iglesia getIdIglesia() {
        return idIglesia;
    }

    public void setIdIglesia(Iglesia idIglesia) {
        this.idIglesia = idIglesia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsers != null ? idUsers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idUsers == null && other.idUsers != null) || (this.idUsers != null && !this.idUsers.equals(other.idUsers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Users[ idUsers=" + idUsers + " ]";
    }
    
}
