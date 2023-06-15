package model;

public class Perfil {

    private int idPerfil;
    private String login;
    private String senha;
    private Funcionario funcionario;

    public Perfil() {
    }

    public Perfil(int idPerfil, String login, String senha, Funcionario funcionario) {
        this.idPerfil = idPerfil;
        this.login = login;
        this.senha = senha;
        this.funcionario = funcionario;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Perfil{" + "idPerfil=" + idPerfil + ", login=" + login 
                + ", senha=" + senha + ", funcionario=" + funcionario + '}';
    }
    
}
