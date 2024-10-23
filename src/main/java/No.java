
/**
 *
 * Nó a ser armazenado na árvore b.
 *
 */
public class No {

    /**
     * Chaves armazenadas no nó.
     */
    private int[] chave;
    
    /**
     * Vetor dos ponteiros dos filhos(children).
     */
    private No[] c;
    
    /**
     * Número de chaves armazenadas.
     */
    private int n;
    
    /**
     * Ordem da árvore;
     */
    private int t;
    
    /**
     * Indica ´se é um nó folha;
     */
    private boolean folha;

    /**
     * Construtor sem parâmetros.
     */
    public No() {
        this(3, true);
    }
    
    /**
     * Construtor sem parâmetros.
     * @param t Grau da árvore, quantidade de filhos para o nó.
     * @param folha Indica se é um nó folha ou não.
     */
    public No(int t, boolean folha) {
        this.n = 0;       
        this.t = t;
        this.folha = folha;
        //Aloca o vetor de chaves
        this.chave = new int[2 * this.t - 1];
        //Aloca o vetor nós filhos
        this.c = new No[2 * this.t];
    }
   
    /**
     * Recuperador da chave.
     *
     * Recupera a chave de uma posição i do nó.
     *
     * @param i Posição da chave.
     * @return O valor da chave.
     */
    public int getChave(int i) {
        return chave[i];
    }

    /**
     * Modificador da chave.
     *
     * Modifica a chave da posição i do nó.
     *
     * @param i Posição a ser atualizada.
     * @param k Valor a ser atualizado.
     */
    public void setChave(int i, int k) {
        chave[i] = k;
    }

    /**
     * Recuperador do nó filho.
     *
     * Recupera o nó filho da posição i do nó atual.
     *
     * @param i Posição a ser recuperada.
     * @return Nó filho da posição i do nó atual.
     */
    public No getC(int i) {
        return c[i];
    }

    /**
     * Modificador do nó filho.
     *
     * Modifica o nó filho da posição i do nó atual.
     *
     * @param i Posição do nó filho a ser modificada do nó atual.
     * @param filho Nó filho a ser atribuído no nó atual.
     */
    public void setC(int i, No filho) {
        c[i] = filho;
    }

    /**
     * Retorna a quantidade de nós.
     *
     * @return Um inteiro com a quantidade nós.
     */
    public int getN() {
        return n;
    }

    /**
     * Modificador da quantidade de nós.
     *
     * @param n Um inteiro a ser modificado.
     */
    public void setN(int n) {
        this.n = n;
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
     * Retorna se´o nó é folha.
     *
     * @return Verdadeiro ou falso se o nó é folha.
     */
    public boolean getFolha() {
        return folha;
    }

    /**
     * Modificador se é folha
     *
     * @param folha Um valor boleando para indicar se é ou não folha.
     */
    public void setFolha(boolean folha) {
        this.folha = folha;
    }

    /**
     * Procurar posição inserção dentro do vetor de chaves.
     *
     * @param k Chave a ser inserida.
     * @return Indica da posição no vetor.
     */
    public int procurarPosicaoChave(int k) {
        int i = 0;
        while ((i < n) && (k > chave[i])) {
            if (k == chave[i]) {
                    return i;
            }
            i = i + 1;
        }
        return i;
    }

    /**
     * Retorna o valor em String do dado.
     *
     * @return Uma string com o valor do dado do nó.
     */
    public String paraString() {
        return "OID: " + this + " / n:" + n + " / folha:" + folha + " / chave: " + chave + " / filhos: " + c;
    }

    /**
     * Retorna o valor em String dos dados dos vetores.
     *
     * @return Uma string com o valor do dado do nó.
     */
    public String getDadosVetoresStr() {

        String chaves_str = "[";
        for (int i = 0; i < chave.length; i++) {;

            chaves_str = chaves_str + this.getChave(i) + " ";
        }
        chaves_str  = chaves_str + "]";
        
        String filhos_str = "[";
        for (int i = 0; i < c.length; i++) {;

            filhos_str = filhos_str + this.getC(i) + " ";
        }
        filhos_str  = filhos_str + "]";

        return "OID: " + this + " / n:" + n + " / folha:" + folha + " / chaves: " + chaves_str + " / c: " + filhos_str;
    }
}
