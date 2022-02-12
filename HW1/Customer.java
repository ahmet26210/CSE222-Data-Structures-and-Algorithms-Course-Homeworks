//package twes;

public class Customer extends twes {
	private Branch branch;
	private Container<productClass> orders;//there is orders of customer but we can add or delete after shopping
	private Container<productClass> orders1;//there is orders of customer but to reach previous orders so i did not remove element of this order after shopping
	Customer(Branch branch,String name, String surname, int id,String e_mail,String password,String SpecialNumber) {
		super(name, surname, id);
		this.e_mail=e_mail;
		this.password=password;
		this.branch=branch;
		this.specialNumber=SpecialNumber;
		orders = new Container<>();
		orders1=new Container<>();
	}
	
	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
	public Container<productClass> getOrders() {
		return orders;
	}
	public Container<productClass> getOrders1() {
		return orders1;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String e_mail) {
		this.password = password;
	}
	
	public Branch getBranch() {
		return branch;
	}
	
	public String getSpecialNumber() {
		return specialNumber;
	}

	public void setSpecialNumber(String specialNumber) {
		this.specialNumber = specialNumber;
	}

	public int searchProducts(Branch branch,productClass product,int number,int number1)throws ArrayIndexOutOfBoundsException {//search product is in that branch or not
		int index=-1;
		if(product instanceof Chairs) {
			if(number1 < 0 || number1-1 >= getBranch().getChairs().at(1).getMaxColor() || number < 0 || number-1 >= getBranch().getChairs().at(1).getMaxModel())
	            throw new ArrayIndexOutOfBoundsException("Invalid index!");
			for(int i=0;i<branch.getChairs().getUsed();i++) {
				if((index=branch.getChairs().contains(product)) !=-1) {
					return index;
				}
			}
		}
		if(product instanceof bookcases) {
			if(number1 < 0 || number1-1 >= getBranch().getBookcasess().at(1).getMaxColor() || number < 0 || number-1 >= getBranch().getBookcasess().at(1).getMaxModel())
	            throw new ArrayIndexOutOfBoundsException("Invalid index!");
			for(int i=0;i<branch.getBookcasess().getUsed();i++) {
				if((index=branch.getBookcasess().contains(product)) !=-1) {
					return index;
				}
			}
		}
		if(product instanceof officeCabinets) {
			if(number1 < 0 || number1-1 >= getBranch().getOfficecabinets().at(1).getMaxColor() || number < 0 || number-1 >= getBranch().getOfficecabinets().at(1).getMaxModel())
	            throw new ArrayIndexOutOfBoundsException("Invalid index!");
			for(int i=0;i<branch.getOfficecabinets().getUsed();i++) {
				if((index=branch.getOfficecabinets().contains(product)) !=-1) {
					return index;
				}
			}
		}
		if(product instanceof meetingTable) {
			if(number1 < 0 || number1-1 >= getBranch().getMeetingtables().at(1).getMaxColor() || number < 0 || number-1 >= getBranch().getMeetingtables().at(1).getMaxModel())
	            throw new ArrayIndexOutOfBoundsException("Invalid index!");
			for(int i=0;i<branch.getMeetingtables().getUsed();i++) {
				if((index=branch.getMeetingtables().contains(product)) !=-1) {
					return index;
				}
			}
		}
		if(product instanceof Desks) {
			if(number1 < 0 || number1-1 >= getBranch().getDesks().at(1).getMaxColor() || number < 0 || number-1 >= getBranch().getDesks().at(1).getMaxModel())
	            throw new ArrayIndexOutOfBoundsException("Invalid index!");
			for(int i=0;i<branch.getDesks().getUsed();i++) {
				if((index=branch.getDesks().contains(product)) !=-1) {
					return index;
				}
			}
		}
		return index;
	}
	public void listofProducts() {
		for(int i=0;i<getBranch().getChairs().getUsed();i++){
			System.out.println(getBranch().getChairs().at(i));
			System.out.println("----------------------------------------");
		}
	
		for(int i=0;i<getBranch().getBookcasess().getUsed();i++) {
			System.out.println(getBranch().getBookcasess().at(i));
			System.out.println("----------------------------------------");
		}
		
		for(int i=0;i<getBranch().getOfficecabinets().getUsed();i++) {
			System.out.println(getBranch().getOfficecabinets().at(i));
			System.out.println("----------------------------------------");
		}
		
		for(int i=0;i<getBranch().getMeetingtables().getUsed();i++) {
			System.out.println(getBranch().getMeetingtables().at(i));
			System.out.println("----------------------------------------");
		}
		
		for(int i=0;i<getBranch().getDesks().getUsed();i++) {
			System.out.println(getBranch().getDesks().at(i));
			System.out.println("----------------------------------------");
		}
	}
	public int findProductWhichBranch(Company company,productClass product,int number,int number1) {//return branch index that have that product
		int index=-1;
		if(product instanceof Chairs) {
			for(int j=0;j<company.getBranch().getUsed();j++) {
				for(int i=0;i<company.getBranch().at(j).getChairs().getUsed();i++) {
					if((index=company.getBranch().at(j).getChairs().contains(product)) !=-1) {
						index=j;
						return index;
					}
				}
			}
		}
		if(product instanceof bookcases) {
			for(int j=0;j<company.getBranch().getUsed();j++) {
				for(int i=0;i<company.getBranch().at(j).getBookcasess().getUsed();i++) {
					if((index=company.getBranch().at(j).getBookcasess().contains(product)) !=-1) {
						index=j;
						return index;
					}
				}
			}
		}
		if(product instanceof officeCabinets) {
			for(int j=0;j<company.getBranch().getUsed();j++) {
				for(int i=0;i<company.getBranch().at(j).getOfficecabinets().getUsed();i++) {
					if((index=company.getBranch().at(j).getOfficecabinets().contains(product)) !=-1) {
						index=j;
						return index;
					}
				}
			}
		}
		if(product instanceof meetingTable) {
			for(int j=0;j<company.getBranch().getUsed();j++) {
				for(int i=0;i<company.getBranch().at(j).getMeetingtables().getUsed();i++) {
					if((index=company.getBranch().at(j).getMeetingtables().contains(product)) !=-1) {
						index=j;
						return index;
					}
				}
			}
		}
		if(product instanceof Desks) {
			for(int j=0;j<company.getBranch().getUsed();j++) {
				for(int i=0;i<company.getBranch().at(j).getDesks().getUsed();i++) {
					if((index=company.getBranch().at(j).getDesks().contains(product)) !=-1) {
						index=j;
						return index;
					}
				}
			}
		}
		return index;
	}
	public void previousOrders() {//previous orders of customer
		for(int i=0;i<getOrders1().getUsed();i++) {
			System.out.println(getOrders1().at(i));
		}
	}
	public void shopOnline(String name,String surname,int id,String email,String password,String SpecialNumber,String adress , String Telno,productClass product,int number,int number1)throws ThereIsNoEmployee {
		System.out.println("Online Shopping ");
		BuyProduct(name,surname,id,email,password,SpecialNumber,product,number,number1);
	}
	public void BuyProduct(String name,String surname,int id,String email,String password,String SpecialNumber,productClass product,int number,int number1) throws ThereIsNoEmployee{
		int index=-1;
		index=findProductWhichBranch(getBranch().getCompany(),product,number,number1);
		if(index!=-1) {
       	 System.out.println("Products is founded at that branch index :" +(index+1));
        }
		else {
			System.out.println("Products is not founded at any branch");
		}
		BranchEmployee employee=getBranch().getCompany().getBranch().at(index).getBranchEmployee().at(1);
		if(employee==null) {
			throw new ThereIsNoEmployee();
		}
		else {
			employee.addNewOrder(name,surname, id, e_mail, password, specialNumber, product, number, number1);//add element of customer order
			employee.accesPreviousOrders(name, surname, id, email, password, SpecialNumber);//to see orders
			employee.makeSales(name,surname, id, e_mail, password, specialNumber, product, number, number1);//and sale 
		}
	}
	@Override
	public String toString(){
        return "Customer : " + getE_mail() +getPassword()+ "\n"+ super.toString();
    }
	@Override
    public boolean equals(Object o)
    {
        if(o == null)
            return false;
        if(!(o instanceof Customer))
            return false;

        return getBranch().getCompany().equals(((Customer)o).getBranch().getCompany()) && getSpecialNumber() == ((Customer)o).getSpecialNumber();
    }
	private String e_mail;
	private String password;
	private String specialNumber;
}
