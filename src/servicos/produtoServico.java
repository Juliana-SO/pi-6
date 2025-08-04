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
public class produtoServico {

    private coon conexao;
    private Connection conn;

    public produtoServico() {
        this.conexao = new coon();
        this.conn = this.conexao.getConexao();
    }
    
    public double produtoExiste(String nomeProduto) {
        String sql = "SELECT valor FROM produtos WHERE nome = ? LIMIT 1";

        try ( PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, nomeProduto);
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
