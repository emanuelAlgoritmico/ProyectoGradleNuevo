/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import persistencia.DocenteDAO;

/**
 *
 * @author USUARIO
 */
@ApplicationScoped
public class LogicaImplementacion implements ILogica{
    
    @PersistenceUnit(name = "ProjectPU")
    private EntityManagerFactory emf;
    
    private DocenteDAO docenteDAO;
    
    //constructor por defecto
    public LogicaImplementacion() {
    }
    
}
