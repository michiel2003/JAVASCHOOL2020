package copyingADataBase;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;



public class CoolFrame {
	
	TableCreators tablecreator = new TableCreators();
	TableCreators.ArtistTable artistTableCreator = tablecreator.new ArtistTable();
	TableCreators.AlbumTable albumTableCreator = tablecreator.new AlbumTable();
	
	
	MySqlConnection mysql = new MySqlConnection();
	SqLiteConnection sqlite = new SqLiteConnection();
	

	public static void main(String[] args) {
		CoolFrame exec = new CoolFrame();
		exec.genFrame();
	}

	
	
	
	DefaultTableModel tableModelArtist = artistTableCreator.createArtistTable();
	DefaultTableModel tableModelAlbum = albumTableCreator.createAlbumTable();

	int selection;
	String selectedValue;
	

	public void genFrame() {
		
		
		JFrame main_top_frame = new JFrame();
		JPanel main_top_panel = new JPanel();
		final JTable main_artisttable = new JTable(tableModelArtist);
		main_artisttable.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		
		main_artisttable.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				System.out.println(main_artisttable.getSelectedRow());
				if(main_artisttable.isColumnSelected(1)) {
					selectedValue = (String) main_artisttable.getValueAt(main_artisttable.getSelectedRow(), 1);
					System.out.println(selectedValue);
				}
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JScrollPane main_artist_scroll = new JScrollPane(main_artisttable);
		
		
		main_top_frame.add(main_top_panel);
		main_top_panel.add(main_artist_scroll);
		main_top_frame.setVisible(true);
		main_top_frame.pack();
		main_top_frame.setLocationRelativeTo(null);
		main_top_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		

	}

}
