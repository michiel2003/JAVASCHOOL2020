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

public class SqLiteCon implements DataBaseConnection{
	
	Connection SqlLiteConnection;
	
	public static void main(String[] args) {
		SqLiteCon exec = new SqLiteCon("jdbc:sqlite:C:\\Users\\mdecap\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db");
		exec.getAlbum();
	}
	
	public SqLiteCon(String connection_url) {
		try {
			this.SqlLiteConnection = DriverManager.getConnection(connection_url);
		} catch (SQLException e) {
			System.out.println("SqlLite connection error");
			e.printStackTrace();
		}
	}
	
	public void add(List<Album> albums) {
		
		try {
			for(Album album: albums) {
				PreparedStatement prepstate =  SqlLiteConnection.prepareStatement("insert into Artist(?, ?) values");
				prepstate.setString(2, album.title);
				prepstate.setInt(3, album.artistId);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public List<Album> getAlbum() {
		
		try {
			PreparedStatement prepStatement = SqlLiteConnection.prepareStatement("select * from Album");
			prepStatement.execute();
			ResultSet result = prepStatement.getResultSet();
			List<Album> albums = new ArrayList<Album>();
			while(result.next()) {
				System.out.println(result.getString(2) + ", " + result.getInt(3));
				albums.add(new Album(result.getString(2), result.getInt(3)));
			}
			return albums;
		} catch (SQLException e) {
			System.out.println("err");
			e.printStackTrace();
		}
		return null;
		
	}
}
