package personagens.monstros;

import personagens.*;
import itens.armas.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import combate.AcaoDeCombate;
import combate.Combatente;
import itens.*;

public abstract class Monstro extends Personagem implements Lootavel{

    private int xpConcedido;
    protected List<AcaoDeCombate> acoes;
    protected List<Item> items;

    public Monstro(String nome, int pontoDeVida, int forca, Arma arma, int xpConcedido){
        super(nome, pontoDeVida, forca, arma);
        this.acoes = new ArrayList<>();
        this.items = new ArrayList<>();
        if(!(this.arma instanceof ArmaNula)){
            this.items.add(this.arma);
        }
        this.xpConcedido=xpConcedido;
    }

//Setters e Getters

    public int getXpConcedido() {
        return xpConcedido;
    }

    public void setXpConcedido(int xpConcedido) {
        this.xpConcedido = xpConcedido;
    }

//-----métodos-----


    //exibe status do monstro
    @Override
    public void exibirStatus() {
        System.out.println("[MONSTRO] "+this.nome+
        " | Vida: "+this.pontoDeVida+"/"+this.vidaMaxima+
        " | Forca: "+this.forca+
        " | XPconcedido: "+this.xpConcedido+
        " | Arma: "+this.arma.getInformacoes());
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        Random rand = new Random();
        int indice = rand.nextInt(acoes.size());
        return acoes.get(indice);
    }

    @Override
    public Item droparLoot(){
        if (items.isEmpty()) {
            return null;
        }
        Random rand = new Random();
        int indice = rand.nextInt(items.size());
        return items.get(indice);
    }

}