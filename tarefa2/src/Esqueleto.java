public class Esqueleto extends Monstro{
    
    public Esqueleto(String nome, int pontoDeVida, int forca, Arma arma, int xpConcedido){
        super(nome, pontoDeVida, forca, arma, xpConcedido);
    }

//-----métodos-----

    @Override
    public int atacar(Personagem alvo){
        System.out.println(">>>"+this.nome+" atacou "+alvo.getNome()+".");
        alvo.recebeDano(forca, this);
        return forca;
    }
    
}

