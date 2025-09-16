package combate;

import itens.armas.*;
public interface Combatente {

    public String getNome();

    public int getForca();

    public Arma getArma();

    public boolean estaVivo();

    public int receberDano(int dano, Combatente atacante);

    public int receberCura(int cura);

    public AcaoDeCombate escolherAcao(Combatente alvo);

}