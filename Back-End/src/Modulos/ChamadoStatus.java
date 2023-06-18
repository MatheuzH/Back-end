package Modulos;

public enum ChamadoStatus {
    ABERTO(1),
    PENDENTE(2),
    PAUSADO(3),
    FECHADO(4);

    public int statusChamado;

    private ChamadoStatus(int statusChamado){
        this.statusChamado = statusChamado;
    }

    public int getstatusChamado(){
        return statusChamado;
    }

    public static ChamadoStatus fromValue(int statusChamado) {
        for (ChamadoStatus chamado : ChamadoStatus.values()) {
            if (chamado.getstatusChamado() == statusChamado) {
                return chamado;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + statusChamado);
    }

    public int getValue(){
        return statusChamado;
    }

}
