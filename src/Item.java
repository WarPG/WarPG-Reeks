public class Item {

	private int price;
	private int category;
	private int dropRate;
	private int wearType;
	private String requirement;

	public Item(){

		price = 0;
		category = 0;
		dropRate = 0;
		wearType = 0;
		requirement= "";

	}
	public Item(int price, int category, int dropRate, int wearType, String requirement){
		this.price = price;
		this.category = category;
		this.dropRate = dropRate;
		this.wearType = wearType;
		this.requirement = requirement;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getDropRate() {
		return dropRate;
	}
	public void setDropRate(int dropRate) {
		this.dropRate = dropRate;
	}
	public int getWearType() {
		return wearType;
	}
	public void setWearType(int wearType) {
		this.wearType = wearType;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String toString(){
		String ret = "";

		if(category==1){
			ret = ret + "Trash";
		}else if(category==2){
			ret = ret + "Common";
		}
		else if(category==3){
			ret = ret + "Rare";
		}
		else if(category==4){
			ret = ret + "Unique";
		}
		else if(category==5){
			ret = ret + "Legendary";
		}

		ret = ret + " ";

		if(wearType==1){
			ret = ret + "Helmet";
		}else if(wearType==2){
			ret = ret + "Chestplate";
		}
		else if(wearType==3){
			ret = ret + "Gloves";
		}
		else if(wearType==4){
			ret = ret + "Shoes";
		}
		else if(wearType==5){
			int rand = (int)(Math.random()*7);
			switch(rand){
				case 0:
					ret = ret + "Sword";
					break;
				case 1:
					ret = ret + "Mace";
					break;
				case 2:
					ret = ret + "Dagger";
					break;
				case 3:
					ret = ret + "WarHammer";
					break;
				case 4:
					ret = ret + "Staff";
					break;
				case 5:
					ret = ret + "BattleAxe";
					break;
				case 6:
					ret = ret + "Spear";
					break;
			}

		}
		else if(wearType==6){
			ret = ret + "Necklace";
		}
		else if(wearType==7){
			ret = ret + "Ring";
		}
		else if(wearType==8){
			ret = ret + "Consumable";
		}

		return ret;

	}

	public boolean isArmor(){
	    if (wearType < 5)
	        return true;
	    return false;
    }


    public boolean isWeapon(){
        if (wearType == 5)
            return true;
        return false;
    }


    public boolean isAccessory(){
        if ((wearType == 6) || (wearType == 7))
            return true;
        return false;
    }

}