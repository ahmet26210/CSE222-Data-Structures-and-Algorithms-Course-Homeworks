//package twes;

public class BranchEmployee extends twes{
	/**
     * Constructor for the branch employee with its branch,name,surname and id.
     * @param branch to which the branch employee belongs.
     * @param name branch employee's name.
     * @param surname branch employee's surname.
     * @param id branch employee's id.
     */
	private Branch branch;//to reach branch and company easily
	BranchEmployee(Branch branch,String name, String surname, int id) {
		super(name, surname, id);
		this.branch=branch;
		
	}
	/**
     * Add new user to company.
     * @param name of the user.
     * @param surname of the user.
     * @param id of the user.
     */
	public void addCustomer(String name,String surname,int id,String email,String password,String SpecialNumber) {
		Customer customer=new Customer(branch,name,surname,id,email,password,SpecialNumber);//we add customer to branch
		if(getBranch().getCompany().getCustomer().contains(customer) == -1)//if branch has not this customer 
			getBranch().getCompany().getCustomer().add(customer);
		else {
			System.out.println("This customer is added before so you can not add again same person to the branch!");
		}
	}
	/**
     * Remove the existing user from the company.
     * @param name of the user.
     * @param surname of the user.
     * @param id of the user.
     */
	public void removeCustomer(String name,String surname,int id,String email,String password,String SpecialNumber) {
		Customer customer=new Customer(branch,name,surname,id,email,password,SpecialNumber);
		if(getBranch().getCompany().getCustomer().contains(customer) != -1){
			getBranch().getCompany().getCustomer().removeElement(customer);
		}
		else {
			System.out.println("This customer is not in that branch so you can not remove it!");
		}
	}
	public Branch getBranch(){
		return branch;
	}
	
