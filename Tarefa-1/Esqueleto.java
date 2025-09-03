public class Esqueleto extends Monstro{
    
    public Esqueleto(String nome, int pontoDeVida, int forca, int xpConcedido){
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

