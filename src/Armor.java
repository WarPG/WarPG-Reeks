import java.util.Random;

public class Armor extends Item{

	private int defense;

	public Armor(int level){
		Random rand = new Random();
		setWearType(rand.nextInt(8) + 1);
		setDefense(rand.nextInt(100) * level + 100);
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
}
