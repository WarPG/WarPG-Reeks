import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Bag extends Item {

    private int capacity;
    private ArrayList<Item> items;

    public Bag(){
        items = new ArrayList<Item>();
    }


    public ArrayList<Item> getItems() {
        try {
            items.clear();
            int[] item_ids = new int[8];
            Class.forName("org.postgresql.Driver");
            Connection con = Connect.getConnection();
            PreparedStatement stmt = Objects.requireNonNull(con).prepareStatement("SELECT slot1,slot2,slot3,slot4,slot5 FROM bag WHERE id=\'" + id + "\'");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            item_ids[0] = rs.getInt("slot1");
            item_ids[1] = rs.getInt("slot2");
            item_ids[2] = rs.getInt("slot3");
            item_ids[3] = rs.getInt("slot4");
            item_ids[4] = rs.getInt("slot5");
            item_ids[5] = rs.getInt("slot6");
            item_ids[6] = rs.getInt("slot7");
            item_ids[7] = rs.getInt("slot8");
            for (int i = 0; i < 8; i++) {
                if (item_ids != null) {
                    PreparedStatement stmt2 = Objects.requireNonNull(con).prepareStatement("SELECT * FROM item WHERE item_id=\'" + item_ids[i] + "\'");
                    ResultSet rs2 = stmt2.executeQuery();
                    rs2.next();
                    items.add(new Item(rs2.getInt("price"), rs2.getInt("category"), rs2.getInt("drop_rate"), rs2.getInt("weartype"), rs2.getString("requirement")));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


}
