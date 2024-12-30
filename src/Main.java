import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Ninja> listaNinjas = new LinkedList<>();

        Ninja naruto = new Ninja("Xaruto Uzucrack", 18, "Aldeia das Folhas");
        Ninja sasuke = new Ninja("Saske Umilha", 18, "Aldeia das Folhas");
        Ninja hiruzen = new Ninja("Hero Zen", 99, "Aldeia das Folhas");
        Ninja gaara = new Ninja("Gara galera", 20, "Vila da Areia");
        Ninja deidara = new Ninja("Dey dara", 20, "Vila Oculta da Pedra");
        Ninja konan = new Ninja("Konan dos papeu", 20, "Aldeia da Chuva");
        Ninja killer = new Ninja("Killer Bumble Bee", 25, "Aldeia Oculta da Nuvem");

        listaNinjas.add(naruto);
        listaNinjas.add(sasuke);
        listaNinjas.add(hiruzen);
        listaNinjas.add(gaara);
        listaNinjas.add(deidara);
        listaNinjas.add(konan);
        listaNinjas.add(killer);

        intermediario(listaNinjas);
    }

    public static void intermediario(LinkedList<Ninja> listaNinjas) {
        Scanner sc = new Scanner(System.in);
        Interface menu = new Interface(sc);

        short opcao = menu.Apresentacao();

        switch (opcao) {
            case 1:
                Ninja novoNinja = menu.CadastrarNinja();
                listaNinjas.add(novoNinja);
                intermediario(listaNinjas);
                break;
            case 2:
                int indice = menu.IndiceNinja(listaNinjas);
                if (indice != -1) {
                    Ninja ninjaRemovido = listaNinjas.remove(indice);
                    System.out.println("Ninja removido: " + ninjaRemovido.getNome());
                }
                intermediario(listaNinjas);
                break;
            case 3:
                menu.ListarNinjas(listaNinjas);
                intermediario(listaNinjas);
                break;
            case 4:
                int ind = menu.IndiceNinja(listaNinjas);
                if (ind != -1) {
                    System.out.println("=================");
                    System.out.println(" ");
                    Ninja ninjaBuscado = listaNinjas.get(ind);
                    System.out.println("Nome do Ninja: " + ninjaBuscado.getNome());
                    System.out.println("Idade do Ninja: " + ninjaBuscado.getIdade());
                    System.out.println("Aldeia do Ninja: " + ninjaBuscado.getVila());
                }
                intermediario(listaNinjas);
                break;
            case 5:
                menu.OrdenarNinjas(listaNinjas);
                intermediario(listaNinjas);
                break;
            case 0:
                System.out.println("Saindo...");
                sc.close();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                intermediario(listaNinjas);
                break;
        }
    }
}