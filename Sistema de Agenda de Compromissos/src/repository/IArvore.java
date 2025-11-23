package repository;

// K = Tipo da Chave (LocalDateTime), V = Tipo do Valor (Compromisso)
public interface IArvore<K, V> {
    void adicionar(V valor, NoArvore noAtual);
    void remover(V valor, NoArvore noAtual);
    NoArvore buscarPorChave(NoArvore no, K chave);
    NoArvore getRaiz();
}