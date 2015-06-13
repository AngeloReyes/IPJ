/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Estadocivil;


@FacesConverter(forClass =Estadocivil.class)
public class estadoCivilConverter implements Converter {
    
     @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
               if (string != null && !string.isEmpty()) {
                   
            return (Estadocivil) uic.getAttributes().get(string);
        }
        return null;
    

        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o instanceof Estadocivil) {
            Estadocivil entity= (Estadocivil) o;
            if (entity != null && entity instanceof Estadocivil && entity.getIdestadoCivil()!= null) {
                uic.getAttributes().put( entity.getIdestadoCivil().toString(), entity);
                return entity.getIdestadoCivil().toString();
            }
        }
        return "";
    }
}
