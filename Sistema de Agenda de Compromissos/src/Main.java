
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import repository.RepositorioSimples;
import service.CompromissoService;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RepositorioSimples repo = new RepositorioSimples();
        CompromissoService service = new CompromissoService(repo);

        while (true) {
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Remover");
            System.out.println("0 - Sair");
            int op = sc.nextInt();
            sc.nextLine();

            if (op == 0) break;

            switch (op) {
                case 1:
                    System.out.print("Dia: ");
                    int dia = sc.nextInt();
                    System.out.print("Mês: ");
                    int mes = sc.nextInt();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    System.out.print("Hora: ");
                    int h = sc.nextInt();
                    System.out.print("Minuto: ");
                    int m = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Título: ");
                    String t = sc.nextLine();

                    System.out.print("Desc: ");
                    String d = sc.nextLine();

                    System.out.print("Prioridade: ");
                    int p = sc.nextInt();

                    service.cadastrar(LocalDate.of(ano, mes, dia), LocalTime.of(h, m), t, d, p);
                    System.out.println("OK!");
                    break;

                case 2:
                    service.listarTodos().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.println(repo.buscarPorId(id));
                    break;

                case 4:
                    System.out.print("ID: ");
                    service.remover(sc.nextLine());
                    break;
            }
        }
    }
}
// para verificar as coisas basta usar  if(date.equals(/* data e hora da coisa */)) @TheeoHenrique
