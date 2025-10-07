import java.util.ArrayList;
import java.util.List;

public class Biblioteca<T extends Midia> {
    private final List<T> midias = new ArrayList<>();

    public void adicionarMidia(T midia) {
        if (midia != null) midias.add(midia);
    }

    public List<T> obterListaMidias() {
        return midias;
    }
}