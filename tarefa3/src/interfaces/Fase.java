package interfaces;

import cenario.TipoCenario;
import personagens.herois.Heroi;

public interface Fase {
    
    public void iniciar(Heroi heroi);

    public boolean isConcluida();

    public TipoCenario getTipoDeCenario();

}
