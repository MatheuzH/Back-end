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


    public static Setor fromValue(int dbValue) {
        for (Setor setor :  Setor.values()) {
            if (setor.getDbValues() == dbValue) {
                return setor;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + dbValue);
}

    public int getValue() {
        return dbValue;
    }
}


