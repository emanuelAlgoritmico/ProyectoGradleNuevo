/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectoGradleNuevo.persistencia;

import modelo.Asignatura;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Test;

/**
 *
 * @author Sala Sistemas
 */
public class AsignaturaDAOTest {
    
    private AsignaturaDAO asignaturaDAO;
    private Long id;
    
    
    public AsignaturaDAOTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoPU");
        this.asignaturaDAO = new AsignaturaDAO(emf);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void test() {
        
        try {
            System.out.println("Insertar");
            Asignatura asig = new Asignatura("750014C", "FPOE", (byte)3, (byte)3);
            asignaturaDAO.create(asig);
            this.id = asig.getId();
            System.out.println(this.id);
            
            //System.out.println("buscarPorCodigo");
            //String codigo = "";
            //AsignaturaDAO instance = null;
            //Asignatura expResult = null;
            //Asignatura result = instance.buscarPorCodigo(codigo);
            //assertEquals(expResult, result);
            //fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(AsignaturaDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

//    @Test
//    public void testBuscarPorEscuela() {
//        //System.out.println("buscarPorEscuela");
//        //String codigoEscuela = "";
//        //AsignaturaDAO instance = null;
//        //List<Asignatura> expResult = null;
//        //List<Asignatura> result = instance.buscarPorEscuela(codigoEscuela);
//        //assertEquals(expResult, result);
//        
//    }
    
}
