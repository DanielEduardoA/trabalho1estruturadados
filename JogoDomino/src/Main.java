public class Main {

    public static void main(String[] args) {
        Jogo j = new Jogo("J1", "J2",
                12);

        HistoricoRodadas historico = j.jogaJogoCompleto();
        System.out.println(historico.getResultado());

    }

}
