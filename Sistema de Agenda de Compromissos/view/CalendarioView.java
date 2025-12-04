package view;

import domain.model.Compromisso;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CalendarioView {

    public static void mostrar(int ano, int mes,
                               List<Compromisso> compromissos) {

        YearMonth ym = YearMonth.of(ano, mes);
        LocalDate primeiro = ym.atDay(1);

        DayOfWeek diaSemana = primeiro.getDayOfWeek();
        int deslocamento = diaSemana.getValue() % 7;

        Set<Integer> diasOcupados =
                compromissos.stream()
                        .filter(c -> c.getData().getYear() == ano &&
                                     c.getData().getMonthValue() == mes)
                        .map(c -> c.getData().getDayOfMonth())
                        .collect(Collectors.toSet());

        System.out.printf(
                "\n      📅 %s / %d\n",
                ym.getMonth(), ano);

        System.out.println("Do Se Te Qu Qa Se Sá");

        for (int i = 0; i < deslocamento; i++)
            System.out.print("   ");

        for (int dia = 1; dia <= ym.lengthOfMonth(); dia++) {

            if (diasOcupados.contains(dia)) {
                System.out.printf("%2d*", dia);
            } else {
                System.out.printf("%2d ", dia);
            }

            if ((dia + deslocamento) % 7 == 0)
                System.out.println();
            else
                System.out.print(" ");
        }

        System.out.println("\n* Dia com compromissos");
    }
}
