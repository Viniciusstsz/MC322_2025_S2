package personagens.herois;

import personagens.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import combate.AcaoDeCombate;
import combate.Combatente;
import itens.armas.Arma;

public abstract class Heroi extends Personagem{
    
    protected int nivel;
    protected int experiencia;
    protected int xpProximoNivel;
    protected float sorte;
    protected List<AcaoDeCombate> acoes;


    /**
     * Construtor do heroi
     * @param nome Nome do heroi
     * @param pontoDeVida Pontos de vida do heroi, define a vida maxima do heroi
     * @param forca Forca do heroi
     * @param arma Arma inicial do heroi
     * @param nivel Nivel inicial do heroi
     * @param experiencia Experiencia inicial do heroi
     * @param xpProximoNivel Quantidade de xp necessario para o proximo nivel
     * @param sorte Sorte do heroi
     */
    public Heroi(String nome, int pontoDeVida, int forca, Arma arma, int nivel, int experiencia, int xpProximoNivel, float sorte){
        super(nome, pontoDeVida, forca, arma);
        this.acoes = new ArrayList<>();
        this.nivel=nivel;
        this.experiencia=experiencia;
        this.xpProximoNivel=xpProximoNivel;
        this.sorte=sorte;
    }

//Setters e Getters

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getXpProximoNivel() {
        return xpProximoNivel;
    }

    public void setXpProximoNivel(int xpProximoNivel) {
        this.xpProximoNivel = xpProximoNivel;
    }

    public float getSorte() {
        return sorte;
    }

    public void setSorte(float sorte) {
        this.sorte = sorte;
    }


//-----métodos-----

    /**
     * Aumenta o xp e verifica se subiu de nivel
     * @param incremento Quantidade de xp ganha
     */
    public void ganharExperiencia(int incremento){
        this.experiencia+=incremento;
        subirDeNivel();
    }

    /**
     * Faz o print das informacoes do heroi
     */
    @Override
    public void exibirStatus() {
        System.out.println("[HEROI] "+this.nome+
        " | Vida: "+this.pontoDeVida+"/"+this.vidaMaxima+
        " | Forca: "+this.forca+
        " | Nivel: "+this.nivel+
        " | XP: "+this.experiencia+"/"+this.xpProximoNivel+
        " | Arma: "+this.arma.getInformacoes()+
        " | Sorte: "+this.sorte);
    }

    /**
     * Verifica se o heroi subiu de nivel
     * Se sim, atualiza atributos e restaura vida
     * Exibe mensagem de nivel up
     */
    private void subirDeNivel(){
        if(this.experiencia < xpProximoNivel){
            return;
        }

        this.experiencia -= xpProximoNivel;
        this.nivel++;
        this.forca += nivel* 3;
        this.vidaMaxima = vidaMaxima + nivel* 5;
        this.pontoDeVida = vidaMaxima;
        this.xpProximoNivel += (this.xpProximoNivel + this.nivel * 25);

        System.out.println("!!! "+this.nome+" subiu para o nivel "+this.nivel+": +"+nivel*3+" de Forca, +"+nivel*5+" de Vida, vida totalmente restaurada !!!");
    }
    
    /**
     * Heroi pode trocar de arma se tiver o nível necessário e a nova arma for melhor que a atual.
     * Exibe mensagem de sucesso ou falha na troca.
     * @param novaArma Nova arma
     */
    public void trocarArma(Arma novaArma) {
        String nomeAtual = this.arma.getNome();
        String nomeNova = novaArma.getNome();

        if (this.nivel < novaArma.getMinNivel()) {
            System.out.println(this.nome + " não tem o nível necessário para usar a arma " + nomeNova + ".");
            return;
        }

        if (novaArma.getDano() <= this.arma.getDano()) {
            System.out.println(this.nome + " decidiu manter " + nomeAtual + " em vez de trocar por " + nomeNova + 
                            " (a nova arma é pior ou igual).");
            return;
        }

        this.arma = novaArma;
        System.out.println(this.nome + " trocou " + nomeAtual + " por " + nomeNova + "!");
    }

    /**
     * Escolhe aleatoriamente uma acao de combate
     */
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        Random rand = new Random();
        int indice = rand.nextInt(acoes.size());
        return acoes.get(indice);
    }
}