	public void addProducts(productClass product,int number,int number1) throws ArrayIndexOutOfBoundsException{// add product at that branch
		if(product instanceof Chairs) {
			if(number1 < 0 || number1-1 >= getBranch().getChairs().get(1).getMaxColor() || number < 0 || number-1 >= getBranch().getChairs().get(1).getMaxModel())
	            throw new ArrayIndexOutOfBoundsException("Invalid index!");
			getBranch().getChairs().add(new Chairs(number,number1));
		}
		if(product instanceof bookcases) {
			if(number1 < 0 || number1-1 >= getBranch().getBookcasess().get(1).getMaxColor() || number < 0 || number-1 >= getBranch().getBookcasess().get(1).getMaxModel())
	            throw new ArrayIndexOutOfBoundsException("Invalid index!");
			getBranch().getBookcasess().add(new bookcases(number,number1));
		}
		if(product instanceof officeCabinets) {
			if(number1 < 0 || number1-1 >= getBranch().getOfficecabinets().get(1).getMaxColor() || number < 0 || number-1 >= getBranch().getOfficecabinets().get(1).getMaxModel())
	            throw new ArrayIndexOutOfBoundsException("Invalid index!");
			getBranch().getOfficecabinets().add(new officeCabinets(number,number1));
		}
		if(product instanceof meetingTable) {
			if(number1 < 0 || number1-1 >= getBranch().getMeetingtables().get(1).getMaxColor() || number-1 < 0 || number >= getBranch().getMeetingtables().get(1).getMaxModel())
	            throw new ArrayIndexOutOfBoundsException("Invalid index!");
			getBranch().getMeetingtables().add(new meetingTable(number,number1));
		}
		if(product instanceof Desks) {
			if(number1 < 0 || number1-1 >= getBranch().getDesks().get(1).getMaxColor() || number < 0 || number-1 >= getBranch().getDesks().get(1).getMaxModel())
	            throw new ArrayIndexOutOfBoundsException("Invalid index!");
			getBranch().getDesks().add(new Desks(number,number1));
		}
	}
	public void removeProducts(productClass product,int number,int number1)throws ArrayIndexOutOfBoundsException {
		if(product instanceof Chairs) {
			if(number1 < 0 || number1-1 >= getBranch().getChairs().get(1).getMaxColor() || number < 0 || number-1 >= getBranch().getChairs().get(1).getMaxModel())
	            throw new ArrayIndexOutOfBoundsException("Invalid index!");
			int a=getBranch().getChairs().contains((Chairs) product);
			getBranch().getChairs().remove(a);
		}
		if(product instanceof bookcases) {
			if(number1 < 0 || number1-1 >= getBranch().getBookcasess().get(1).getMaxColor() || number < 0 || number-1 >= getBranch().getBookcasess().get(1).getMaxModel())
	            throw new ArrayIndexOutOfBoundsException("Invalid index!");
			int a=getBranch().getBookcasess().contains((bookcases) product);
			getBranch().getBookcasess().remove(a);
		}
		if(product instanceof officeCabinets) {
			if(number1 < 0 || number1-1 >= getBranch().getOfficecabinets().get(1).getMaxColor() || number < 0 || number-1 >= getBranch().getOfficecabinets().get(1).getMaxModel())
	            throw new ArrayIndexOutOfBoundsException("Invalid index!");
			int a=getBranch().getOfficecabinets().contains((officeCabinets) product);
			getBranch().getOfficecabinets().remove(a);
		}
		if(product instanceof meetingTable) {
			if(number1 < 0 || number1-1 >= getBranch().getMeetingtables().get(1).getMaxColor() || number-1 < 0 || number >= getBranch().getMeetingtables().get(1).getMaxModel())
	            throw new ArrayIndexOutOfBoundsException("Invalid index!");
			int a=getBranch().getMeetingtables().contains((meetingTable) product);
			getBranch().getMeetingtables().remove(a);
		}
		if(product instanceof Desks) {
			if(number1 < 0 || number1-1 >= getBranch().getDesks().get(1).getMaxColor() || number < 0 || number-1 >= getBranch().getDesks().get(1).getMaxModel())
	            throw new ArrayIndexOutOfBoundsException("Invalid index!");
			int a=getBranch().getDesks().contains((Desks) product);
			getBranch().getDesks().remove(a);
		}
	}
	public void makeSales(String name,String surname,int id,String email,String password,String SpecialNumber,productClass product,int number,int number1) {
		int index=-1;
		Customer customer=new Customer(getBranch(),name,surname,id,email,password,SpecialNumber);
		if((index = getBranch().getCompany().getCustomer().contains(customer)) == -1) {//if first shopping of customer we add customer to the that branch
			System.out.println("Welcome you are new subscribes we add you!");
			getBranch().getBranchEmployee().get(1).addCustomer(name,surname,id,email,password,SpecialNumber); //random employee dosent matter
		}
		removeProducts(product,number,number1);//remove product from branch 
		updateOrders(name,surname,id,email,password,SpecialNumber,product,number,number1);//remove product from order list of customer
	}
	public void accesPreviousOrders(String name,String surname,int id,String email,String password,String SpecialNumber) {
		int index=0;
		Customer customer=new Customer(branch,name,surname,id,email,password,SpecialNumber);
		if((index = getBranch().getCompany().getCustomer().contains(customer)) != -1) {
			for(int i=0;i<getBranch().getCompany().getCustomer().get(index).getOrders().getUsed();i++) {
				System.out.println(getBranch().getCompany().getCustomer().get(index).getOrders().at(i));
			}
		}
		else {
			System.out.println("This Customer is not in that branch so you can not access previous orders of customer");
		}
	}
	public void addNewOrder(String name,String surname,int id,String email,String password,String SpecialNumber,productClass product,int number,int number1) throws ArrayIndexOutOfBoundsException
    {

		int index=0;
		Customer customer=new Customer(branch,name,surname,id,email,password,SpecialNumber);
		if((index = getBranch().getCompany().getCustomer().contains(customer)) != -1) {
			if(product instanceof Chairs) {
				if(number1 < 0 || number1-1 >= getBranch().getChairs().get(1).getMaxColor() || number < 0 || number-1 >= getBranch().getChairs().get(1).getMaxModel())
		            throw new ArrayIndexOutOfBoundsException("Invalid index!");
				getBranch().getCompany().getCustomer().get(index).getOrders().addElement(new Chairs(number,number1));
				getBranch().getCompany().getCustomer().get(index).getOrders1().add(new Chairs(number,number1));
			}
			if(product instanceof bookcases) {
				if(number1 < 0 || number1-1 >= getBranch().getBookcasess().get(1).getMaxColor() || number < 0 || number-1 >= getBranch().getBookcasess().get(1).getMaxModel())
		            throw new ArrayIndexOutOfBoundsException("Invalid index!");
				getBranch().getCompany().getCustomer().get(index).getOrders().addElement(new bookcases(number,number1));
				getBranch().getCompany().getCustomer().get(index).getOrders1().add(new Chairs(number,number1));
			}
			if(product instanceof officeCabinets) {
				if(number1 < 0 || number1-1 >= getBranch().getOfficecabinets().get(1).getMaxColor() || number < 0 || number-1 >= getBranch().getOfficecabinets().get(1).getMaxModel())
		            throw new ArrayIndexOutOfBoundsException("Invalid index!");
				getBranch().getCompany().getCustomer().get(index).getOrders().addElement(new officeCabinets(number,number1));
				getBranch().getCompany().getCustomer().get(index).getOrders1().add(new Chairs(number,number1));
			}
			if(product instanceof meetingTable) {
				if(number1 < 0 || number1-1 >= getBranch().getMeetingtables().get(1).getMaxColor() || number-1 < 0 || number >= getBranch().getMeetingtables().get(1).getMaxModel())
		            throw new ArrayIndexOutOfBoundsException("Invalid index!");
				getBranch().getCompany().getCustomer().get(index).getOrders().addElement(new meetingTable(number,number1));
				getBranch().getCompany().getCustomer().get(index).getOrders1().add(new Chairs(number,number1));
			}
			if(product instanceof Desks) {
				if(number1 < 0 || number1-1 >= getBranch().getDesks().get(1).getMaxColor() || number < 0 || number-1 >= getBranch().getDesks().get(1).getMaxModel())
		            throw new ArrayIndexOutOfBoundsException("Invalid index!");
				getBranch().getCompany().getCustomer().get(index).getOrders().addElement(new Desks(number,number1));
				getBranch().getCompany().getCustomer().get(index).getOrders1().add(new Chairs(number,number1));
			}
		}
		else {
			System.out.println("This Customer is not in that branch so you can not add new orders to customer");
		}
	}
	public void updateOrders(String name,String surname,int id,String email,String password,String SpecialNumber,productClass product,int number,int number1)throws ArrayIndexOutOfBoundsException {
		int index=0;
		Customer customer=new Customer(branch,name,surname,id,email,password,SpecialNumber);
		if((index = getBranch().getCompany().getCustomer().contains(customer)) != -1) {
			if(product instanceof Chairs) {
				if(number1 < 0 || number1-1 >= getBranch().getChairs().get(1).getMaxColor() || number < 0 || number-1 >= getBranch().getChairs().get(1).getMaxModel())
		            throw new ArrayIndexOutOfBoundsException("Invalid index!");
				getBranch().getCompany().getCustomer().get(index).getOrders().removeElement(new Chairs(number,number1));
			}
			if(product instanceof bookcases) {
				if(number1 < 0 || number1-1 >= getBranch().getBookcasess().get(1).getMaxColor() || number < 0 || number-1 >= getBranch().getBookcasess().get(1).getMaxModel())
		            throw new ArrayIndexOutOfBoundsException("Invalid index!");
				getBranch().getCompany().getCustomer().get(index).getOrders().removeElement(new bookcases(number,number1));
			}
			if(product instanceof officeCabinets) {
				if(number1 < 0 || number1-1 >= getBranch().getOfficecabinets().get(1).getMaxColor() || number < 0 || number-1 >= getBranch().getOfficecabinets().get(1).getMaxModel())
		            throw new ArrayIndexOutOfBoundsException("Invalid index!");
				getBranch().getCompany().getCustomer().get(index).getOrders().removeElement(new officeCabinets(number,number1));
			}
			if(product instanceof meetingTable) {
				if(number1 < 0 || number1-1 >= getBranch().getMeetingtables().get(1).getMaxColor() || number-1 < 0 || number >= getBranch().getMeetingtables().get(1).getMaxModel())
		            throw new ArrayIndexOutOfBoundsException("Invalid index!");
				getBranch().getCompany().getCustomer().get(index).getOrders().removeElement(new meetingTable(number,number1));
			}
			if(product instanceof Desks) {
				if(number1 < 0 || number1-1 >= getBranch().getDesks().get(1).getMaxColor() || number < 0 || number-1 >= getBranch().getDesks().get(1).getMaxModel())
		            throw new ArrayIndexOutOfBoundsException("Invalid index!");
				getBranch().getCompany().getCustomer().get(index).getOrders().removeElement(new Desks(number,number1));
			}
		}
		else {
			System.out.println("This Customer is not in that branch so you can not update new orders to customer");
		}
	}
	public boolean findProduct(Company company,productClass product,int number1,int number2,int number3,int number4) {//check needed product is in that branch or not
		int index=-1;
		index=company.getCustomer().get(number3).searchProducts(company.getBranch().get(number4), product, number1, number2);
		
		if(index==-1) {
			branch.getCompany().getAdministrator().add1Product(branch,product,number1,number2);//if product is not in branch it calls admin add function and adding to the branch
			System.out.println("Element is not founded at that branch so we said admin then admin have added product the branch");
			return true;
		}
		else {
			return true;
		}
		
	}
	public String toString()
    {
        return  "Company Name: " + getBranch().getCompany().getCompanyName() + "\n" +
                "Branch Code: " + getBranch().getBranchCode() + "\n" +
                super.toString();
    }
	@Override
    public boolean equals(Object o)
    {
        if(o == null)
            return false;
        if(!(o instanceof BranchEmployee))
            return false;

        return getBranch().equals(((BranchEmployee)o).getBranch()) && super.equals(o);
    }
}
