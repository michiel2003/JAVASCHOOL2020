package copyingADataBase;

import java.util.ArrayList;
import java.util.List;

public class Copying {
	
	MySqlConnection mysql = new MySqlConnection();
	SqLiteConnection sqlite = new SqLiteConnection();
	
	public static void main(String[] args) {
		Copying exec = new Copying();
		exec.copyArtist();
		exec.copyTrack();
		exec.copyAlbum();
	}
	
	public void copyArtist() {
		List<Artist> artists = new ArrayList<Artist>();
		artists.addAll(sqlite.getArtist());
		mysql.addArtist(artists);
	}
	
	public void copyAlbum() {
		List<Album> albums = new ArrayList<Album>();
		albums.addAll(sqlite.getAlbum());
		mysql.addAlbum(albums);
	}
	
	public void copyTrack() {
		List<Track> tracks = new ArrayList<Track>();
		tracks.addAll(sqlite.getTrack());
		mysql.addTrack(tracks);
	}
	

}
