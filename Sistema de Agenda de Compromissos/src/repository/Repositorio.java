package repository;

import java.util.List;

public interface Repositorio<T> {
    void salvar(T entidade);
    void remover(String id);
    T buscarPorId(String id);
    List<T> listarTodos();
}