package personagens.monstros;

import personagens.*;
import personagens.herois.*;
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

    public Monstro(String nome, int pontoDeVida, int forca, Arma arma, int xpConcedido){
        super(nome, pontoDeVida, forca, arma);
        this.acoes = new ArrayList<>();
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
        System.out.println("");
        System.out.println("[MONSTRO] "+this.nome+" | Vida: "+this.pontoDeVida+" | Forca: "+this.forca+" | XPconcedido: "+this.xpConcedido+" | Arma: "+this.arma.getNome());
        System.out.println("");
    }

    //monstro recebe dano de heroi
    //se morrer, heroi ganha experiencia e monstro pode largar arma
    //retorna o dano recebido
    @Override
    public int receberDano(int dano, Combatente atacante) {
        System.out.println("[*] " + this.nome + " recebeu " + dano + " de dano.");

        this.pontoDeVida -= dano;

        if (this.pontoDeVida <= 0) {
            this.pontoDeVida = 0;
            System.out.println("!" + this.nome + " foi derrotado!");

            if (atacante instanceof Heroi) {
                this.morrer((Heroi) atacante);
            }
        }
        return dano;
    }

    //ações quando heroi derrota o monstro
    //heroi ganha experiencia
    //monstro pode largar arma
    private void morrer(Heroi atacante){
        this.largarArma(atacante);
        atacante.ganharExperiencia(this.xpConcedido);
    }

    //monstro ataca
    //retorna o dano causado
    public int atacar(Personagem alvo){
        System.out.println("-->"+this.nome+" atacou "+alvo.getNome()+".");
        int dano = alvo.receberDano(forca+arma.getDano(), this);
        return dano;
    }


    //monstro tem uma chance de largar a arma quando derrotado
    //se largar a arma, o heroi pode trocar a arma atual pela arma largada
    private void largarArma(Heroi heroi){
        if(this.arma instanceof ArmaNula){
            System.out.println("~~~"+this.nome+" não tinha arma para largar.");
            return;
        }
        if(heroi.getSorte() < Math.random()){
            System.out.println("~~~"+this.nome+" não largou a arma.");
            return;
        }
        System.out.println("~~~"+this.nome+" largou a arma.");
        heroi.trocarArma(this.arma);
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        Random rand = new Random();
        int indice = rand.nextInt(acoes.size());
        return acoes.get(indice);
    }

    @Override
    public Item droparLoot(){
        return this.arma;
    }

}