//package twes;

public class Company {
	private String CompanyName;
	private Administrator administrator;
	private Container<Branch> branch;
	private Container<Customer> customer;
	public Company(String companyName,String adminName,String adminSurname,int adminId)throws addAdminException {
		setCompanyName(companyName);
		administrator =new Administrator(this,adminName,adminSurname,adminId);
        branch = new Container<>();
        customer = new Container<>();
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName)throws addAdminException {
		if(getCompanyName()==null)
			CompanyName = companyName;
		else {
			throw new addAdminException();
		}
	}
	public Administrator getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Administrator administrator)
	{	
			this.administrator = administrator;
	}
	public Container<Branch> getBranch() {//return branch container
		return branch;
	}
	public Container<Customer> getCustomer() {
		return customer;
	}
	 @Override
	    public boolean equals(Object o)
	    {
	        if(o == null)
	            return false;
	        return getCompanyName().equals(((Company)o).CompanyName);
	    }
	    @Override
	    public String toString()
	    {
	        String str = "";

	        str += getCompanyName() + "\n";
	        str += "Administrator : " + getAdministrator().getName() + "  " + getAdministrator().getSurname() + "\n";

	        return str;
	    }
}
