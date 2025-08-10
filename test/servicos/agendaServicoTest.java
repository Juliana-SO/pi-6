/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package servicos;

import beans.agenda;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class agendaServicoTest {
    
    public agendaServicoTest() {
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
     * Test of inserirA method, of class agendaServico.
     */
    
    @Test
    public void testeagenda() throws ParseException{
        agenda a = new agenda();
        a.setData(new SimpleDateFormat("dd/MM/yyyy").parse("03/09/2025"));
        a.setNomeCliente("Juliana Soares");
        a.setHora("13:30");
        a.setFuncionario("Maria Oliveira");
        a.setNomeServico("Escova Progressiva");
        a.setValor(150.00);
        
        agendaServico instance = new agendaServico();
        instance.inserirA(a);
    }
    @Test
    public void testInserirA() {
        System.out.println("inserirA");
        agenda agenda = null;
        agendaServico instance = new agendaServico();
        instance.inserirA(agenda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAgenda method, of class agendaServico.
     */
    @Test
    public void testGetAgenda() {
        System.out.println("getAgenda");
        agendaServico instance = new agendaServico();
        List<agenda> expResult = null;
        List<agenda> result = instance.getAgenda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
