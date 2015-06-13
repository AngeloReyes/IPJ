/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navegacion;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Angelo
 */
@ManagedBean
@ViewScoped
public class NavMB implements Serializable {

    /**
     * Creates a new instance of NavMB
     */
    public NavMB() {
    }

    public String aPaginaInicio() {
        return "index";
    }

    public String aPaginaIMiembro() {
        return "pagina_miembro";
    }
      public String aPaginaICelula() {
        return "pagina_celula";
    }

}
