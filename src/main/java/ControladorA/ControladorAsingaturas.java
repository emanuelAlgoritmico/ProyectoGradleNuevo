/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorA;

import Modelo.Asignatura;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Sala Sistemas
 */
@Named(value = "asignCtrl")  // Sirve para poder acceder a la clase en asignaturas.xhtml
@SessionScoped
public class ControladorAsingaturas implements Serializable {
    
    private Asignatura asignatura = new Asignatura("750014C", "FPOE", (byte)3, (byte)3);
    
    public Asignatura getAsignatura() {
        return asignatura;
    }
}

