public abstract class Heroi extends Personagem{
    
    protected int nivel;
    protected int experiencia;
    protected int xpProximoNivel;
    protected float sorte;

    public Heroi(String nome, int pontoDeVida, int forca, Arma arma, int nivel, int experiencia, int xpProximoNivel, float sorte){
        super(nome, pontoDeVida, forca, arma);
        this.nivel=nivel;
        this.experiencia=experiencia;
        this.xpProximoNivel=xpProximoNivel;
        this.sorte=sorte;
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

    public int getXpProximoNivel() {
        return xpProximoNivel;
    }

    public void setXpProximoNivel(int xpProximoNivel) {
        this.xpProximoNivel = xpProximoNivel;
    }

    public float getSorte() {
        return sorte;
    }

    public void setSorte(float sorte) {
        this.sorte = sorte;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }


//-----métodos-----

    public void ganharExperiencia(int incremento){
        System.out.println("***"+this.nome+" ganhou "+incremento+" de experiência.");
        this.experiencia+=incremento;
        subirDeNivel();
    }

    public abstract void usarHabilidadeEspecial(Personagem alvo);

    @Override
    public void exibirStatus() {
        System.out.println("=== Héroi ===");
        System.out.println(this.nome);
        System.out.println("Vida: "+this.pontoDeVida+"    Força: "+this.forca);
        System.out.println("Nível: "+this.nivel+"    XP: "+this.experiencia);
        System.out.println("");
    }

    private void subirDeNivel(){
        this.xpProximoNivel = (int) (25 * (Math.pow(2, this.nivel)));
        if(this.experiencia < xpProximoNivel){
            return;
        }
        this.experiencia -= xpProximoNivel;
        this.nivel++;
        this.forca += 3;
        this.pontoDeVida = this.nivel * 5 + 25;
        System.out.println("");
        System.out.println("!!!"+this.nome+" subiu para o nível "+this.nivel+"!!!");
        System.out.println("+++"+this.nome+" ganhou 3 de força, 5 de vida e recuperou toda a vida.");
        System.out.println("");
    }
    
    public void trocarArma(Arma novaArma){
        if(novaArma.getDano() <= this.arma.getDano()){
            System.out.println("^^^"+this.nome+" tentou trocar a arma, mas a nova arma é pior que a atual.");
            return;
        }
        System.out.println("~~~"+this.nome+" trocou de arma.");
        this.arma=novaArma;
    }

}
