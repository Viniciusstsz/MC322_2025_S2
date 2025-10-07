package cenario;

import interfaces.Fase;
import personagens.herois.Heroi;
import personagens.monstros.*;;

public class FaseDeCombate implements Fase {

    private TipoCenario tipoCenario;
    private int nivel;
    private Monstro inimigos[];

    public FaseDeCombate(TipoCenario cenario, int nivel, Monstro inimigos[]){
        this.tipoCenario = cenario;
        this.nivel=nivel;
        this.inimigos=inimigos;
    }

//Setters e Getters

    public TipoCenario getTipoDeCenario(){
        return tipoCenario;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Monstro[] getInimigos() {
        return inimigos;
    }

    public void setInimigos(Monstro[] inimigos) {
        this.inimigos = inimigos;
    }

//-----métodos-----

    public boolean isConcluida() {
    for (Monstro inimigo : inimigos) {
        if (inimigo != null && inimigo.estaVivo()) {
            return false;
            }
        }
    return true;
    }

    public void iniciar(Heroi heroi) {
        System.out.println("Iniciando a fase: " + tipoCenario.getDescricao());
        tipoCenario.aplicarEfeitos(heroi);
    }

}
