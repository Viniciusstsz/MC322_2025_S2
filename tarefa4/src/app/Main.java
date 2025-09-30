package app;

import personagens.herois.*;
import personagens.monstros.*;
import itens.*;
import itens.armas.*;
import cenario.*;
import combate.AcaoDeCombate;

public class Main {
    public static void main(String[] args) {

        MenuPrincipal.menuPrincipal();

        int escolha = InputManager.lerInteiro("Digite sua escolha > ",1,2);

        if(escolha == 1){
            int dificuldade = InputManager.lerInteiro("Escolha uma Dificuldade:\n"+
            "[1] Facil\n"+
            "[2] Normal\n"+
            "[3] Dificil\n"+
            "Digite sua escolha > ", 1, 3);
        
            Heroi heroi = new Guerreiro("Icarus", 18, 6, new Espada(1, 1, "Espada enferrujada"), 1, 0, 50, 0.5f, 10);
        
            Dificuldade D = Dificuldade.NORMAL;
            
            if(dificuldade == 1) D = Dificuldade.FACIL;
            if(dificuldade == 3) D = Dificuldade.DIFICil;

            int quantidadeFases = InputManager.lerInteiro("Quantas fases deseja?\n", 1, 10);

            ConstrutorDeCenariosFixo construtor = new ConstrutorDeCenariosFixo();
            FaseDeCombate fases[] = construtor.gerar(quantidadeFases,D);

            for(int i=0; i<fases.length; i++){
                System.out.println("========== Início da Fase "+(i+1)+" ==========");
                System.out.println("");
                fases[i].iniciar(heroi);

                Monstro inimigos[] = fases[i].getInimigos();
                System.out.println("");

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

                    int xpConcedido = inimigo.getXpConcedido();
                    System.out.println(heroi.getNome()+ " Ganhou +"+xpConcedido+" de experiencia");
                    System.out.println("");
                    heroi.ganharExperiencia(xpConcedido);

                    boolean coletouLoot = false;
                    while (true) {

                        escolha = InputManager.lerInteiro("\nO que deseja fazer?\n"+
                        "[1] Coletar loot\n"+
                        "[2] Exibir status do Heroi\n"+
                        "[3] Continuar o jogo\n"+
                        "[4] Fechar o jogo\n"
                        , 1, 4);
                        if(escolha == 1){
                            if(coletouLoot == true){
                                System.out.println("Já coletou o loot");
                            }
                            else {
                                coletouLoot = true;
                                Item item = inimigo.droparLoot();
                                if(item != null){
                                    System.out.println(inimigo.getNome()+ " dropou "+ item.getNome());
                                    if(item instanceof Arma){
                                        heroi.trocarArma((Arma) item);
                                    }
                                } else System.out.println(inimigo.getNome()+ " nao dropou nada");
                            }
                            
                        }
                        
                        if(escolha == 2){
                            heroi.exibirStatus();
                        }

                        if(escolha == 3){
                            break;
                        }

                        if(escolha == 4){
                            System.out.println("========== Fim do Jogo ==========");
                            return;
                        }
                    };
                    
                    System.out.println("");
                    
                }
                
                System.out.println("!!! "+heroi.getNome()+" completou a fase "+fases[i].getTipoDeCenario()+" !!!");
                System.out.println("");
                System.out.println("========== Fim da Fase "+(i+1)+" ==========");
                System.out.println("");
            }
            System.out.println("!!! Parabéns! "+heroi.getNome()+" completou todas as fases e se tornou um verdadeiro herói! !!!");
            System.out.println("");        
        }
        System.out.println("========== Fim do Jogo ==========");
    }
}

