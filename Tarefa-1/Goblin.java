public class Goblin extends Monstro{
    
    public Goblin(String nome, int pontoDeVida, int forca, int xpConcedido){
        super(nome, pontoDeVida, forca, xpConcedido);
    }

//-----métodos-----

    @Override
    public int atacar(Personagem personagem){
        personagem.pontoDeVida-=forca;
        return forca;
    }
    
    @Override
    protected void exibirStatus(){
        System.out.println("nome: "+this.nome+" vida:"+this.pontoDeVida+" força:"+this.forca+" XP concedido:"+this.xpConcedido);
    }
}
