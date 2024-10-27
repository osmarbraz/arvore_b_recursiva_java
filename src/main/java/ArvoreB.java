
import java.util.LinkedList;
import java.util.Queue;

/**
 * Árvore B.
 *
 * Criada por Rudolf Bayer e Edward Meyers McCreight em 1971 enquanto
 * trabalhavam no Boeing Scientific Research Labs, a origem do nome (árvore B)
 * não foi definida por estes. Especula-se que o B venha da palavra
 * balanceamento, do nome de um de seus inventores Bayer ou de Boeing, nome da
 * empresa.
 *
 * Página 505 Thomas H. Cormen 3 ed.
 *
 */
public class ArvoreB {

    /**
     * Nó de início da árvore.
     */
    private No raiz;

    /**
     * Ordem da árvore;
     */
    private int t;

    /**
     * Construtor sem parâmetro.
     *
     */
    public ArvoreB() {
        this(2);
        //3 espaços para as chaves
        //4 espaços para os filhos
    }

    /**
     * Construtor com parâmetro.
     *
     * @param t Grau mínimo (define o intervalo para o número de chaves).
     */
    public ArvoreB(int t) {
        //Define o grau(ordem) mínimo da árvore.
        this.t = t;

        //Define árvore como vazia
        this.raiz = null;
    }

    /**
     * Recuperador de início.
     *
     * @return O nó do início da árvore.
     */
    public No getRaiz() {
        return raiz;
    }

    /**
     * Modificador de raiz.
     *
     * @param raiz Um nó a ser atribuído ao início da árvore.
     */
    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    /**
     * Recuperador de t.
     *
     * @return O grau da árvore
     */
    public int getT() {
        return t;
    }

    /**
     * Modificador de t.
     *
     * @param t O grau da árvore.
     */
    public void setT(int t) {
        this.t = t;
    }

    /**
     * Caminhamento em pré-ordem na sub-árvore.
     *
     * @param _raiz Início da sub-árvore.
     */
    public void listarPreOrdem(No _raiz) {
        //Se _raiz não for nulo
        if (_raiz != null) {
            int i;
            //Percorre todas as chaves do nó _raiz
            for (i = 0; i < _raiz.getN(); i++) {
                //Visita a chave i da _raiz
                System.out.print(_raiz.getChave(i) + " ");
                //Percorre o filho i da _raiz
                listarPreOrdem(_raiz.getC(i));
            }
            //Percorre o último filho            
            listarPreOrdem(_raiz.getC(i));
        }
    }

    /**
     * Caminhamento em pré-ordem na árvore.
     *
     */
    public void listarPreOrdem() {
        this.listarPreOrdem(this.getRaiz());
    }

    /**
     * Caminhamento em central(in)-ordem na sub-árvore.
     *
     * @param _raiz Início da sub-árvore.
     */
    public void listarCentralOrdem(No _raiz) {
        //Se _raiz não for nulo
        if (_raiz != null) {
            int i;
            //Percorre todas as chaves do nó _raiz
            for (i = 0; i < _raiz.getN(); i++) {
                //Percore o filho i da _raiz
                listarCentralOrdem(_raiz.getC(i));
                // Visita a chave i da _raiz
                System.out.print(_raiz.getChave(i) + " ");
            }
            // Percorre o último filho
            listarCentralOrdem(_raiz.getC(_raiz.getN()));
        }
    }

    /**
     * Caminhamento em central(in)-ordem na árvore.
     *
     */
    public void listarCentralOrdem() {
        this.listarCentralOrdem(this.getRaiz());
    }

    /**
     * Caminhamento em pós-ordem na sub-árvore.
     *
     * @param _raiz Início da sub-árvore.
     */
    public void listarPosOrdem(No _raiz) {
        //Se _raiz não for nulo
        if (_raiz != null) {
            int i;
            //Percorre todas as chaves do nó _raiz
            for (i = 0; i < _raiz.getN(); i++) {
                //Percorre o filho i da _raiz
                listarPosOrdem(_raiz.getC(i));
                //Visita a chave i da _raiz
                System.out.print(_raiz.getChave(i) + " ");
            }
            // Percorre o último filho
            listarPosOrdem(_raiz.getC(i));
        }
    }

