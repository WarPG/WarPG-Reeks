import java.io.Reader;
import java.net.*;
import java.sql.*;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

public class Character {

    public static void main(String [] args) throws URISyntaxException, SQLException {
        getConnection();
    }
    private int id;
	private int dexterity;
	private int experience;
	private int health;
	private int defense;
	private int hitPoints;
	private int gold;
	private int charisma;
	private int attack;
	private int strength;
	private int luck;
	private int ms;
	private String cClass;
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getHitPoints() {
		return hitPoints;
	}
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getCharisma() {
		return charisma;
	}
	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getLuck() {
		return luck;
	}
	public void setLuck(int luck) {
		this.luck = luck;
	}
	public  String getcClass(){return cClass;}
    public void setcClass(String cClass){this.cClass=cClass;}
	public int getMs(){return ms;}
	public void setMs(int ms){this.ms=ms;}
    public int getId() {return id;}
    public void setId(int id) { this.id = id; }

	public Character(int hero_id, Reader name, int dexterity, int experience, int  health, int  defense, int hit_points ,
                     int  gold , int  charisma , int  attack , int  strength , int  luck , Reader cClass , int  ms){
	    this.id=hero_id;
	    this.name=name.toString();
	    this.dexterity=dexterity;
	    this.experience=experience;
	    this.health=health;
	    this.defense=defense;
	    this.hitPoints=hit_points;
	    this.gold=gold;
	    this.charisma=charisma;
	    this.attack=attack;
	    this.strength=strength;
	    this.luck=luck;
	    this.cClass=cClass.toString();
	    this.ms=ms;
    }
	
	
	public Character getCharacter(int id){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM hero WHERE hero_id="+id);
            ResultSet rs = stmt.executeQuery();
            Character chr = new Character(rs.getInt(1),rs.getCharacterStream(2),rs.getInt(3)
                                ,rs.getInt(4) ,rs.getInt(5) ,rs.getInt(6) ,rs.getInt(7)
                    ,rs.getInt(8) ,rs.getInt(9) ,rs.getInt(10) ,rs.getInt(11) ,rs.getInt(12)
                    ,rs.getCharacterStream(13) ,rs.getInt(14));
            con.close();
            return chr;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Character newCharacter(String id, String password,String name){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO hero VALUES (id,password,nextval('hero_id'),name,1,0,1,1,1,0,1,1,1,1)");
            stmt.executeQuery();
            PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM hero WHERE lastval(hero_id)");
            ResultSet rs = stmt2.executeQuery();
            Character chr = getCharacter(rs.getInt("hero_id"));
            con.close();
            return chr;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
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




	/*
    public static void main(String [] args){
        try {

            Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("postgres://ylvpctvunmtdxy:3bd1b5b109dbc9bb61e8eb4e8daaf4add1d6b94f453298578315ade51a57614e@ec2-54-217-235-166.eu-west-1.compute.amazonaws.com:5432/dej96gpmnq6f0e","postgres","ridahab");
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM Character");
            ResultSet Rs = stmt.executeQuery();
            while(true){
                System.out.println("lol");
            }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    */
}
