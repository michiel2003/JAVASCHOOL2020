package dbinjava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.WindowConstants;

public class DataBasesInJava {

	Connection DataBaseConnect;

	public static void main(String[] args) {
		DataBasesInJava exec = new DataBasesInJava();
		try {
			exec.DataBaseConnect = DriverManager.getConnection(
					"jdbc:sqlite:C:\\Users\\mdecap\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db");
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
		exec.frame();
	}

	public List<String> GetSqlInfo(String command, int column) {
		try {
			List<String> DbInfoRetrieved = new ArrayList<String>();
			PreparedStatement prepstate = DataBaseConnect.prepareStatement(command);
			prepstate.execute();
			ResultSet result = prepstate.getResultSet();
			while (result.next()) {
				String resulttext = result.getString(column);
				DbInfoRetrieved.add(resulttext);
			}
			return DbInfoRetrieved;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}
	
	public void InsertInto(String command) {
		try {
			PreparedStatement prepstate = DataBaseConnect.prepareStatement(command);
			prepstate.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	DefaultListModel<String> ListArtistNameModel = new DefaultListModel<String>();
	
	public void updatelist() {
		ListArtistNameModel.clear();
		ListArtistNameModel.addAll(GetSqlInfo("Select * From Artist Order by Name asc", 2));
	}

	public void frame() {
		// FRAME INIT
		JFrame frame = new JFrame();
		JTabbedPane tabs = new JTabbedPane();
		
		// TAB 1 (GET INFO)
		JPanel Tab1 = new JPanel();
		JList ListArtistName = new JList(ListArtistNameModel);
		updatelist();
		JScrollPane scrollListArtisName = new JScrollPane(ListArtistName);
		
		// TAB 2 (ADD INFO)
		JPanel Tab2 = new JPanel();
		JTextArea AddText = new JTextArea("PLACEHOLDER");
		JButton button = new JButton("ADD");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InsertInto("Insert into Artist (Name) values (\"" + AddText.getText() + "\");");
				updatelist();
			}
		});

		
		frame.add(tabs);
		
		tabs.add("GET INFO", Tab1);
		tabs.add("ADD INFO", Tab2);
		
		Tab1.add(scrollListArtisName);
		
		Tab2.add(AddText);
		Tab2.add(button);

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