    /**
     * Caminhamento em pós-ordem na árvore.
     *
     */
    public void listarPosOrdem() {
        this.listarPosOrdem(this.getRaiz());
    }

    /**
     * Caminhamento em nível na sub-árvore.
     *
     * @param _raiz Início da sub-árvore.
     */
    public void listarEmNilvel(No _raiz) {
        Queue<No> queue = new LinkedList<>();
        queue.add(_raiz);
        while (!queue.isEmpty()) {
            No atual = queue.poll();
            for (int i = 0; i < atual.getN(); i++) {
                //Visita o filho i do nó atual
                System.out.print(atual.getChave(i) + " ");
            }
            if (!atual.getFolha()) {
                for (int i = 0; i < atual.getN() + 1; i++) {
                    queue.add(atual.getC(i));
                }
            }
            System.out.println(); // Nova linha para cada nível
        }
    }

    /**
     * Caminhamento em nível na árvore.
     *
     */
    public void listarEmNilvel() {
        this.listarEmNilvel(this.getRaiz());
    }

    /**
     * Caminhamento em nível com detalhes na sub-árvore.
     *
     * @param _raiz Início da sub-árvore.
     */
    public void listarEmNilvelDetalhes(No _raiz) {
        //Se _raiz não for nulo
        if (_raiz != null) {
            //Lista para armanzenar os nós do nível
            Queue<No> queue = new LinkedList<>();
            //Começa pela raiz
            queue.add(_raiz);
            System.out.println("OID Raiz:" + this.getRaiz());
            int nivel = 0;

            while (!queue.isEmpty()) {
                Queue<No> proximoNivel = new LinkedList<>();

                System.out.println("Nível:" + nivel);

                while (!queue.isEmpty()) {
                    //Retira o primeiro nó da fila
                    No atual = queue.poll();

                    //Exib os ddos do nó atual                
                    System.out.println("[" + atual.getDadosVetoresStr() + "]");

                    //Adiciona os filhos do nó atual a lista para exibir o próximo nível                
                    for (int i = 0; i < atual.getN() + 1; i++) {
                        if (atual.getC(i) != null) {
                            proximoNivel.add(atual.getC(i));
                        }
                    }
                }
                nivel = nivel + 1;
                queue = proximoNivel;
            }
        }
    }

    /**
     * Caminhamento em nível com detalhes na árvore.
     *
     */
    public void listarEmNilvelDetalhes() {
        this.listarEmNilvelDetalhes(this.getRaiz());
    }

    /**
     * Dividir(split) um nó em 2 nós descendentes.
     *
     * Função para dividir um nó x da posição i em dois nós decendentes. Observe
     * que x deve estar completo quando a função for chamada.
     *
     * Baseado no método B-TREE-SPLIT-CHILD(x,i) Thomas H. Cormen Página 494.
     *
     * @param x Raiz da sub-árvore.
     * @param i Indíce da posição a ser dividida.
     */
    public void dividirNo(No x, int i) {
        //Dividir x em duas partes, y e z.
        //Recupera o primeiro filho da raiz.
        //y filho da esquerda da raiz(x)
        No y = x.getC(i);

        //Cria um novo nó filho que irá armazenar chaves (t-1) de y.
        //Este novo nó vai ficar a direita de y.
        No z = new No(this.t, y.getFolha());
        z.setN(t - 1);

        //Copia as metade(t-1) das chaves de y(esquerda) para z(direita)
        for (int j = 0; j < this.t - 1; j++) {
            z.setChave(j, y.getChave(j + this.t));
            //Zera a chave de y pois já foram copiados para z
            y.setChave(j + t, 0);
        }
        //Se y não for folha
        if (y.getFolha() == false) {
            //Copia metade (t) dos filhos de y(esquerda) para z(direita)
            for (int j = 0; j < this.t; j++) {
                z.setC(j, y.getC(j + this.t));
                //Zera os filhos de y pois já foram copiados para z
                y.setC(j + t, null);
            }
        }
        //Reduz a quantidade de elementos de y
        y.setN(this.t - 1);

        //Como este nó terá um novo filho, cria espaço para o novo filho
        for (int j = x.getN(); j >= i + 1; j--) {
            x.setC(j + 1, x.getC(j));
        }
        //Conecta o novo filho a este nó
        x.setC(i + 1, z);

        //Uma chave de y se moverá para este nó. 
        //Encontre a localização da nova chave e mova todas as 
        //chaves maiores um espaço à frente.
        //Empurra as chaves de x para direta para dar lugar a z        
        for (int j = x.getN() - 1; j >= i; j--) {
            x.setChave(j + 1, x.getChave(j));
        }
        //Copie a chave do meio de y para este nó raiz
        x.setChave(i, y.getChave(this.t - 1));
        //Zera a chave de y pois já foi copiado para a raiz
        y.setChave(t - 1, 0);

        //Incrementa a contagem de chaves neste nó
        x.setN(x.getN() + 1);
    }

