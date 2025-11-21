# Projeto-final-de-LP2-Sistema-de-Agenda-de-Compromissos

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