public abstract class Monstro extends Personagem{

    protected int xpConcedido;

    public Monstro(String nome, int pontoDeVida, int forca, int xpConcedido){
        super(nome, pontoDeVida, forca);
        this.xpConcedido=xpConcedido;
    }

//Setters e Getters

    public int getXpConcedido() {
        return xpConcedido;
    }

    public void setXpConcedido(int xpConcedido) {
        this.xpConcedido = xpConcedido;
    }

//-----métodos-----

    @Override
    public String exibirStatus() {
        return "nome"+this.nome+"vida"+this.pontoDeVida;
    }

}