    /**
     * Inserir quanto não estiver cheio.
     *
     * Baseado no método B-TREE-INSERT-NONFULL(x,k) Thomas H. Cormen Página 496
     *
     * @param _raiz Raiz da sub-árvore
     * @param k Chave a ser inserida.
     */
    public void inserirNaoCheio(No _raiz, int k) {

        int i = _raiz.getN() - 1;
        //Se _raiz é uma folha, inserimos o valor diretamente
        if (_raiz.getFolha()) {
            //Percorre o vetor de chaves até a posição de inserção.
            //Desloca as chaves i + 1 posições para a inclusão da nova chave.
            while ((i >= 0) && (k < _raiz.getChave(i))) {
                _raiz.setChave(i + 1, _raiz.getChave(i));
                i = i - 1;
            }
            //Insere a nova chave
            _raiz.setChave(i + 1, k);
            //Incrementa a quantidade de chaves
            _raiz.setN(_raiz.getN() + 1);
        } else {
            // Se_raiz não é uma folha, encontramos o filho correto e inserimos recursivamente

            //Encontra o filho que terá a nova chave
            while ((i >= 0) && (k < _raiz.getChave(i))) {
                i = i - 1;
            }
            i = i + 1;

            //Veja se o filho encontrado está cheio
            if (_raiz.getC(i).getN() == (2 * _raiz.getT() - 1)) {
                this.dividirNo(_raiz, i);
                if (k > _raiz.getChave(i)) {
                    i = i + 1;
                }
            }
            inserirNaoCheio(_raiz.getC(i), k);
        }
    }

    /**
     * Inserção em sub-árvore B.
     *
     * Com divisão(split) e fusão(merge) preventiva para grau máximo.
     *
     * Insere os resultados de uma divisão de nó na árvore. A função pega uma
     * tupla contendo a chave que será inserida no nó _raiz(pai) e ponteiros
     * para os nós descendentes(filhos) esquerdo e direito. Primeiro, ele
     * verifica se o nó _raiz(pai) é nulo, nesse caso ele cria um novo nó raiz e
     * atualiza os seus atributos. Caso contrário, se o nó não estiver cheio (n
     * &lt; 2 * t -1) ele chamada a função inserirNaoCheio recursivamente até
     * encontrar a posição da chave a realizar a inserção. Se o nó estiver cheio
     * cheio (n = 2 * t -1) ele chamada a função dividirNo para dividir para a
     * nova raiz na posição 0 em dois nós para poder inserir o novo nó e chama a
     * função inserirNaoCheio.
     *
     * Inserir recursivo em sub-árvore B. Baseado no método B-TREE-INSERT(T,k)
     * Thomas H. Cormen Página 495 Em Cormen r = _raiz
     *
     * @param _raiz Raiz da sub-árvore.
     * @param k Chave a ser inserida.
     */
    public void inserir(No _raiz, int k) {
        //Árvore vazia
        if (this.getRaiz() == null) {
            System.out.println("Arvore vazia " + k);
            //Cria um novo nó
            No s = new No(this.t, true);
            //Tornar a raiz anterior filho da nova raiz
            s.setC(0, _raiz);
            //Atribui o valor da chave
            s.setChave(0, k);
            //Incrementa a quantidade de chaves
            s.setN(s.getN() + 1);
            //Atribui o novo nó a raiz
            this.setRaiz(s);
        } else {
            //Já atingiu a quantidade máxima de chaves no Nó.
            if (_raiz.getN() == (2 * this.t - 1)) {
                //Cria um novo nó
                No s = new No(this.t, false);
                //Quantidade de chaves no novo no
                s.setN(0);
                //Tornar a raiz anterior filho da nova raiz
                s.setC(0, _raiz);
                //Modifica a raiz com o novo nó criado
                this.setRaiz(s);
                //Dividir a raiz atual e mover 1a chave para a nova raiz
                this.dividirNo(s, 0);
                //Insere na nova sub-árvore
                this.inserirNaoCheio(s, k);
            } else {
                //Arvore não está cheia
                this.inserirNaoCheio(_raiz, k);
            }
        }
    }

