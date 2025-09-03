public class Guerreiro extends Heroi{

    private int furia;

    public Guerreiro(String nome, int pontoDeVida, int forca, int nivel, int experiencia, int furia ){
        super(nome, pontoDeVida, forca, nivel, experiencia);
        this.furia=furia;
    }
    
//Setters e Getters

    public int getFuria() {
        return furia;
    }

    public void setFuria(int furia) {
        this.furia = furia;
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
        System.out.println("O guerreiro utiliza furia");
    }

    @Override
    protected void exibirStatus(){
        System.out.println("nome: "+this.nome+" vida:"+this.pontoDeVida+" força:"+this.forca+" experiência:"+this.experiencia+" furia:"+this.furia);
    }
}