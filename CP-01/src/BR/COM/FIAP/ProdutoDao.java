package BR.COM.FIAP;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ProdutoDao {
    private Map<Integer, Produto> produtos = new HashMap<>();

    public void cadastrar(Produto produto) {
        if (produtos.containsKey(produto.getCodigo())) {
            System.out.println("❌ Já existe um produto com esse código!");
            Pause();
            LimparTela();

        } else {
            produtos.put(produto.getCodigo(), produto);
            System.out.println("✅ Produto cadastrado com sucesso!");
            Pause();
            LimparTela();
        }
    }

    public void listar() {
        if (produtos.isEmpty()) {
            System.out.println("⚠ Nenhum produto cadastrado.");
            Pause();
            LimparTela();
        } else {
            produtos.values().forEach(Produto::exibirInfo);
        }
    }

    public Produto pesquisarPorCodigo(int codigo) {
        return produtos.get(codigo);
    }

    public List<Produto> pesquisarPorNome(String nome) {
        List<Produto> encontrados = new ArrayList<>();
        for (Produto p : produtos.values()) {
            if (p.getNome().toLowerCase().contains(nome.toLowerCase())) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }

    public void editar(int codigo, String novoNome, double novoPreco) {
        Produto produto = produtos.get(codigo);
        if (produto != null) {
            produto.setNome(novoNome);
            produto.setPreco(novoPreco);
            System.out.println("✏ Produto atualizado com sucesso!");
            Pause();
            LimparTela();
        } else {
            System.out.println("❌ Produto não encontrado.");
            Pause();
            LimparTela();
        }
    }

    public void remover(int codigo) {
        if (produtos.remove(codigo) != null) {
            System.out.println("🗑 Produto removido com sucesso!");
            Pause();
            LimparTela();
        } else {
            System.out.println("❌ Produto não encontrado.");

            Pause();
            LimparTela();
        }
    }
public static void Pause(){
    try {
        Thread.sleep(1500);
    } catch (InterruptedException e) {
    }
}

    public static void LimparTela() {
        for (int i = 0; i < 50; i++)
            System.out.println();
    }

}