    /**
     * Inserção na raiz de árvore B.
     *
     * @param k Chave a ser inserida.
     */
    public void inserir(int k) {
        this.inserir(this.getRaiz(), k);
    }

    /**
     * Procura nó na árvore.Procura uma chave k na sub-arvore do nó atual.
     *
     * Baseado no métodoB-TREE-SEARCH(x,k) Thomas H. Cormen Página 492
     *
     * @param _raiz Raiz da sub-ãrvore.
     * @param k Chave a ser procurada.
     * @return Retorna o nó que possui o valor k.
     */
    public No procurar(No _raiz, int k) {
        //Se _raiz diferente de nulo
        if (_raiz != null) {

            int i = 0;
            //Encontra a primeira chave maior ou igual a k
            while ((i < _raiz.getN()) && (k > _raiz.getChave(i))) {
                i = i + 1;
            }
            //Se a chave encontrada for igual a k, retorne este nó
            if ((i < _raiz.getN()) && (k == _raiz.getChave(i))) {
                return _raiz;
            }
            // Se a chave não for encontrada aqui e este for um nó folha
            if (_raiz.getFolha() == true) {
                return null;
            } else {
                //Procura no próximo filho
                return procurar(_raiz.getC(i), k);
            }
        } else {
            return null;
        }
    }

    /**
     * Método auxiliar para procurar uma chave na árvore.
     *
     * Não precisa especificar a raiz.
     *
     * @param k Chave a ser procurada na árvore.
     * @return O nó encontrado ou null.
     */
    public No procurar(int k) {
        return this.procurar(this.getRaiz(), k);
    }

    /**
     * Excluir árvore recursivamente apartir de _raiz.
     *
     * @param _raiz Início da árvore a ser excluida.
     * @return Retorna nul para o nó apgado.
     */
    public No apagar(No _raiz) {
        if (_raiz != null) {
            if (!_raiz.getFolha()) {
                for (int i = 0; i <= _raiz.getN(); ++i) {
                    return apagar(_raiz.getC(i));
                }
                return null;
            }
        }
        return null;
    }

    /**
     * Apaga a árvore apartir da raiz.
     */
    public void apagar() {
        this.setRaiz(apagar(this.getRaiz()));
    }

    /**
     * Encontra a chave com o valor mínimo na árvore.
     *
     * @param _raiz Início da árvore.
     * @return A chave miníma da árvore.
     */
    public int getValorMinimo(No _raiz) {
        if (_raiz == null) {
            return -1;
        } else {
            if (_raiz.getFolha()) {
                //retona a chave com o valor mínimo de x
                return _raiz.getChave(0);
            } else {
                //Procura no próximo filho
                return getValorMinimo(_raiz.getC(0));
            }
        }
    }

    /**
     * Encontra a chave com o valor mínimo da raiz.
     *
     * @return A chave mínima da árvore.
     */
    public int getValorMinimo() {
        return getValorMinimo(this.getRaiz());
    }

    /**
     * Encontra a chave com o valor máximo na árvore.
     *
     * @param _raiz Início da árvore.
     * @return A chave máxima da árvore.
     */
    public int getValorMaximo(No _raiz) {
        if (_raiz == null) {
            return -1;
        } else {
            if (_raiz.getFolha()) {
                //retona a chave com o valor mínimo de x
                return _raiz.getChave(_raiz.getN() - 1);
            } else {
                //Procura no próximo filho
                return getValorMaximo(_raiz.getC(_raiz.getN()));
            }
        }
    }

