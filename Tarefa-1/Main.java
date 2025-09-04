public class Main{

    public static void main(String[] args) {
        
    //-----Inicialização dos personagens-----
    
        //Criar um heroi

        Guerreiro Guerreiro_Aposentado = new Guerreiro("Guerreiro Aposentado", 200, 30, 25, 0, 7);

        //Criar três monstros

        Goblin goblin = new Goblin("Goblin", 40, 10, 15);
        Esqueleto esqueleto = new Esqueleto("Esqueleto", 50, 15, 30);
        Harpia harpia = new Harpia("Harpia", 70, 12, 40);

        Monstro[] monstros = {goblin, esqueleto, harpia};

    //-----Inicia-se o desafio-----

        //Mensagem inicial

        System.out.println("=====================================");
        System.out.println(
            "Um guerreiro renomado, exausto das festas intermináveis da capital,\n" +
            "retorna à sua vila natal após derrotar o temível lobo Fenrir.\n" +
            "Em busca apenas de paz, ele segue seu caminho… mas no percurso,\n" +
            "inimigos inesperados surgem, obrigando-o a lutar mais uma vez antes de finalmente chegar em casa."
        );
        System.out.println("=====================================");

        //Mostrar status do heroi

        Guerreiro_Aposentado.exibirStatus();

    //-----Turnos de combate-----

        //loop de combate com cada monstro

        for(Monstro monstro : monstros) {
            System.out.println("!!! Um "+monstro.getNome()+" aparece na estrada !!!");

            //loop de turnos
            while(Guerreiro_Aposentado.getPontoDeVida()>0 && monstro.getPontoDeVida()>0) {
                
                //turno do heroi
                Guerreiro_Aposentado.atacar(monstro);
                System.out.println(">>> "+Guerreiro_Aposentado.getNome()+" atacou o "+monstro.getNome()+" e causou "+Guerreiro_Aposentado.getForca()+" de dano.");
                
                if(monstro.getPontoDeVida()<=0){
                    System.out.println("[*] "+monstro.getNome()+" foi derrotado!");
                    Guerreiro_Aposentado.ganharExperiencia(monstro.xpConcedido);
                    System.out.println("*** "+Guerreiro_Aposentado.getNome()+" ganhou "+monstro.xpConcedido+" pontos de experiência.");
                    break;
                }

                //turno do monstro
                monstro.atacar(Guerreiro_Aposentado);
                System.out.println("--> "+monstro.getNome()+" atacou "+Guerreiro_Aposentado.getNome()+" e causou "+monstro.getForca()+" de dano.");
                
            }

            monstro.exibirStatus();
            Guerreiro_Aposentado.exibirStatus();

            //Verifica se o heroi foi derrotado
            if(Guerreiro_Aposentado.getPontoDeVida()<=0){
                break;
            }

        }

    //-----Mensagem final-----

        if (Guerreiro_Aposentado.getPontoDeVida() > 0) {
            System.out.println("========================================");
            System.out.println("Todos os inimigos foram derrotados.");
            System.out.println("Pode seguir o caminho para a vila natal.");
            System.out.println("========================================");
        } else {
            System.out.println("========================================");
            System.out.println("!!! " + Guerreiro_Aposentado.getNome() + " CAIU !!!");
            System.out.println("Derrotado em sua jornada de volta para casa...");
            System.out.println("========================================");
        }

    }
}
