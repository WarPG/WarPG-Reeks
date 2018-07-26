import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Weapon extends Item{

    private int attack;

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Weapon() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM weapon ORDER BY RANDOM() LIMIT 1 ");

            ResultSet rs = stmt.executeQuery();
            rs.next();

            price = rs.getInt("price");
            category = rs.getInt("tier");
            dropRate = rs.getInt("drop_rate");
            wearType = rs.getInt("weartype");
            attack = rs.getInt("attack");
            requirement = rs.getString("requirement");
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
