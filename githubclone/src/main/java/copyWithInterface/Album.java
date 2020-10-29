package copyWithInterface;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

class Album {
	
	String columns[] = {"AlbumId", "Title", "ArtistId", "Column1"}; 
	
	String title;
	int artistId;
	
	public Album(String title, int artistid) {
		this.title = title;
		this.artistId = artistid;
	}

}
