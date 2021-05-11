# trabalho1estruturadados

Trabalho apresentado para a disciplina Estrutura de dados pelos alunos:
Daniel Eduardo Costa de Almeida e Ângelo Gabriel Lopes

A classe EstrategiaJogo
Contem a implementação para verificar se uma peça encaixa em uma das extremidades da mesa e para decidir a primeira jogada da máquina possível de acordo com sua mão

A classe HistoricoRodadas
Contem a implementação para guardar o histórico de rodadas que ja foram realizadas

A classe Jogada
É a classe de modelo que contem a peça e o tipo de jogada que foi realizada

A classe Jogador
É a classe de modelo que contem o nome do jogador, a estrategia de jogo que ele ira usar (primeira peça possivel), a lista de peças que estão em sua mão e sua ultima jogada

A classe Jogo
É a classe de modelo que contem os dados dos jogadores, as peças que estão na mesa, o número de rodadas já realizadas, se o jogo esta finalizado e o nome do vencedor

A classe ListaDuplamenteEncadeada
A classe contem a implementação de uma lista duplamente encadeada

A classe Mesa
É a classe de modelo que contem as peças já jogadas

A classe No
A classe contem os nós da lista encadeada

A classe Peca
É a classe de modelo que representa a peça de dominó

A classe Rodada
Contem dados da jogada do jogador 1 e 2 e as peças que estão na mesa

Enum TipoJogada
Contem os tipos de jogadas possíveis

Inicialmente serão distribuidas randomicamente 12 peças para cada jogador que serão armazenados em sua mão (lista duplamente encadeada). A cada jogada caso a joga seja válida e não seja passar a vez uma peça sera removida da mão do jogador (lista duplamente encadeada) e adicionada a mesa (lista duplamente encadeada).

Caso o número da peça encaixa com a estremidade a direita da mesa a peça será adicionada no final da mesa (lista encadeada). Caso o número da peça encaixa com a estremidade a esquerda da mesa a peça será adicionada no inicio da mesa (lista encadeada). 

Os números das peças poderão ser invertidos de lado para se encaixar as extremidades da mesa.

Para cada peça do humano será validado se o mesmo tem a peça que foi lida no teclado, se a peça realmente encaixa na posição escolhida, se a posição da jogada é válida, se a peça joga tem os que representam corretamente uma peça de dominó.

Enquanto o jogo não estiver finalizado uma nova rodada será iniciada. Um jogo poderá ser finalizado caso um dos jogadores não tenha mais peças na mão ou caso ou 2 jogares passem a vez durante a mesma rodada.





