package personagens.monstros;

import combate.AtaqueFisico;
import itens.armas.*;

public class Goblin extends Monstro{
    
    public Goblin(String nome, int pontoDeVida, int forca, Arma arma, int xpConcedido){
        super(nome, pontoDeVida, forca, arma, xpConcedido);
        this.acoes.add(new AtaqueFisico());        
    }

//-----métodos-----
    
    public static Goblin gerarGoblin(int nivel){
        Arma armas[] = {
            new ArmaNula(),

            new Adaga(nivel, 1*nivel,"Adaga de ossos"),
            new Adaga(nivel, 2*nivel,"Adaga de bronze" ),
            new Adaga(nivel, 3*nivel,"Adaga de ferro" ),

            new Espada(nivel, 2*nivel,"Espada curta de ossos" ),
            new Espada(nivel, 3*nivel,"Espada curta de bronze" ),
            new Espada(nivel, 4*nivel,"Espada curta de ferro")
        };

        int max = armas.length;
        int sortearArma = (int)(Math.random() * max);
        Arma arma = armas[sortearArma];

        Goblin goblin = new Goblin("Goblin", 6*nivel, 2*nivel, arma, 16*nivel);

        return goblin;
    }


}
