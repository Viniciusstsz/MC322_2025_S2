public class Harpia extends Monstro{
    
    public Harpia(String nome, int pontoDeVida, int forca, int xpConcedido){
        super(nome, pontoDeVida, forca, xpConcedido);
    }

//-----métodos-----

    @Override
    public int atacar(Personagem alvo){
        alvo.recebeDano(forca);
        return forca;
    }
    
}
