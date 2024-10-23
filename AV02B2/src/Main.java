import Objetos.Hotel;
import Objetos.Quarto;
import Objetos.Reserva;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.print("Escolha uma opção: \n");
            System.out.println("1 - Cadastrar Quarto");
            System.out.println("2 - Cadastrar Reserva");
            System.out.println("3 - Sair");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Número do quarto: ");
                int numero = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Tipo de quarto (solteiro/casal/suite): ");
                String tipo = scanner.nextLine();

                System.out.print("Preço diário: ");
                double preco = scanner.nextDouble();

                hotel.cadastrarQuarto(numero, tipo, preco);
                System.out.println("Quarto cadastrado com sucesso!");

            }
            else if (opcao == 2) {
                scanner.nextLine();
                System.out.print("Nome do hóspede: ");
                String nomeHospede = scanner.nextLine();

                System.out.print("Data de check-in (dd/mm/yyyy): ");
                String dataCheckIn = scanner.nextLine();

                System.out.print("Data de check-out (dd/mm/yyyy): ");
                String dataCheckOut = scanner.nextLine();

                System.out.print("Número do quarto: ");
                int numeroQuarto = scanner.nextInt();

                hotel.cadastrarReserva(nomeHospede, dataCheckIn, dataCheckOut, numeroQuarto);
                System.out.println("Reserva cadastrada com sucesso!");

            }
            else if (opcao == 3) {
                break;
            }
        }
    }
}