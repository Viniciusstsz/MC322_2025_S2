public class Mago extends Heroi{
    
    private int mana;

    public Mago(String nome, int pontoDeVida, int forca, int nivel, int experiencia, int mana ){
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
    public int atacar(Personagem alvo){
        alvo.recebeDano(forca);
        return forca;
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println("O Mago conjura uma bola de fogo!");
    }
}
