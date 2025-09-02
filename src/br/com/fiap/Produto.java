package br.com.fiap;

public class Produto extends Entidade {
    private double preco;

    public Produto(String nome, double preco) {
        super(nome);
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public double getValor() {
        return preco;
    }

    @Override
    public String toString() {
        return super.toString() + ", Preço: " + preco;
    }
}
