/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CelulaEJB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Celula;

/**
 *
 * @author Angelo
 */
@ManagedBean(name="celulaMB")
@ViewScoped
public class CelulaMB implements Serializable {

    /**
     * Creates a new instance of CelulaMB
     */
    @EJB
    private CelulaEJB celulaEJB;
    private Celula celula = new Celula();
    private Celula CelulaSelect;
    private List<Celula> listaCelulas = new ArrayList<Celula>();
   

  

    public CelulaMB(CelulaEJB celulaEJB, Celula CelulaSelect) {
        this.celulaEJB = celulaEJB;
        this.CelulaSelect = CelulaSelect;
    }

    public CelulaEJB getCelulaEJB() {
        return celulaEJB;
    }

    public void setCelulaEJB(CelulaEJB celulaEJB) {
        this.celulaEJB = celulaEJB;
    }

    public Celula getCelula() {
        return celula;
    }

    public void setCelula(Celula celula) {
        this.celula = celula;
    }

    public Celula getCelulaSelect() {
        return CelulaSelect;
    }

    public void setCelulaSelect(Celula CelulaSelect) {
        this.CelulaSelect = CelulaSelect;
    }

    public List<Celula> getListaCelulas() {
        listaCelulas = celulaEJB.buscarTodasLasCelulas();
        return listaCelulas;
    }

    public void setListaCelulas(List<Celula> listaCelulas) {
        this.listaCelulas = listaCelulas;
    }

    public CelulaMB() {
    }

}
