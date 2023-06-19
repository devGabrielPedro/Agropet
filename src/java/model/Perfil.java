package model;

public class Perfil {

    private int idPerfil;
    private String nome;
    private String login_per;
    private String senha_per;

    public Perfil() {
    }

    public Perfil(int idPerfil, String nome, String login_per, String senha_per) {
        this.idPerfil = idPerfil;
        this.nome = nome;
        this.login_per = login_per;
        this.senha_per = senha_per;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin_per() {
        return login_per;
    }

    public void setLogin_per(String login_per) {
        this.login_per = login_per;
    }

    public String getSenha_per() {
        return senha_per;
    }

    public void setSenha_per(String senha_per) {
        this.senha_per = senha_per;
    }

    @Override
    public String toString() {
        return "Perfil{" + "idPerfil=" + idPerfil + ", nome=" + nome + ", login_per=" + login_per + ", senha_per=" + senha_per + '}';
    }
    
}
