import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Wearable extends Item{
	
	private int strength;

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public Wearable(int level) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = Connect.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM wearable ORDER BY RANDOM() LIMIT 1 ");

			ResultSet rs = stmt.executeQuery();
			rs.next();

			price = rs.getInt("price");
			category = rs.getInt("category");
			dropRate = rs.getInt("drop_rate");
			wearType = rs.getInt("weartype");
			requirement = rs.getString("requirement");
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
