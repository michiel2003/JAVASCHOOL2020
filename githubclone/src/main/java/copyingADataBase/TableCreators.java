package copyingADataBase;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class TableCreators {
	
	Connection_DataBase connectionInterface = new MySqlConnection();
	
	
	class ArtistTable {
		public final String[] COLUMNSArtist = { "ArtistId", "Name" };

		public DefaultTableModel createArtistTable() {
			DefaultTableModel tableModelArtist = new DefaultTableModel(COLUMNSArtist, 0);
			List<Artist> artists = new ArrayList<Artist>();
			artists.addAll(connectionInterface.getArtist());
			for (Artist artist : artists) {
				Object[] row = { connectionInterface.getArtistID(artist.name), artist.name };
				tableModelArtist.addRow(row);
			}
			return tableModelArtist;

		}
	}

	class AlbumTable {
		public final String[] COLUMNSAlbum = { "AlbumId", "Title", "ArtistId" };

		public DefaultTableModel createAlbumTable() {
			DefaultTableModel tableModelAlbum = new DefaultTableModel(COLUMNSAlbum, 0);
			List<Album> albums = new ArrayList<Album>();
			albums.addAll(connectionInterface.getAlbum());
			for (Album album : albums) {
				Object[] row = {connectionInterface.getAlbumID(album.title), album.title, album.artistId};
				tableModelAlbum.addRow(row);
			} return tableModelAlbum;
		}
	}

}
