/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import beans.agenda;
import conexao.coon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import utils.erroutils;

/**
 *
 * @author julia
 */
public class agendaServico {
    private coon conexao;
    private Connection conn;
    
    public agendaServico() {
        this.conexao = new coon();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserirA(agenda agenda) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    if (agenda.getData() == null) {
        JOptionPane.showMessageDialog(null, "Erro: a data está nula!");
        return;
    }

    String sql = "INSERT INTO agenda(dat, nomeCliente, hora, nomeFuncionario, nomeServico, valor) VALUES (?, ?, ?, ?, ?, ?)";
    
    try {
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, sdf.format(agenda.getData()));   
        stmt.setString(2, agenda.getNomeCliente());
        stmt.setString(3, agenda.getHora());  
        stmt.setString(4, agenda.getFuncionario());
        stmt.setString(5, agenda.getNomeServico());
        stmt.setDouble(6, agenda.getValor());
        stmt.execute();

    } catch (Exception e) {
        erroutils.logErro("Erro ao inserir Cliente", e);
    }
 }
    public List<agenda> getAgenda() {
        String sql = "SELECT * FROM agenda";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<agenda> listaAgenda = new ArrayList<>();

            while (rs.next()) {
                agenda agenda = new agenda();
                agenda.setId(rs.getInt("id"));
                agenda.setData(rs.getDate("dat"));
                agenda.setNomeCliente(rs.getString("nomeCliente"));
                agenda.setNomeServico(rs.getString("nomeServico"));
                agenda.setFuncionario(rs.getString("nomeFuncionario"));
                agenda.setValor(rs.getDouble("valor"));
                agenda.setHora(rs.getString("hora"));
                listaAgenda.add(agenda);

            }

            return listaAgenda;
        } catch (Exception e) {
            return null;
        }

    }

    
    
}
