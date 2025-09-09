public class Fase {
    
    private int nivel;
    private String ambiente;
    private Monstro Inimigos[];

    public Fase(int nivel, String ambiente, Monstro inimigos[]){
        this.nivel=nivel;
        this.ambiente=ambiente;
        this.Inimigos=inimigos;
    }
}
