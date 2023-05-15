public class Funcionarios {
    int id_funcionario, cargo, fk_setor;
    String email, nomeFuncionario, senha;


    public Funcionarios(int id_funcionario, int cargo, int fk_setor, String email, String nomeFuncionario, String senha) {
        this.id_funcionario = id_funcionario;
        this.cargo = cargo;
        this.fk_setor = fk_setor;
        this.email = email;
        this.nomeFuncionario = nomeFuncionario;
        this.senha = senha;
    }


    public int getId_funcionario() {
        return this.id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getCargo() {
        return this.cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public int getFk_setor() {
        return this.fk_setor;
    }

    public void setFk_setor(int fk_setor) {
        this.fk_setor = fk_setor;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeFuncionario() {
        return this.nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
