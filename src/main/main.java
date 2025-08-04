/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import beans.agenda;
import beans.cliente;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import servicos.agendaServico;
import servicos.clienteServico;

/**
 *
 * @author julia
 */
public class main {

    public static void main(String[] args) {
        System.out.println("******************************");
        System.out.println("*          TESTANDO          *");
        System.out.println("******************************");
        
        main minhaAplicacao = new main();
        // minhaAplicacao.testarAgenda();
        // minhaAplicacao.testarCliente();
    }
    public void testarAgenda(){
            agenda ag = new agenda();
            ag.setData(new Date());
            ag.setNomeCliente("Maria Oliveira");
            ag.setHora("14:00");
            ag.setNomeServico("Corte de Cabelo");
            ag.setFuncionario("João Silva");
            ag.setValor(75.0);
            agendaServico servico = new agendaServico();
            servico.inserirA(ag);
            System.out.println("Agenda de " + ag.getNomeCliente() + " para " + ag.getNomeServico() + " salva com sucesso!");
    

    }
    public void testarCliente(){
        cliente cli = new cliente();
        cli.setNome("Ana Paula Lima");
        cli.setTelefone("98765-4321");
        cli.setCpf("12345678900");
        cli.setEmail("ana.paula@example.com");
        cli.setEndereco("Rua das Flores, 123, São Paulo - SP");
        Calendar cal = Calendar.getInstance();
        cal.set(1990, Calendar.MAY, 15); 
        cli.setAniversario(cal.getTime());
        cli.setAlergia("sim"); 

        clienteServico clienteService = new clienteServico(); 
        
        clienteService.inserirC(cli);
     
    }
}
