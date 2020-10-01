package toets1;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

public class Cars {

	String[] automerken = { "Volvo", "Audi", "Mercedes", "VolksWagen", "Opel", "Porsche", "MCLaren", "Pagani" };

	static List<Car> cars = new ArrayList<Car>();

	public static void main(String[] args) {
		Cars exec = new Cars();
		exec.create_cars();
		exec.allCars();
		exec.morethan4cyl();
		exec.showinFrame(cars);
	}

	private void morethan4cyl() {
		System.out.println("--SHOWING CARS WITH MORE THAN 4 CYLINDERS--\n______________________________");
		for (Car a : cars) {
			if (a.cylinders > 4) {
				printCar(a);
			}
		}
	}

	private void allCars() {
		System.out.println("--SHOWING ALL CARS--\n______________________________");
		for (Car a : cars) {
			printCar(a);
		}
	}

	private void printCar(Car a) {
		System.out.println("MERK      	" + a.merk);
		System.out.println("CYLINDERS 	" + a.cylinders);
		System.out.println("HORSEPOWER	" + a.Hp);
		System.out.println("PRICE     	" + a.kostprijs);
		System.out.println("______________________________");
	}

	public void create_cars() {
		for (int i = 0; i < 10; i++) {
			String naam = automerken[(int) Math.floor(Math.random() * 7)];
			int Hp = (int) Math.floor(Math.random() * 800);
			int Cylinders = (int) Math.floor(Math.random() * 8);
			if (Cylinders == 0 || Cylinders == 1) {
				Cylinders = 2;
			}
			double kostprijs = Math.floor(Math.random() * 80000);
			cars.add(new Car(naam, Hp, Cylinders, kostprijs));
		}
	}
	
	public void showinFrame(List<Car> carlistshow) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JTextArea textarea = new JTextArea(10, 15);
		JScrollPane scroll = new JScrollPane(textarea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frame.add(panel);
		panel.add(scroll);
		for(Car a: carlistshow) {
			String addtext = ("MERK |   " + a.merk + "\n" + "CYLINDERS |   " + a.cylinders + "\n" + "HORSEPOWER |   " + a.Hp + "\n" + "PRICE |   " + a.kostprijs +  "\n" + "Hp PER CYLINDER | " + HpPerCylinder(a) + "\n" +  "______________________________" + "\n");
			textarea.setText(textarea.getText() + addtext);
		}
		frame.setMinimumSize(new Dimension(400, 400));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public float HpPerCylinder(Car a) {
		float powerpercyl = a.Hp / a.cylinders;
		return powerpercyl;
	}

}
