package app;

import personagens.herois.*;
import personagens.monstros.*;
import itens.*;
import itens.armas.*;
import cenario.*;
import combate.AcaoDeCombate;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== Início do Jogo ==========");
        System.out.println("O guerreiro finalmente atravessou os portões de sua vila,");
        System.out.println("o peso da viagem e da batalha ainda em seus ombros, mas com a sensação de dever cumprido.");
        System.out.println("Ali, encontrou Icarus, seu novo aprendiz, um jovem de olhos curiosos e determinação intensa.");
        System.out.println("");
        System.out.println("Depois de algumas semanas treinando sob a orientação do veterano,");
        System.out.println("Icarus decidiu que era hora de provar sua coragem.");
        System.out.println("Com uma mochila leve e a espada enferrujada do mestre,");
        System.out.println("ele partiu rumo a uma pequena aventura nos arredores da vila,");
        System.out.println("em busca de monstros, tesouros e histórias que um dia contaria ao lado do seu mentor.");
        System.out.println("");
        System.out.println("O guerreiro observou o aprendiz desaparecer na trilha, sentindo orgulho e uma pontada de preocupação.");
        System.out.println("Sabia que ensinar alguém a lutar era também aprender a deixar partir.");
        System.out.println("A estrada estava aberta, e novas histórias começavam a se desenrolar.");
        System.out.println("");

        ConstrutorDeCenariosFixo construtor = new ConstrutorDeCenariosFixo();

        Heroi heroi = new Guerreiro("Icarus", 18, 6, new Espada(1, 1, "Espada enferrujada"), 1, 0, 50, 0.5f, 10);
    
        FaseDeCombate fases[] = construtor.gerar(3, Dificuldade.NORMAL);

        for(int i=0; i<fases.length; i++){
            System.out.println("========== Início da Fase "+(i+1)+" ==========");
            System.out.println("");
            fases[i].iniciar(heroi);

            Monstro inimigos[] = fases[i].getInimigos();
            System.out.println("");
            heroi.exibirStatus();

            for(int j=0; j<inimigos.length; j++){
                Monstro inimigo = inimigos[j];
                System.out.println("");
                System.out.println("!!! "+inimigo.getNome()+" apareceu !!!");
                inimigo.exibirStatus();
                System.out.println("");
                while(inimigo.estaVivo() && heroi.estaVivo()){

                    AcaoDeCombate acao = heroi.escolherAcao(inimigo);
                    acao.executar(heroi, inimigo);

                    if(inimigo.estaVivo()){
                        acao = inimigo.escolherAcao(heroi);
                        acao.executar(inimigo, heroi);
                    } else {
                        System.out.println("");
                    }
                }

                if(heroi.getPontoDeVida() <= 0){
                    System.out.println("");
                    System.out.println("!!! "+heroi.getNome()+" foi derrotado na fase "+fases[i].getTipoDeCenario()+" !!!");
                    heroi.exibirStatus();
                    System.out.println("");
                    System.out.println("========== Fim do Jogo ==========");
                    return;
                }
                System.out.println(inimigo.getNome()+" foi derrotado por "+ heroi.getNome());

                if(inimigo instanceof Lootavel){
                    Item item = inimigo.droparLoot();
                    if(item != null){
                        System.out.println(inimigo.getNome()+ " dropou "+ item.getNome());
                        if(item instanceof Arma){
                            heroi.trocarArma((Arma) item);
                        }
                    } else System.out.println(inimigo.getNome()+ " nao dropou nada");
                }
                int xpConcedido = inimigo.getXpConcedido();
                System.out.println(heroi.getNome()+ " Ganhou +"+xpConcedido+" de experiencia");
                System.out.println("");
                heroi.ganharExperiencia(xpConcedido);
                heroi.exibirStatus();
                System.out.println("");
                
            }
            
            System.out.println("!!! "+heroi.getNome()+" completou a fase "+fases[i].getTipoDeCenario()+" !!!");
            System.out.println("");
            System.out.println("========== Fim da Fase "+(i+1)+" ==========");
            System.out.println("");
        }
        System.out.println("!!! Parabéns! "+heroi.getNome()+" completou todas as fases e se tornou um verdadeiro herói! !!!");
        System.out.println("");        
        System.out.println("========== Fim do Jogo ==========");
    }
}

