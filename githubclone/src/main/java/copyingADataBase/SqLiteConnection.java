package copyingADataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqLiteConnection implements Connection_DataBase{

	Connection SqlLiteConnection;

	public SqLiteConnection() {
		try {
			this.SqlLiteConnection = DriverManager.getConnection(
					"jdbc:sqlite:C:\\Users\\mdecap\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db");
		} catch (SQLException e) {
			System.out.println("SqlLite connection error");
			e.printStackTrace();
		}
	}

	public List<Artist> getArtist() {
		try {
			PreparedStatement prepstate = SqlLiteConnection.prepareStatement("select * from Artist");
			prepstate.execute();
			ResultSet result = prepstate.getResultSet();
			List<Artist> artists = new ArrayList<Artist>();
			while (result.next()) {
				artists.add(new Artist(result.getString(2)));
			}
			return artists;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Album> getAlbum() {

		try {
			PreparedStatement prepStatement = SqlLiteConnection.prepareStatement("select * from Album");
			prepStatement.execute();
			ResultSet result = prepStatement.getResultSet();
			List<Album> albums = new ArrayList<Album>();
			while (result.next()) {
				albums.add(new Album(result.getString(2), result.getInt(3)));
			}
			return albums;
		} catch (SQLException e) {
			System.out.println("err");
			e.printStackTrace();
		}
		return null;

	}
	
	public List<Track> getTrack() {

		try {
			PreparedStatement prepStatement = SqlLiteConnection.prepareStatement("select * from Track");
			prepStatement.execute();
			ResultSet result = prepStatement.getResultSet();
			List<Track> tracks = new ArrayList<Track>();
			while (result.next()) {
				tracks.add(new Track(result.getString(2), result.getInt(3), result.getInt(4), result.getInt(5), result.getString(6), result.getInt(7), result.getInt(8)));
			}
			return tracks;
		} catch (SQLException e) {
			System.out.println("err");
			e.printStackTrace();
		}
		return null;

	}
	
	public void addArtist(List<Artist> artists) {
		try {
			for (Artist artist : artists) {
				PreparedStatement prepstate = SqlLiteConnection.prepareStatement("insert into Artist(Name) values (?)");
				prepstate.setString(1, artist.name);
				prepstate.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addAlbum(List<Album> albums) {

		try {
			for (Album album : albums) {
				PreparedStatement prepstate = SqlLiteConnection
						.prepareStatement("insert into Album(Title, ArtistId) values(?, ?)");
				prepstate.setString(1, album.title);
				prepstate.setInt(2, album.artistId);
				prepstate.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addTrack(List<Track> tracks) {
		try {
			for (Track track : tracks) {
				PreparedStatement prepstate = SqlLiteConnection.prepareStatement(
						"insert into Track(Name, AlbumId, MediaTypeId, GenreId, composer, Milliseconds, bytes) values(?, ?, ?, ?, ?, ?, ?)");
				prepstate.setString(1, track.name);
				prepstate.setInt(2, track.albumid);
				prepstate.setInt(3, track.mediatypeid);
				prepstate.setInt(4, track.genreid);
				prepstate.setString(5, track.composer);
				prepstate.setInt(6, track.milliseconds);
				prepstate.setInt(7, track.bytes);
				prepstate.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getAlbumID(String title) {
		try {
			PreparedStatement prepstate = SqlLiteConnection.prepareStatement("select * from Album where title like \"" + title + "\"");
			prepstate.executeUpdate();
			ResultSet result = prepstate.getResultSet();
			return result.getString(1);
		} catch(SQLException e) {
			e.printStackTrace();
		} return title;
	}
	
	public String getArtistID(String name) {
		try {
			PreparedStatement prepstate = SqlLiteConnection
					.prepareStatement("select * from Artist where Name like \"" + name + "\"");
			prepstate.execute();
			ResultSet result = prepstate.getResultSet();
			return result.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;

	}
}
