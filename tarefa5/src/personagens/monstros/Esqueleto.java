package personagens.monstros;

import combate.AtaqueFisico;
import itens.armas.*;

public class Esqueleto extends Monstro{
    
    public Esqueleto(String nome, int pontoDeVida, int forca, Arma arma, int xpConcedido){
        super(nome, pontoDeVida, forca, arma, xpConcedido);
        this.acoes.add(new AtaqueFisico());
    }

    private static Arma armas[] = {
        new ArmaNula(),

        new Espada(1, 3,"Espada de ossos" ),
        new Espada(1, 4,"Espada de bronze" ),
        new Espada(1, 5,"Espada de ferro"),

        new Martelo(1, 4,"Martelo de ossos" ),
        new Martelo(1, 5,"Martelo de bronze"),
        new Martelo(1, 6,"Martelo de ferro")
    };

//-----métodos-----
        
        /**
         * Gera um esqueleto aleatorio
         * @param nivel Define os atributos do esqueleto gerado de acordo com multiplicadores definidos
         * @return Retorna o esqueleto
         */
        public static Esqueleto gerarEsqueleto(int nivel){


        int max = armas.length;
        int sortearArma = (int)(Math.random() * max);
        Arma arma = armas[sortearArma];
        arma.setDano(nivel * arma.getDano());
        arma.setMinNivel(nivel);

        Esqueleto Esqueleto = new Esqueleto("Esqueleto", 10*nivel, 6*nivel, arma, 32*nivel);

        return Esqueleto;
    }


}

