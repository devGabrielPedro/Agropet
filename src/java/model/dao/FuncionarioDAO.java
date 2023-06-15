package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Funcionario;

public class FuncionarioDAO extends DataBaseDAO {
    
    public FuncionarioDAO() throws Exception{}
    
    public ArrayList<Funcionario> getLista() throws Exception{
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        String SQL = "SELECT * FROM funcionario";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(SQL);
        while(rs.next()) {
            Funcionario f = new Funcionario();
            f.setIdFuncionario(rs.getInt("idFuncionario")); // parâmetro com o mesmo nome da coluna do banco de dados
            f.setNome(rs.getString("nome"));
            f.setCpf(rs.getString("cpf"));
            f.setEndereco(rs.getString("endereco"));
            f.setTelefone(rs.getString("telefone"));
            f.setFuncao(rs.getString("funcao"));
            lista.add(f);
        }
        this.desconectar();
        return lista;
}
    
    public boolean grava(Funcionario f) {
        try{
            String sql;
            this.conectar();
            if(f.getIdFuncionario()==0) {
                sql = "INSERT INTO funcionario(nome,cpf,endereco,telefone,funcao) VALUES(?,?,?,?,?)";
            } else {
                sql = "UPDATE funcionario SET nome = ?, cpf = ?, endereco = ?, telefone = ?, funcao = ? WHERE idFuncionario = ?";
            }
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getCpf());
            pstm.setString(3, f.getEndereco());
            pstm.setString(4, f.getTelefone());
            pstm.setString(5, f.getFuncao());
            if(f.getIdFuncionario() > 0) {
                pstm.setInt(2, f.getIdFuncionario());
            }
            pstm.execute();
            this.desconectar();
            return true;
            
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean exclui(Funcionario f) {
        try{
            this.conectar();
            String sql = "DELETE FROM funcionario WHERE idFuncionario=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,f.getIdFuncionario());
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public Funcionario getCarregaPorID(int idFuncionario) throws Exception {
        
        Funcionario f = new Funcionario();
        String sql = "SELECT * FROM funcionario WHERE idFuncionario=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idFuncionario);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()) {
            f.setIdFuncionario(rs.getInt("idFuncionario"));
            f.setNome(rs.getString("nome"));
            f.setCpf(rs.getString("cpf"));
            f.setEndereco(rs.getString("endereco"));
            f.setTelefone(rs.getString("telefone"));
            f.setFuncao(rs.getString("funcao"));
        }
        this.desconectar();
        return f;
    }
    
}
