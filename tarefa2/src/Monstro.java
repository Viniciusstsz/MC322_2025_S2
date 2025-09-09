public abstract class Monstro extends Personagem{

    private int xpConcedido;
    private Arma listaDeArmasParaLargar[];


    public Monstro(String nome, int pontoDeVida, int forca, Arma arma, int xpConcedido){
        super(nome, pontoDeVida, forca, arma);
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

    protected int recebeDano(int dano, Heroi atacante){

        System.out.println("[*]"+this.nome+" recebeu "+dano+" de dano.");
        
        if(dano>=this.pontoDeVida){
            this.pontoDeVida=0;
            System.out.println("!"+this.nome+" foi derrotado!");
            atacante.ganharExperiencia(this.xpConcedido);
            this.largarArma(atacante);
            return 0;
        }

        this.pontoDeVida-=dano;
        return pontoDeVida;
    }

    private void largarArma(Heroi heroi){

        int numeroDeArmasNaLista=this.listaDeArmasParaLargar.length;
        int indiceDaArmaSorteada=(int)(Math.random()*numeroDeArmasNaLista);

        Arma armaSorteada=this.listaDeArmasParaLargar[indiceDaArmaSorteada];

        System.out.println("~~~"+this.nome+" largou a arma.");
        heroi.trocarArma(armaSorteada);
    }
}