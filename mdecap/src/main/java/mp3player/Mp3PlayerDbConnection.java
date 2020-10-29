package mp3player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mp3PlayerDbConnection {
	
	Connection mp3DbConnection;
	
	public Mp3PlayerDbConnection(String url) {
		try {
			
			this.mp3DbConnection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
