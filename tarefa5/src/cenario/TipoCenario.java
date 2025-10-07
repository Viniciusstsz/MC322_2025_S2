package cenario;

import personagens.herois.Heroi;

public enum TipoCenario {
    FAZENDA("O Touro Enfurecido") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("Ambiente: Um celeiro antigo, cercado por pastos verdes, com uma cerca de madeira rangendo.");
        }
    },
    MINA("A Mina Abandonada") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("Ambiente: Um túnel escuro e úmido, com paredes de pedra cobertas de musgo. O som distante de gotejamento de água ecoa pelas cavernas, e há um cheiro de terra molhada no ar.");
        }
    },
    FLORESTA("A Floresta Sombria") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("Ambiente: Uma floresta densa e escura, onde a luz do sol mal penetra através das copas das árvores. O som de folhas farfalhando e galhos quebrando cria uma atmosfera inquietante.");
        }
    };

    private final String descricao;

    TipoCenario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract void aplicarEfeitos(Heroi heroi);
}