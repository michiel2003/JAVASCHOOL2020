package copyWithInterface;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Copier {
	
	DataBaseConnection sqllite = new SqLiteCon(
			"jdbc:sqlite:C:\\Users\\michi\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db");
	DataBaseConnection mysql = new MySqlCon("jdbc:mysql://localhost:3306/javatest?user=root&password=");

	public static void main(String[] args) {
		Copier exec = new Copier();
		exec.CreatingFrameOfCopy();
	}

	public void copy() {
		
		List<Album> albums = new ArrayList<Album>();
		albums.addAll(sqllite.getAlbum());
		mysql.add(albums);
	}

	DefaultListModel<Album> list_1 = new DefaultListModel<Album>();
	DefaultListModel<String> list_1_data = new DefaultListModel<String>();
	public void update() {
		list_1.clear();
		list_1_data.clear();
		list_1.addAll((sqllite.getAlbum()));
		for(int i = 0; i < list_1.size(); i++) {
			list_1_data.add(i, list_1.get(i).title);
		}
	}

	public void CreatingFrameOfCopy() {
		JFrame main_top_frame = new JFrame();
		JPanel main_top_panel = new JPanel();
		update();
		JList<String> AlbumTitles = new JList<String>(list_1_data);
		JScrollPane scroll = new JScrollPane(AlbumTitles);
		
		

		// add all components to the main_top_frame//
		main_top_frame.add(main_top_panel);
		main_top_panel.add(scroll);
		main_top_frame.setVisible(true);

	}

}
