import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Accessory extends Item{

    private int dexterity;

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public Accessory() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM accesory ORDER BY RANDOM() LIMIT 1 ");

            ResultSet rs = stmt.executeQuery();
            rs.next();

            price = rs.getInt("price");
            category = rs.getInt("category");
            dropRate = rs.getInt("drop_rate");
            wearType = rs.getInt("weartype");
            requirement = rs.getString("requirement");
            dexterity = rs.getInt("dexterity");
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
