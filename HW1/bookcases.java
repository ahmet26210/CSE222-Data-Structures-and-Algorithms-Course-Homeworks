//package twes;

public class bookcases extends productClass{
	bookcases(int Modelnum,int Colornum){
		super(12,0,Modelnum,Colornum);
	}

	@Override
	public String toString() {
		return "BookCases"+super.toString();
	}
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
