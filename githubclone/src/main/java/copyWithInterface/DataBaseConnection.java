package copyWithInterface;

import java.util.List;

public interface DataBaseConnection {
	
	public void add(List<Album> albums);
	
	public List<Album> getAlbum();

}
