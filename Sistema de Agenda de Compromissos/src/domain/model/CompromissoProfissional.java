package domain.model;

import annotation.InfoAutor;
import java.time.LocalDate;
import java.time.LocalTime;


@InfoAutor(
    nome = "Matheus Castro", 
    data = "27/11/2025",
    versao = "1.0",
    descricao = "Subclass de compromisso da categoria profissional"
)
public class CompromissoProfissional extends Compromisso {
    public CompromissoProfissional(String id, LocalDate data, LocalTime hora, String titulo, String descricao, int prioridade) {
        super(id, data, hora, titulo, descricao, prioridade);
    }
}
