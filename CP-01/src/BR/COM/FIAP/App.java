package BR.COM.FIAP;


import java.util.Scanner;
import java.util.List;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProdutoDao dao = new ProdutoDao();

        int opcao;

        do {



            System.out.println("\n===== MENU PRODUTOS =====");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Pesquisar por Código");
            System.out.println("4 - Pesquisar por Nome");
            System.out.println("5 - Editar Produto");
            System.out.println("6 - Remover Produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer


            switch (opcao) {
                case 1:

                    System.out.print("Código: ");
                    int cod = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Preço(com vírgula):");
                    double preco = sc.nextDouble();



                    if (preco < 0) {
                        throw new IllegalArgumentException("O preço não pode ser negativo!!");
                    }

                    dao.cadastrar(new Produto(cod, nome, preco));

                    break;
                case 2:
                    dao.listar();
                    break;

                case 3:
                    System.out.print("Digite o código: ");
                    int c = sc.nextInt();
                    Produto p = dao.pesquisarPorCodigo(c);
                    if (p != null) p.exibirInfo();
                    else System.out.println("❌ Produto não encontrado.");
                    break;

                case 4:
                    System.out.print("Digite parte do nome: ");
                    String n = sc.nextLine();
                    List<Produto> encontrados = dao.pesquisarPorNome(n);
                    if (encontrados.isEmpty())
                        System.out.println("❌ Nenhum produto encontrado.");
                    else
                        encontrados.forEach(Produto::exibirInfo);
                    break;

                case 5:
                    System.out.print("Código do produto a editar: ");
                    int codEd = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Novo preço: ");
                    double novoPreco = sc.nextDouble();
                    dao.editar(codEd, novoNome, novoPreco);
                    break;

                case 6:
                    System.out.print("Código do produto a remover: ");
                    int codRem = sc.nextInt();
                    dao.remover(codRem);
                    break;

                case 0:
                    System.out.println("👋 Encerrando...");
                    break;

                default:
                    System.out.println("⚠ Opção inválida!");


            }
        } while (opcao != 0);


        sc.close();
    }

    }
