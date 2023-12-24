package s3t3e1.GardenShop.infrastructure.adapter.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import s3t3e1.GardenShop.application.port.out.TicketRepository;
import s3t3e1.GardenShop.domain.Ticket;

public class TxtTicketRepository implements TicketRepository {

	private static String dataPath;

	private static String ticketFile = dataPath + "tickets.txt";
	
	private String filePath = "data/tickets.txt";

	public TxtTicketRepository() {
		// Add constructor logic here if needed
	}
	
	/*
	 * @Override
	 * public void save(Ticket ticket) {
	 * File newTicket = new File(ticketFile);
	 * try {
	 * if(!newTicket.exists()) {
	 * newTicket.createNewFile();
	 * System.out.println("New tickets file created");
	 * }
	 * 
	 * FileWriter fw = new FileWriter(newTicket, true);
	 * fw.write(ticket.toString());
	 * fw.write(""); // write for each line saved in the hashmap ticketLines
	 * fw.close();
	 * } catch (IOException e) {
	 * e.printStackTrace();
	 * }
	 * }
	 */

	public void save(Ticket ticket) {
		try (FileWriter writer = new FileWriter(filePath, true)) {
			writer.write(ticket.toString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public TxtTicketRepository(String filePath) {
		this.filePath = filePath;
	}


	public void delete(Ticket ticket) {
		List<Ticket> tickets = new ArrayList<>();
    File file = new File(filePath);

    // Read all tickets into a list
    try (Scanner scanner = new Scanner(file)) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Assuming you have a method to convert a line of text into a Ticket
            Ticket t = convertLineToTicket(line);
            tickets.add(t);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    // Remove the ticket from the list
    tickets.removeIf(t -> t.getTicketID() == ticket.getTicketID());

    // Clear the file
    try (PrintWriter writer = new PrintWriter(file)) {
        writer.print("");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    // Write the remaining tickets back into the file
    try (FileWriter writer = new FileWriter(filePath, true)) {
        for (Ticket t : tickets) {
            writer.write(t.toString() + "\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
	}


	private Ticket convertLineToTicket(String line) {
		return null;
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


	
	}

