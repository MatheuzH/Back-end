package Modulos;

public class Funcionario {
    private int id_funcionario;
    private Cargo cargo;
    private Setor fk_setor;
    private String email, nomeFuncionario, senha;

    public Funcionario(int id_funcionario, String email, String nomeFuncionario, Cargo cargo, String senha, Setor fk_setor) {
        this.id_funcionario = id_funcionario;
        this.email = email;
        this.nomeFuncionario = nomeFuncionario;
        this.cargo = cargo;
        this.senha = senha;
        this.fk_setor = fk_setor;
    }

    public Funcionario(String email, String nomeFuncionario, Cargo cargo, String senha, Setor fk_setor) {
        this.email = email;
        this.nomeFuncionario = nomeFuncionario;
        this.cargo = cargo;
        this.senha = senha;
        this.fk_setor = fk_setor;
    }

    public Funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public Funcionario() {
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Setor getId_Setor(){
        return fk_setor;
    }

    public int getId_funcionario(){
        return id_funcionario;
    }

    public String getEmail(){
        return email;
    }

    public String getNomeFuncionario(){
        return nomeFuncionario;
    }

    public String getSenha(){
        return senha;
    }

    public void setId_funcionario(int id_funcionario){
        this.id_funcionario = id_funcionario;
    }

    public void setId_Setor(Setor id_setor){
        this.fk_setor = id_setor;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setNomeFuncionario(String nomeFuncionario){
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

}

