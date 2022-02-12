//package twes;

public class officeCabinets extends productClass {
	officeCabinets(int Modelnum,int Colornum){
		super(12,0,Modelnum,Colornum);
	}

	@Override
	public String toString() {
		return "officeCabinets"+super.toString();
	}
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
