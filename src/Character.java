import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Character {

    private Connect c = new Connect();
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

    public static void main(String[] args) {
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
    public int getId() {return id;}
    public void setId(int id) { this.id = id; }

	public Character(int hero_id, Reader name, int dexterity, int experience, int  health, int  defense, int hit_points ,
                     int  gold , int  charisma , int  attack , int  strength , int  luck ){
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

	public Character(){}

    public String getName() {
        return name;
    }

	public Character getCharacter(int id){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = Connect.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM hero WHERE hero_id="+id);
            ResultSet rs = stmt.executeQuery();
            Character chr = new Character(rs.getInt(1),rs.getCharacterStream(2),rs.getInt(3)
                                ,rs.getInt(4) ,rs.getInt(5) ,rs.getInt(6) ,rs.getInt(7)
                    ,rs.getInt(8) ,rs.getInt(9) ,rs.getInt(10) ,rs.getInt(11) ,rs.getInt(12));
            con.close();
            return chr;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Character newCharacter(String id, String password,String name){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = Connect.getConnection();
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
        }
        return null;
    }

}
