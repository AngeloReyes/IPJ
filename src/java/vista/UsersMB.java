/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.UsersEJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Users;

/**
 *
 * @author Angelo
 */
@ManagedBean
@ViewScoped
public class UsersMB implements Serializable {

    @EJB
    private UsersEJB usersEJB;
    private Users users = new Users();
    private List<Users> listaUsers = new ArrayList<Users>();

    /**
     * Creates a new instance of UsersMB
     */
    public UsersMB() {
    }

    public UsersMB(UsersEJB usersEJB) {
        this.usersEJB = usersEJB;
    }

    public UsersEJB getUsersEJB() {
        return usersEJB;
    }

    public void setUsersEJB(UsersEJB usersEJB) {
        this.usersEJB = usersEJB;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Users> getListaUsers() {
        listaUsers = usersEJB.buscarporUserName();
        return listaUsers;
    }

    public void setListaUsers(List<Users> listaUsers) {
        this.listaUsers = listaUsers;
    }

    public String iniciosesion() {
        String redire = null;
        Users usuar = null;
        try {

            usuar = usersEJB.buscarporUserContraseña(this.users);
            if (usuar != null) {
                //almacenar en la sesion de jsf
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuar);
                redire = "index";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                        "Credenciales Incorrectas", ""));
            }

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "algo fallo", ""));
        }
        return redire;

    }
    
    
    
    public void verificarSesion(){
    try{
    FacesContext context= FacesContext.getCurrentInstance();
    Users varUser=(Users) context.getExternalContext().getSessionMap().get("usuario");
    
    if(varUser==null){
        context.getExternalContext().redirect("index.xhtml");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "no hay sesion iniciada", ""));
    
    
    }
    
    
    }
    catch(Exception ex){
    
    
    }
    
    
    }

}
