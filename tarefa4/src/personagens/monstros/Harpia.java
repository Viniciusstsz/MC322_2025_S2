package personagens.monstros;

import combate.AtaqueFisico;
import itens.armas.*;;

public class Harpia extends Monstro{
    
    public Harpia(String nome, int pontoDeVida, int forca, Arma arma, int xpConcedido){
        super(nome, pontoDeVida, forca, arma, xpConcedido);
        this.acoes.add(new AtaqueFisico());
    }

//-----métodos-----
    
    public static Harpia gerarHarpia(int nivel){
        Arma armas[] = {
            new ArmaNula(),

            new Adaga(nivel, 1*nivel,"Adaga de ossos"),
            new Adaga(nivel, 2*nivel,"Adaga de bronze" ),
            new Adaga(nivel, 3*nivel,"Adaga de ferro" ),

            new Arco(nivel, 2*nivel,"Arco curto de ossos" ),
            new Arco(nivel, 3*nivel,"Arco curto de bronze" ),
            new Arco(nivel, 4*nivel,"Arco curto de ferro")
        };

        int max = armas.length;
        int sortearArma = (int)(Math.random() * max);
        Arma arma = armas[sortearArma];

        Harpia harpia = new Harpia("Harpia", 8*nivel, 4*nivel, arma, 20*nivel);

        return harpia;
    }

}
