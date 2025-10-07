package personagens.monstros;

import combate.AtaqueFisico;
import itens.armas.*;;

public class Touro extends Monstro{
    
    public Touro(String nome, int pontoDeVida, int forca, Arma arma, int xpConcedido){
        super(nome, pontoDeVida, forca, arma, xpConcedido);
        this.acoes.add(new AtaqueFisico());
    }

//-----métodos-----
    
}