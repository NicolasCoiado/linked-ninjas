import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Interface {
    private final Scanner sc;

    public Interface(Scanner scanner) {
        this.sc = scanner;
    }

    public short Apresentacao() {
        System.out.println(" ");
        System.out.println("=================");

        System.out.println("O que deseja fazer?");
        System.out.println("1 - Cadastrar um ninja.");
        System.out.println("2 - Remover primeiro ninja.");
        System.out.println("3 - Exibir ninjas.");
        System.out.println("4 - Acessar um ninja específico.");
        System.out.println("5 - Ordenar lista de ninjas.");
        System.out.println("0 - Sair.");

        return sc.nextShort();
    }

    public Ninja CadastrarNinja() {
        System.out.println(" ");
        System.out.println("=================");
        System.out.println("Cadastro de Ninja:");
        System.out.println("=================");

        sc.nextLine();
        System.out.print("Digite o nome do Ninja: ");
        String nome = sc.nextLine();

        System.out.print("Digite a idade do Ninja: ");
        int idade = sc.nextInt();

        sc.nextLine();
        System.out.print("Digite a aldeia do Ninja: ");
        String aldeia = sc.nextLine();

        return new Ninja(nome, idade, aldeia);
    }

    public int IndiceNinja(LinkedList<Ninja> listaNinjas) {
        System.out.println("Digite o nome do ninja que deseja buscar:");
        sc.nextLine();
        String nome = sc.nextLine();

        for (int i = 0; i < listaNinjas.size(); i++) {
            if (listaNinjas.get(i).getNome().equalsIgnoreCase(nome)) {
                return i;
            }
        }

        System.out.println("Ninja não encontrado.");
        return -1;
    }

    public void ListarNinjas(LinkedList<Ninja> listaNinjas) {
        System.out.println(" ");
        System.out.println("=================");
        System.out.println("Lista de Ninjas:");
        System.out.println("=================");

        for (Ninja ninja : listaNinjas) {
            System.out.println("Nome do Ninja: " + ninja.getNome());
            System.out.println("Idade do Ninja: " + ninja.getIdade());
            System.out.println("Aldeia do Ninja: " + ninja.getVila());
            System.out.println("-----------------");
        }
    }

    public void OrdenarNinjas(LinkedList<Ninja> listaNinjas) {
        System.out.println(" ");
        System.out.println("=================");
        System.out.println("Ordenar por:");
        System.out.println("1 - Nome");
        System.out.println("2 - Idade");
        System.out.println("3 - Aldeia");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                listaNinjas.sort(Comparator.comparing(Ninja::getNome));
                System.out.println("Lista ordenada por nome.");
                break;
            case 2:
                listaNinjas.sort(Comparator.comparingInt(Ninja::getIdade));
                System.out.println("Lista ordenada por idade.");
                break;
            case 3:
                listaNinjas.sort(Comparator.comparing(Ninja::getVila));
                System.out.println("Lista ordenada por aldeia.");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
}
