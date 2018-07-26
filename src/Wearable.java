import java.util.Random;

public class Wearable extends Item{
	
	private int strength;

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public Wearable(int level){
		Random rand = new Random();
		setWearType(rand.nextInt(8) + 1);
		setStrength(rand.nextInt(100)* level + 100);
	}
}
