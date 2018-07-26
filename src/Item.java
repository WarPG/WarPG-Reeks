import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Item {

    protected int price;
    protected int category;
    protected int dropRate;
    protected int wearType;
    protected int id;
    protected String requirement;

    public Item(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM item ORDER BY RANDOM() LIMIT 1 ");

            ResultSet rs = stmt.executeQuery();
            rs.next();

            price = rs.getInt("price");
            category = rs.getInt("category");
            dropRate = rs.getInt("drop_rate");
            wearType = rs.getInt("weartype");
            requirement = rs.getString("requirement");
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        } else if(category==3){
            ret = ret + "Rare";
        } else if(category==4){
            ret = ret + "Unique";
        } else if(category==5){
            ret = ret + "Legendary";
        }

        ret = ret + " ";

        if(wearType==1){
            ret = ret + "Helmet";
        }else if(wearType==4){
            ret = ret + "Chestplate";
        } else if(wearType==3){
            ret = ret + "Gloves";
        } else if(wearType==2){
            ret = ret + "Shoes";
        } else if(wearType==5){
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

        } else if(wearType==6){
            ret = ret + "Necklace";
        } else if(wearType==7){
            ret = ret + "Ring";
        } else if(wearType==8){
            ret = ret + "Consumable";
        }

        return ret;

    }

    public boolean isArmor(){
        return wearType < 4;
    }

    public boolean isWearable(){
        return wearType == 4;
    }


    public boolean isWeapon(){
        return wearType == 5;
    }


    public boolean isAccessory(){
        return (wearType == 6) || (wearType == 7);
    }

}