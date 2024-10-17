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
     * Indica ´se é um nó folha;
     */
    private boolean folha;

    /**
     * Construtor sem parâmetros.
     */
    public No() {
        this.folha = true;
        this.n = 0; 
    }

    /**
     * Aloca as estruturas do nó da árvore b.
     * 
     * @param t Quantidade de chaves e filhos em um nó.
     */
    public void alocarNo(int t){
        //Aloca o vetor de chaves
        this.chave = new int[2 * t - 1];
        //Aloca o vetor nós filhos
        this.c = new No[2 * t];
    }
    
    /**
     * Recuperador da chave.
     * 
     * Recupera a chave de uma posição i do nó.
     * 
     * @param i Posição da chave.
     * @return  O valor da chave.
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
     * Retorna se´o nó é folha.
     * 
     * @return Verdadeiro ou falso se o nó é folha.
     */    
    public boolean getFolha() {
        return folha;
    }

    /**
     * Modificador se é  folha
     * 
     * @param folha Um valor boleando para indicar se é ou não folha.
     */
    public void setFolha(boolean folha) {
        this.folha = folha;
    }
    
    public int procurarPosicao(int k) {
        //busca a melhor posicao para insercao dentro do vetor
        int i = 0;
        while ((i < n) && (k > chave[i])) {
            i++;
        }
        return i;
    }

    /**
     * Retorna o valor em String do dado.
     *
     * @return Uma string com o valor do dado do nó.
     */
    public String paraString() {
        return "OID: " + this + " / n:" + n + " / folha:" + folha + " / chave: " + chave + " / c: " + c;
    }    
}