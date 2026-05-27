/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import co.edu.uvpalmira.fpoe.jpalib.NonexistentEntityException;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import modelo.Asignatura;
import proyectoGradleNuevo.persistencia.AsignaturaDAO;
import jakarta.enterprise.context.ApplicationScoped;

/**
 *
 * @author Sala Sistemas
 */
@ApplicationScoped
public class LogicaImplementacion implements ILogica{
    
    @PersistenceUnit(name = "ProjectPU")
    private EntityManagerFactory emf;
    
    private AsignaturaDAO asignaturaDAO;
    // Constructor por defecto
    public LogicaImplementacion() {
    }
    
    // paso 8
    @PostConstruct
    public void init() {
        this.asignaturaDAO = new AsignaturaDAO(this.emf);
    }
    
    @Override
    public void crearAsignatura(Asignatura asignatura) throws SQLIntegrityConstraintViolationException, Exception{
        this.asignaturaDAO.create(asignatura);
    }

    @Override
    public void modificarAsignatura(Asignatura asignatura) throws NonexistentEntityException, Exception{
        this.asignaturaDAO.edit(asignatura);
    }

    @Override
    public Asignatura buscarAsignatura(Asignatura asignatura) {
    return this.asignaturaDAO.buscarPorCodigo(asignatura.getCodigo()); // esta raro
    }

    @Override
    public List<Asignatura> buscarAsignatuar() {
        return this.asignaturaDAO.findEntities();
    }
    
}
