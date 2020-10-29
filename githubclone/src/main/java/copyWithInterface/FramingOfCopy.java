package copyWithInterface;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FramingOfCopy {
	
	DefaultListModel<String> list_1 = new DefaultListModel<String>();
	
	public void CreatingFrameOfCopy() {
		JFrame main_top_frame = new JFrame();
		JPanel main_top_panel = new JPanel();
		
		
		
		//add all components to the main_top_frame//
		main_top_frame.add(main_top_panel);
	}

}
