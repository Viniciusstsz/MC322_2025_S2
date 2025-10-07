package personagens;

import itens.armas.Arma;
import combate.AcaoDeCombate;
import combate.Combatente;


/**
 * Classe base para Herois e Monstros
 */
public abstract class Personagem implements Combatente {
    
    //Atributos
    protected String nome;
    protected int pontoDeVida;
    protected int forca;
    protected Arma arma;
    protected int vidaMaxima;

    /**
     * Construtor de personagem
     * @param nome Nome do personagem
     * @param pontoDeVida Quantidade de vida do personagem, define tambem a vida maxima do personagem
     * @param forca Forca do personagem
     * @param arma Arma do personagem
     */
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

    /**
     * Reduz os pontos de vida do personagem de acordo com um dano sofrido, impede que a vida chegue a zero
     * @param dano Dano que o atacante pode causar
     * @param atacante Combatente que atacou o personagem
     * @return retorna o dano que o personagem sofreu
     */
    public int receberDano(int dano, Combatente atacante){
        this.pontoDeVida-=dano;

        if(this.pontoDeVida <= 0){
            this.pontoDeVida=0;
            return dano;
        }
        return dano;
    }

    /**
     * Verifica se o personagem esta vivo
     * @return true se os pontos de vida forem > 0, e false caso contrario
     */
    public boolean estaVivo(){
        return this.pontoDeVida > 0;
    }

    /**
     * Faz o print das informacoes do personagem
     */
    public void exibirStatus(){
        System.out.println("");
        System.out.println("[PERSONAGEM] "+this.nome+
        " | Vida: "+this.pontoDeVida+"/"+this.vidaMaxima+
        " | Forca: "+this.forca+
        " | Arma: "+this.arma.getInformacoes());
        System.out.println("");
    }

    public abstract AcaoDeCombate escolherAcao(Combatente alvo);

    /**
     * Aumenta a vida do personagem de acordo com uma cura recebida
     * garante que os pontos de vida não passem da vida maxima
     */
    public int receberCura(int cura){
        pontoDeVida += cura;
        if(pontoDeVida > vidaMaxima){
            pontoDeVida = vidaMaxima;
        }
        return pontoDeVida;
    }
}
