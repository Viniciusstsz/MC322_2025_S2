public class Main {
    
//-----Inicialização dos personagens-----

    //Criar um heroi

    Guerreiro Guerreiro_Aposentado = new Guerreiro("Guerreiro Aposentado", 100, 20, 1, 0, 3);

    //Criar três monstros

    Goblin goblin = new Goblin("Goblin", 50, 10, 20);
    Esqueleto esqueleto = new Esqueleto("Esqueleto", 60, 15, 30);
    Harpia harpia = new Harpia("Harpia", 70, 12, 25);

//-----Inicia-se o desafio-----

    //Mensagem inicial

    System.out.println("Um guerreiro renomado, cansado das celebrações intermináveis da capital, parte rumo à sua vila natal após abater o lobo Fenrir. No caminho de volta, buscando apenas paz, encontra inimigos que o forçam a lutar mais uma vez antes de chegar em casa.");

    //Mostrar status do heroi

    Guerreiro_Aposentado.exibirStatus();

//-----Turnos de combate-----

    //loop dos três monstros

        //loop de combate com goblin

            System.out.println("Um "+goblin.getNome()+" aparece na estrada!");

            while(Guerreiro_Aposentado.getPontoDeVida()>0 && goblin.getPontoDeVida()>0) {
                
            
            //turno do heroi
            Guerreiro_Aposentado.atacar(goblin);
            System.out.println(Guerreiro_Aposentado.getNome()+" atacou o "+goblin.getNome()+" e causou "+Guerreiro_Aposentado.getForca()+" de dano.");
            
            if(goblin.getPontoDeVida()<=0){
                System.out.println(goblin.getNome()+" foi derrotado!");
                Guerreiro_Aposentado.ganharExperiencia(goblin.xpConcedido);
                System.out.println(Guerreiro_Aposentado.getNome()+" ganhou "+goblin.xpConcedido+" pontos de experiência.");
                break;
            }

            goblin.exibirStatus();

            //turno do monstro
            goblin.atacar(Guerreiro_Aposentado);
            System.out.println(goblin.getNome()+" atacou "+Guerreiro_Aposentado.getNome()+" e causou "+goblin.getForca()+" de dano.");
            
            if(Guerreiro_Aposentado.getPontoDeVida()<=0){
                System.out.println(Guerreiro_Aposentado.getNome()+" foi derrotado!");
                break;
            }
            Guerreiro_Aposentado.exibirStatus();
            
        }

        //loop de combate com esqueleto

            System.out.println("Um "+esqueleto.getNome()+" aparece na estrada!");

            while(Guerreiro_Aposentado.getPontoDeVida()>0 && esqueleto.getPontoDeVida()>0) {
            
            //turno do heroi
            Guerreiro_Aposentado.atacar(esqueleto);
            System.out.println(Guerreiro_Aposentado.getNome()+" atacou o "+esqueleto.getNome()+" e causou "+Guerreiro_Aposentado.getForca()+" de dano.");
            
            if(esqueleto.getPontoDeVida()<=0){
                System.out.println(esqueleto.getNome()+" foi derrotado!");
                Guerreiro_Aposentado.ganharExperiencia(esqueleto.xpConcedido);
                System.out.println(Guerreiro_Aposentado.getNome()+" ganhou "+esqueleto.xpConcedido+" pontos de experiência.");
                break;
            }

            esqueleto.exibirStatus();

            //turno do monstro
            esqueleto.atacar(Guerreiro_Aposentado);
            System.out.println(esqueleto.getNome()+" atacou "+Guerreiro_Aposentado.getNome()+" e causou "+esqueleto.getForca()+" de dano.");
            
            if(Guerreiro_Aposentado.getPontoDeVida()<=0){
                System.out.println(Guerreiro_Aposentado.getNome()+" foi derrotado!");
                break;
            }
            Guerreiro_Aposentado.exibirStatus();
        }

        //loop de combate com harpia

            System.out.println("Uma "+harpia.getNome()+" aparece na estrada!");

            while(Guerreiro_Aposentado.getPontoDeVida()>0 && harpia.getPontoDeVida()>0) {
            
            //turno do heroi
            Guerreiro_Aposentado.atacar(harpia);
            System.out.println(Guerreiro_Aposentado.getNome()+" atacou a "+harpia.getNome()+" e causou "+Guerreiro_Aposentado.getForca()+" de dano.");
            
            if(harpia.getPontoDeVida()<=0){
                System.out.println(harpia.getNome()+" foi derrotada!");
                Guerreiro_Aposentado.ganharExperiencia(harpia.xpConcedido);
                System.out.println(Guerreiro_Aposentado.getNome()+" ganhou "+harpia.xpConcedido+" pontos de experiência.");
                break;
            }

            harpia.exibirStatus();

            //turno do monstro
            harpia.atacar(Guerreiro_Aposentado);
            System.out.println(harpia.getNome()+" atacou "+Guerreiro_Aposentado.getNome()+" e causou "+harpia.getForca()+" de dano.");
            
            if(Guerreiro_Aposentado.getPontoDeVida()<=0){
                System.out.println(Guerreiro_Aposentado.getNome()+" foi derrotado!");
                break;
            }
            Guerreiro_Aposentado.exibirStatus();
        }

//-----Mensagem de vitória-----

        if(Guerreiro_Aposentado.getPontoDeVida()>0){
            Guerreiro_Aposentado.exibirStatus();
            System.out.println(Guerreiro_Aposentado.getNome()+" derrotou todos os inimigos e pode continuar o caminho à sua vila natal.");
        }  else {
            System.out.println(Guerreiro_Aposentado.getNome()+" foi derrotado em sua jornada de volta para casa.");
        }

}
