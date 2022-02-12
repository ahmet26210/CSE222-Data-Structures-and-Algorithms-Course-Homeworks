//package twes;

public class meetingTable extends productClass{
	meetingTable(int Modelnum,int Colornum){
		super(10,4,Modelnum,Colornum);
	}

	@Override
	public String toString() {
		return "meetingTable"+super.toString();
	}
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
