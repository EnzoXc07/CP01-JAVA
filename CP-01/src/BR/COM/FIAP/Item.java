package BR.COM.FIAP;

public abstract class Item {
    private int codigo;
    private String nome;

    public Item(int codigo, String nome) {

        if (codigo < 0){
            throw new IllegalArgumentException("O código não pode ser negativo.");
        }
        if (nome == null) {
            throw new IllegalArgumentException("O nome não pode ser nulo.");
        }

        this.codigo = codigo;
        this.nome = nome;
    }



    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public abstract void exibirInfo();

    }
