package Objetos;

import java.util.*;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void cadastrarQuarto(int numero, String tipo, double preco) {
        Quarto quarto = new Quarto(numero, tipo, preco, true);
        quartos.add(quarto);
    }

    public void cadastrarReserva(String nomeHospede, String dataCheckIn, String dataCheckOut, int numeroQuarto) {
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);

        if (quarto != null && quarto.isDisponivel()) {
            Reserva reserva = new Reserva(nomeHospede, dataCheckIn, dataCheckOut, quarto.getTipo(), numeroQuarto);
            reservas.add(reserva);
            quarto.setDisponivel(false);
        }
        else {
            System.out.println("Quarto não disponível.");
        }
    }

    public Quarto buscarQuartoPorNumero(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null;
    }

    public void checkIn(int numeroQuarto) {
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);

        if (quarto != null && !quarto.isDisponivel()) {
            System.out.println("Quarto já está ocupado.");
        }
        else if (quarto != null) {
            quarto.setDisponivel(false);
            System.out.println("Check-in realizado com sucesso.");
        }
        else {
            System.out.println("Quarto não encontrado.");
        }
    }

    public void checkOut(int numeroQuarto) {
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);

        if (quarto != null && quarto.isDisponivel()) {
            System.out.println("Quarto já está disponível.");
        }
        else if (quarto != null) {
            quarto.setDisponivel(true);
            System.out.println("Check-out realizado com sucesso.");
        }
        else {
            System.out.println("Quarto não encontrado.");
        }
    }

    public void relatorioOcupacao() {
        int quartosOcupados = 0;

        for (Quarto quarto : quartos) {
            if (!quarto.isDisponivel()) {
                quartosOcupados++;
                System.out.println("Quarto " + quarto.getNumero() + " - Tipo: " + quarto.getTipo());
            }
        }

        System.out.println("Total de quartos ocupados: " + quartosOcupados);
    }


}
