//package twes;

public class Administrator extends twes{//it is admin class extend person features
	private Company company;//to reach the company easily 
	/**
     * Constructor for the administrator with name,surname,id and its company.
     * @param company of the administrator.
     * @param name of the administrator.
     * @param surname of the administrator.
     * @param id of the administrator.
     */
	Administrator(Company company,String name, String surname, int id) {
		super(name, surname, id);
		this.company=company;
	}
	
	public Company getCompany() {
		return company;
	}
	/**
     * Add new branch for its company.
     * @param branchCode is the unique code for the branch.
     */
	public void addBranch(int branchCode) {//we add branch by using branch code
		Branch branch=new Branch(getCompany(),branchCode);//make a new branch for control
		if(getCompany().getBranch().contains(branch)==-1) {//check branch is contains at that company
			getCompany().getBranch().addElement(branch);//add branch of that company
			System.out.println("Branch is added to the this company by Administrator");
		}
		else {
			System.out.println("This branch has already exist at company");
		}
	}
	/**
     * Remove the existing branch.
     * @param branchCode is the target branch to remove.
     */
	public void removeBranch(int branchCode) {
		Branch branch=new Branch(getCompany(),branchCode);
		if(getCompany().getBranch().contains(branch)!=-1) {
			getCompany().getBranch().removeElement(branch);//remove branch from that company
			System.out.println("Branch is deleted from this company by Administrator");
		}
		else {
			System.out.println("There is no branch like that at company");
		}
	}
	/**
     * Add new branch employee to a branch.
     * @param branchCode the target branch to add a new branch employee.
     * @return true if the branch doesn't have that branch employee. Otherwise returns false and adding branch employee operation is not successful.
     */
	public boolean addBranchEmployee(int branchCode,String name,String surname,int id) throws ThereIsNoBranch {
		int index=0;
		Branch branch=new Branch(getCompany(),branchCode);
		index=getCompany().getBranch().contains(branch);
		if(index==-1) {
			throw new ThereIsNoBranch();
		}
		if(index!=-1) {//check that branch is contains of that company
			BranchEmployee branchemployee =new BranchEmployee(getCompany().getBranch().at(index),name,surname,id);//make a new employee then we add the employee
			if(getCompany().getBranch().at(index).getBranchEmployee().contains(branchemployee)==-1) {
				getCompany().getBranch().at(index).getBranchEmployee().addElement(branchemployee);
				return true;
			}
			else {
				System.out.println("This employee already exist in that branch!");
			}
		}
		return false;
	}
	 /**
     * Remove the existing branch employee from a branch.
     * @param branchCode the target branch to remove the current branch employee.
     * @return true if the branch employee is removed. Otherwise returns false.
     */
	public boolean removeBranchEmployee(int branchCode,String name,String surname,int id)throws ThereIsNoBranch {
		int index=0;
		Branch branch=new Branch(getCompany(),branchCode);
		index=getCompany().getBranch().contains(branch);
		if(index==-1) {
			throw new ThereIsNoBranch();
		}
		if(index!=-1) {
			BranchEmployee branchemployee =new BranchEmployee(getCompany().getBranch().at(index),name,surname,id);
			getCompany().getBranch().at(index).getBranchEmployee().removeElement(branchemployee);
			return true;
		}
		return false;
	}
	public void add1Product(Branch branch,productClass product,int number,int number1) {//this function add product to branch if employee calls this function when needed product is not in that branch
		if(product instanceof Chairs) {
			branch.getChairs().addElement(new Chairs(number,number1));
		}
		if(product instanceof bookcases) {
			branch.getBookcasess().addElement(new bookcases(number,number1));
		}
		if(product instanceof officeCabinets) {
			branch.getOfficecabinets().addElement(new officeCabinets(number,number1));
		}
		if(product instanceof meetingTable) {
			branch.getMeetingtables().addElement(new meetingTable(number,number1));
		}
		if(product instanceof Desks) {
			branch.getDesks().addElement(new Desks(number,number1));
		}
	}
	@Override
    public boolean equals(Object o)
    {
        if(o == null)
            return false;

        return  getCompany().equals(((Administrator)o).getCompany()) && super.equals(o);
    }

    @Override
    public String toString()
    {
        return "Company : " + getCompany().getCompanyName() + "\n"+ super.toString();
    }
}
