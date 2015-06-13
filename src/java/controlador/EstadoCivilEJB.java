/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Estadocivil;

/**
 *
 * @author Angelo
 */
@Stateless
public class EstadoCivilEJB {

         @PersistenceContext(unitName = "PersistenceIPJ")
    private EntityManager em;

    public List<Estadocivil> buscarEstadocivil() {
        Query query = em.createNamedQuery("Estadocivil.findAll");
        return query.getResultList();
    }

  

    public Estadocivil crearNuevoEstado(Estadocivil estadocivil) {
        em.persist(estadocivil);
        return estadocivil;

    }

    public Estadocivil actualizarEstado(Estadocivil estadocivil) {
        em.merge(estadocivil);
        return estadocivil;
    }

    public void eliminarEstado(Estadocivil estadocivil) {
        estadocivil = em.find(Estadocivil.class, estadocivil.getIdestadoCivil());
        em.remove(estadocivil);
    }
}
