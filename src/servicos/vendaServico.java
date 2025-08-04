/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import beans.venda;
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
public class vendaServico {

    private coon conexao;
    private Connection conn;

    public vendaServico() {
        this.conexao = new coon();
        this.conn = this.conexao.getConexao();
    }

    public void inserirV(venda venda) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
        String sql = "INSERT INTO vendas(dat, nomeCliente, nomeFuncionario, nomeProduto, nomeServico, valor, hora) VALUES "
                + "( ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, sdf.format(venda.getData()));
            stmt.setString(2, venda.getNomeCliente());
            stmt.setString(3, venda.getFuncionario());
            stmt.setString(4, venda.getNomeProduto());
            stmt.setString(5, venda.getNomeServico());
            stmt.setDouble(6, venda.getValor());
            stmt.setString(7, venda.getHora());
            stmt.execute();

        } catch (Exception e) {
            erroutils.logErro("Erro ao inserir venda", e);
        }
    }

    public List<venda> getVendas(String nome) {
        String sql = "SELECT * FROM vendas WHERE nomeCliente LIKE ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            List<venda> listaVendas = new ArrayList<>();

            while (rs.next()) {
                venda venda = new venda();
                venda.setId(rs.getInt("id"));
                venda.setData(rs.getDate("dat"));
                venda.setNomeCliente(rs.getString("nomeCliente"));
                venda.setNomeProduto(rs.getString("nomeProduto"));
                venda.setNomeServico(rs.getString("nomeServico"));
                venda.setFuncionario(rs.getString("nomeFuncionario"));
                venda.setValor(rs.getDouble("valor"));
                venda.setHora(rs.getString("hora"));
                listaVendas.add(venda);

            }

            return listaVendas;
        } catch (Exception e) {
            return null;
        }

    }

}
