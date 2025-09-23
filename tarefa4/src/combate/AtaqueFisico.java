package combate;

import personagens.herois.Guerreiro;

public class AtaqueFisico implements AcaoDeCombate {

    @Override
    public void executar(Combatente atacante, Combatente alvo){
        int dano = atacante.getForca() + atacante.getArma().getDano();
        dano = alvo.receberDano(dano, atacante);
        System.out.println(atacante.getNome() + " realizou um ataque físico em " + alvo.getNome() + " causando " + dano + " de dano.");
        if(atacante instanceof Guerreiro){
            Guerreiro guerreiro = (Guerreiro) atacante;
            int furia = guerreiro.getFuria() +1;
            guerreiro.setFuria(furia);
            System.out.println(guerreiro.getNome() + " ganhou +1 de furia! (Furia atual: " + guerreiro.getFuria() + ")");
        }
    }
}
