package domain.model;

import annotation.InfoAutor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@InfoAutor(
    nome = "Matheus Castro", 
    data = "27/11/2025",
    versao = "1.0",
    descricao = "Classe base para todos os tipo de compromisso"
)
public class Compromisso {

    private String id;
    private LocalDate data;
    private LocalTime hora;
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

    public Compromisso(String id, LocalDate data, LocalTime hora, String titulo, String descricao, int prioridade) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public LocalDateTime getDataHora() {
        return LocalDateTime.of(data, hora);
    }
}
