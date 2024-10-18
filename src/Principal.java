
/**
 * Implementação de Árvore Binária Encadeada.
 */
import javax.swing.JOptionPane;

public class Principal {

    /**
     * Realiza a leitura dos dados dos nós.
     *
     * @return O valor lido.
     */
    public static int leitura() {
        return Integer.parseInt(JOptionPane.showInputDialog("Digite um valor:"));
    }

    /**
     * Árvore de exemplo.
     *
     * @param arvore Árvore a ser preenchida.
     */
    public static void arvoreExemplo(ArvoreB arvore) {
        arvore.inserir(arvore.getRaiz(), 10);
        arvore.inserir(arvore.getRaiz(), 20);
        arvore.inserir(arvore.getRaiz(), 30);
        
        arvore.inserir(arvore.getRaiz(), 40);
        arvore.inserir(arvore.getRaiz(), 15);
        arvore.inserir(arvore.getRaiz(), 25);
        
        arvore.inserir(arvore.getRaiz(), 35);
        arvore.inserir(arvore.getRaiz(), 45);
        arvore.inserir(arvore.getRaiz(), 50);
        System.out.println("Caminho Centro:");
        arvore.listarCentralOrdem();
        System.out.println();
    }

    /**
     * Método principal.
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Declara e instância da árvore.
         */
        ArvoreB ipe = new ArvoreB();

        // Controla o menu da lista
        int opcao = -1;

        //Laço do menu de opções
        while (opcao != 99) {
            //Monta o menu de opções
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\t### Árvore B ###\n"
                    + "Selecione a opção desejada:\n"
                    + " 1- Inserir \n"
                    + " 2- Excluir \n"
                    + " 3- Caminhar Pré Ordem\n"
                    + " 4- Caminhar Central(In) Ordem\n"
                    + " 5- Caminhar Pós Ordem\n"
                    + " 6- Caminhar Em Nível\n"
                    + " 7- Caminhar Em Nível Detalhado\n"
                    + " 8- Contar nós \n"
                    + " 9- Localizar nó \n"
                    + "10- Mostrar folhas \n"
                    + "11- Altura da árvore\n"
                    + "12- Valor mínimo da árvore\n"
                    + "13- Valor máximo da árvore\n"
                    + "14- Apagar árvore\n"
                    + "99- Sair\n"));

            switch (opcao) {
                case 1: {
                    //Preenche o valor do dado
                    int dado = leitura();
                    //Insere o valor na árvore
                    //ipe.inserir(dado, 0);
                    ipe.inserir(ipe.getRaiz(), dado);
                    break;
                }
                case 2: {
                    //Preenche o valor do dado                    
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser removido"));
                    //Remove o valor da árvore
                    if (ipe.remover(dado) == true) {
                        System.out.println("Valor " + dado + " removido da árvore.");
                    } else {
                        System.out.println("Valor " + dado + " não removido da árvore.");
                    }
                    break;
                }
                case 3: {
                    System.out.println(">> Caminhamento Pré Ordem");
                    ipe.listarPreOrdem();
                    System.out.println();
                    break;
                }
                case 4: {
                    System.out.println(">> Caminhamento Central(in)");
                    ipe.listarCentralOrdem();
                    System.out.println();
                    break;
                }
                case 5: {
                    System.out.println(">> Caminhamento Pós Ordem");
                    ipe.listarPosOrdem();
                    System.out.println();
                    break;
                }
                case 6: {
                    System.out.println(">> Caminhamento Em Nível");
                    ipe.listarEmNilvel();
                    System.out.println();
                    break;
                }
                case 7: {
                    System.out.println(">> Caminhamento Em Nível Detalhado");
                    ipe.listarEmNilvelDetalhes();
                    System.out.println();
                    break;
                }
                case 8: {
                    //Retorna a quantidade de nós
                    int qtde = ipe.contarNo();
                    System.out.println("Nós encontrados: " + qtde);
                    break;
                }
                case 9: {
                    //Preenche o valor do dado
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser procurado:"));
                    No encontrou = ipe.procurar(dado);
                    if (encontrou != null) {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " foi encontrado!");
                    } else {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " não foi encontrado!");
                    }
                    break;
                }
                case 10: {
                    System.out.println("Mostrar Folhas\n" + ipe.encontrarFolhas());
                    break;
                }
                case 11: {
                    System.out.println("Altura árvore: " + ipe.getAltura());
                    break;
                }
                case 12: {
                    System.out.println("Valor mínimo da árvore: " + ipe.getValorMinimo());
                    break;
                }
                case 13: {
                    System.out.println("Valor máximo da árvore: " + ipe.getValorMaximo());
                    break;
                }
                case 14: {
                    ipe.apagar();
                    System.out.println("Árvore apagada");
                    break;
                }
                //Preenche uma árvore com vários nós
                case 98: {
                    arvoreExemplo(ipe);
                    break;
                }

                //Opção de saída do programa
                case 99: {
                    System.out.println("Saindo do programa!");
                    break;
                }
                //Opção inválida do menu
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }//Fim switch   
        }//Fim while
    }//Fim main
}//Fim Principal
