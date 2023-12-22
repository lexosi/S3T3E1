package s3t3e1.GardenShop.infrastructure.adapter.repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import s3t3e1.GardenShop.application.port.out.TicketRepository;
import s3t3e1.GardenShop.domain.Ticket;

public class TxtTicketRepository implements TicketRepository {

	private static String ticketFile = dataPath + "tickets.txt";
	
	public TxtTicketRepository() {
		// Add constructor logic here if needed
	}
	
	@Override
	public void save(Ticket ticket) {
		File newTicket = new File(ticketFile);
		try {
			if(!newTicket.exists()) {
				newTicket.createNewFile();
				System.out.println("New tickets file created");
			}
			
			FileWriter fw = new FileWriter(newTicket, true);
			fw.write(ticket.toString());
			fw.write(""); // write for each line saved in the hashmap ticketLines
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Ticket findTicket(List<Ticket> registeredSales, int tckID) {
		Optional<Ticket> ticket = registeredSales.stream()
				.filter(t -> t.getTicketID() == tckID)
				.findFirst();
		return ticket.get();
	}
	
	public void saveLines() {
	//	
//				File newTicket = new File("tickets.txt");
//				
//				if(!newTicket.exists()) {
//					newTicket.createNewFile();
//					System.out.println("New ticket created");
//				}
//				
//				FileWriter writting = new FileWriter(newTicket, true);
//				writting.write("Flower Shop\n" + FlowerShop.getName());
//				writting.write(currentLine); // write for each line saved in the hashmap ticketLines
//				writting.close();
//			}
}


	@Override
	public void delete(Ticket ticket) {
		// TODO Auto-generated method stub
		
	}
	}