    /**
     * Encontra a chave com o valor máximo na árvore.
     *
     * @return A chave máxima da árvore.
     */
    public int getValorMaximo() {
        return this.getValorMaximo(this.getRaiz());
    }

    /**
     * Conta os nós de uma sub-árvore.
     *
     * @param _raiz
     * @return A quantidade de nós da sub-árvore.
     */
    public int contarNo(No _raiz) {
        int cont = 0;
        if (_raiz != null) {
            for (int i = 0; i < _raiz.getN(); i++) {
                cont = cont + contarNo(_raiz.getC(i));
                cont = cont + 1;
            }
            cont = cont + contarNo(_raiz.getC(_raiz.getN()));
        }
        return cont;
    }

    /**
     * Conta os nós da árvore.
     *
     * @return A quantidade de nós da árvore.
     */
    public int contarNo() {
        return this.contarNo(this.getRaiz());
    }

    /**
     * Retorna uma String com os valores dos nós folhas de uma árvore binária.
     *
     * @param _raiz Uma raiz de uma subárvore.
     * @return Uma String com os valores dos nós folhas da árvore binária.
     */
    public String encontrarFolhas(No _raiz) {
        String str = "";
        if (_raiz != null) {
            for (int i = 0; i < _raiz.getN(); i++) {
                str = str + encontrarFolhas(_raiz.getC(i));
                if (_raiz.getFolha()) {
                    str = str + " " + _raiz.getChave(i) + " - ";
                }
            }
            str = str + encontrarFolhas(_raiz.getC(_raiz.getN()));
        }
        return str;
    }

    /**
     * Retorna uma String com os valores dos nós folhas da raiz árvore binária.
     *
     * @return Uma String com os valores dos nós folhas da árvore binária.
     */
    public String encontrarFolhas() {
        return encontrarFolhas(this.getRaiz());
    }

    /**
     * Encontra a getAltura de uma sub-árvore.
     *
     * @param _raiz Raiz de uma sub-árvore.
     * @return A getAltura da sub-árvore.
     */
    public int getAltura(No _raiz) {
        if (_raiz == null) {
            return 0;
        } else {
            int esquerda = 0;
            for (int i = 0; i < _raiz.getN(); i++) {
                esquerda = esquerda + getAltura(_raiz.getC(i));
            }
            int direita = getAltura(_raiz.getC(_raiz.getN()));
            if (esquerda > direita) {
                return 1 + esquerda;
            } else {
                return 1 + direita;
            }
        }
    }

    /**
     * Encontra a getAltura da árvore.
     *
     * @return A getAltura da árvore.
     */
    public int getAltura() {
        return this.getAltura(this.getRaiz());
    }

    /**
     * Retorna a chave do antecessor de _raiz.
     *
     * @param _raiz Início da árvore.
     * @return O valor da chave.
     */
    public int getChaveAntecessor(No _raiz) {
        while (!_raiz.getFolha()) {
            _raiz = _raiz.getC(_raiz.getN());
        }
        return _raiz.getChave(_raiz.getN() - 1);
    }

    /**
     * Retorna a chave do sucessor de _raiz.
     *
     * @param _raiz Início da árvore.
     * @return O valor da chave.
     */
    public int getChaveSucessor(No _raiz) {
        while (!_raiz.getFolha()) {
            _raiz = _raiz.getC(0);
        }
        return _raiz.getChave(0);
    }

