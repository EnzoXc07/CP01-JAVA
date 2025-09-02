package br.com.fiap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Entidade> produtos = new ArrayList<>();
    private static int proximoCodigo = 1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Pesquisar por Código");
            System.out.println("4. Editar Produto");
            System.out.println("5. Remover Produto");
            System.out.println("6. Pesquisar por Nome");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço do produto: ");
                    double preco = sc.nextDouble();
                    sc.nextLine();
                    Produto p = new Produto(nome, preco);
                    p.setCodigo(proximoCodigo++);
                    produtos.add(p);
                    System.out.println("Produto cadastrado!");
                    break;
                case 2:
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for (Entidade e : produtos) {
                            System.out.println(e);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Código: ");
                    int cod = sc.nextInt();
                    sc.nextLine();
                    Entidade e = null;
                    for (Entidade prod : produtos) {
                        if (prod.getCodigo() == cod) {
                            e = prod;
                            break;
                        }
                    }
                    if (e != null) {
                        System.out.println(e);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Código do produto a editar: ");
                    int codEdit = sc.nextInt();
                    sc.nextLine();
                    Entidade eEdit = null;
                    for (Entidade prod : produtos) {
                        if (prod.getCodigo() == codEdit) {
                            eEdit = prod;
                            break;
                        }
                    }
                    if (eEdit != null) {
                        System.out.print("Novo nome: ");
                        String novoNome = sc.nextLine();
                        System.out.print("Novo preço: ");
                        double novoPreco = sc.nextDouble();
                        sc.nextLine();
                        eEdit.setNome(novoNome);
                        ((Produto) eEdit).setPreco(novoPreco);
                        System.out.println("Produto editado!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Código do produto a remover: ");
                    int codRem = sc.nextInt();
                    sc.nextLine();
                    Entidade toRemove = null;
                    for (Entidade prod : produtos) {
                        if (prod.getCodigo() == codRem) {
                            toRemove = prod;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        produtos.remove(toRemove);
                        System.out.println("Produto removido!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 6:
                    System.out.print("Nome a pesquisar: ");
                    String nomePesq = sc.nextLine();
                    List<Entidade> resultados = new ArrayList<>();
                    for (Entidade prod : produtos) {
                        if (prod.getNome().equalsIgnoreCase(nomePesq)) {
                            resultados.add(prod);
                        }
                    }
                    if (resultados.isEmpty()) {
                        System.out.println("Nenhum produto encontrado.");
                    } else {
                        for (Entidade r : resultados) {
                            System.out.println(r);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();

    }
}