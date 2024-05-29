public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int conteudo) {
        No novoNo = new No(conteudo);
        No pai;
        if (raiz == null) {
            //System.out.println("A raiz foi criada com o conteúdo " + novoNo.getConteudo() + ".");
            raiz = novoNo;
        } else {
            //Verificar se ficara a esq ou direita
            No atual = raiz;
            while (true) {
                pai = atual;
                if (novoNo.getConteudo() <= atual.getConteudo()) {
                    //posicionar o nó à esq
                    atual = atual.getEsquerda();
                    if (atual == null) {
                        pai.setEsquerda(novoNo);
                        //System.out.println("O nó com conteúdo " + novoNo.getConteudo() + " foi inserido com sucesso, onde seu pai é igual a: " + pai.getConteudo());
                        return;
                    }
                } else {
                    //posicionar o nó à dir
                    atual = atual.getDireita();
                    if (atual == null) {
                        pai.setDireita(novoNo);
                        //System.out.println("O nó com conteúdo " + novoNo.getConteudo() + " foi inserido com sucesso, onde seu pai é igual a: " + pai.getConteudo());
                        return;
                    }
                }
            }

        }
    }


    public void preOrdem(No no) {
        StringBuilder resultado = new StringBuilder();
        preOrdem(no, resultado);
        System.out.println(resultado.toString().trim());
    }

    private void preOrdem(No no, StringBuilder resultado) {
        if (no == null) {
            return;
        }
        resultado.append(no.getConteudo()).append(" ");
        preOrdem(no.getEsquerda(), resultado);
        preOrdem(no.getDireita(), resultado);
    }

    public void emOrdem(No no) {
        StringBuilder resultado = new StringBuilder();
        emOrdem(no, resultado);
        System.out.println(resultado.toString().trim());
    }

    private void emOrdem(No no, StringBuilder resultado) {
        if (no == null) {
            return;
        }
        emOrdem(no.getEsquerda(), resultado);
        resultado.append(no.getConteudo()).append(" ");
        emOrdem(no.getDireita(), resultado);
    }

    public void posOrdem(No no) {
        StringBuilder resultado = new StringBuilder();
        posOrdem(no, resultado);
        System.out.println(resultado.toString().trim());
    }

    private void posOrdem(No no, StringBuilder resultado) {
        if (no == null) {
            return;
        }
        posOrdem(no.getEsquerda(), resultado);
        posOrdem(no.getDireita(), resultado);
        resultado.append(no.getConteudo()).append(" ");
    }

    public No getRaiz() {
        return raiz;
    }

    public void remover ( int val){
        if (raiz == null) {
            return;
        }

        No pai = null;
        No atual = raiz;

        // Encontrar o nó a ser removido
        while (atual != null && atual.getConteudo() != val) {
            pai = atual;
            if (val < atual.getConteudo()) {
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }

        if (atual == null) {
            return; // Nó não encontrado
        }

        // Caso 1: Nó a ser removido não tem filhos
        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            if (pai == null) {
                raiz = null; // Nó é a raiz
            } else if (pai.getEsquerda() == atual) {
                pai.setEsquerda(null); // Nó é filho à esquerda
            } else {
                pai.setDireita(null); // Nó é filho à direita
            }
            return;
        }

        // Caso 2: Nó a ser removido tem apenas um filho
        if (atual.getEsquerda() == null) {
            if (pai == null) {
                raiz = atual.getDireita(); // Nó é a raiz
            } else if (pai.getEsquerda() == atual) {
                pai.setEsquerda(atual.getDireita()); // Nó é filho à esquerda
            } else {
                pai.setDireita(atual.getDireita()); // Nó é filho à direita
            }
            return;
        } else if (atual.getDireita() == null) {
            if (pai == null) {
                raiz = atual.getEsquerda(); // Nó é a raiz
            } else if (pai.getEsquerda() == atual) {
                pai.setEsquerda(atual.getEsquerda()); // Nó é filho à esquerda
            } else {
                pai.setDireita(atual.getEsquerda()); // Nó é filho à direita
            }
            return;
        }

        //Caso 3: Nó a ser removida com 2 filhos
        No sucessor = menor(atual.getDireita());
        atual.setConteudo(sucessor.getConteudo());
        atual = atual.getDireita();
        No paiSucessor = atual;
        while (atual.getEsquerda() != null) {
            paiSucessor = atual;
            atual = atual.getEsquerda();
        }
        if (paiSucessor == sucessor) {
            atual.setEsquerda(null);
        } else {
            paiSucessor.setEsquerda(atual.getDireita());
        }
    }

    private No menor(No no) {
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }
}