//package twes;

public class Desks extends productClass {
	Desks(int Modelnum,int Colornum){
		super(5,4,Modelnum,Colornum);
	}

	@Override
	public String toString() {
		return "Desks"+super.toString();
	}
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
