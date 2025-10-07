package personagens.monstros;

import personagens.*;
import itens.armas.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import combate.AcaoDeCombate;
import combate.Combatente;
import itens.*;


/**
 * Base para todos os monstros do rpg
 */
public abstract class Monstro extends Personagem implements Lootavel{

    private int xpConcedido;
    protected List<AcaoDeCombate> acoes;
    protected List<Item> items;

    /**
     * Construtor do monstro
     * @param nome Nome do monstro
     * @param pontoDeVida Pontos de vida do monstro, define a vida maxima do monstro
     * @param forca Forca do monstro
     * @param arma Arma do monstro
     * @param xpConcedido Xp que o monstro vai conceder
     */    
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


    /**
     * Faz o print das informacoes do montro
     */
    @Override
    public void exibirStatus() {
        System.out.println("[MONSTRO] "+this.nome+
        " | Vida: "+this.pontoDeVida+"/"+this.vidaMaxima+
        " | Forca: "+this.forca+
        " | XPconcedido: "+this.xpConcedido+
        " | Arma: "+this.arma.getInformacoes());
    }

    /**
     * Escolhe uma acao de combate aleatoria da lista de acoes
     */
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        Random rand = new Random();
        int indice = rand.nextInt(acoes.size());
        return acoes.get(indice);
    }

    /**
     * Escolhe um item aleatorio da lista de itens para largar
     * caso a lista nao tenha nenhum item retorna null
     */
    public Item droparLoot(){
        if (items.isEmpty()) {
            return null;
        }
        Random rand = new Random();
        int indice = rand.nextInt(items.size());
        return items.get(indice);
    }

}