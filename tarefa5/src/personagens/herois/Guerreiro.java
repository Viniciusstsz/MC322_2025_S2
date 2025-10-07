package personagens.herois;

import java.util.ArrayList;
import java.util.Random;

import combate.*;
import itens.armas.Arma;

public class Guerreiro extends Heroi{
    AcaoDeCombate atqfis = new AtaqueFisico();
    AcaoDeCombate atqfur = new AtaqueComFuria();

    private int furia;

    /**
     * Construtor do guerreiro
     * @param nome Nome
     * @param pontoDeVida Pontos de vida, define a vida maxima
     * @param forca Forca incial
     * @param arma Arma inicial
     * @param nivel Nivel inicial
     * @param experiencia Experiencia inicial
     * @param xpProximoNivel Quantidade de xp necessario para o proximo nivel
     * @param sorte Sorte
     * @param furia Furia inical
     */
    public Guerreiro(String nome, int pontoDeVida, int forca, Arma arma, int nivel, int experiencia, int xpProximoNivel, float sorte, int furia) {
    super(nome, pontoDeVida, forca, arma, nivel, experiencia, xpProximoNivel, sorte);
    this.furia = furia;
    this.acoes = new ArrayList<>();
    this.acoes.add(atqfis);
    this.acoes.add(atqfur);
}
    
//Setters e Getters

    public int getFuria() {
        return furia;
    }

    public void setFuria(int furia) {
        this.furia = furia;
    }

//-----métodos-----

    /**
     * Faz o print das informacoes do guerreiro
     */
    @Override
    public void exibirStatus() {
        System.out.println("[GUERREIRO] "+this.nome+
        " | Vida: "+this.pontoDeVida+"/"+this.vidaMaxima+
        " | Forca: "+this.forca+
        " | Nivel: "+this.nivel+
        " | XP: "+this.experiencia+"/"+this.xpProximoNivel+
        " | Arma: "+this.arma.getInformacoes()+
        " | Sorte: "+this.sorte+
        " | Furia: "+this.furia);
    }

    
    /**
     * Adiciona uma logica na escolha dos ataques
     * Quando esta com pouca vida (e tem furia disponivel) ou com muita furia o guerreiro tenta usar o ataque de furia com mais frequencia
     * Se nao acha furia usa o ataque fisico
     * Se nao entrou nas condicoes, escolhe aleatorio
     */
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        double vidaAtual = (double) this.pontoDeVida / this.vidaMaxima;

        if (vidaAtual < 0.2 || furia > 10 && furia > 0) {
            for (AcaoDeCombate acao : acoes) {
                if (acao instanceof AtaqueComFuria && this.furia > 0) {
                    return acao;
                }
            }
            for (AcaoDeCombate acao : acoes) {
                if (acao instanceof AtaqueFisico) {
                    return acao;
                }
            }
        }

        Random rand = new Random();
        int indice = rand.nextInt(acoes.size());
        return acoes.get(indice);
    }

}