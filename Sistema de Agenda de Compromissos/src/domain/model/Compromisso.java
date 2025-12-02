package domain.model;

import annotation.InfoAutor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;

/**
 * @brief Classe abstrata base que representa um compromisso na agenda
 *
 * @note Classe base para hierarquia de compromissos usando herança
 * @see CompromissoPessoal
 * @see CompromissoProfissional
 */
@InfoAutor(
        nome = "Matheus Castro",
        data = "27/11/2025",
        versao = "1.0",
        descricao = "Classe base para todos os tipo de compromisso"
)
public abstract class Compromisso {

    private String id;
    private LocalDate data;
    private LocalTime hora;
    private LocalDateTime dataHora;
    private String titulo;
    private String descricao;
    private int prioridade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    /**
     * @brief Construtor padrão sem parâmetros
     * 
     * @note Cria uma instância vazia de Compromisso
     */
    public Compromisso(){

    }

    /**
     * @brief Construtor parametrizado completo
     * 
     * @param id Identificador único do compromisso
     * @param data Data do compromisso
     * @param hora Hora do compromisso
     * @param titulo Título descritivo do compromisso
     * @param descricao Descrição detalhada do compromisso
     * @param prioridade Nível de prioridade (valores mais altos = maior prioridade)
     */
    public Compromisso(String id, LocalDate data, LocalTime hora, String titulo, String descricao, int prioridade) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    /**
     * @brief Combina data e hora em um único objeto LocalDateTime
     * @return LocalDateTime representando a data e hora completas do compromisso
     * 
     * @note Método útil para comparações e ordenações por data/hora completa
     */
    public LocalDateTime getDataHora() {
        return LocalDateTime.of(data, hora);
    }
    
    /**
     * @brief Representação em string do compromisso
     * @return String formatada com informações do compromisso
     */
    @Override
    public String toString() {
        return String.format("%s - %s | %s | %s | Prioridade: %d", 
                data, hora, titulo, descricao, prioridade);
    }

    public static final Comparator<Compromisso> POR_ID = 
        Comparator.comparingInt(c -> Integer.parseInt(c.getId()));

    public static final Comparator<Compromisso> POR_PRIORIDADE = 
        Comparator.comparingInt(Compromisso::getPrioridade).reversed();
}