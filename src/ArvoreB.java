
import java.util.LinkedList;
import java.util.Queue;

/**
 * Árvore B
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
        this(4);
    }

    /**
     * Construtor com parâmetro.
     *
     * @param t Grau mínimo (define o intervalo para o número de chaves).
     */
    public ArvoreB(int t) {
        this.t = t;

        //Cria a raiz da árvore.
        this.criarRaiz();
    }

    /**
     * Cria a raiz da árvore.
     */
    public void criarRaiz() {
        //Instancia o nó raiz da árvore.
        this.raiz = new No();
        raiz.alocarNo(this.t);
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
     * @param no Início da sub-árvore.
     */
    public void listarPreOrdem(No no) {
        if (no != null) {
            int i;
            for (i = 0; i < no.getN(); i++) {
                System.out.print(no.getChave(i) + " ");
                listarPreOrdem(no.getC(i));
            }
            //Percorre o último filho            
            listarPreOrdem(no.getC(i));
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
     * @param no Início da sub-árvore.
     */
    public void listarCentralOrdem(No no) {
        if (no != null) {
            int i;
            for (i = 0; i < no.getN(); i++) {
                listarCentralOrdem(no.getC(i));

                // Visita a chave i
                System.out.print(no.getChave(i) + " ");
            }
            // Percorre o último filho
            listarCentralOrdem(no.getC(no.getN()));
        }
    }

    /**
     * Caminhamento em central(in)-ordem na árvore.
     *
     * @param no Início da árvore.
     */
    public void listarCentralOrdem() {
        this.listarCentralOrdem(this.getRaiz());
    }

    /**
     * Caminhamento em pós-ordem na sub-árvore.
     *
     * @param no Início da sub-árvore.
     */
    public void listarPosOrdem(No no) {
        if (no != null) {
            int i;
            for (i = 0; i < no.getN(); i++) {
                //Percorre o filho à esquerda da chave i
                listarPosOrdem(no.getC(i));
                // Visita a chave i
                System.out.print(no.getChave(i) + " ");
            }
            // Percorre o último filho
            listarPosOrdem(no.getC(i));
        }
    }

    /**
     * Caminhamento em pós-ordem na árvore.
     *
     * @param no Início da árvore.
     */
    public void listarPosOrdem() {
        this.listarPosOrdem(this.getRaiz());
    }

    /**
     * Caminhamento em nível na sub-árvore.
     *
     * @param no Início da sub-árvore.
     */
    public void listarEmNilvel(No no) {
        Queue<No> queue = new LinkedList<>();
        queue.add(no);

        while (!queue.isEmpty()) {
            No atual = queue.poll();
            for (int i = 0; i < atual.getN(); i++) {;
                System.out.print(atual.getChave(i) + " ");
            }
            if (!atual.getFolha()) {
                for (int i = 0; i < atual.getN(); i++) {
                    queue.add(atual.getC(i));
                }
            }

            System.out.println(); // Nova linha para cada nível
        }
    }

    /**
     * Caminhamento em nível na árvore.
     *
     * @param no Início da árvore.
     */
    public void listarEmNilvel() {
        this.listarEmNilvel(this.getRaiz());
    }

    /**
     * Dividir um nó em 2 filhos.
     *
     * Função para dividir o filho r deste nó. Observe que r deve estar completo
     * quando esta função for chamada.
     *
     * Baseado no método B-TREE-SPLIT-CHILD(x,i) Thomas H. Cormen Página 515.
     *
     * @param r Raiz da árvore.
     * @param i Posição a ser dividida.
     */
    public void dividirNo(No r, int i) {

        //Cria um novo nó que irá armazenar chaves (t-1) de y
        No z = new No();
        z.alocarNo(t);

        //Dividir x em duas partes.
        // y filho da esquerda
        No y = r.getC(i);

        // z filho da direita
        z.setFolha(y.getFolha());
        z.setN(t - 1);

        //Copia as últimas chaves (t-1) de y para z  
        for (int j = 0; j < t - 1; j++) {
            z.setChave(j, y.getChave(j + t));
        }
        //Se y não for folha
        if (y.getFolha() == false) {
            //Copia os últimos t filhos de y para z
            for (int j = 0; j < t; j++) {
                z.setC(j, y.getC(j + t));
            }
        }
        //Reduz a quantidade de elementos de y
        y.setN(t - 1);

        //Como este nó terá um novo filho, cria espaço para o novo filho
        for (int j = r.getN(); j >= i + 1; j--) {
            r.setC(j + 1, r.getC(j));
        }
        //Conecta o novo filho a este nó
        r.setC(i + 1, z);

        //Uma chave de y se moverá para este nó. 
        //Encontre a localização da nova chave e mova todas as 
        //chaves maiores um espaço à frente.
        //Empurra as chaves de x para direta para dar lugar a z        
        for (int j = r.getN() - 1; j >= i; j--) {
            r.setChave(j + 1, r.getChave(j));
        }
        //Copie a chave do meio de y para este nó
        r.setChave(i, y.getChave(t - 1));

        // Incrementa a contagem de chaves neste nó
        r.setN(r.getN() + 1);
    }

    /**
     * Inserção em árvore B.
     *
     * Baseado no método B-TREE-INSERT(T,k) Thomas H. Cormen Página 516 Em
     * Cormen r = _raiz
     *
     * @param r Raiz da árvore.
     * @param k Chave a ser inserida.
     */
    public void inserir(No r, int k) {
        //Já atingiu a quantidade máxima de valores no Nó.        
        if (r.getN() == (2 * t - 1)) {
            //Cria um novo nó
            No s = new No();
            s.alocarNo(t);

            //Modifica a raiz
            this.setRaiz(s);
            s.setFolha(false);
            s.setN(0);

            //Tornar a raiz antiga filha da nova raiz
            s.setC(0, r);

            //Dividir a raiz antiga e mover 1 chave para a nova raiz
            this.dividirNo(s, 0);

            //Insere na nova sub-árvore
            this.inserirNaoCheio(s, k);
        } else {
            //Arvore não está cheia
            this.inserirNaoCheio(r, k);
        }
    }

    /**
     * Inserir quanto não estiver cheio.
     *
     * Baseado no método B-TREE-INSERT-NONFULL(x,k) Thomas H. Cormen Página 517
     *
     * @param x
     * @param k
     */
    public void inserirNaoCheio(No x, int k) {
        //int i = x.getN() - 1;
        int i = x.getN() - 1;
        if (x.getFolha()) {
            while ((i >= 0) && (k < x.getChave(i))) {
                x.setChave(i + 1, x.getChave(i));
                i = i - 1;
            }
            x.setChave(i + 1, k);
            x.setN(x.getN() + 1);
        } else {
            //Se o nó não é folha

            // Encontra o filho que terá a nova chave
            while ((i >= 0) && (k < x.getChave(i))) {
                i = i - 1;
            }
            i = i + 1;

            // Veja se o filho encontrado está cheio
            if (x.getC(i).getN() == 2 * t - 1) {
                this.dividirNo(x, i);
                if (k > x.getChave(i)) {
                    i = i + 1;
                }
            }
            inserirNaoCheio(x.getC(i), k);
        }
    }

    /**
     * Procura nó na árvore.
     *
     * Procura uma chave k na sub-arvore do nó atual.
     *
     * Baseado no métodoB-TREE-SEARCH(x,k) Thomas H. Cormen Página 513
     *
     * @param x
     * @param k
     */
    public No procurar(No x, int k) {

        if (x != null) {

            int i = 0;
            //Encontra a primeira chave maior ou igual a k
            while ((i < x.getN()) && (k > x.getChave(i))) {
                i = i + 1;
            }
            //Se a chave encontrada for igual a k, retorne este nó
            if ((i < x.getN()) && (k == x.getChave(i))) {
                return x;
            }
            // Se a chave não for encontrada aqui e este for um nó folha
            if (x.getFolha() == true) {
                return null;
            } else {
                //Procura no ´róximo filho
                return procurar(x.getC(i), k);
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
     * Excluir árvore recursivamente apartir de r.
     *
     * @param r Início da árvore a ser excluida.
     */
    public No apagar(No r) {
        if (r != null) {
            if (!r.getFolha()) {
                for (int i = 0; i <= r.getN(); ++i) {
                    apagar(r.getC(i));
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
        //Cria uma nova raiz
        this.criarRaiz();
    }

    /**
     * Encontra a chave com o valor mínimo na árvore.
     *
     * @param r Início da árvore.
     * @return A chave miníma da árvore.
     */
    public int getValorMinimo(No r) {
        if (r == null) {
            System.out.println("A árvore está vazia.");
            return -1;
        } else {
            if (r.getFolha()) {
                //retona a chave com o valor mínimo de x
                return r.getChave(0);
            } else {
                //Procura no próximo filho
                return getValorMinimo(r.getC(0));
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
     * @param r Início da árvore.
     * @return A chave máxima da árvore.
     */
    public int getValorMaximo(No r) {
        if (r == null) {
            System.out.println("A árvore está vazia.");
            return -1;
        } else {
            if (r.getFolha()) {
                //retona a chave com o valor mínimo de x
                return r.getChave(r.getN() - 1);
            } else {
                //Procura no próximo filho
                return getValorMaximo(r.getC(r.getN()));
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
     * @param _raiz
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
            if (_raiz.getFolha()) {
                for (int i = 0; i < _raiz.getN(); i++) {
                    str = str + encontrarFolhas(_raiz.getC(i));
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
     * @param _raiz Raiz de árvore.
     * @return A getAltura da árvore.
     */
    public int getAltura() {
        return this.getAltura(this.getRaiz());
    }

    /**
     * Retorna a chave do antecessor de r.
     *
     * @param r Início da árvore.
     * @return O valor da chave.
     */
    public int getChaveAntecessor(No r) {
        while (!r.getFolha()) {
            r = r.getC(r.getN() + 1);
        }
        return r.getChave(r.getN());
    }

    /**
     * Retorna a chave do sucessor de r.
     *
     * @param r Início da árvore.
     * @return O valor da chave.
     */
    public int getChaveSucessor(No r) {
        while (!r.getFolha()) {
            r = r.getC(0);
        }
        return r.getChave(0);
    }

    public void mergeFilhos(No pai, int ix) {
        No filho1 = pai.getC(ix);
        No filho2 = pai.getC(ix + 1);

        filho1.setN(2 * t - 1);
        filho1.setChave(t, pai.getChave(ix));
        for (int i = 0; i < t - 1; i++) {
            filho1.setChave(t + i, filho2.getChave(i));
        }
        if (!filho1.getFolha()) {
            for (int i = 1; i <= t; i++) {
                filho1.setC(i + t, filho2.getC(i));
            }
        }
        pai.setN(pai.getN() + 1);
        for (int i = ix; i < pai.getN(); i++) {
            pai.setChave(i, pai.getChave(i + 1));
            pai.setC(i + 1, pai.getC(i + 2));
        }
        filho2 = null;
        if (pai.getN() == 0) {
            pai = null;
            if (pai == this.getRaiz()) {
                this.setRaiz(filho1);
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
     * @return Verdadeiro ou falso se conseguiu realizar a exclusão.
     */
    public boolean remover(No _raiz, int k) {
        int i = 0;

        while (i < _raiz.getN() && k > _raiz.getChave(i)) {
            i = i + 1;
        }
        //A chave está no nó _raiz
        if (i < _raiz.getN() && k == _raiz.getChave(i)) {
            //O Nó é uma folha
            if (_raiz.getFolha()) {
                //Remove k do _raiz
                _raiz.setN(_raiz.getN() - 1);
                for (int j = i; j <= _raiz.getN(); j++) {
                    _raiz.setChave(i, _raiz.getChave(i + 1));
                }
                return true;
            } else {
                //O no _raiz é interno
                No noAnt = _raiz.getC(i);//O nó filho anterior ao no _raiz
                No noProx = _raiz.getC(i + 1);//O nó filho posterior ao no _raiz
                //O nó noAnt contém chaves igual a t
                if (noAnt.getN() >= t) {
                    //Obtem a chave do antecessor
                    int kAnt = this.getChaveAntecessor(noAnt);
                    // Substitui a chave na raiz
                    _raiz.setChave(i, kAnt);
                    //Conseguiu excluir
                    return true;
                } else {
                    //O nó noProx contém chaves igual a t
                    if (noProx.getN() >= t) {
                        //Obtem a chave do sucessor
                        int kProx = this.getChaveSucessor(noProx);
                        // Substitui a chave na raiz
                        _raiz.setChave(i, kProx);
                        //Conseguiu excluir
                        return true;
                    } else {
                        // Ambos os nós noAnt e noProx contêm apenas chave em quantidades menores que o máximo
                        mergeFilhos(_raiz, i);
                        return remover(noAnt, k);
                    }
                }
            }
        } else {
            //A chave não está em _raiz
            //O nó raiz da subárvore que contém a chave
            No noFilho = _raiz.getC(i);
            //Quantidade de chave igual a t-1
            if (noFilho.getN() == t - 1) {
                //nó irmão da esquerda
                No noEsq = i > 0 ? _raiz.getC(i - 1) : null;
                //nó irmão da dirata
                No noDir = i <= _raiz.getN() ? _raiz.getC(i + 1) : null;
                int j;
                //O nó irmão esquerdo tem menos chave que t
                if (noEsq != null && noEsq.getN() >= t) {
                    //A chave i-1 no nó _raiz é movida para noFilho
                    for (j = noFilho.getN() + 1; j > 1; j--) {
                        noFilho.setChave(j, noFilho.getChave(j - 1));
                    }
                    noFilho.setChave(0, _raiz.getChave(i - 1));

                    if (!noEsq.getFolha()) {
                        //O ponteiro filho nó pLeft é movido para noFilho
                        for (j = noFilho.getN() + 2; j > 1; j--) {
                            noFilho.setC(j, noFilho.getC(j - 1));
                        }
                        noFilho.setC(0, noEsq.getC(noEsq.getN()));
                    }
                    noFilho.setN(noFilho.getN() + 1);

                    _raiz.setChave(i, noEsq.getChave(noEsq.getN()));
                    noEsq.setN(noEsq.getN() - 1);
                } else {
                    //O nó irmão direito tem pelo chave menor que t
                    if (noDir != null && noDir.getN() >= t) {
                        //A palavra-chave i no nó _raiz é movida para noFilho
                        noFilho.setChave(noFilho.getN() + 1, _raiz.getChave(i));
                        noFilho.setN(noFilho.getN() + 1);
                        //A menor chave no nó noDir sobe para _raiz
                        _raiz.setChave(i, noDir.getChave(0));
                        noDir.setN(noDir.getN() - 1);
                        for (j = 1; j <= noDir.getN(); j++) {
                            noDir.setChave(j, noDir.getChave(j + 1));
                        }
                        if (!noDir.getFolha()) {
                            //O ponteiro filho apropriado no nó noDir é movido para noFilho
                            noFilho.setC(noFilho.getN() + 1, noDir.getC(0));

                            for (j = 0; j <= noDir.getN() + 1; ++j) {
                                noDir.setC(j, noDir.getC(j + 1));
                            }
                        }

                    } else {
                        //Os nós irmãos esquerdo e direito contêm chaves t-1
                        //Mesclar com o irmão esquerdo
                        if (noEsq == null) {
                            mergeFilhos(_raiz, i - 1);
                            noFilho = noEsq;
                        } else {
                            //Mesclar com o irmão direito
                            if (noDir == null) {
                                mergeFilhos(_raiz, i);
                            }
                        }
                    }
                }
                return remover(noFilho, k);
            }
        }
        return false;
    }

    /**
     * Remove uma chave da árvore.
     *
     * @param k Chave a ser removida.
     * @return Verdadeiro ou falso se conseguiu realizar a exclusão.
     */
    public boolean remover(int k) {
        return this.remover(this.getRaiz(), k);
    }
}
