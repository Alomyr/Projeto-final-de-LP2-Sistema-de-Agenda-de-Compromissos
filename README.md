# TimeMaster - Sistema de Agenda de Compromissos
Nome da Tarefa:
Projeto U3 — Sistema Livre com Árvore + Ordenação + POO Avançada (6pt)
Descrição:

#### Projeto U3 — Sistema Livre com Árvore + Ordenação + POO Avançada

## Entregáveis 

Código-fonte em packages (+ README com como compilar/rodar).

Saída de console mostrando CRUD + árvore + ordenação + leitura de anotação.

# Período:
Inicia em 18/11/2025 às 00h00 e finaliza em 27/11/2025 às 23h59
## 📋 Descrição do Projeto

O TimeMaster é um gerenciador inteligente de compromissos desenvolvido em Java que utiliza estruturas de dados avançadas e conceitos de Programação Orientada a Objetos para oferecer uma gestão eficiente de agenda pessoal e profissional.

# Descriçao da atividade Avaliativa: 

### Entrega final: 27/11/2025 — Valor: 6 pts

 

Desenvolva uma aplicação tema livre (ex.: produtos, alunos, agenda) que integre:

Estrutura de dados de árvore (ABB ou AVL).

Algoritmo de ordenação (MergeSort ou HeapSort).

POO avançada: interface(s), herança + polimorfismo, classe genérica, tratamento de exceções (inclui exceção de negócio).

Annotation personalizada lida em tempo de execução (Reflection).

Coleções genéricas (ArrayList / HashMap) quando fizer sentido.

 

## Requisitos obrigatórios

Domínio com classe base + 2 subclasses (polimorfismo ativo).

Interfaces (ex.: Repositorio<T>, Ordenacao<T>, Arvore<K,V>).

Classe genérica (ex.: RepositorioHash<T> com Function<T,String> para ID).

Exceções: NegocioException (regra de negócio) + try/catch no Main com mensagens claras.

Annotation @InfoAutor (nome, data) aplicada em ≥2 classes; ler via reflexão e imprimir.

Árvore (ABB/AVL): inserir, buscar, travessia em-ordem (retornar valores ordenados pela chave).

Ordenação (Merge/Heap): ordenar lista por Comparator.

Demonstração no Main: adicionar, listar, buscar, remover, imprimir em ordem (árvore) e ordenado (algoritmo).

## 🎯 Funcionalidades Principais

###    ✅ Cadastro, edição, busca e remoção de compromissos

###    ⚠️ Detecção de conflitos de horário na agenda

###    📊 Classificação de compromissos pessoais e profissionais

###    🔍 Busca eficiente usando Árvore Binária de Busca (ABB)

###    📈 Ordenação por data, prioridade e categoria usando HeapSort

###    🏷️ Sistema de prioridades para organização inteligente

## 🏗️ Estrutura do Domínio

### Classes Principais

    Compromisso (Classe Base)

        CompromissoPessoal (Subclasse)

        CompromissoProfissional (Subclasse)

### Regras de Negócio

    ❌ Data não pode ser no passado

    ❌ Não é permitido registrar dois compromissos no mesmo horário

    ✅ Validações com NegocioException

## 🛠️ Tecnologias e Conceitos Aplicados
### Estruturas de Dados

    Árvore Binária de Busca (ABB) por horário (LocalDateTime)

    HeapSort para ordenação múltipla

    HashMap para repositório genérico

### POO Avançada

    Herança e Polimorfismo

    Interfaces (Repositorio<T>, Ordenacao<T>, Arvore<K,V>)

    Classe Genérica RepositorioHash<T>

    Tratamento de Exceções personalizadas

### Recursos Java

    Annotations personalizadas (@InfoAutor)

    Reflection para leitura de metadados

    Generics para type safety

    Collections Framework

## 📁 Estrutura do Projeto

        src/
        ├── model/
        │    ├── Compromisso.java
        │    ├── CompromissoPessoal.java
        │    ├── CompromissoProfissional.java
        │    └── enums/
        │         ├── Prioridade.java
        │         └── Categoria.java
        ├── repository/
        │    ├── Repositorio.java
        │    ├── RepositorioHash.java
        │    └── Arvore.java
        ├── service/
        │    ├── AgendaService.java
        │    ├── OrdenacaoService.java
        │    └── NegocioException.java
        ├── view/
        │    ├── ViewConsole.java
        │    ├── MenuPrincipal.java
        │    └── HelpersView.java
        ├── annotation/
        │    └── InfoAutor.java
        └── main/
            └── Main.java




