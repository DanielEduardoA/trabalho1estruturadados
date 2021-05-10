public class ListaDuplamenteEncadeada {

    No primeiro, ultimo;
    int quantidade;

    public ListaDuplamenteEncadeada() {
        primeiro = ultimo = null;
        quantidade = 0;
    }

    public void addInicio(Peca peca) {
        No no = new No(null, primeiro, peca);
        if (primeiro == null)
            primeiro = ultimo = no;
        else {
            primeiro.setAnterior(primeiro);
            primeiro = no;
        }
        quantidade++;
    }

    public void addFim(Peca peca) {
        No no = new No(primeiro, null, peca);
        if (primeiro == null)
            primeiro = ultimo = no;
        else {
            ultimo.setProximo(no);
            ultimo = no;
        }
        quantidade++;
    }

    public No buscarPorPosicao(int posicao) {
        if (posicao < 0 || posicao >= quantidade) {
            return null;
        }

        if (posicao == 0) {
            return this.primeiro;
        } else if (posicao == this.quantidade - 1) {
            return this.ultimo;
        } else {
            No aux = primeiro;
            for (int i = 0; i < posicao; i++) {
                aux = aux.getProximo();
            }
            return aux;
        }
    }

    public boolean contem(Peca peca) {
        int posicao = pegarPosicaoNo(peca);

        if (posicao == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean estaVazio() {
        if (quantidade == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        No aux = primeiro;
        for (int i = 0; i < quantidade; i++) {
            stringBuilder.append(aux.getPeca().toString());
            stringBuilder.append(" ");
            aux = aux.getProximo();
        }
        return stringBuilder.toString();
    }

    public int pegarPosicaoNo(Peca peca) {
        if (peca.equals(primeiro.getPeca())) {
            return 0;
        } else if (peca.equals(ultimo.getPeca())) {
            return quantidade - 1;
        } else {
            No aux = primeiro;
            for (int i = 0; i < quantidade - 1; i++) {
                if (peca.equals(aux.getPeca())) {
                    return i + 1;
                }
                aux = aux.getProximo();
            }
        }

        return -1;
    }

    public void removeLista(Peca peca) {
        No temp = primeiro;
        No anterior = null;

        if (primeiro.getPeca().equals(peca)) {
            primeiro = primeiro.getProximo();
        } else {
            while (temp != null && !temp.getPeca().equals(peca)) {
                anterior = temp;
                temp = temp.getProximo();
            }

            if (temp != null) {
                anterior.setProximo(temp.getProximo());
            }
            if (temp == ultimo) {
                ultimo = anterior;
            }
        }
        quantidade--;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public No getPrimeiro() {
        return primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }
}