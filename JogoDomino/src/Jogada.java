public class Jogada {

    private Peca peca;
    private TipoJogada tipo;

    public Jogada(Peca peca, TipoJogada tipo) {
        this.peca = peca;
        this.tipo = tipo;
    }
    
    public Jogada(TipoJogada tipo) {
        this.tipo = tipo;
    }

    public Jogada() {
        this(null, TipoJogada.PASSA);
    }

    public TipoJogada getTipo() {
        return tipo;
    }

    public Peca getPeca() {
        return peca;
    }

    @Override
    public String toString() {
        String jogada = "";
        if (this.tipo.equals(TipoJogada.PASSA) || this.tipo.equals(TipoJogada.INVALIDA)) {
            jogada = this.getTipoEmString();
        } else {
            jogada = peca.toString() + " " + this.getTipoEmString();
        }

        return jogada;
    }

    private String getTipoEmString() {
        switch (tipo) {
            case PASSA: {
                return "Passou";
            }
            case NA_DIREITA: {
                return "na direita";
            }
            case NA_ESQUERDA: {
                return "na esquerda";
            }
            case INVALIDA: {
                return "Jogada inválida";
            }
            default: {
                return null;
            }
        }
    }
}