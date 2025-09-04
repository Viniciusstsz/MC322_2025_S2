public class Esqueleto extends Monstro{
    
    public Esqueleto(String nome, int pontoDeVida, int forca, int xpConcedido){
        super(nome, pontoDeVida, forca, xpConcedido);
    }

//-----métodos-----

    @Override
    public int atacar(Personagem alvo){
        alvo.recebeDano(forca);
        return forca;
    }
    
}
