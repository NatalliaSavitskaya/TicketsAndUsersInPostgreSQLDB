public class User {

    private String name;
    private java.sql.Timestamp creationDate;

    public User(String name, java.sql.Timestamp creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public String getName () {
        return this.name;
    }

    public java.sql.Timestamp getCreationDate () {
        return this.creationDate;
    }
}