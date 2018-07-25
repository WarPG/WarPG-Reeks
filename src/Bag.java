import java.util.ArrayList;

public class Bag{

	private int capacity;
	private ArrayList<Item> items;

	public Bag(){
		items = new ArrayList<Item>();
	}


	public ArrayList<Item> getItems() {
		return items;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


}
