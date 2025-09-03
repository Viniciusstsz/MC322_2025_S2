public class Mago extends Heroi{
    
    private int mana;

    public Mago(String nome, int pontoDeVida, int forca, int nivel, int experiencia, int furia ){
        super(nome, pontoDeVida, forca, nivel, experiencia);
        this.mana=mana;
    }
    
//Setters e Getters

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

//-----métodos-----

    @Override
    public int atacar(Personagem personagem){
        personagem.pontoDeVida-=forca;
        return forca;
    }

    public void ganharExperiencia(int incremento){
        this.experiencia+=incremento;
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println("O Mago conjura uma bola de fogo!");
    }

    @Override
    protected void exibirStatus(){
        System.out.println("nome: "+this.nome+" vida:"+this.pontoDeVida+" força:"+this.forca+" experiência:"+this.experiencia+" mana:"+this.mana);
    }
}
