public class No {

    private Peca peca;
    private No proximo;
    private No anterior;
    
    public No(Peca peca) {
        this.peca = peca;
    }
    
    public No(No ant, No prox, Peca peca) {
        this.anterior = ant;
        this.proximo = prox;
        this.peca = peca;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

}
