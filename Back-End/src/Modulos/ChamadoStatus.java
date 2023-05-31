package Modulos;

public enum ChamadoStatus {
    ABERTO(1), 
    PENDENTE(2), 
    PAUSADO(3), 
    FECHADO(4);

    private int statusChamado;

    private ChamadoStatus(int statusChamado){
        this.statusChamado = statusChamado;
    }   

    public int getValores(){
        return statusChamado;
    }
}
