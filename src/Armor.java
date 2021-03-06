import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Armor extends Item{

	private int defense;

    public Armor() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM armor ORDER BY RANDOM() LIMIT 1 ");

            ResultSet rs = stmt.executeQuery();
            rs.next();

            price = rs.getInt("price");
            category = rs.getInt("tier");
            dropRate = rs.getInt("drop_rate");
            wearType = rs.getInt("weartype");
            defense = rs.getInt("defense");
            requirement = rs.getString("requirement");
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Armor(int item_id) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM armor WHERE item_id=" + item_id);

            ResultSet rs = stmt.executeQuery();
            rs.next();

            price = rs.getInt("price");
            category = rs.getInt("tier");
            dropRate = rs.getInt("drop_rate");
            wearType = rs.getInt("weartype");
            defense = rs.getInt("defense");
            requirement = rs.getString("requirement");
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
}
