public abstract class Arma {
    private int minNivel;
    private int dano;


    public Arma(int minNivel,int dano){
        this.minNivel=minNivel;
        this.dano=dano;
    }

//Setters e Getters

    public int getMinNivel() {
        return minNivel;
    }

    public void setMinNivel(int minNivel) {
        this.minNivel = minNivel;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
}
