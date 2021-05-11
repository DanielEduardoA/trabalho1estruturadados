public class EstrategiaJogo {

    public Jogada decidirJogada(ListaDuplamenteEncadeada mao, Mesa mesa) {
        if (mesa.getNumPecas() == 0) {
            return new Jogada(mao.buscarPorPosicao(0).getPeca(), TipoJogada.NA_DIREITA);
        }

        for (int i = 0; i < mao.getQuantidade() - 1; i++) {
            Peca peca = mao.buscarPorPosicao(i).getPeca();
            if (peca.encaixa(mesa.getNumNaDireita())) {
                return new Jogada(peca, TipoJogada.NA_DIREITA);
            }
            if (peca.encaixa(mesa.getNumNaEsquerda())) {
                return new Jogada(peca, TipoJogada.NA_ESQUERDA);
            }
        }

        return new Jogada();
    }

    public boolean verificarPecaEncaixa(Peca peca, Mesa mesa) {
        if (mesa.estaVazia()) {
            return true;
        } else {
            return peca.encaixa(mesa.getNumNaDireita()) || peca.encaixa(mesa.getNumNaEsquerda());
        }
    }
}
