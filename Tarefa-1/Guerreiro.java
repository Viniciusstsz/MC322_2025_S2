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
    public int atacar(Personagem alvo){
        alvo.recebeDano(forca);
        return forca;
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println("O Guerreiro utiliza furia");
    }
}
