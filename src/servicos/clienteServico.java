/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import beans.cliente;
import conexao.coon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import utils.erroutils;

/**
 *
 * @author julia
 */
public class clienteServico {
    private coon conexao;
    private Connection conn;

    public clienteServico() {
        this.conexao = new coon();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserirC(cliente cliente) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "INSERT INTO clientes( nome, telefone, cpf, email, endereco, aniversario, alergia) VALUES "
                + "( ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, sdf.format(cliente.getAniversario()));
            stmt.setString(7, cliente.getAlergia());
            stmt.execute();

        } catch (Exception e) {
             erroutils.logErro("Erro ao inserir Cliente", e);
        }
    }
    public cliente getClienteNome(String nome) {
        String sql = "SELECT * FROM clientes WHERE nome LIKE ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            cliente cliente = new cliente();
            rs.next();

            cliente.setId(rs.getInt("id"));
            cliente.setNome(nome);
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setEmail(rs.getString("email"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setAniversario(rs.getDate("aniversario"));
            cliente.setAlergia(rs.getString("alergia"));
            return cliente;

        } catch (Exception e) {
            erroutils.logErro("Erro ao procurar Cliente", e);
            return null;
        }
    }
    public boolean clienteExiste(String nomeCliente) {
        String sql = "SELECT 1 FROM clientes WHERE nome = ? LIMIT 1";

        try ( PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, nomeCliente);
            try ( ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            return false;
        }

    }

}
