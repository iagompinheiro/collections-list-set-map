package list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompra {

    private List<Item> itemList;

    public CarrinhoCompra() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removeItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        for (Item item : itemList) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                itensParaRemover.add(item);
            }
        }
        itemList.removeAll(itensParaRemover);
    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        for (Item item : itemList) {
            valorTotal += item.getPreco() * item.getQuantidade();
        }
        return valorTotal;
    }


    public void exibirItens() {
        if (!itemList.isEmpty()) {
            System.out.println(this.itemList);
        } else {
            System.out.println("O carrinho está vazio.");
        }

    }

    @Override
    public String toString() {
        return "CarrinhoCompra{" +
                "itemList=" + itemList +
                '}';
    }

    public static void main(String[] args) {
        CarrinhoCompra carrinhoCompra = new CarrinhoCompra();

        carrinhoCompra.adicionarItem("Camiseta", 5d, 1);
        carrinhoCompra.adicionarItem("Calça", 2d, 1);

        carrinhoCompra.exibirItens();
        System.out.println("O valor total é: " + carrinhoCompra.calcularValorTotal());


        carrinhoCompra.removeItem("Calça");
        carrinhoCompra.exibirItens();

        System.out.println("O valor total é: " + carrinhoCompra.calcularValorTotal());
    }
}