## 🚀 Como Compilar e Executar

### Pré-requisitos

Java JDK 11 ou superior

IDE Java (Eclipse, IntelliJ, VS Code) ou terminal

### Compilação via Terminal

    # Navegar até o diretório src
    cd src

    # Compilar todos os arquivos Java
    javac -d ../bin main/Main.java

    # Executar a aplicação
    java -cp ../bin main.Main
## Execução em IDE

Importe o projeto na sua IDE

Configure o JDK 11+

Execute a classe Main.java no pacote main

### 📊 Casos de Uso Demonstrados

### O sistema demonstra:

CRUD Completo - Create, Read, Update, Delete

Inserção na Árvore e travessia em-ordem

Ordenação com HeapSort por múltiplos critérios

Tratamento de Exceções com mensagens amigáveis

Leitura de Annotations via Reflection

Detecção de Conflitos de horário

## ⚙️ Funcionalidades Técnicas
### Árvore Binária de Busca

Inserção ordenada por LocalDateTime

Busca eficiente O(log n) em cenário balanceado

Travessia em-ordem para listagem ordenada

### Algoritmo HeapSort

Ordenação por data, prioridade e categoria

Implementação com Comparator

Complexidade O(n log n)

### Sistema de Exceções

NegocioException para regras de domínio

Try-catch no Main com feedback ao usuário

Validações em tempo de execução

## 🎨 Annotation Personalizada

    @InfoAutor

        Aplicada em Compromisso e RepositorioHash

        Contém nome do autor e data de criação

        Lida via Reflection no startup

## 📝 Exemplo de Uso

    // Criar compromisso profissional
    Compromisso reuniao = new CompromissoProfissional(
        "Reunião de Projeto",
        LocalDateTime.of(2025, 11, 20, 14, 0),
        Prioridade.ALTA,
        "Sala 101"
    );

    // Adicionar à agenda
    agendaService.adicionarCompromisso(reuniao);

    // Listar compromissos ordenados por prioridade
    List<Compromisso> ordenados = ordenacaoService.listarCompromissosPorPrioridade();

## 🗓️ Cronograma de Desenvolvimento dos conhecimentos em sala de aula:

    Data	Checkpoint
    16/10	Annotations: criar @InfoAutor
    21/10	Reflexão: ler @InfoAutor no Main
    23/10	Depuração e ajustes de exceções
    28/10	Profiling: medir tempo de ordenação
    04/11	Árvore ABB funcional
    06/11	Integração do algoritmo de ordenação
    11/11	Revisão final e organização
    18/11	Roteirização dos casos de uso
    25/11	Refinamento final
    27/11	Entrega do projeto

## 👥 Autores
**Instituição:** Universidade Federal do Rio Grande do Norte (UFRN)

**Departamento:** DEPARTAMENTO DE INFORMÁTICA E MATEMÁTICA APLICADA **Período:** [2025.2]

### Identificação Pessoal
**Professor** ALAN DE OLIVEIRA SANTANA
- **E-mail:**  alandeoliveirasantana@gmail.com


- **Nome dos alunos:**

    GUILHERME ANDRIEL FIGUEIREDO MEDEIROS DA SILVA

    JAMILLY EMILLY DA SILVA CAMPELO

    KEZIA KETILLEN SANTOS LIMA

    MATHEUS VINICIUS SILVA FREIRE DE CASTRO

    THEO HENRIQUE DA SILVA BORGES


- **E-mail e @github:** 
     
     matheuscastro11213@gmail.com / https://github.com/Alomyr
     jamilly.s.campelo@gmail.com / https://github.com/jamilly-campelo

     theo123b@gmail.com / https://github.com/TheooHenrique

##### ⚠️ Nota: Este projeto é acadêmico e desenvolvido para fins educacionais, demonstrando a aplicação prática de estruturas de dados e conceitos avançados de POO em Java. Projeto desenvolvido como trabalho final de Linguagem de Programação 2, implementando os conceitos aprendidos durante o curso.
