/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import controlador.MiembroEJB;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Miembro;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Angelo
 */
@ManagedBean
@ViewScoped
public class MiembroMB implements Serializable {

    /**
     * Creates a new instance of MiembroMB
     */
    @EJB
    private MiembroEJB miembroEJB;
    private Miembro miembro = new Miembro();
    private Miembro MiembroSelect;
    private List<Miembro> listaMiembros = new ArrayList<Miembro>();
    private String[] a;
    private String nombreCompleto;
    private Date dt = new Date();
    private String FechaActual;

    public String getFechaMin() {
        return fechaMin;
    }

    public void setFechaMin(String fechaMin) {
        this.fechaMin = fechaMin;
    }
    private String fechaMin;
     SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    public String getFechaActual() {
       
       
       
        return FechaActual;
    }

    public void setFechaActual(String FechaActual) {
        this.FechaActual = FechaActual;
    }

//    public MiembroMB(MiembroEJB miembroEJB, Miembro MiembroSelect, String[] a, String nombreCompleto, String FechaActual) {
//        this.miembroEJB = miembroEJB;
//        this.MiembroSelect = MiembroSelect;
//        this.a = a;
//        this.nombreCompleto = nombreCompleto;
//        this.FechaActual = FechaActual;
//    }

    public MiembroMB(MiembroEJB miembroEJB, Miembro MiembroSelect, String[] a, String nombreCompleto, String FechaActual, String fechaMin) {
        this.miembroEJB = miembroEJB;
        this.MiembroSelect = MiembroSelect;
        this.a = a;
        this.nombreCompleto = nombreCompleto;
        this.FechaActual = FechaActual;
        this.fechaMin = fechaMin;
    }

   


      public MiembroMB() {
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public MiembroEJB getMiembroEJB() {
        return miembroEJB;
    }

    public void setMiembroEJB(MiembroEJB miembroEJB) {
        this.miembroEJB = miembroEJB;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public Miembro getMiembroSelect() {
        return MiembroSelect;
    }

    public void setMiembroSelect(Miembro MiembroSelect) {
        this.MiembroSelect = MiembroSelect;
    }

    public List<Miembro> getListaMiembros() {
        HashSet st = new HashSet();
        st.addAll(listaMiembros);
        listaMiembros.clear();
        listaMiembros.addAll(st);
        return listaMiembros;
    }

    public void setListaMiembros(List<Miembro> listaMiembros) {
        this.listaMiembros = listaMiembros;
    }

    public void onRowSelect(SelectEvent event) {
        this.miembro = (Miembro) event.getObject();
    }

    public void onClickSalir() {
        MiembroSelect = null;
    }

   public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
       
        fechaMin=format.format(event.getObject());
        
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, fechaMin, format.format(event.getObject())));
   
   }

    public void eliminarMiembro() {
        try {
            miembroEJB.eliminarMiembro(miembro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "El registro ha sido eliminado exitosamente.", ""));
            MiembroSelect = null;
            miembro = new Miembro();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El Registro no ha sido eliminado.", e.getMessage()));
        }
    }

    public void guardarOactualizarMiembro() {
        try {
            if (miembro == null) {

                miembro = miembroEJB.crearNuevoMiembro(miembro);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "El registro ha sido guardado exitosamente.", ""));
            } else if (miembro != null) {
                miembro = miembroEJB.actualizarMiembro(miembro);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "El registro ha sido actualizado exitosamente.", ""));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El Registro no puede ser guardado.", e.getMessage()));
        }
    }

    public Miembro nuevaMiembro() {
        MiembroSelect = null;
        miembro = new Miembro();
         FechaActual=sdf.format(dt);
        return miembro;
    }

    public void buscar() {
        System.out.println(nombreCompleto + " :/");
        if (nombreCompleto.isEmpty()) {
            System.out.println(nombreCompleto + " .l.");

        } else {
            StringTokenizer st = new StringTokenizer(nombreCompleto);

            int i = 0;
            a = new String[st.countTokens()];
            while (st.hasMoreTokens()) {
                a[i] = st.nextElement().toString();
                i++;

            }

            if (a != null) {

                if (a.length > 4) {
                    String n2;
                    n2 = a[1] + " " + a[2];
                    listaMiembros = miembroEJB.buscarMiembro(a[0], n2, a[2], a[3]);

                } else {
                    if (a.length == 4) {

                        listaMiembros = miembroEJB.buscarMiembro(a[0], a[1], a[2], a[3]);
                    } else {
                        if (a.length == 3) {
                            listaMiembros = miembroEJB.buscarMiembro("", a[0], a[1], a[2]);
                            listaMiembros.addAll(miembroEJB.buscarMiembro(a[0], "", a[1], a[2]));
                            listaMiembros.addAll(miembroEJB.buscarMiembro(a[0], a[1], "", a[2]));
                            listaMiembros.addAll(miembroEJB.buscarMiembro(a[0], a[1], a[2], ""));

                        } else {
                            if (a.length == 2) {

                                listaMiembros = miembroEJB.buscarMiembro(a[0], a[1], "", "");
                                listaMiembros.addAll(miembroEJB.buscarMiembro(a[0], "", a[1], ""));
                                listaMiembros.addAll(miembroEJB.buscarMiembro(a[0], "", "", a[1]));
                                listaMiembros.addAll(miembroEJB.buscarMiembro("", a[0], a[1], ""));
                                listaMiembros.addAll(miembroEJB.buscarMiembro("", a[0], "", a[1]));
                                listaMiembros.addAll(miembroEJB.buscarMiembro("", "", a[0], a[1]));

                            } else {
                                if (a.length == 1) {
                                    System.out.println("1");
                                    listaMiembros = miembroEJB.buscarMiembro(a[0], "", "", "");
                                    listaMiembros.addAll(miembroEJB.buscarMiembro("", a[0], "", ""));
                                    listaMiembros.addAll(miembroEJB.buscarMiembro("", "", a[0], ""));
                                    listaMiembros.addAll(miembroEJB.buscarMiembro("", "", "", a[0]));

                                }

                            }

                        }

                    }

                }
            }

        }
    }
}
