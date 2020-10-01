package bezigheid01;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class WeirdFrame {
	
	
	public static void main(String[] args) {
		WeirdFrame exec = new WeirdFrame();
		exec.CreateFrame();
	}
	
	public void CreateFrame() {
		Dimension dim = new Dimension(100, 100);
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JTextField textfield = new JTextField();
		JTextArea textarea = new JTextArea();
		textfield.setPreferredSize(dim);
		textarea.setPreferredSize(dim);
		textarea.setEditable(false);
		JButton button = new JButton("add");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textarea.setText(textarea.getText() + textfield.getText());
				textfield.setText("");
			}
		});
		
		frame.add(panel);
		panel.add(textarea);
		panel.add(textfield);
		panel.add(button);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800, 600));
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}
