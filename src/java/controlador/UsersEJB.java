

package controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Users;

/**
 *
 * @author Angelo
 */
@Stateless
public class UsersEJB {
    
    @PersistenceContext(unitName = "PersistenceIPJ")
    private EntityManager em;
   
    
public List<Users> buscarporUserName() {
        Query query = em.createNamedQuery("Users.findAll");
       
        return query.getResultList();
    }

public Users buscarporUserContraseña( Users u) {
      Users usr=null;
        Query query = em.createNamedQuery("Users.findByUsuarioContraseña");
       query.setParameter("usuario", u.getUsuario());
        query.setParameter("contrase\u00f1a", u.getContraseña());
        List<Users> lista= query.getResultList();
        if(!lista.isEmpty()){ 
            usr= lista.get(0);
        } 
        return usr;
    }

    public Users crearNuevausers(Users users) {
        em.persist(users);
        return users;

    }

    public Users actualizarusers(Users users) {
        em.merge(users);
        return users;
    }

    public void eliminarusers(Users users) {
        users = em.find(Users.class, users.getIdUsers());
        em.remove(users);
    }
   
}
