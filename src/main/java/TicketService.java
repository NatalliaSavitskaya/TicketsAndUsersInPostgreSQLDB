import java.sql.Timestamp;

class TicketService {
    public static void main(String []args) {
        DAO dao = new DAO(); // Create DAO instance
        User user = new User("Christina Agile", new Timestamp(System.currentTimeMillis()));  // Create a User instance
        dao.saveUser(user); // Save the User to the database

        Ticket ticket = new Ticket(2, "YEAR", new Timestamp(System.currentTimeMillis())); // Create a Ticket instance
        dao.saveTicket(ticket); // Save the Ticket to the database
    }
}