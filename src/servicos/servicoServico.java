/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import conexao.coon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author julia
 */
public class servicoServico {
   private coon conexao;
    private Connection conn;

    public servicoServico() {
        this.conexao = new coon();
        this.conn = this.conexao.getConexao();
    } 
    public double servicoExiste(String nomeServico) {
        String sql = "SELECT valor FROM servicos WHERE nome = ? LIMIT 1";

        try ( PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, nomeServico);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("valor"); 
                }
            }
        } catch (Exception e) {
           return -1.0;  
        }

        return -1.0;  
    }
}
