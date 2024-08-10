import java.sql.Timestamp;
import java.util.List;

class TicketService {
    public static void main(String []args) {
        DAO dao = new DAO(); // Create DAO instance

        // Saving user to the database
        User user = new User("Christina Agile", new Timestamp(System.currentTimeMillis()));
        dao.saveUser(user);

        // Saving ticket to the database
        Ticket ticket = new Ticket(2, "YEAR", new Timestamp(System.currentTimeMillis()));
        dao.saveTicket(ticket);

        // Fetching user by ID
        User isUser = dao.getUserById(5);
        if (isUser != null) {
            System.out.println("User found: " + isUser);
        } else {
            System.out.println("User not found.");
        }

        // Fetching ticket by ID
        Ticket ticketById = dao.getTicketById(1); // Replace with an actual ID
        if (ticketById != null) {
            System.out.println("Ticket found by ID: " + ticketById);
        } else {
            System.out.println("Ticket not found by ID.");
        }

        // Fetch tickets by user ID
        List<Ticket> ticketsByUserId = dao.getTicketsByUserId(1); // Replace with an actual user ID
        if (!ticketsByUserId.isEmpty()) {
            System.out.println("Tickets found by user ID:");
            for (Ticket eachTicket : ticketsByUserId) {
                System.out.println(eachTicket);
            }
        } else {
            System.out.println("No tickets found for the user ID.");
        }
    }
}