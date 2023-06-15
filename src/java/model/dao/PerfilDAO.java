package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Perfil;

public class PerfilDAO extends DataBaseDAO {
    
    public PerfilDAO() throws Exception{}
    
    public ArrayList<Perfil> getLista() throws Exception{
        ArrayList<Perfil> lista = new ArrayList<Perfil>();
        String SQL = "SELECT * FROM perfil";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(SQL);
        while(rs.next()) {
            Perfil p = new Perfil();
            p.setIdPerfil(rs.getInt("idPerfil")); // parâmetro com o mesmo nome da coluna do banco de dados
            p.setLogin(rs.getString("login"));
            p.setSenha(rs.getString("senha"));
            p.setFuncionario(rs.getFuncionario("funcionario"));
            lista.add(p);
        }
        this.desconectar();
        return lista;
}
    
    public boolean grava(Perfil p) {
        try{
            String sql;
            this.conectar();
            if(f.getIdFuncionario()==0) {
                sql = "INSERT INTO perfil(login,senha,funcionario) VALUES(?,?,?)";
            } else {
                sql = "UPDATE perfil SET login = ?, senha = ?, funcionario = ? WHERE idPerfil = ?";
            }
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, p.getLogin());
            pstm.setString(2, p.getSenha());
            pstm.setFuncionario(3, p.getFuncionario());
            if(p.getIdPerfil() > 0) {
                pstm.setInt(2, p.getIdPerfil());
            }
            pstm.execute();
            this.desconectar();
            return true;
            
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean exclui(Perfil p) {
        try{
            this.conectar();
            String sql = "DELETE FROM perfil WHERE idPerfil=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,p.getIdPerfil());
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public Perfil getCarregaPorID(int idPerfil) throws Exception {
        
        Perfil p = new Perfil();
        String sql = "SELECT * FROM perfil WHERE idPerfil=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idPerfil);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()) {
            p.setIdPerfil(rs.getInt("idPerfil"));
            p.setLogin(rs.getString("login"));
            p.setSenha(rs.getString("senha"));
            p.setFuncionario(rs.getFuncionario("funcionario"));
        }
        this.desconectar();
        return p;
    }
    
}
