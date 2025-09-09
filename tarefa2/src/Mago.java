public class Mago extends Heroi{
    
    private int mana;

    public Mago(String nome, int pontoDeVida, int forca, Arma arma, int nivel, int experiencia, int xpProximoNivel, float sorte , int mana ){
        super(nome, pontoDeVida, forca, arma, nivel, experiencia, xpProximoNivel, sorte);
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
        System.out.println(">>>"+this.nome+" lançou um feitiço em "+alvo.getNome()+".");
        alvo.recebeDano(forca, this);
        return forca;
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        System.out.println("O Mago conjura uma bola de fogo!");
        if(this.sorte > 0.5 && this.mana >= 5){
            System.out.println("Acertou o golpe crítico!");
            alvo.recebeDano(forca*2, this);
            this.mana -= 5;
        } else if (this.mana < 5) {
            System.out.println("O Mago está sem mana e não consegue conjurar a bola de fogo.");
        } else{
            System.out.println("A bola de fogo erra o alvo, explodindo no chão próximo a ele.");
            this.recebeDano(forca/5, this);
            this.mana -= 5;
        }
    }
}
