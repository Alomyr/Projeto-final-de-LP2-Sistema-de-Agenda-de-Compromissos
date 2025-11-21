package domain.model;

import annotation.InfoAutor;
import java.time.LocalDate;
import java.time.LocalTime;

@InfoAutor(
    nome = "Matheus Castro", 
    data = "27/11/2025",
    versao = "1.0",
    descricao = "Subclass de compromisso da categoria pessoal"
)
public class CompromissoPessoal extends Compromisso {
    public CompromissoPessoal(String id, LocalDate data, LocalTime hora, String titulo, String descricao, int prioridade) {
        super(id, data, hora, titulo, descricao, prioridade);
    }
}
