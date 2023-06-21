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
            p.setNome(rs.getString("nome"));
            p.setLogin_per(rs.getString("login_per"));
            p.setSenha_per(rs.getString("senha_per"));
            lista.add(p);
        }
        this.desconectar();
        return lista;
}
    
    public boolean grava(Perfil p) {
        try{
            String sql;
            this.conectar();
            if(p.getIdPerfil()==0) {
                sql = "INSERT INTO perfil(nome,login_per,senha_per) VALUES(?,?,?)";
            } else {
                sql = "UPDATE perfil SET nome = ?, login_per = ?, senha_per = ? WHERE idPerfil = ?";
            }
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getLogin_per());
            pstm.setString(3, p.getSenha_per());
            if(p.getIdPerfil() > 0) {
                pstm.setInt(4, p.getIdPerfil());
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
        if (rs.next()) {
            p.setIdPerfil(rs.getInt("idPerfil"));
            p.setNome(rs.getString("nome"));
            p.setLogin_per(rs.getString("login_per"));
            p.setSenha_per(rs.getString("senha_per"));
        }
        this.desconectar();
        return p;
    }
    public Perfil getRecuperarPerfil(String login_per) {
        
        Perfil p = new Perfil();
        String sql = "SELECT p.* FROM perfil p "
                + "WHERE p.login_per=?";
        
        try {
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, login_per);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                p.setIdPerfil(rs.getInt("p.idPerfil"));
                p.setNome(rs.getString("p.nome"));
                p.setLogin_per(rs.getString("p.login_per"));
                p.setSenha_per(rs.getString("p.senha_per"));
            }
            this.desconectar();
            return p;
            
        } catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    
}
