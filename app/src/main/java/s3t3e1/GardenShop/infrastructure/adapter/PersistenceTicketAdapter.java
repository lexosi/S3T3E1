package s3t3e1.GardenShop.infrastructure.adapter;

import s3t3e1.GardenShop.domain.Ticket;

public class PersistenceTicketAdapter implements s3t3e1.GardenShop.application.port.out.PersistenceTicketPort {
    private static final String FILE_PATH = "tickets.txt";

    @Override
    public void saveTicket(Ticket ticket) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(ticket.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ticket> obtainTickets() {
        // Aquí se implementaría la lógica para leer los tickets desde el archivo.
        // Como este es un ejemplo, se deja sin implementar.
        return null;
    }
}