    /**
     * Fusão(Merge) de dois nós.
     *
     * Realiza a fusão dos nós i e i + 1 na árvore em _raiz.
     *
     * @param _raiz Início da árvore.
     * @param idx Indice do nó na raiz.
     */
    public void fusaoNos(No _raiz, int idx) {
        //Recupera o nó do filho
        No filho = _raiz.getC(idx);
        //Recupera o nó do irmão do filho;
        No irmao = _raiz.getC(idx + 1);
        //Move a chave para o filho
        filho.setChave(t - 1, _raiz.getChave(idx));
        //Desloca as chaves do irmão para o filho
        for (int i = 0; i < irmao.getN(); i++) {
            filho.setChave(i + t, irmao.getChave(i));
        }
        //Se tem filhos
        if (!filho.getFolha()) {
            //Desloca os filhos do irmão para o filho
            for (int i = 0; i <= irmao.getN(); i++) {
                filho.setC(i + t, irmao.getC(i));
            }
        }
        //Desloca as chaves uma posição para esquerda
        for (int i = idx + 1; i < _raiz.getN(); i++) {
            _raiz.setChave(i - 1, _raiz.getChave(i));
        }
        //Desloca os filhos uma posição para esquerda
        for (int i = idx + 2; i <= _raiz.getN(); i++) {
            _raiz.setC(i - 1, _raiz.getC(i));
        }

        //Incrementa o nó filho
        filho.setN(filho.getN() + irmao.getN() + 1);

        //Zera a posição da chave copiada
        _raiz.setChave(_raiz.getN() - 1, 0);

        //Decrementa o nó irmao
        _raiz.setN(_raiz.getN() - 1);

        //Apaga o irmão
        //irmao = null;
    }

    /**
     * removerCompleto uma chave de um nó folha.
     *
     * @param _raiz Raiz da sub-árvore.
     * @param idx Indice do nó na raiz.
     * @return Verdadeiro ou falso se conseguiu realizar a exclusão.
     */
    public boolean removerFolha(No _raiz, int idx) {

        for (int i = idx + 1; i < _raiz.getN(); i++) {
            _raiz.setChave(i - 1, _raiz.getChave(i));
        }

        //Zera a folha apagada
        _raiz.setChave(_raiz.getN() - 1, 0);

        //Remove k do _raiz
        _raiz.setN(_raiz.getN() - 1);

        return true;
    }

    /**
     * remover uma chave de um nó não folha.
     *
     * @param _raiz Raiz da sub-árvore.
     * @param idx Indice do nó na raiz.
     */
    public void removerNaoFolha(No _raiz, int idx) {
        // Recupera a chave da _raiz
        int k = _raiz.getChave(idx);

        //O nó antecessor contém chaves igual a t
        if (_raiz.getC(idx).getN() >= t) {
            //Obtem a chave do antecessor            
            int kpred = this.getChaveAntecessor(_raiz.getC(idx));
            //Substitui a chave na raiz
            _raiz.setChave(idx, kpred);
            this.remover(_raiz.getC(idx), kpred);
        } else {
            // O nó sucessor contém chaves igual a t
            if (_raiz.getC(idx + 1).getN() >= t) {
                //Obtem a chave do sucessor
                int ksuc = this.getChaveSucessor(_raiz.getC(idx + 1));
                //Substitui a chave na raiz
                _raiz.setChave(idx, ksuc);
                this.remover(_raiz.getC(idx + 1), ksuc);
            } else {
                //Ambos os nós noAnt e noProx contêm apenas chave em quantidades menores que o máximo
                fusaoNos(_raiz, idx);
                this.remover(_raiz.getC(idx), k);
            }
        }
    }

    /**
     * Pegar emprestado do irmão anterior
     *
     * @param _raiz Raiz da sub-árvore.
     * @param idx Indice do nó na raiz.
     */
    void pegarEmprestadoAnterior(No _raiz, int idx) {
        //Recupera o nó do filho
        No filho = _raiz.getC(idx);
        //Recupera o nó do irmão anterior
        No irmao = _raiz.getC(idx - 1);

        for (int i = filho.getN() - 1; i >= 0; i--) {
            filho.setChave(i + 1, filho.getChave(i));
        }

        if (!filho.getFolha()) {
            for (int i = filho.getN(); i >= 0; i--) {
                filho.setChave(i + 1, filho.getChave(i));
            }
        }

        filho.setChave(0, filho.getChave(idx - 1));

        if (!filho.getFolha()) {
            filho.setC(0, irmao.getC(irmao.getN()));
        }

        //Troca a chave do nó atual pelo irmão anterior
        _raiz.setChave(idx - 1, irmao.getChave(irmao.getN() - 1));

        //Incrementa o nó filho
        filho.setN(filho.getN() + 1);
        //Decrementa o nó irmao
        irmao.setN(irmao.getN() - 1);
    }

