package repository;

import annotation.InfoAutor;
import domain.model.Compromisso;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@InfoAutor(nome = "Matheus Castro", data = "27/11/2025", versao = "1.0", descricao = "Repositorio Generico com Hash")
public class RepositorioHash<T> implements Repositorio<T> {

    private final Map<String, T> dados = new HashMap<>();
    private final Function<T, String> extratorId; 
    private final Arvore arvore; 

    public RepositorioHash(Function<T, String> extratorId) {
        this.extratorId = extratorId;
        this.arvore = new Arvore();
    }

    @Override
    public void salvar(T entidade) {
        String id = extratorId.apply(entidade);
        
        dados.put(id, entidade);

        if (entidade instanceof Compromisso) {
            this.arvore.adicionar((Compromisso) entidade, this.arvore.getRaiz());
        }
    }

    @Override
    public void remover(String id) {
        T removed = dados.remove(id);
        if (removed instanceof Compromisso) {
            this.arvore.remover((Compromisso) removed, this.arvore.getRaiz());
        }
    }

    // Remover por entidade (genérico)
    public void remover(T entidade){
        String id = extratorId.apply(entidade);
        remover(id);
    }

    @Override
    public T buscarPorId(String id) {
        return dados.get(id);
    }

    @Override
    public java.util.List<T> listarTodos() {
        return new ArrayList<>(dados.values());
    }

    public Arvore getTree(){
        return this.arvore;
    }
}