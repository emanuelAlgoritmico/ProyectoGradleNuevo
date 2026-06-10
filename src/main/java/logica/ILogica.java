/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica;

import co.edu.uvpalmira.fpoe.jpalib.NonexistentEntityException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import modelo.Docente;

/**
 *
 * @author USUARIO
 */
public interface ILogica {
    
    public void crearDocente(Docente docente) throws SQLIntegrityConstraintViolationException,Exception;
    public void modificarDocente(Docente docente) throws NonexistentEntityException, Exception;
    public void save(Docente docente) throws SQLIntegrityConstraintViolationException, Exception;
    public List<Docente> buscarDocentes(); 

}
