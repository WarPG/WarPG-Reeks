import java.util.Random;

public class Armor extends Item{

	private int defense;

	public int getDefence() {
		return defense;
	}

	public void setDefence(int defense) {
		this.defense = defense;
	}

	public Armor(int level){
		Random rand = new Random();
		setWearType(rand.nextInt(8) + 1);
		setDefence(rand.nextInt(100)* level + 100);
	}
}
