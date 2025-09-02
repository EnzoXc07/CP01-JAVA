package br.com.fiap;

public abstract class Entidade {
    private int codigo;
    private String nome;

    public Entidade(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract double getValor();

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome;
    }
}
