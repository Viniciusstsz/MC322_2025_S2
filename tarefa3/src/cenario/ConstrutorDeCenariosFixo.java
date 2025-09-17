package cenario;

import java.util.Random;

import itens.armas.*;
import personagens.monstros.*;

public class ConstrutorDeCenariosFixo implements GeradorDeFases {

//-----métodos-----

    public FaseDeCombate[] gerar(int numeroDeFases){
        FaseDeCombate fases[] = new FaseDeCombate[numeroDeFases];
        for(int i=0; i<numeroDeFases; i++){
            int nivel = i+1;
            fases[i] = faseAleatoria(nivel);
        }
        return fases;
    }

    private static FaseDeCombate faseAleatoria(int nivel){ 

        Random rand = new Random();
        int sortearFase = rand.nextInt(3);

        switch(sortearFase){
            case 1: return gerarFazenda(nivel);
            case 2: return gerarFloresta(nivel);
            default: return gerarMina(nivel);
        }
    }

    private static FaseDeCombate gerarFazenda(int nivel){

        Monstro inimigos[] = new Monstro[1];
        inimigos[0] = new Touro("Touro Enfurecido", 16*nivel, 5*nivel, new ArmaNula(), 42*nivel);
        
        FaseDeCombate fazenda = new FaseDeCombate(TipoCenario.FAZENDA ,nivel, inimigos);
        return fazenda;
    }

    private static FaseDeCombate gerarMina(int nivel){
        int min = 2;
        int max = 5;
        int n = (int)(Math.random() * (max - min + 1)) + min;

        Monstro inimigos[] = new Monstro[nivel*n];
        for(int i=0; i<inimigos.length; i++){

        min = 1;
        max = 2;
        int sortearMonstro = (int)(Math.random() * (max - min + 1)) + min;
            switch (sortearMonstro) {
                case 1:
                    inimigos[i] = Esqueleto.gerarEsqueleto(nivel);
                    break;
                default:
                    inimigos[i] = Goblin.gerarGoblin(nivel);
                    break;
            }
        }
        
        FaseDeCombate mina = new FaseDeCombate(TipoCenario.MINA, nivel, inimigos);
        return mina;
    }

    private static FaseDeCombate gerarFloresta(int nivel){
        int min = 2;
        int max = 5;
        int n = (int)(Math.random() * (max - min + 1)) + min;
        
        Monstro inimigos[] = new Monstro[nivel*n];
        for(int i=0; i<inimigos.length; i++){
        min = 1;
        max = 2;
        int sortearMonstro = (int)(Math.random() * (max - min + 1)) + min;
            switch (sortearMonstro) {
                case 1:
                    inimigos[i] = Harpia.gerarHarpia(nivel);
                    break;
                default:
                    inimigos[i] = Goblin.gerarGoblin(nivel);
                    break;
            }
        }
        
        FaseDeCombate floresta = new FaseDeCombate(TipoCenario.FLORESTA, nivel, inimigos);
        return floresta;
    }

}
