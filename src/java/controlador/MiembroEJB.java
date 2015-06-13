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
import modelo.Miembro;

/**
 *
 * @author Angelo
 */
@Stateless
public class MiembroEJB {

    @PersistenceContext(unitName = "PersistenceIPJ")
    private EntityManager em;

    public List<Miembro> buscarTodosLosMiembros() {
        Query query = em.createNamedQuery("Miembro.findAll");
        return query.getResultList();
    }

    public List<Miembro> buscarMiembro(String nombre1, String nombre2, String apellido1, String apellido2) {

        //n1,n2,a1,a2
        if (nombre1 != "" && nombre2 != "" && apellido1 != "" && apellido2 != "") {
            System.out.println("wiiiiiiiiiii");
            Query query = em.createNamedQuery("Miembro.findByDosNombreDosApellido");

            query.setParameter("nombre1", nombre1);
            query.setParameter("nombre2", nombre2);
            query.setParameter("apellido1", apellido1);
            query.setParameter("apellido2", apellido2);
            return query.getResultList();
        } else {
            //n2,a1,a2
            if (nombre1 == "" && nombre2 != "" && apellido1 != "" && apellido2 != "") {

                Query query = em.createNamedQuery("Miembro.findByNombre2DosApellido");

                query.setParameter("nombre2", nombre2);
                query.setParameter("apellido1", apellido1);
                query.setParameter("apellido2", apellido2);
                return query.getResultList();

            } else {
                //n1,a1,a2
                if (nombre1 != "" && nombre2 == "" && apellido1 != "" && apellido2 != "") {

                    Query query = em.createNamedQuery("Miembro.findByNombre1DosApellido");

                    query.setParameter("nombre1", nombre1);
                    query.setParameter("apellido1", apellido1);
                    query.setParameter("apellido2", apellido2);
                    return query.getResultList();

                } else {
                    //n1,n2,a1
                    if (nombre1 != "" && nombre2 != "" && apellido1 != "" && apellido2 == "") {
                        Query query = em.createNamedQuery("Miembro.findByDosNombreApellido1");

                        query.setParameter("nombre1", nombre1);
                        query.setParameter("nombre2", nombre2);
                        query.setParameter("apellido1", apellido1);

                        return query.getResultList();

                    } else {
                        //n1,n2,a2
                        if (nombre1 != "" && nombre2 != "" && apellido1 == "" && apellido2 != "") {
                            Query query = em.createNamedQuery("Miembro.findByDosNombreApellido2");

                            query.setParameter("nombre1", nombre1);
                            query.setParameter("nombre2", nombre2);
                            query.setParameter("apellido2", apellido2);
                            return query.getResultList();

                        } else {
                            //n1,n2
                            if (nombre1 != "" && nombre2 != "" && apellido1 == "" && apellido2 == "") {
                                Query query = em.createNamedQuery("Miembro.findByDosNombre");

                                query.setParameter("nombre1", nombre1);
                                query.setParameter("nombre2", nombre2);
                                return query.getResultList();

                            } else {
                                //n1,a1
                                if (nombre1 != "" && nombre2 == "" && apellido1 != "" && apellido2 == "") {
                                    Query query = em.createNamedQuery("Miembro.findByNombre1Apellido1");

                                    query.setParameter("nombre1", nombre1);
                                    query.setParameter("apellido1", apellido1);

                                    return query.getResultList();

                                } else {
                                    //n1,a2
                                    if (nombre1 != "" && nombre2 == "" && apellido1 == "" && apellido2 != "") {
                                        Query query = em.createNamedQuery("Miembro.findByNombre1Apellido2");
                                        query.setParameter("nombre1", nombre1);
                                        query.setParameter("apellido2", apellido2);

                                        return query.getResultList();

                                    } else {
                                        //n2,a1
                                        if (nombre1 == "" && nombre2 != "" && apellido1 != "" && apellido2 == "") {
                                            Query query = em.createNamedQuery("Miembro.findByNombre2Apellido1");

                                            query.setParameter("nombre2", nombre2);
                                            query.setParameter("apellido1", apellido1);

                                            return query.getResultList();

                                        } else {
                                            //n2,a2
                                            if (nombre1 == "" && nombre2 != "" && apellido1 == "" && apellido2 != "") {
                                                Query query = em.createNamedQuery("Miembro.findByNombre2Apellido2");
                                                query.setParameter("nombre2", nombre2);
                                                query.setParameter("apellido2", apellido2);
                                                return query.getResultList();

                                            } else {
                                                //a1,a2
                                                if (nombre1 == "" && nombre2 == "" && apellido1 != "" && apellido2 != "") {
                                                    Query query = em.createNamedQuery("Miembro.findByDosApellido");
                                                    query.setParameter("apellido1", apellido1);
                                                    query.setParameter("apellido2", apellido2);
                                                    return query.getResultList();
                                                } else {
                                                    //n1
                                                    if (nombre1 != "" && nombre2 == "" && apellido1 == "" && apellido2 == "") {
                                                        Query query = em.createNamedQuery("Miembro.findByNombre1");
                                                        query.setParameter("nombre1", nombre1);
                                                        return query.getResultList();

                                                    } else {
                                                        //n2
                                                        if (nombre1 == "" && nombre2 != "" && apellido1 == "" && apellido2 == "") {
                                                            Query query = em.createNamedQuery("Miembro.findByNombre2");
                                                            query.setParameter("nombre2", nombre2);
                                                            return query.getResultList();

                                                        } else {
                                                            //a1
                                                            if (nombre1 == "" && nombre2 == "" && apellido1 != "" && apellido2 == "") {
                                                                Query query = em.createNamedQuery("Miembro.findByApellido1");
                                                                query.setParameter("apellido1", apellido1);
                                                                return query.getResultList();

                                                            } else {
                                                                //a2
                                                                if (nombre1 == "" && nombre2 == "" && apellido1 == "" && apellido2 != "") {
                                                                    Query query = em.createNamedQuery("Miembro.findByApellido2");
                                                                    query.setParameter("apellido2", apellido2);
                                                                    return query.getResultList();

                                                                }
                                                                return null; 

                                                            }
                                                        }

                                                    }

                                                }
                                            }

                                        }

                                    }

                                }

                            }

                        }

                    }

                }

            }

        }
       

    }
    
    

    public Miembro crearNuevoMiembro(Miembro miembro) {
       
        em.persist(miembro);
        return miembro;

    }

    public Miembro actualizarMiembro(Miembro miembro) {
        em.merge(miembro);
        return miembro;
    }

    public void eliminarMiembro(Miembro miembro) {
        miembro = em.find(Miembro.class, miembro.getIdMiembro());
        em.remove(miembro);
    }

}
