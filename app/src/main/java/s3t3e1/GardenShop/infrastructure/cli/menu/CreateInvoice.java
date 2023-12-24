package s3t3e1.GardenShop.infrastructure.cli.menu;

import s3t3e1.GardenShop.domain.Ticket;
import s3t3e1.GardenShop.infrastructure.adapter.repository.TxtTicketRepository;

public class CreateInvoice {

    public static void createInvoice() {
        // Crear un nuevo ticket
        Ticket newTicket = new Ticket(0, 0);

        // Crear un repositorio de tickets
        TxtTicketRepository ticketRepo = new TxtTicketRepository(
                "app/src/main/java/s3t3e1/GardenShop/data/tickets.txt");

        // Guardar el nuevo ticket en el repositorio
        ticketRepo.save(newTicket);
    }

}