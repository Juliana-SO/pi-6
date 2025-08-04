/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import beans.funcionario;
import conexao.coon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class funcionarioServicos {

    private coon conexao;
    private Connection conn;

    public funcionarioServicos() {
        this.conexao = new coon();
        this.conn = this.conexao.getConexao();
    }

    public List<funcionario> getFuncionarios() {
        String sql = "SELECT * FROM funcionarios";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<funcionario> listaF = new ArrayList<>();

            while (rs.next()) {
                funcionario f = new funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                listaF.add(f);

            }

            return listaF;
        } catch (Exception e) {
            return null;
        }
    }

public boolean funcionarioExiste(String nomeFuncionario) {
        String sql = "SELECT 1 FROM funcionarios WHERE nome = ? LIMIT 1";

        try ( PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, nomeFuncionario);
            try ( ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            return false;
        }

    }
}
