package repository;

import domain.model.Compromisso;
import java.time.LocalDateTime;

public class Arvore implements IArvore<LocalDateTime, Compromisso> {
    private NoArvore raiz;

    /**
     * @brief Constrói a árvore com um nó raíz padrão
     */
    public Arvore(){
        raiz = new NoArvore();
    }

    @Override
    public void adicionar(Compromisso compromisso, NoArvore noAtual) {
        NoArvore novoNo = new NoArvore(compromisso, null, null);
        if (this.raiz.getCompromisso() == null){
            this.raiz = novoNo;
        } else {
            if (noAtual == null) noAtual = this.raiz;

            if (compromisso.getDataHora().isAfter(noAtual.getCompromisso().getDataHora())){
                if (noAtual.getRight() != null){
                    adicionar(compromisso, noAtual.getRight());
                } else {
                    noAtual.setRight(novoNo);
                    novoNo.setPai(noAtual);
                }
            }
            else if (compromisso.getDataHora().isBefore(noAtual.getCompromisso().getDataHora())){
                if (noAtual.getLeft() != null){
                    adicionar(compromisso, noAtual.getLeft());
                } else {
                    noAtual.setLeft(novoNo);
                    novoNo.setPai(noAtual);
                }
            }
        }
    }

    @Override
    public void remover(Compromisso compromisso, NoArvore noAtual) {
        NoArvore target = buscarPorDataHora(noAtual, compromisso.getDataHora());
        if (target == null) return;

        // caso folha
        if (target.getLeft() == null && target.getRight() == null) {
            if (target == this.raiz){
                this.raiz = new NoArvore();
            } else {
                if (target.getPai().getLeft() == target){
                    target.getPai().setLeft(null);
                } else if (target.getPai().getRight() == target){
                    target.getPai().setRight(null);
                }
            }
            return;
        }

        // caso só tem filho à esquerda
        if (target.getLeft() != null && target.getRight() == null){
            NoArvore left = target.getLeft();
            target.setCompromisso(left.getCompromisso());
            // remove left node recursively
            remover(left.getCompromisso(), left);
            return;
        }

        // caso só tem filho à direita
        if (target.getRight() != null && target.getLeft() == null){
            NoArvore right = target.getRight();
            target.setCompromisso(right.getCompromisso());
            remover(right.getCompromisso(), right);
            return;
        }

        // caso tem os dois filhos
        if (target.getLeft() != null && target.getRight() != null){
            NoArvore succ = getSucc(target);
            if (succ != null){
                target.setCompromisso(succ.getCompromisso());
                if (succ.getPai() != null){
                    if (succ.getPai().getLeft() == succ) {
                        succ.getPai().setLeft(succ.getRight());
                    } else if (succ.getPai().getRight() == succ) {
                        succ.getPai().setRight(succ.getRight());
                    }
                    if (succ.getRight() != null) succ.getRight().setPai(succ.getPai());
                }
            }
        }
    }

    /**
     * @brief Busca um compromisso pela data e hora específicas
     * @param dt Data e hora do compromisso a ser buscado
     * @return Compromisso encontrado ou null se não existir
     * 
     * @note Útil para verificar conflitos de horário na agenda
     */
    @Override
    public NoArvore buscarPorChave(NoArvore no, LocalDateTime dt) {
        return this.buscarPorDataHora(no, dt); // Redireciona para seu método existente
    }

    public NoArvore buscarPorDataHora(NoArvore no, LocalDateTime dt) {
        if (no == null || no.value == null) {return null;}
        
        if (dt.equals(no.value.getDataHora())) {
            return no;
        } else if (dt.isBefore(no.value.getDataHora())) {
            return buscarPorDataHora(no.left, dt);
        } else {
            return buscarPorDataHora(no.right, dt);
        }
    }
  
    //Aux functions
    public NoArvore getMin(NoArvore root){
        if (root == null) return null;
        while (root.getLeft() != null){
            root = root.getLeft();
        }
        return root;
    }
    
    public NoArvore getMax(NoArvore root){
        if (root == null) return null;
        while (root.getRight() != null){
            root = root.getRight();
        }
        return root;
    }

    public NoArvore getPred(NoArvore root){
        if (root == null) return null;
        if (root.getLeft() != null){
            return getMax(root.getLeft());
        }
        return root.getPai();
    }

    /**
     * @brief Retorna sucessor de uma determinada árvore
     * @param root Nó raíz da árvore
     * @return Nó cuja dataHora é a sucessora do nó raíz
     */
    public NoArvore getSucc(NoArvore root){
        if (root == null) return null;
        if (root.getRight() != null){
            return getMin (root.getRight());
        }
        return root.getPai();
        
    }

    @Override
    public NoArvore getRaiz() {
        return this.raiz;
    }

    /**
     * @brief Imprime a árvore em In-Order (Ordem de dataHora)
     * @param no
     */
    public void printTree(NoArvore no){
        if (no == null || no.getCompromisso() == null) return;

        if (no.getLeft() != null) printTree(no.getLeft());
        System.out.println(no.getCompromisso().toString());
        if (no.getRight() != null) printTree(no.getRight());
    }
    
}
