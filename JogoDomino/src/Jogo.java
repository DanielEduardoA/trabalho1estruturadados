
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Jogo {

    private Jogador jogador1;
    private Jogador jogador2;

    private Mesa mesa = new Mesa();
    private int rodadasJogadas = 0;

    private boolean finalizado = false;
    private String vencedor = null;

    public Jogo(String nomeJogador1, String nomeJogador2,
            int numPecasInicial) {
        List<Peca> pecas = criarPecas();
        Collections.shuffle(pecas, new Random());

        ListaDuplamenteEncadeada maoJ1 = sortearMao(pecas, numPecasInicial);
        ListaDuplamenteEncadeada maoJ2 = sortearMao(pecas, numPecasInicial);

        jogador1 = new Jogador(nomeJogador1, new EstrategiaJogo(), maoJ1);
        jogador2 = new Jogador(nomeJogador2, new EstrategiaJogo(), maoJ2);
    }
    
    public HistoricoRodadas jogar() {
        HistoricoRodadas historico = new HistoricoRodadas(jogador1, jogador2);
        int i = 1;
        while (!this.isFinalizado()) {
            System.out.println("\nRodada: " + i);
            this.adicionarRodada();
            historico.adicionarRodada(jogador1.getUltimaJogada(), jogador2.getUltimaJogada(), mesa);
            i++;
        }

        if (this.isResultadoEmpate()) {
            historico.setResultadoEmpate();
        } else {
            historico.setVencedor(getVencedor());
        }

        return historico;

    }
    
    private ListaDuplamenteEncadeada sortearMao(List<Peca> pecas, int numPecasInicial) {
        ListaDuplamenteEncadeada mao = new ListaDuplamenteEncadeada();
        for (int i = 0; i < numPecasInicial; i++) {
            mao.adicionarInicio(pecas.remove(0));
        }
        return mao;
    }

    private List<Peca> criarPecas() {
        List<Peca> pecas = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                pecas.add(new Peca(i, j));
            }
        }

        return pecas;
    }

    private void realizarJogada(Jogador jogador, Jogada jogada) {
        switch (jogada.getTipo()) {
            case NA_ESQUERDA: {
                ListaDuplamenteEncadeada pecas = mesa.jogarEsquerda(jogada.getPeca());
                this.mesa.setPecas(pecas);
                jogador.removeDaMao(jogada.getPeca());
                break;
            }
            case NA_DIREITA: {
                ListaDuplamenteEncadeada pecas = mesa.jogarDireita(jogada.getPeca());
                this.mesa.setPecas(pecas);
                jogador.removeDaMao(jogada.getPeca());
                break;
            }
            case PASSA:
                break;
            case INVALIDA:
                break;
            default:
                break;
        }
    }
    
    private void adicionarRodada() {
        rodadasJogadas += 1;

        System.out.println("M?o jogador " + jogador1.getNome() + ": " + jogador1.getMao().toString());
        Jogada jogadaJ1 = jogador1.decidirJogadaHumano(mesa);
        realizarJogada(jogador1, jogadaJ1);

        if (jogador1.getNumPecas() == 0) {
            this.finalizado = true;
            this.vencedor = this.jogador1.getNome();
            return;
        }

        Jogada jogadaJ2 = jogador2.decidirJogadaMaquina(mesa);
        realizarJogada(jogador2, jogadaJ2);

        if (jogador2.getNumPecas() == 0) {
            finalizado = true;
            vencedor = this.jogador2.getNome();
            return;
        }

        if (jogadaJ1.getTipo() == TipoJogada.PASSA && jogadaJ2.getTipo() == TipoJogada.PASSA) {
            finalizado = true;
            vencedor = null;
        }
    }

    @Override
    public String toString() {
        return jogador1.toString() + "\n" + jogador2.toString() + "\nMesa: " + mesa.toString();
    }

    public int getNumRodadas() {
        return rodadasJogadas;
    }

    public boolean isFinalizado() {
        return this.finalizado;
    }

    public boolean isResultadoEmpate() {
        return this.isFinalizado() && this.vencedor == null;
    }

    public String getVencedor() {
        return vencedor;
    }
    
    public int getNumPecasJ1() {
        return jogador1.getNumPecas();
    }

    public int getNumPecasJ2() {
        return jogador2.getNumPecas();
    }


}