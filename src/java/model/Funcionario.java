package model;

public class Funcionario {
    
    private int idFuncionario;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String funcao;

    public Funcionario() {
    }

    public Funcionario(int idFuncionario, String nome, String cpf, String endereco, String telefone, String funcao) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.funcao = funcao;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "idFuncionario=" + idFuncionario 
                + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco 
                + ", telefone=" + telefone + ", funcao=" + funcao + '}';
    }
    
    
    
}
