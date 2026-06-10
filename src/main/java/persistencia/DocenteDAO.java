/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import co.edu.uvpalmira.fpoe.jpalib.AbstractDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import modelo.Docente;

/**
 *
 * @author USUARIO
 */
public class DocenteDAO extends AbstractDAO<Docente>{
    
    public DocenteDAO(EntityManagerFactory emf) {
        super(Docente.class, emf);
    }
    
    public Docente buscarPorCodigo(int codigo) {
        EntityManager em = super.getEntityManager();
        return (Docente) em.createNamedQuery("Docente.buscarPorCodigo")
                .setParameter("codigo", codigo)
                .getSingleResult();
    }
}
