package repository;

import annotation.InfoAutor;
import domain.model.Compromisso;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@InfoAutor(
    nome = "Matheus Castro", 
    data = "27/11/2025",
    versao = "1.0",
    descricao = "Classe basica para as function que o usario pode usar respeitando as regras de negocios"
)
public class Repositorio {

    private final List<Compromisso> lista = new ArrayList<>();

    public void salvar(Compromisso c) {
        lista.add(c);
    }

    public void remover(Compromisso c) {
        lista.remove(c);
    }

    public List<Compromisso> buscarTodos() {
        return new ArrayList<>(lista);
    }

    public Compromisso buscarPorId(String id) {
        return lista.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public Compromisso buscarPorDataHora(LocalDateTime dt) {
        return lista.stream()
            .filter(c -> c.getDataHora().equals(dt))
            .findFirst()
            .orElse(null);
    }
}
