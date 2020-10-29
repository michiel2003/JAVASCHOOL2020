package copyWithInterface;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlCon implements DataBaseConnection{

	Connection MySqlconn ;

//	public static void main(String[] args) {
//		SqLiteCon exec = new SqLiteCon("jdbc:mysql://localhost:3307/JavaDB?user=root&password=");
//		List<Album> albums = new ArrayList<Album>();
//	}
	
	public MySqlCon(String url) {
		try {
			MySqlconn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add(List<Album> albums) {

		try {
			for (Album album : albums) {
				PreparedStatement prepstate = MySqlconn.prepareStatement("insert into Album(Title, ArtistId) values(?, ?)");
				prepstate.setString(1, album.title);
				prepstate.setInt(2, album.artistId);
				prepstate.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Album> getAlbum() {

		try {
			PreparedStatement prepStatement = MySqlconn.prepareStatement("select * from Album");
			prepStatement.execute();
			ResultSet result = prepStatement.getResultSet();
			List<Album> albums = new ArrayList<Album>();
			while (result.next()) {
				System.out.println(result.getString(2) + ", " + result.getInt(3));
				albums.add(new Album(result.getString(2), result.getInt(3)));
				
			}
			return albums;
		} catch (Exception e) {
			System.out.println("err");
			e.printStackTrace();
		}
		return null;

	}

}
