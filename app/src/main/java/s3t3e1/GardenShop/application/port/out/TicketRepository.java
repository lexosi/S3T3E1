package s3t3e1.GardenShop.application.port.out;

import java.util.List;

import s3t3e1.GardenShop.domain.Ticket;

public interface TicketRepository {

	Ticket save(Ticket ticket);

	Ticket findTicket(List<Ticket> registeredSales, int id);
	void delete(Ticket ticket);
	    
}
