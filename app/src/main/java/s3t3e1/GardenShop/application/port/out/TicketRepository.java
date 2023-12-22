package s3t3e1.GardenShop.application.port.out;

import s3t3e1.GardenShop.domain.Ticket;

public interface TicketRepository {

	Ticket save(Ticket ticket);
	Ticket findTicket(String id);
	void delete(Ticket ticket);
	    
}
