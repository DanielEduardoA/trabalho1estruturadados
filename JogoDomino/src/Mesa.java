public class Mesa {

    public static final int SEM_PECA = -1;

    private ListaDuplamenteEncadeada pecas;

    public Mesa() {
        pecas = new ListaDuplamenteEncadeada();
    }


    public ListaDuplamenteEncadeada jogarDireita(Peca peca) {
        Peca temp = new Peca(peca.getNumEsquerdo(), peca.getNumDireito());
        if (estaVazia()) {
            pecas.adicionarFim(peca);
        } else {
            if (peca.getNumEsquerdo() != getNumNaDireita()) {
                temp.setNumEsquerdo(peca.getNumDireito());
                temp.setNumDireito(peca.getNumEsquerdo());
            }

            if (temp.getNumEsquerdo() == getNumNaDireita()) {
                pecas.adicionarFim(temp);
            }
        }
        return pecas;
    }

    public ListaDuplamenteEncadeada jogarEsquerda(Peca peca) {
        Peca temp = new Peca(peca.getNumEsquerdo(), peca.getNumDireito());
        if (estaVazia()) {
            pecas.adicionarInicio(peca);
        } else {
            if (peca.getNumDireito() != getNumNaEsquerda()) {
                temp.setNumEsquerdo(peca.getNumDireito());
                temp.setNumDireito(peca.getNumEsquerdo());
            }

            if (temp.getNumDireito() == getNumNaEsquerda()) {
                pecas.adicionarInicio(temp);
            }
        }
        return pecas;
    }
    
    public boolean estaVazia() {
        return getNumPecas() == 0;
    }

    public ListaDuplamenteEncadeada getPecas() {
        return pecas;
    }

    public void setPecas(ListaDuplamenteEncadeada pecas) {
        this.pecas = pecas;
    }
    
    public int getNumPecas() {
        return pecas.getQuantidade();
    }

    public int getNumNaDireita() {
        return pecas.estaVazio() ? SEM_PECA : pecas.getUltimo().getPeca().getNumDireito();
    }

    public int getNumNaEsquerda() {
        return pecas.estaVazio() ? SEM_PECA : pecas.getPrimeiro().getPeca().getNumEsquerdo();
    }

}