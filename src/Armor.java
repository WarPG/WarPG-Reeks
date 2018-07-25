import java.util.Random;

public class Armor extends Item{
	
	private int defence;

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public Armor(int level){
		Random rand = new Random();
		setWearType(rand.nextInt(8) + 1);
		setDefence(rand.nextInt(100)* level + 100);
	}
}
