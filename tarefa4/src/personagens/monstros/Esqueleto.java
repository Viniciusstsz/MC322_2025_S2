package personagens.monstros;

import combate.AtaqueFisico;
import itens.armas.*;

public class Esqueleto extends Monstro{
    
    public Esqueleto(String nome, int pontoDeVida, int forca, Arma arma, int xpConcedido){
        super(nome, pontoDeVida, forca, arma, xpConcedido);
        this.acoes.add(new AtaqueFisico());
    }

//-----métodos-----
    
        public static Esqueleto gerarEsqueleto(int nivel){
        Arma armas[] = {
            new ArmaNula(),

            new Espada(nivel, 3*nivel,"Espada de ossos" ),
            new Espada(nivel, 4*nivel,"Espada de bronze" ),
            new Espada(nivel, 5*nivel,"Espada de ferro"),

            new Martelo(nivel, 4*nivel,"Martelo de ossos" ),
            new Martelo(nivel, 5*nivel,"Martelo de bronze"),
            new Martelo(nivel, 6*nivel,"Martelo de ferro")
        };

        int max = armas.length;
        int sortearArma = (int)(Math.random() * max);
        Arma arma = armas[sortearArma];

        Esqueleto Esqueleto = new Esqueleto("Esqueleto", 10*nivel, 6*nivel, arma, 32*nivel);

        return Esqueleto;
    }


}

