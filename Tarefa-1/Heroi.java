public abstract class Heroi extends Personagem{
    
    protected int nivel;
    protected int experiencia;

    public Heroi(String nome, int pontoDeVida, int forca, int nivel, int experiencia){
        super(nome, pontoDeVida, forca);
        this.nivel=nivel;
        this.experiencia=experiencia;
    }

//Setters e Getters

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

//-----métodos-----

    public void ganharExperiencia(int incremento){
        this.experiencia+=incremento;
    }

    public abstract void usarHabilidadeEspecial();


}
