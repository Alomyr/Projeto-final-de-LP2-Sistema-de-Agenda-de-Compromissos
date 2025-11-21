# Projeto-final-de-LP2-Sistema-de-Agenda-de-Compromissos
// NOTE: fazer o restante do readme e docxigen

## PROPOSTA 4 — Sistema de Agenda de Compromissos 
“TimeMaster” — Gerenciador inteligente de compromissos 

### Domínio 

• Classe Base: Compromisso 
• Subclasses: 
    o CompromissoPessoal 
    o CompromissoProfissional 
### Funcionalidades 

• Cadastrar, editar, buscar e remover compromissos. 
• Checar conflitos de agenda. 
• Regra de negócio: 
        o Data não pode ser passada. 
        o Não pode registrar dois compromissos no mesmo horário → 
        NegocioException. 
### Árvore 

• ABB por horário (LocalDateTime). 
### Ordenação 

• HeapSort por: 
    o Data, 
    o Prioridade, 
    o Categoria. 
### POO Avançada 

• Interfaces + Repositório genérico. 
• Classe genérica de repositorio com Function<Compromisso, String> para ID. 

### Anotação 
• @InfoAutor em Compromisso e RepositorioHash.


Nome da Tarefa:
Projeto U3 — Sistema Livre com Árvore + Ordenação + POO Avançada (6pt)
Descrição:

Projeto U3 — Sistema Livre com Árvore + Ordenação + POO Avançada

 

Entrega final: 27/11/2025 — Valor: 6 pts

 

Desenvolva uma aplicação tema livre (ex.: produtos, alunos, agenda) que integre:

 

Estrutura de dados de árvore (ABB ou AVL).

Algoritmo de ordenação (MergeSort ou HeapSort).

POO avançada: interface(s), herança + polimorfismo, classe genérica, tratamento de exceções (inclui exceção de negócio).

Annotation personalizada lida em tempo de execução (Reflection).

Coleções genéricas (ArrayList / HashMap) quando fizer sentido.

 

Requisitos obrigatórios

 

Domínio com classe base + 2 subclasses (polimorfismo ativo).

Interfaces (ex.: Repositorio<T>, Ordenacao<T>, Arvore<K,V>).

Classe genérica (ex.: RepositorioHash<T> com Function<T,String> para ID).

Exceções: NegocioException (regra de negócio) + try/catch no Main com mensagens claras.

Annotation @InfoAutor (nome, data) aplicada em ≥2 classes; ler via reflexão e imprimir.

Árvore (ABB/AVL): inserir, buscar, travessia em-ordem (retornar valores ordenados pela chave).

Ordenação (Merge/Heap): ordenar lista por Comparator.

Demonstração no Main: adicionar, listar, buscar, remover, imprimir em ordem (árvore) e ordenado (algoritmo).

 

Entregáveis

 

Código-fonte em packages (+ README com como compilar/rodar).

Saída de console mostrando CRUD + árvore + ordenação + leitura de anotação.

 

Checkpoints por aula (curtinhos)

 

16/10 – Annotations: criar @InfoAutor e anotar 2 classes.

21/10 – Reflexão: ler @InfoAutor no Main.

23/10 – Depuração: rodar com alguns registros; ajustar mensagens/exceções.

28/10 – Profiling: medir tempo de ordenar N itens (log em ms).

30/10 – Estruturas (listas/pilhas): (opcional) fila/pilha pequena de ações.

04/11 – Árvores/Grafos: árvore (ABB/AVL) funcional (inserir/buscar/em-ordem).

06/11 – Integração de algoritmos: ligar sort por Comparator e comparar com em-ordem.

11/11 – Revisão: limpar pacotes/nomes; README.

18/11 – Orientações: roteirizar casos do Main (CRUD + árvore + sort).

25/11 – Desenvolvimento: refino final.

27/11 – Entrega: demonstração rodando.
Período:
Inicia em 18/11/2025 às 00h00 e finaliza em 27/11/2025 às 23h59