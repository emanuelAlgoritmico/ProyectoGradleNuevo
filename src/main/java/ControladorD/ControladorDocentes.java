/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorD;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.ILogica;
import modelo.Docente;

/**
 *
 * @author USUARIO
 */
/**
     *
     */


    @Named(value = "docenteCtrl")  // Sirve para poder acceder a la clase en asignaturas.xhtml
@SessionScoped
public class ControladorDocentes implements Serializable{
    
        @Inject
    private ILogica logica;
    
    private Docente docente = new Docente(1113633, "Ema", "Alv", "Masculino");
    
    public List<Docente> getDocentes() {
        return this.logica.buscarDocentes();
    }
    
    public Docente getDocente() {
        return docente;
    } 
    
    public void guardar() {
        try {
            this.logica.crearDocente(this.docente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La asignatura " + this.docente.getNombre()+ " fue guardado"));
            this.docente = new Docente();
        } catch (SQLIntegrityConstraintViolationException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de restricciones", ex.getLocalizedMessage()));
            Logger.getLogger(ControladorDocentes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no identificado. Contacte con el desarrollador", ex.getLocalizedMessage()));
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cancelar() {
        this.docente = new Docente();
        FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage("Proceso cancelado")
        );
    }
}
    

