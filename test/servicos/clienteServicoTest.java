/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package servicos;

import beans.cliente;
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
public class clienteServicoTest {
    
    public clienteServicoTest() {
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
     * Test of inserirC method, of class clienteServico.
     */
    @Test
    public void inserirtest(){
        cliente c = new cliente();
        c.setNome("Juliana Soares");
        c.setTelefone("99999-9999");
        c.setCpf("12345678901");
        c.setEmail("juliana@gmail.com");
        c.setEndereco("Rua da flor, 123");
        c.setAlergia("sim");
        
        clienteServico instance = new clienteServico();
        instance.inserirC(c);
    }
    @Test
    public void testInserirC() {
        System.out.println("inserirC");
        cliente cliente = null;
        clienteServico instance = new clienteServico();
        instance.inserirC(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClienteNome method, of class clienteServico.
     */
    @Test
    public void testGetClienteNome() {
        System.out.println("getClienteNome");
        String nome = "";
        clienteServico instance = new clienteServico();
        cliente expResult = null;
        cliente result = instance.getClienteNome(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clienteExiste method, of class clienteServico.
     */
    @Test
    public void testClienteExiste() {
        System.out.println("clienteExiste");
        String nomeCliente = "";
        clienteServico instance = new clienteServico();
        boolean expResult = false;
        boolean result = instance.clienteExiste(nomeCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
