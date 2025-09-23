package personagens.herois;

import java.util.ArrayList;
import java.util.Random;

import combate.*;
import itens.armas.Arma;

public class Guerreiro extends Heroi{

    private int furia;

    public Guerreiro(String nome, int pontoDeVida, int forca, Arma arma, int nivel, int experiencia, int xpProximoNivel, float sorte, int furia) {
    super(nome, pontoDeVida, forca, arma, nivel, experiencia, xpProximoNivel, sorte);
    this.furia = furia;
    this.acoes = new ArrayList<>();
    this.acoes.add(new AtaqueFisico());
    this.acoes.add(new AtaqueComFuria());
}
    
//Setters e Getters

    public int getFuria() {
        return furia;
    }

    public void setFuria(int furia) {
        this.furia = furia;
    }

//-----métodos-----

    // Exibe status do guerreiro 
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

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        double vidaAtual = (double) this.pontoDeVida / this.vidaMaxima;

        if (vidaAtual < 0.5 || furia > 10) {
            // procura ação de furia na lista
            for (AcaoDeCombate acao : acoes) {
                if (acao instanceof AtaqueComFuria && this.furia > 0) {
                    return acao;
                }
            }
            // fallback: se não achou ataque de fúria, tenta físico
            for (AcaoDeCombate acao : acoes) {
                if (acao instanceof AtaqueFisico) {
                    return acao;
                }
            }
        }

        // se não entrou nas condições, escolhe aleatório
        Random rand = new Random();
        int indice = rand.nextInt(acoes.size());
        return acoes.get(indice);
    }

}