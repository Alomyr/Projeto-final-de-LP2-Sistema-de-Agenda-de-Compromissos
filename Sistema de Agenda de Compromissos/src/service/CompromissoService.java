package service;

import annotation.InfoAutor;
import domain.exception.NegocioException;
import domain.model.Compromisso;
import domain.model.CompromissoPessoal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import repository.RepositorioHash;
import util.Ordenavel;

@InfoAutor(
    nome = "Matheus Castro", 
    data = "27/11/2025",
    versao = "1.0",
    descricao = "Serviço ajustado para usar apenas RepositorioHash por enquanto"
)
public class CompromissoService {

    private final RepositorioHash<Compromisso> repo;
    private int sequence = 1;
    private final Ordenavel<Compromisso> ordenacaoService;

    public CompromissoService(RepositorioHash<Compromisso> repo) {
        this.repo = repo;
        this.ordenacaoService = new OrdenacaoService<>();
    }

    public List<Compromisso> listarCompromissosOrdenadosPorId() {
        List<Compromisso> lista = repo.listarTodos(); 

        ordenacaoService.ordenar(lista, Compromisso.POR_ID);

        return lista;
    }

    public List<Compromisso> listarCompromissosPorPrioridade() {
        List<Compromisso> lista = repo.listarTodos(); 
        
        ordenacaoService.ordenar(lista, Compromisso.POR_PRIORIDADE);
        
        return lista;
    }

    public void cadastrar(LocalDate data, LocalTime hora, String titulo, String descricao, int prioridade) {
        if (data.isBefore(LocalDate.now())) {
            throw new NegocioException("Data no passado.");
        }

        LocalDateTime dt = LocalDateTime.of(data, hora);

        for (Compromisso c : repo.listarTodos()) {
            if (c.getDataHora().equals(dt)) {
                throw new NegocioException("Conflito de horário.");
            }
        }

        String id = String.valueOf(sequence++);
        Compromisso c = new CompromissoPessoal(id, data, hora, titulo, descricao, prioridade);

        repo.salvar(c);
    }

    public void editar(String id, LocalDate novaData, LocalTime novaHora, String novoTitulo,
                       String novaDesc, int novaPrioridade) {

        Compromisso c = repo.buscarPorId(id);
        if (c == null) throw new NegocioException("Não encontrado.");

        if (novaData.isBefore(LocalDate.now())) {
            throw new NegocioException("Data no passado.");
        }

        LocalDateTime dt = LocalDateTime.of(novaData, novaHora);
        for (Compromisso existente : repo.listarTodos()) {
            if (existente.getDataHora().equals(dt) && !existente.getId().equals(c.getId())) {
                throw new NegocioException("Conflito de horário.");
            }
        }

        c.setData(novaData);
        c.setHora(novaHora);
        c.setTitulo(novoTitulo);
        c.setDescricao(novaDesc);
        c.setPrioridade(novaPrioridade);
    }

    public void remover(String id) {
        repo.remover(id);
    }

    public List<Compromisso> listarTodos() {
        return repo.listarTodos();
    }
}