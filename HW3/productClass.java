//package twes;

public abstract class productClass implements productInterface{
	final private int maxModel;
	final private int maxColor;
	private int colorNumber;
	private int modelNumber;
	
	public productClass(int maxModel, int maxColor, int colorNumber, int modelNumber) {
		this.maxModel = maxModel;
		this.maxColor = maxColor;
		this.colorNumber = colorNumber;
		this.modelNumber = modelNumber;
		isValid(getColorNumber(),getModelNumber());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		productClass other = (productClass) obj;
		if (colorNumber != other.colorNumber)
			return false;
		if (modelNumber != other.modelNumber)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "productClass [maxModel=" + maxModel + ", maxColor=" + maxColor + ", colorNumber=" + colorNumber
				+ ", modelNumber=" + modelNumber + "]";
	}


	@Override
	public boolean isValid(int Modelnum,int Colornum) {
		if(Modelnum>maxModel || Modelnum<0 || Colornum<0 || Colornum>maxColor)
			return false;
		return true;
	}


	public int getColorNumber() {
		return colorNumber;
	}


	public void setColorNumber(int colorNumber) {
		this.colorNumber = colorNumber;
	}


	public int getModelNumber() {
		return modelNumber;
	}


	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}


	public int getMaxModel() {
		return maxModel;
	}


	public int getMaxColor() {
		return maxColor;
	}
}
