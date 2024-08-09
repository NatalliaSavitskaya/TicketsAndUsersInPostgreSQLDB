import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/ticket_service_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";

    // Get a database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Save a user to the database
    public void saveUser(User user) {
        String sql = "INSERT INTO public.\"User\" (name, creation_date) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getName());
            pstmt.setTimestamp(2, user.getCreationDate());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Save a ticket to the database
    public void saveTicket(Ticket ticket) {
        String sql = "INSERT INTO public.\"Ticket\" (user_id, ticket_type, creation_date) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ticket.getUserId());
            pstmt.setString(2, ticket.getTicketType());
            pstmt.setTimestamp(3, ticket.getCreationDate());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}