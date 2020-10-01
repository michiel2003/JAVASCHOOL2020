package toets1;

public class Car {
	
	String merk;
	int Hp;
	int cylinders;
	double kostprijs;
	
	public Car(String merk, int Hp, int cylinders) {
		this.merk = merk;
		this.Hp = Hp;
		this.cylinders = cylinders;
	}
	
	public Car(String merk, int Hp, int cylinders, double kostprijs) {
		this.merk = merk;
		this.Hp = Hp;
		this.cylinders = cylinders;
		this.kostprijs = kostprijs;
	}

}
