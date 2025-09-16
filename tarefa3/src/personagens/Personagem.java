package personagens;

import itens.armas.Arma;
import combate.AcaoDeCombate;
import combate.Combatente;

public abstract class Personagem implements Combatente {
    
    //Atributos
    protected String nome;
    protected int pontoDeVida;
    protected int forca;
    protected Arma arma;
    protected int vidaMaxima;

    public Personagem(String nome, int pontoDeVida, int forca, Arma arma){
        this.nome=nome;
        this.pontoDeVida=pontoDeVida;
        this.forca=forca;
        this.arma=arma;
        this.vidaMaxima=pontoDeVida;
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

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

//-----métodos-----

    @Override
    public int receberDano(int dano, Combatente atacante){
        this.pontoDeVida-=dano;
        System.out.println("[*]"+this.nome+" recebeu "+dano+" de dano.");

        if(this.pontoDeVida <= 0){
            this.pontoDeVida=0;
            System.out.println("!"+this.nome+" foi derrotado por "+atacante.getNome()+"!");
            return dano;
        }
        this.pontoDeVida-=dano;
        return dano;
    }

    public boolean estaVivo(){
        return this.pontoDeVida > 0;
    }

    public void exibirStatus(){
        System.out.println("");
        System.out.println("[PERSONAGEM] "+this.nome+" | Vida: "+this.pontoDeVida+" | Forca: "+this.forca+" | Arma: "+this.arma.getNome());
        System.out.println("");
    }

    protected abstract int atacar(Personagem alvo);

    public abstract AcaoDeCombate escolherAcao(Combatente alvo);

    public int receberCura(int cura){
        pontoDeVida += cura;
        if(pontoDeVida > vidaMaxima){
            pontoDeVida = vidaMaxima;
        }
        return pontoDeVida;
    }
}
