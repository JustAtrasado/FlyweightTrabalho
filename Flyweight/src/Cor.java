import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Cor {
    private String nome;

    public Cor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class CorFactory {
    private Map<String, Cor> cores = new HashMap<>();

    public Cor getCor(String nome) {
        Cor cor = cores.get(nome);
        if (cor == null) {
            cor = new Cor(nome);
            cores.put(nome, cor);
        }
        return cor;
    }
}

class Forma {
    private Cor cor;
    private String posicao;
    private int tamanho;

    public Forma(Cor cor, String posicao, int tamanho) {
        this.cor = cor;
        this.posicao = posicao;
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Forma [cor=" + cor.getNome() + ", posição=" + posicao + ", tamanho=" + tamanho + "]";
    }
}

class FormaManager {
    private List<Forma> formas = new ArrayList<>();
    private CorFactory corFactory = new CorFactory();

    public void addForma(String nomeCor, String posicao, int tamanho) {
        Cor cor = corFactory.getCor(nomeCor);
        formas.add(new Forma(cor, posicao, tamanho));
    }

    public void apresentar() {
        for (Forma forma : formas) {
            System.out.println(forma);
        }
    }
}

class SistemaGestaoCores {
    public static void main(String[] args) {
        FormaManager formaManager = new FormaManager();

        formaManager.addForma("Vermelho", "0,0", 10);
        formaManager.addForma("Verde", "1,1", 20);
        formaManager.addForma("Vermelho", "2,2", 15);

        formaManager.apresentar();
    }
}
