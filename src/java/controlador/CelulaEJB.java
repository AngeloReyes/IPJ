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
import modelo.Celula;
/**
 *
 * @author Angelo
 */
@Stateless
public class CelulaEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
      @PersistenceContext(unitName = "PersistenceIPJ")
    private EntityManager em;

    public List<Celula> buscarTodasLasCelulas() {
        Query query = em.createNamedQuery("Celula.findAll");
        return query.getResultList();
    }

  

    public Celula crearNuevaCelula(Celula celula) {
        em.persist(celula);
        return celula;

    }

    public Celula actualizarCelula(Celula celula) {
        em.merge(celula);
        return celula;
    }

    public void eliminarCelula(Celula celula) {
        celula = em.find(Celula.class, celula.getIdCelula());
        em.remove(celula);
    }
}
