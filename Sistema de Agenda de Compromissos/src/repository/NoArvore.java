package repository;

import domain.model.Compromisso;

public class NoArvore {
    Compromisso value;
    NoArvore left;
    NoArvore right;
    NoArvore pai;

    /**
     * @brief Construtor com parâmetros
     * @param compromisso Compromisso a ser atribuído ao valor do nó
     * @param left Nó filho à esquerda do nó
     * @param right Nó filho à direita do nó
     */
    public NoArvore(Compromisso compromisso, NoArvore left, NoArvore right){
        this.value = compromisso;
        this.left = left;
        this.right = right;
    }

    /**
     * @brief Construtor do nó sem parâmetros
     */
    public NoArvore(){
        this.value = null;
        this.left = null;
        this.right = null;
        this.pai = null;
    }

    /**
     * @return Compromisso do nó
     */
    public Compromisso getCompromisso(){
        return this.value;
    };

    /**
     * @return Filho à esquerda
     */
    public NoArvore getLeft(){
        return this.left;
    }

    /**
     * @return Filho à direita
     */
    public NoArvore getRight(){
        return this.right;
    }

    /**
     * @return Nó pai
     */
    public NoArvore getPai(){
        return this.pai;
    }

    /**
     * @brief Insere um compromisso no nó
     * @param compromisso Compromisso a ser inserido no valor
     */
    public void setCompromisso(Compromisso compromisso){
        this.value = compromisso;
    }

    /**
     * @brief Insere filho à esquerda
     * @param left Nó à esquerda a ser inserido
     */
    public void setLeft(NoArvore left){
        this.left = left;
    }

    /**
     * @brief Insere filho à direita
     * @param right Nó à direita a ser inserido
     */
    public void setRight(NoArvore right){
        this.right = right;
    }

    /**
     * @brief Define quem é o pai
     * @param pai Pai a ser inserido
     */
    public void setPai(NoArvore pai){
        this.pai = pai;
    }
}
