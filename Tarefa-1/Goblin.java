public class Goblin extends Monstro{
    
    public Goblin(String nome, int pontoDeVida, int forca, int xpConcedido){
        super(nome, pontoDeVida, forca, xpConcedido);
    }

//-----métodos-----

    @Override
    public int atacar(Personagem alvo){
        alvo.recebeDano(forca);
        return forca;
    }
    
}
