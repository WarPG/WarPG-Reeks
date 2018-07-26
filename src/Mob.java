import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    Connect c = new Connect();

    public Mob(int level, int x, int y){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = Connect.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM mob ORDER BY RANDOM() LIMIT 1 ");
            ResultSet rs = stmt.executeQuery();
            rs.next();
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
        }
    }
}
