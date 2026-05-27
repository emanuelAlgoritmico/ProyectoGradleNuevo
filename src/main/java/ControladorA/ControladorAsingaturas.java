/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorA;

import modelo.Asignatura;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.ILogica;
import java.sql.SQLIntegrityConstraintViolationException;


/**
 *
 * @author Sala Sistemas
 */
@Named(value = "asignCtrl")  // Sirve para poder acceder a la clase en asignaturas.xhtml
@SessionScoped
public class ControladorAsingaturas implements Serializable {
    
    @Inject
    private ILogica logica;
    
    private Asignatura asignatura = new Asignatura("750014C", "FPOE", (byte)3, (byte)3);
    
    public Asignatura getAsignatura() {
        return asignatura;
    } 
    
    public void guardar() {
        try {
            this.logica.crearAsignatura(this.asignatura);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La asignatura" + this.asignatura.getDescription() + " fue guardado"));
            this.asignatura = new Asignatura();
        } catch (SQLIntegrityConstraintViolationException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de restricciones", ex.getLocalizedMessage()));
            Logger.getLogger(ControladorAsingaturas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no identificado. Contacte con el desarrollador", ex.getLocalizedMessage()));
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
}

