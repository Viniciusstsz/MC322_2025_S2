package combate;

import personagens.herois.Guerreiro;

public class AtaqueComFuria implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (usuario instanceof Guerreiro) {
            Guerreiro guerreiro = (Guerreiro) usuario;
            if(guerreiro.getFuria() > 0){
                int furia = guerreiro.getFuria()-1;
                guerreiro.setFuria(furia);

                int dano = (int) ((guerreiro.getForca() + guerreiro.getArma().getDano())*1.3);
                dano = alvo.receberDano(dano, guerreiro);

                System.out.println(guerreiro.getNome() + " usou ataque com furia em " + alvo.getNome() +
                   " causando " + dano + " de dano! (Furia: " + guerreiro.getFuria() + ")");
            } else {
                System.out.println(guerreiro.getNome()+" nao pode usar ataque com furia!");
            }
        } else {
            System.out.println("Este ataque pode ser usado apenas por guerreiros!");
        }
    }
}