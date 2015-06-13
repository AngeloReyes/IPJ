/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EstadoCivilEJB;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Estadocivil;

/**
 *
 * @author Angelo
 */
@ManagedBean(name="estadoCivilMB")
@ViewScoped
public class EstadoCivilMB {

    /**
     * Creates a new instance of EstadoCivilMB
     */
      @EJB
      private EstadoCivilEJB estadoCivilEJB;
    private Estadocivil estadocivil = new Estadocivil();
    private Estadocivil CelulaSelect;
    private List<Estadocivil> listaCelulas = new ArrayList<Estadocivil>();

    public EstadoCivilMB(EstadoCivilEJB estadoCivilEJB, Estadocivil CelulaSelect) {
        this.estadoCivilEJB = estadoCivilEJB;
        this.CelulaSelect = CelulaSelect;
    }
    
    public EstadoCivilMB() {
    }

    public EstadoCivilEJB getEstadoCivilEJB() {
        return estadoCivilEJB;
    }

    public void setEstadoCivilEJB(EstadoCivilEJB estadoCivilEJB) {
        this.estadoCivilEJB = estadoCivilEJB;
    }

    public Estadocivil getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(Estadocivil estadocivil) {
        this.estadocivil = estadocivil;
    }

    public Estadocivil getCelulaSelect() {
        return CelulaSelect;
    }

    public void setCelulaSelect(Estadocivil CelulaSelect) {
        this.CelulaSelect = CelulaSelect;
    }

    public List<Estadocivil> getListaCelulas() {
        listaCelulas =estadoCivilEJB.buscarEstadocivil();
        return listaCelulas;
    }

    public void setListaCelulas(List<Estadocivil> listaCelulas) {
        this.listaCelulas = listaCelulas;
    }

}
