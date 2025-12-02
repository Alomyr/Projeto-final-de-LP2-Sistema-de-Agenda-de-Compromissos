import domain.model.Compromisso;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import repository.Arvore;
import repository.RepositorioHash;
import service.CompromissoService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        RepositorioHash<Compromisso> repo = new RepositorioHash<>(Compromisso::getId);
        CompromissoService service = new CompromissoService(repo);

        while (true) {
            System.out.println("\n--- TIME MASTER ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar ordenado por data/hora");
            System.out.println("3 - Listar ordenado por ID");
            System.out.println("4 - Listar ordenado por prioridade");
            System.out.println("5 - Buscar por ID");
            System.out.println("6 - Remover");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            
            int op = sc.nextInt();
            sc.nextLine(); 

            if (op == 0) break;

            try { 
                switch (op) {
                    case 1: {
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

                        System.out.print("Descrição: ");
                        String d = sc.nextLine();

                        System.out.print("Prioridade: ");
                        int p = sc.nextInt();

                        service.cadastrar(LocalDate.of(ano, mes, dia), LocalTime.of(h, m), t, d, p);
                        System.out.println(">> Sucesso: Compromisso cadastrado!");
                        break;
                    }

                    case 2: {
                        System.out.println("\n--- LISTA POR DATA/HORA ---");
                        List<Compromisso> lista = service.listarTodos();
                        Arvore arvore = repo.getTree();

                        if (lista.isEmpty()) {
                            System.out.println("Nenhum compromisso agendado.");
                        } else {
                            arvore.printTree(arvore.getRaiz());
                        }
                        break;
                    }

                    case 3: {
                        System.out.println("\n--- LISTA POR ID ---");
                        List<Compromisso> listaId = service.listarCompromissosOrdenadosPorId();
                        if (listaId.isEmpty()) {
                            System.out.println("Nenhum compromisso cadastrado.");
                        } else {
                            for (Compromisso c : listaId) System.out.println(c);
                        }
                        break;
                    }

                    case 4: {
                        System.out.println("\n--- LISTA POR PRIORIDADE ---");
                        List<Compromisso> listaPrioridade = service.listarCompromissosPorPrioridade();
                        if (listaPrioridade.isEmpty()) {
                            System.out.println("Nenhum compromisso cadastrado.");
                        } else {
                            for (Compromisso c : listaPrioridade) System.out.println(c);
                        }
                        break;
                    }

                    case 5: {
                        System.out.print("ID para busca: ");
                        String idBusca = sc.nextLine();
                        Compromisso encontrado = repo.buscarPorId(idBusca);

                        if (encontrado != null) {
                            System.out.println("Encontrado: " + encontrado);
                        } else {
                            System.out.println(">> Não encontrado.");
                        }
                        break;
                    }

                    case 6: {
                        System.out.print("ID para remover: ");
                        String idRem = sc.nextLine();
                        service.remover(idRem);
                        System.out.println(">> Operação de remoção concluída.");
                        break;
                    }
                    
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
        sc.close();
    }
}