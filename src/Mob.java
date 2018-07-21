import java.net.URISyntaxException;
import java.sql.*;
import java.util.Properties;
import java.util.Random;

public class Mob {
	
	private String name;
	private int health;
	private int defence;
	private int attack;
	private int dexterity;
	private int strength;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}


    public Mob(int level, int x, int y){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT column FROM mob ORDER BY RANDOM() LIMIT 1 ");
            ResultSet rs = stmt.executeQuery();
            Random r = new Random();
            name = rs.getCharacterStream("name").toString();
            health = 1000 + level*(rs.getInt("health"));
            defence = 100 + level*(rs.getInt("defense"));
            attack = 100 + level*(rs.getInt("attack"));
            dexterity = 100 + level*(rs.getInt("dexterity"));
            strength = 100 + level*(rs.getInt("strength"));
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    private static Connection getConnection() throws URISyntaxException, SQLException {
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
