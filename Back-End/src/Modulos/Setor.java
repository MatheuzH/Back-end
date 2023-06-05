package Modulos;

public enum Setor {
    TI(1),
    COMERCIAL(2),
    OPERACOES(3);

    public int dbValue;

    private Setor(int dbValue) {
        this.dbValue = dbValue;
    }

    public int getDbValues() {
        return dbValue;
    }
}
