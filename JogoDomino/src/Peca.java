public class Peca {

    private int numEsquerdo;
    private int numDireito;

    public Peca() {}

    public Peca(int numEsquerdo, int numDireito) {
        this.numEsquerdo = numEsquerdo;
        this.numDireito = numDireito;
    }

    public boolean encaixa(int numero) {
        return this.numDireito == numero || this.numEsquerdo == numero;
    }

    public void setNumEsquerdo(int numEsquerdo) {
        this.numEsquerdo = numEsquerdo;
    }

    public void setNumDireito(int numDireito) {
        this.numDireito = numDireito;
    }

    public int getNumDireito() {
        return numDireito;
    }

    public int getNumEsquerdo() {
        return numEsquerdo;
    }

    @Override
    public String toString() {
        return this.getNumEsquerdo() + ":" + this.getNumDireito();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numDireito;
        result = prime * result + numEsquerdo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Peca other = (Peca) obj;
        if (numDireito != other.numDireito)
            return false;
        if (numEsquerdo != other.numEsquerdo)
            return false;
        return true;
    }

}