    /**
     * Emprestar do irmão seguinte
     *
     * @param _raiz Raiz da sub-árvore.
     * @param idx Indice do nó na raiz.
     */
    void pergarEmprestadoProximo(No _raiz, int idx) {
        //Recupera o nó do filho
        No filho = _raiz.getC(idx);
        //Recupera o nó do irmão seguinte
        No irmao = _raiz.getC(idx + 1);

        filho.setChave(filho.getN(), filho.getChave(idx));

        if (!filho.getFolha()) {
            filho.setC(filho.getN() + 1, irmao.getC(0));
        }

        _raiz.setChave(idx, irmao.getChave(0));

        for (int i = 1; i < irmao.getN(); i++) {
            irmao.setChave(i - 1, irmao.getChave(i));
        }

        if (!irmao.getFolha()) {
            for (int i = 1; i <= irmao.getN(); i++) {
                irmao.setC(i - 1, irmao.getC(i));
            }
        }

        //Incrementa o nó filho
        filho.setN(filho.getN() + 1);
        //Decrementa o nó irmão
        irmao.setN(irmao.getN() - 1);
    }

    /**
     * Preenche um nó filho.
     *
     * @param _raiz Raiz da sub-árvore.
     * @param idx Indice do nó na raiz.
     */
    public void preencherFilhos(No _raiz, int idx) {
        if (idx != 0 && _raiz.getC(idx - 1).getN() >= t) {
            this.pegarEmprestadoAnterior(_raiz, idx);
        } else {
            if (idx != _raiz.getN() && _raiz.getC(idx + 1).getN() >= t) {
                this.pergarEmprestadoProximo(_raiz, idx);
            } else {
                if (idx != _raiz.getN()) {
                    this.fusaoNos(_raiz, idx);
                } else {
                    this.fusaoNos(_raiz, idx - 1);
                }
            }
        }
    }

    /**
     * Remove uma chave da sub-árvore.
     *
     * Utiliza uma rotina recursiva.
     *
     * @param _raiz Raiz da sub-árvore.
     * @param k Chave a ser removida.
     */
    public void remover(No _raiz, int k) {
        int i = 0;

        //Procura a posição da chave no nó
        while (i < _raiz.getN() && k > _raiz.getChave(i)) {
            i = i + 1;
        }
        //A chave está no nó _raiz
        if (i < _raiz.getN() && k == _raiz.getChave(i)) {
            //O Nó é uma folha
            if (_raiz.getFolha()) {
                //Remove k do _raiz;
                this.removerFolha(_raiz, i);
            } else {
                this.removerNaoFolha(_raiz, i);
            }
        } else {
            //A _raiz não é folha
            if (!_raiz.getFolha()) {
                boolean flag = (i == _raiz.getN());

                if (_raiz.getC(i).getN() < t) {
                    this.preencherFilhos(_raiz, i);
                }
                if (flag && i > _raiz.getN()) {
                    this.remover(_raiz.getC(i - 1), k);
                } else {
                    this.remover(_raiz.getC(i), k);
                }
            } else {
                //Chegou em folha e não achou
                System.out.println("A chave " + k + " não está na árvore");
            }
        }
    }

    /**
     * Remove uma chave da árvore.
     *
     * @param k Chave a ser removida.
     * @return Verdadeiro ou falso se conseguiu realizar a exclusão.
     */
    public boolean remover(int k) {
        //Procura a chave na árvore
        if (this.procurar(k) == null) {
            return false;
        } else {
            //Realiza a exclusão
            this.remover(this.getRaiz(), k);

            //Se a árvore ficou vazia 
            if (this.getRaiz().getN() == 0) {
                //No temp = this.getRaiz();
                if (this.getRaiz().getFolha()) {
                    //Atribui null para a raiz
                    this.setRaiz(null);
                } else {
                    //Seta a raiz com o primeiro filho
                    this.setRaiz(this.getRaiz().getC(0));
                }
                //Apaga a raiz
                //temp = null;                
            }
            return true;
        }
    }
}
