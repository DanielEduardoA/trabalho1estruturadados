public class Rodada {

    private Jogada jogadaJ1;
    private Jogada jogadaJ2;
    private ListaDuplamenteEncadeada pecasMesa;
    private Jogador jogador1;
    private Jogador jogador2;

    public Rodada(Jogador j1, Jogada jogadaJ1, Jogador j2, Jogada jogadaJ2, ListaDuplamenteEncadeada naMesa) {
        this.jogador1 = j1;
        this.jogadaJ1 = jogadaJ1;
        this.jogador2 = j2;
        this.jogadaJ2 = jogadaJ2;
        this.pecasMesa = naMesa;
    }

    @Override
    public String toString() {
        return "  " + this.jogador1.getNome() + " : " + jogadaJ1.toString() + "\n  "
                + this.jogador2.getNome() + " : " + jogadaJ2.toString() + "\n  "
                + "MESA: " + pecasMesa.toString();
    }
}
