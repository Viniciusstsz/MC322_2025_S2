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
    public void exibirStatus() {
        System.out.println("=== Monstro ===");
        System.out.println(this.nome);
        System.out.println("Vida: "+this.pontoDeVida+"    Força: "+this.forca);
        System.out.println("XP concedido: "+this.xpConcedido);
        System.out.println("");
    }
}
