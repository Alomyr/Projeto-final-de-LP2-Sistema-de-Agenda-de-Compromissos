package repository;

import annotation.InfoAutor;
import domain.model.Compromisso;

/**
 * @brief Implementação concreta de repositório para entidades Compromisso
 *
 * @note Implementa operações CRUD básicas para gerenciamento de compromissos
 * @see Compromisso
 */
@InfoAutor(
        nome = "Matheus Castro",
        data = "27/11/2025",
        versao = "1.0",
        descricao = "Classe básica para as funções que o usuário pode usar respeitando as regras de negócios"
)
public class Repositorio {

    private final Arvore tree = new Arvore();

    /**
     * @brief Adiciona um novo compromisso ao repositório
     * @param c Compromisso a ser salvo no repositório
     */
    public void salvar(Compromisso c) {
        tree.Adicionar(c, tree.getRaiz());
    }

    /**
     * @brief Remove um compromisso existente do repositório
     * @param c Compromisso a ser removido do repositório
     */
    public void remover(Compromisso c) {
        tree.Remover(c, tree.getRaiz());
    }

    /**
     * @brief Busca um compromisso pelo seu identificador único
     * @param id Identificador do compromisso a ser buscado
     * @return Compromisso encontrado ou null se não existir
     */
    //TODO @Guilherme-Andriel buscar por id. Tem que pegar a árvore, transformar numa lista, e buscar por id nessa lista.
   public Compromisso buscarPorId(String id) {
    List<Compromisso> lista = new ArrayList<>();
    percorrerEmOrdem(tree.getRaiz(), lista);

    for (Compromisso c : lista) {
        if (c.getId().equals(id)) {
            return c;
        }
    }

    return null;
    }
    // método auxiliar (conversão da árvore para lista)
    private void percorrerEmOrdem(NoArvore no, List<Compromisso> lista) {
        if (no == null || no.getCompromisso() == null) return;

        percorrerEmOrdem(no.getLeft(), lista);
        lista.add(no.getCompromisso());
        percorrerEmOrdem(no.getRight(), lista);
    }



    public Arvore getTree(){
        return this.tree;
    }
}
