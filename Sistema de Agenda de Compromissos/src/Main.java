import domain.model.Compromisso;
import repository.RepositorioHash;
import service.CompromissoService;
import view.CalendarioView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        RepositorioHash<Compromisso> repo =
                new RepositorioHash<>(Compromisso::getId);

        CompromissoService service =
                new CompromissoService(repo);

        int op;

        do {
            mostrarMenu();
            op = lerInt("Opção: ");

            try {
                switch (op) {
                    case 1:
                        cadastrar(service);
                        break;

                    case 2:
                        listar(service);
                        break;

                    case 3:
                        buscar(repo);
                        break;

                    case 4:
                        remover(service);
                        break;

                    case 0:
                        System.out.println("Encerrando...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("❌ ERRO: " + e.getMessage());
            }

        } while (op != 0);

        sc.close();
    }

    // ================= MENU =================

    private static void mostrarMenu() {
        System.out.println("\n==============================");
        System.out.println("        ⏰ TIME MASTER        ");
        System.out.println("==============================");
        System.out.println("1 - Cadastrar compromisso");
        System.out.println("2 - Listar compromissos");
        System.out.println("3 - Buscar compromisso por ID");
        System.out.println("4 - Remover compromisso");
        System.out.println("0 - Sair");
    }

    // ================= CADASTRO =================

    private static void cadastrar(CompromissoService service) {

        System.out.println("\n📅 Escolha a data do compromisso");

        LocalDate base = mostrarCalendarioDuranteCadastro(service);

        int dia;
        while (true) {
            dia = lerInt("Dia do mês: ");
            try {
                LocalDate.of(
                        base.getYear(),
                        base.getMonthValue(),
                        dia
                );
                break;
            } catch (Exception e) {
                System.out.println("❌ Dia inválido para este mês.");
            }
        }

        LocalDate data = LocalDate.of(
                base.getYear(),
                base.getMonthValue(),
                dia
        );

        // Hora no formato HH:mm
        LocalTime time;
        while (true) {
            try {
                System.out.print("Hora (HH:mm): ");
                String horaTotal = sc.nextLine();
                String[] horaMinuto = horaTotal.split(":");

                int hora = Integer.parseInt(horaMinuto[0]);
                int minuto = Integer.parseInt(horaMinuto[1]);

                time = LocalTime.of(hora, minuto);
                break;
            } catch (Exception e) {
                System.out.println("❌ Horário inválido. Use HH:mm");
            }
        }

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Descrição: ");
        String desc = sc.nextLine();

        int prioridade = lerInt("Prioridade (1-5): ");

        service.cadastrar(data, time, titulo, desc, prioridade);

        System.out.println("✔ Compromisso cadastrado com sucesso!");
    }

    // ================= LISTAR =================

    private static void listar(CompromissoService service) {
        List<Compromisso> lista = service.listarTodos();

        if (lista.isEmpty()) {
            System.out.println("Nenhum compromisso.");
            return;
        }

        for (Compromisso c : lista) {
            System.out.println("----------------------------------");
            System.out.println(c);
        }
    }

    // ================= BUSCAR =================

    private static void buscar(RepositorioHash<Compromisso> repo) {
        System.out.print("ID: ");
        String id = sc.nextLine();

        Compromisso c = repo.buscarPorId(id);
        System.out.println(c == null ? "❌ Não encontrado." : c);
    }

    // ================= REMOVER =================

    private static void remover(CompromissoService service) {
        System.out.print("ID para remover: ");
        String id = sc.nextLine();

        System.out.print("Confirmar remoção? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            service.remover(id);
            System.out.println("✔ Removido.");
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    // ================= CALENDÁRIO =================

    private static LocalDate mostrarCalendarioDuranteCadastro(
            CompromissoService service) {

        LocalDate atual = LocalDate.now();

        while (true) {
            CalendarioView.mostrar(
                    atual.getYear(),
                    atual.getMonthValue(),
                    service.listarTodos()
            );

            System.out.print(
                "\n[n] Próximo | [p] Anterior | [0] Escolher este mês: "
            );

            String cmd = sc.nextLine();

            if (cmd.equalsIgnoreCase("n")) {
                atual = atual.plusMonths(1);
            } else if (cmd.equalsIgnoreCase("p")) {
                atual = atual.minusMonths(1);
            } else if (cmd.equals("0")) {
                return atual;
            }
        }
    }

    // ================= UTIL =================

    private static int lerInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Digite um número válido.");
            }
        }
    }
}
