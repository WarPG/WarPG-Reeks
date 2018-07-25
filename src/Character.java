import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Character {

    private Connect c = new Connect();
    private String id;
    private String password;
    private int hero_id;
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

    public Character(Reader id, Reader password, int hero_id, Reader name, int dexterity, int experience, int health, int defense, int hit_points,
                     int  gold , int  charisma , int  attack , int  strength , int  luck ){
        this.id = id.toString();
        this.password = password.toString();
        this.hero_id = hero_id;
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
    }

    public Character() {
        this.id = "JaneDoe";
        this.password = "1234";
        this.hero_id = 999999;
        this.name = "Jane Doe";
        this.dexterity = 10;
        this.experience = 0;
        this.health = 50;
        this.defense = 10;
        this.hitPoints = 10;
        this.gold = 0;
        this.charisma = 10;
        this.attack = 10;
        this.strength = 10;
        this.luck = 10;
    }

    public int getHero_id() {
        return hero_id;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    public String getName() {
        return name;
    }

	public Character getCharacter(int id){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = Connect.getConnection();
            PreparedStatement stmt = Objects.requireNonNull(con).prepareStatement("SELECT * FROM hero WHERE hero_id=" + id);
            ResultSet rs = stmt.executeQuery();
            Character chr = new Character(
                    rs.getCharacterStream("id"),
                    rs.getCharacterStream("password"),
                    rs.getInt("hero_id"),
                    rs.getCharacterStream("name"),
                    rs.getInt("dexterity"),
                    rs.getInt("experience"),
                    rs.getInt("health"),
                    rs.getInt("defense"),
                    rs.getInt("hit_points"),
                    rs.getInt("gold"),
                    rs.getInt("charisma"),
                    rs.getInt("attack"),
                    rs.getInt("strength"),
                    rs.getInt("luck")
            );
            con.close();
            return chr;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Character newCharacter(String id, String password,String name){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = Connect.getConnection();
            PreparedStatement stmt = Objects.requireNonNull(con).prepareStatement("INSERT INTO hero VALUES (id,password,nextval('hero_id'),name,1,0,1,1,1,0,1,1,1,1)");
            stmt.executeQuery();
            PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM hero WHERE lastval(hero_id)");
            ResultSet rs = stmt2.executeQuery();
            Character chr = getCharacter(rs.getInt("hero_id"));
            con.close();
            return chr;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
