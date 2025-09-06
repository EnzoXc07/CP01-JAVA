package BR.COM.FIAP;

public class Produto extends Item {
    private double preco;

    public Produto(int codigo, String nome, double preco) {
        super(codigo, nome);
        this.preco = preco;
    }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    @Override
    public void exibirInfo() {
        System.out.printf("Produto: %s | Código: %d | Preço: R$ %.2f%n", getNome(), getCodigo(), preco);
    }
}