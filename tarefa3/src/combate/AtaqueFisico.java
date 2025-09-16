package combate;

public class AtaqueFisico implements AcaoDeCombate {
    @Override
    public void executar(Combatente atacante, Combatente alvo){
        int dano = atacante.getForca() + atacante.getArma().getDano();
        dano = alvo.receberDano(dano, atacante);
        System.out.println(atacante.getNome() + " realizou um ataque físico em " + alvo.getNome() + " causando " + dano + " de dano.");
    }
}
