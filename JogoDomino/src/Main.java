public class Main {

    public static void main(String[] args) {
        Jogo jogo = new Jogo("J1", "J2",
                12);

        HistoricoRodadas historico = jogo.jogar();
        System.out.println(historico.getResultado());

    }

}
