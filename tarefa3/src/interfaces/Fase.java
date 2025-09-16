package interfaces;

import personagens.herois.Heroi;

public interface Fase {
    
    public void iniciar(Heroi heroi);

    public boolean isConcluida();

    public String getTipoDeCenario();

}
