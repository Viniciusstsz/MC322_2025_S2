public abstract class Personagem {
    
    //Atributos
    protected String nome;
    protected int pontoDeVida;
    protected int forca;

    public Personagem(String nome, int pontoDeVida, int forca){
        this.nome=nome;
        this.pontoDeVida=pontoDeVida;
        this.forca=forca;
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

    protected int recebeDano(int dano){
        this.pontoDeVida-=dano;
        return pontoDeVida;
    }

    protected String exibirStatus(){
        return "nome"+this.nome+"vida"+this.pontoDeVida;
    }

    protected abstract int atacar(Personagem personagem);

}
