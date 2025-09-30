import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Propriedade> propriedades = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MackImoveis ---");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Listar Usuários");
            System.out.println("3 - Cadastrar Propriedade");
            System.out.println("4 - Listar Propriedades");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1 -> cadastrarUsuario(scanner); 
                case 2 -> listarUsuarios(); 
                case 3 -> cadastrarPropriedade(scanner); 
                case 4 -> listarPropriedades(); 
                case 0 -> System.out.println("Saindo..."); 
                default -> System.out.println("Opção inválida!");
            }
        } while(opcao != 0);

        scanner.close();
    }

    private static void cadastrarUsuario(Scanner sc) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        usuarios.add(new Usuario(nome, email, senha));
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Usuario u : usuarios) {
                u.imprimirDados();
                System.out.println("-----");
            }
        }
    }

    private static void cadastrarPropriedade(Scanner sc) {
        if (usuarios.isEmpty()) {
            System.out.println("Cadastre pelo menos um usuário (proprietário) antes!");
            return;
        }

        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();
        System.out.print("Localização: ");
        String localizacao = sc.nextLine();
        System.out.print("Capacidade: ");
        int capacidade = sc.nextInt();
        System.out.print("Preço por noite: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        // Por enquanto o primeiro usuário é o proprietário
        Usuario proprietario = usuarios.get(0);

        Propriedade propriedade = new Propriedade(titulo, descricao, localizacao, capacidade, preco, proprietario); 
        propriedades.add(propriedade);
        proprietario.adicionarPropriedades(propriedade);
        System.out.println("Propriedade cadastrada com sucesso!");
    }

    private static void listarPropriedades() {
        if (propriedades.isEmpty()) {
            System.out.println("Nenhuma propriedade cadastrada.");
        } else {
            for (Propriedade p : propriedades) {
                p.imprimirDados();
                System.out.println("-----");
            }
        }
    }
}