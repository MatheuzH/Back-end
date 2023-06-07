package Modulos;

public enum Cargo {
    GESTORCOMERCIAL(1), GESTOROPERACAO(2), 
    ANALISTACOMERCIAL(3), ANALISTAOPERACAO(4), 
    ADMSIS(5), ANALISTATI(6);

    public int cargos;

    private Cargo(int cargos){
        this.cargos = cargos;
    }

    public int getCargos() {
        return cargos;
    }
}
