import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Character {

    private Connect c = new Connect();
    private Bag bg;
    private String id;
    private String password;
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

	public Bag getBag(){
		return bg;
	}

    public String getName() {
        return name;
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


    public Character(Reader id, Reader password, Reader name, int dexterity, int experience, int health, int defense, int hit_points,
                     int  gold , int  charisma , int  attack , int  strength , int  luck ){
        this.id = id.toString();
        this.password = password.toString();
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

    public Character getCharacter(String id, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = Connect.getConnection();
            PreparedStatement stmt = Objects.requireNonNull(con).prepareStatement("SELECT * FROM hero WHERE id=\'" + id + "\' AND password=\'" + password + "\'");
            ResultSet rs = stmt.executeQuery();
            Character chr = new Character(
                    rs.getCharacterStream("id"),
                    rs.getCharacterStream("password"),
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

    public Character newCharacter(String id, String password, String name){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = Connect.getConnection();
            PreparedStatement stmt = Objects.requireNonNull(con).prepareStatement("INSERT INTO hero (id,password,name,dexterity,experience,health,defense,hit_points,gold,charisma,attack,strength,luck)VALUES (\'" + id + "\',\'" + password + "\',\'" + name + "\',1,0,1,1,1,0,1,1,1,1)");
            stmt.executeQuery();
            PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM hero WHERE id=\'" + id + "\' AND password=\'" + password + "\'");
            ResultSet rs = stmt2.executeQuery();
            Character chr = new Character(
                    rs.getCharacterStream("id"),
                    rs.getCharacterStream("password"),
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

    public void wearArmor(Armor item) {

        ArrayList<Item> items = bg.getItems();

        if (items.get(item.getWearType()) != null) {
            setDefense(getDefense() - ((Armor) items.get(item.getWearType())).getDefence() + item.getDefence());
        } else {
            setDefense(getDefense() + item.getDefence());

        }
    }

    public void wearWeapon(Weapon item) {

        ArrayList<Item> items = bg.getItems();

        if (items.get(5) != null) {
            setAttack(getAttack() - ((Weapon) items.get(item.getWearType())).getAttack() + item.getAttack());
        } else {
            setAttack(getAttack() + item.getAttack());

        }
    }

    public void wearAccessory(Accessory item) {

        ArrayList<Item> items = bg.getItems();

        if (items.get(item.getWearType()) != null) {
            setDexterity(getDexterity() - ((Accessory) items.get(item.getWearType())).getDexterity() + item.getDexterity());
        } else {
            setDexterity(getDexterity() + item.getDexterity());

        }
    }

    public void wearWearable(Item item) {
    }
}
