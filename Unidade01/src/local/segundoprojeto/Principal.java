package local.segundoprojeto;



import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DAO dao = new DAO();

        dao.conectar();

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Listar Empregados");
            System.out.println("2. Inserir Empregados");
            System.out.println("3. Excluir Empregados");
            System.out.println("4. Atualizar Empregados");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (opcao) {
                case 1:
                    listarEmpregados(dao);
                    break;
                case 2:
                    inserirEmpregado(scanner, dao);
                    break;
                case 3:
                    excluirEmpregados(scanner, dao);
                    break;
                case 4:
                    atualizarEmpregados(scanner, dao);
                    break;
                case 5:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
            }
        } while (opcao != 5);

        dao.close();
        scanner.close();
    }

    public static void listarEmpregados(DAO dao) {
        Empregados[] empregados = dao.getEmpregados();
        if (empregados != null) {
            for (Empregados empregado : empregados) {
                System.out.println(empregado);
            }
        } else {
            System.out.println("Nenhum empregado encontrado.");
        }
    }

    public static void inserirEmpregado(Scanner scanner, DAO dao) {
        System.out.print("Digite o código do empregado: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Digite o nome do empregado: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o cargo do empregado: ");
        String cargo = scanner.nextLine();

        System.out.print("Digite o salário do empregado: ");
        double salario = scanner.nextDouble();

        Empregados novoEmpregado = new Empregados(codigo, nome, cargo, salario);
        if (dao.inserirEmpregados(novoEmpregado)) {
            System.out.println("Empregado inserido com sucesso.");
        } else {
            System.out.println("Erro ao inserir o empregado.");
        }
    }

    public static void excluirEmpregados(Scanner scanner, DAO dao) {
        System.out.print("Digite o código do empregado a ser excluído: ");
        int codigo = scanner.nextInt();
        if (dao.excluirEmpregado(codigo)) {
            System.out.println("Empregado excluído com sucesso.");
        } else {
            System.out.println("Erro ao excluir o empregado.");
        }
    }

    public static void atualizarEmpregados(Scanner scanner, DAO dao) {
        System.out.print("Digite o código do empregado a ser atualizado: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Digite o novo nome do empregado: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o novo cargo do empregado: ");
        String cargo = scanner.nextLine();

        System.out.print("Digite o novo salário do empregado: ");
        double salario = scanner.nextDouble();

        Empregados empregadoAtualizado = new Empregados(codigo, nome, cargo, salario);
        if (dao.atualizarEmpregado(empregadoAtualizado)) {
            System.out.println("Empregado atualizado com sucesso.");
        } else {
            System.out.println("Erro ao atualizar o empregado.");
        }
    }
}

