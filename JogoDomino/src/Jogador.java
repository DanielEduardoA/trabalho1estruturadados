import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jogador {

    private static final String PECA_REGEX = "([0-6]):([0-6])";
    private static final String SEPARADOR_PECAS_REGEX = ":";

    private EstrategiaJogo estrategia;
    private ListaDuplamenteEncadeada mao;
    private String nome;
    private Jogada ultimaJogada;

    public Jogador(String nome, EstrategiaJogo estrategia, ListaDuplamenteEncadeada mao) {
        this.nome = nome;
        this.estrategia = estrategia;
        this.mao = mao;
        this.ultimaJogada = null;
    }

    public Jogador(String nome, ListaDuplamenteEncadeada mao) {
        this.nome = nome;
        this.mao = mao;
        this.ultimaJogada = null;
    }

    public String getNome() {
        return nome;
    }

    public Jogada decidirJogadaHumano(Mesa mesa) {
        Jogada jogada = null;
        TipoJogada tipoJogada = lerTipoJogada();
        if (!tipoJogada.equals(TipoJogada.PASSA)) {
            jogada = realizarJogada(tipoJogada, mesa);
        } else {
            jogada = new Jogada(TipoJogada.PASSA);
        }
        this.ultimaJogada = jogada;
        return jogada;
    }

    public Jogada decidirJogadaMaquina(Mesa mesa) {
        Jogada jogada = estrategia.decidirJogada(mao, mesa);
        if (!jogada.getTipo().equals(TipoJogada.PASSA)) {
            Peca pecaJogada = jogada.getPeca();
            if (!mao.contem(pecaJogada)) {
                System.err.println("Tentou jogar uma peça que não tem na mão: " + pecaJogada);
                jogada = new Jogada(TipoJogada.INVALIDA);
            }
        }
        this.ultimaJogada = jogada;
        return jogada;
    }

    public void removeDaMao(Peca peca) {
        this.mao.removerLista(peca);
    }

    @SuppressWarnings("resource")
    private TipoJogada lerTipoJogada() {
        System.out.println("Digite o código referente tipo de jogada que deseja fazer: ");
        System.out.println("1 - A direita");
        System.out.println("2 - A esquerda");
        System.out.println("3 - Passar a vez");
        Scanner scanner = new Scanner(System.in);
        TipoJogada tipoJogada;
        int tipo = scanner.nextInt();
        switch (tipo) {
            case 1:
                tipoJogada = TipoJogada.NA_DIREITA;
                break;
            case 2:
                tipoJogada = TipoJogada.NA_ESQUERDA;
                break;
            case 3:
                tipoJogada = TipoJogada.PASSA;
                break;
            default:
                tipoJogada = TipoJogada.INVALIDA;
                break;
        }
        return tipoJogada;
    }

    @SuppressWarnings("resource")
    private Peca lerPeca() throws Exception {
        System.out.println("Digite a peça que deseja jogar no formato numero:numero: ");
        Scanner scanner = new Scanner(System.in);
        String pecaJogada = scanner.next();
        Peca peca;
        if (validarPeca(pecaJogada)) {
            int numDireito = pegarNumeroDireito(pecaJogada);
            int numEsquerdo = pegarNumeroEsquerdo(pecaJogada);
            peca = new Peca(numEsquerdo, numDireito);
        } else {
            throw new Exception("Peça inválida");
        }
        return peca;
    }
    
    private Jogada realizarJogada(TipoJogada tipoJogada, Mesa mesa) {
        Jogada jogada = null;
        try {
            Peca peca = lerPeca();
            jogada = new Jogada(peca, tipoJogada);
            if (!mao.contem(peca)) {
                System.err.println("Tentou jogar uma peça que não tem na mão: " + peca);
                jogada = new Jogada(TipoJogada.INVALIDA);
            }
            if (!estrategia.verificarPecaEncaixa(peca, mesa)) {
                System.err.println("A peça: " + peca + " não pode ser encaixada na posição escolhida");
                jogada = new Jogada(TipoJogada.INVALIDA);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            jogada = new Jogada(TipoJogada.INVALIDA);
        }
        return jogada;
    }

    private int pegarNumeroDireito(String pecaJogada) {
        return Integer.parseInt(pecaJogada.split(SEPARADOR_PECAS_REGEX)[1]);
    }

    private int pegarNumeroEsquerdo(String pecaJogada) {
        return Integer.parseInt(pecaJogada.split(SEPARADOR_PECAS_REGEX)[0]);
    }

    private boolean validarPeca(String peca) {
        Pattern pattern = Pattern.compile(PECA_REGEX);
        Matcher matcher = pattern.matcher(peca);
        return matcher.find();
    }

    public int getNumPecas() {
        return mao.getQuantidade();
    }

    public Jogada getUltimaJogada() {
        return ultimaJogada;
    }

    public ListaDuplamenteEncadeada getMao() {
        return mao;
    }
}
