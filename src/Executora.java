public class Executora {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(6);
        arvoreBinaria.inserir(4);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(2);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(9);
        arvoreBinaria.inserir(11);

        System.out.println("Árvore antes da remoção:");

        //arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());//
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
        //arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());//

        arvoreBinaria.remover(6);

        System.out.println();

        System.out.println("Árvore após a remoção da raiz:");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
    }
}
