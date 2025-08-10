/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package servicos;

import beans.funcionario;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julia
 */
public class funcionarioServicosTest {
    
    public funcionarioServicosTest() {
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

    /**
     * Test of getFuncionarios method, of class funcionarioServicos.
     */
    @Test
    public void existetest(){
       funcionarioServicos instance = new funcionarioServicos();
       instance.funcionarioExiste("Maria Oliveira");   
    }
    
    @Test
    public void testGetFuncionarios() {
        System.out.println("getFuncionarios");
        funcionarioServicos instance = new funcionarioServicos();
        List<funcionario> expResult = null;
        List<funcionario> result = instance.getFuncionarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of funcionarioExiste method, of class funcionarioServicos.
     */
    @Test
    public void testFuncionarioExiste() {
        System.out.println("funcionarioExiste");
        String nomeFuncionario = "";
        funcionarioServicos instance = new funcionarioServicos();
        boolean expResult = false;
        boolean result = instance.funcionarioExiste(nomeFuncionario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
