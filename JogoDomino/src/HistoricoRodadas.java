import java.util.ArrayList;
import java.util.List;

public class HistoricoRodadas {

    private List<Rodada> rodadas;
    private Jogador jogador1;
    private Jogador jogador2;
    private boolean empate;
    private String vencedor;

    public HistoricoRodadas(Jogador jogador1, Jogador jogador2) {
        this.rodadas = new ArrayList<Rodada>();
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.empate = false;
        this.vencedor = null;
    }

    public void adicionarRodada(Jogada ultimaJogadaJ1, Jogada ultimaJogadaJ2, Mesa mesa) {
        Rodada novaRodada = new Rodada(jogador1, ultimaJogadaJ1, jogador2, ultimaJogadaJ2,
                mesa.getPecas());
        this.rodadas.add(novaRodada);
        System.out.println(novaRodada.toString());
    }

    public void setResultadoEmpate() {
        this.empate = true;
        this.vencedor = null;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
        this.empate = false;
    }

    public boolean isEmpate() {
        return empate;
    }

    public String getVencedor() {
        return vencedor;
    }

    public String getResultado() {
        return "\nRESULTADO: " + (this.isEmpate() ? "EMPATE\n" : ("VITÓRIA DE " + getVencedor()) + "\n");
    }
}
