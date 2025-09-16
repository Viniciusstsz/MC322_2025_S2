package personagens.monstros;

import java.util.ArrayList;

import combate.AtaqueFisico;
import itens.armas.*;

public class Esqueleto extends Monstro{
    
    public Esqueleto(String nome, int pontoDeVida, int forca, Arma arma, int xpConcedido){
        super(nome, pontoDeVida, forca, arma, xpConcedido);
        this.acoes = new ArrayList<>();
        this.acoes.add(new AtaqueFisico());
    }

//-----métodos-----
    
}

