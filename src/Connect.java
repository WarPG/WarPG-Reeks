import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {
    public static Connection getConnection() {
        try {
            String url = "jdbc:postgresql://ec2-54-217-235-166.eu-west-1.compute.amazonaws.com:5432/dej96gpmnq6f0e?user=ylvpctvunmtdxy&password=3bd1b5b109dbc9bb61e8eb4e8daaf4add1d6b94f453298578315ade51a57614e&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            Properties props = new Properties();
            props.setProperty("user", "ylvpctvunmtdxy");
            props.setProperty("password", "3bd1b5b109dbc9bb61e8eb4e8daaf4add1d6b94f453298578315ade51a57614e");
            props.setProperty("ssl", "true");
            return DriverManager.getConnection(url, props);
        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }
    }
}
