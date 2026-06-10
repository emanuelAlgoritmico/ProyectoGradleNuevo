/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import co.edu.uvpalmira.fpoe.jpalib.NonexistentEntityException;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import modelo.Docente;
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
    
    @PostConstruct
    public void init() {
        this.docenteDAO = new DocenteDAO(this.emf);
    }

    @Override
    public void save(Docente docente) throws SQLIntegrityConstraintViolationException, Exception {
        this.docenteDAO.save(docente);
    }

    @Override
    public List<Docente> buscarDocentes() {
        return this.docenteDAO.findEntities(); 
    }

    @Override
    public void crearDocente(Docente docente) throws SQLIntegrityConstraintViolationException, Exception {
        this.docenteDAO.create(docente);
    }

    @Override
    public void modificarDocente(Docente docente) throws NonexistentEntityException, Exception {
        this.docenteDAO.edit(docente);
    }
}
