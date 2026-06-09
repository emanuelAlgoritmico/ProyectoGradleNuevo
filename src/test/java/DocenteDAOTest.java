/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Docente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import persistencia.DocenteDAO;

/**
 *
 * @author USUARIO
 */
public class DocenteDAOTest {
    
    private DocenteDAO docenteDAO;
    private Long id;
    
    
    public DocenteDAOTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoPU");
        this.docenteDAO = new DocenteDAO(emf);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test() {
        
        try {
            System.out.println("Insertar");
            Docente docen = new Docente(11136334, "Perez", "Perez", "Masculino");
            docenteDAO.create(docen);
            this.id = docen.getId();
            System.out.println(this.id);
            Assert.assertNotNull(docen.getId());
            
            System.out.println("Buscar");
            docen = null;
            docen = docenteDAO.buscarPorCodigo("11136334");
            Assert.assertEquals("Pepe", docen.getNombre());
            
            docen.setNombre("Pepe Perez");
            this.docenteDAO.edit(docen);
            
            docen = docenteDAO.buscarPorCodigo("11136334");
            Assert.assertEquals("Pepe Perez", docen.getNombre());
            
            //System.out.println("buscarPorCodigo");
            //String codigo = "";
            //AsignaturaDAO instance = null;
            //Asignatura expResult = null;
            //Asignatura result = instance.buscarPorCodigo(codigo);
            //assertEquals(expResult, result);
            //fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(DocenteDAOTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
        
    }
}
