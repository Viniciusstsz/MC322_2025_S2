public abstract class Personagem {
    
    //Atributos
    protected String nome;
    protected int pontoDeVida;
    protected int forca;
    protected Arma arma;

    public Personagem(String nome, int pontoDeVida, int forca, Arma arma){
        this.nome=nome;
        this.pontoDeVida=pontoDeVida;
        this.forca=forca;
        this.arma=arma;
    }

//Setters e Getters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontoDeVida() {
        return pontoDeVida;
    }

    public void setPontoDeVida(int pontoDeVida) {
        this.pontoDeVida = pontoDeVida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

//-----métodos-----

    protected int recebeDano(int dano, Personagem atacante){
        System.out.println("[*]"+this.nome+" recebeu "+dano+" de dano.");
        if(dano>=this.pontoDeVida){
            this.pontoDeVida=0;
            System.out.println("!"+this.nome+" foi derrotado por"+atacante.getNome()+"!");
            return 0;
        }
        this.pontoDeVida-=dano;
        return pontoDeVida;
    }

    protected abstract void exibirStatus();

    protected abstract int atacar(Personagem alvo);

}
