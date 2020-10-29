package copyingADataBase;

import java.util.List;

public interface Connection_DataBase {
	
	public void addArtist(List<Artist> artists);
	
	public void addTrack(List<Track> tracks);
	
	public void addAlbum(List<Album> albums);
	
	public List<Artist> getArtist();
	
	public List<Track> getTrack();
	
	public List<Album> getAlbum();

	public Object getArtistID(String name);

	public Object getAlbumID(String title);

}
