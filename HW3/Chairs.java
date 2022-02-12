//package twes;

public class Chairs extends productClass {
	Chairs(int Modelnum,int Colornum){
		super(7,5,Modelnum,Colornum);
	}
	
	@Override
	public String toString() {
		return "OfficeChair"+super.toString();
	}
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
