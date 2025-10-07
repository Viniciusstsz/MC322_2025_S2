package itens.armas;

public class ArmaNula extends Arma{
    
    public ArmaNula(){
        super(0, 0, "Sem arma");
    }
    
    @Override
    public String getInformacoes() {
        return "Sem Arma";
    }
}
