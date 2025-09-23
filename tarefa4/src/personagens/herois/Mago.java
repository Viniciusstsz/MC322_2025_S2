package personagens.herois;

import java.util.ArrayList;

import combate.AtaqueFisico;
import itens.armas.Arma;

public class Mago extends Heroi{
    
    private int mana;

    public Mago(String nome, int pontoDeVida, int forca, Arma arma, int nivel, int experiencia, int xpProximoNivel, float sorte , int mana ){
        super(nome, pontoDeVida, forca, arma, nivel, experiencia, xpProximoNivel, sorte);
        this.mana=mana;
        this.acoes = new ArrayList<>();
        this.acoes.add(new AtaqueFisico());
    }
    
//Setters e Getters

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

//-----métodos-----

}
