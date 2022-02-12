//package twes;

public class Branch {
	 /**
     * Constructor for  the branch with its company and branch code.
     * @param company branch's company.
     * @param branchCode branch's unique branch code.
     */
	public Branch(Company company,int branchCode){
		this.company = company;
		setBranchCode(branchCode);
		branchEmployee = new Container<>();
		bookcasess = new Container<>();
		officecabinets = new Container<>();
		meetingtables = new Container<>();
		desks = new Container<>();
		chairs = new Container<>();
		Products=new Container<>(5);
		initFunction();
	}
	public int getBranchCode() {
		return branchCode;
	}
	public Container<BranchEmployee> getBranchEmployee() {
		return branchEmployee; 
	}
	public void initFunction() {
		int number=0,number1=0;
		Products.addElement(new Chairs(1,1));
		Products.addElement(new bookcases(1,1));
		Products.addElement(new officeCabinets(1,1));
		Products.addElement(new meetingTable(1,1));
		Products.addElement(new Desks(1,1));
		for(int i=0;i<5;i++) {
			number=Products.at(i).getMaxModel();
			number1=Products.at(i).getMaxColor();
			for(int j=0;j<number;j++) {
				if(i==1) {
					bookcasess.addElement(new bookcases(j+1,1));
				}
				if(i==2) {
					officecabinets.addElement(new officeCabinets(j+1,1));
				}
				for(int k=0;k<number1;k++) {
					if(i==0) {
						chairs.addElement(new Chairs(j+1,k+1));
					}
					if(i==3) {
						meetingtables.addElement(new meetingTable(j+1,k+1));
					}
					if(i==4) {
						desks.addElement(new Desks(j+1,k+1));
					}
				}
			}
		}
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	public Company getCompany() {
		return company;
	}
	@Override
    public boolean equals(Object o)
    {
        if(o == null)
            return false;
        if(!(o instanceof Branch))
            return false;

        return getCompany().equals(((Branch)o).getCompany()) && getBranchCode() == ((Branch)o).getBranchCode();
    }
	
    public Container<Chairs> getChairs() {
		return chairs;
	}
	public void setChairs(Container<Chairs> chairs) {
		this.chairs = chairs;
	}
	public Container<bookcases> getBookcasess() {
		return bookcasess;
	}
	public Container<officeCabinets> getOfficecabinets() {
		return officecabinets;
	}
	public Container<meetingTable> getMeetingtables() {
		return meetingtables;
	}
	public Container<Desks> getDesks() {
		return desks;
	}
	public Container<productClass> getProducts() {
		return Products;
	}
	public String getSellSituation() {
		return SellSituation;
	}
	@Override
    public String toString() { return String.format("%s --> %s",getCompany().getCompanyName(),getBranchCode()+". Branch"); }
	private int branchCode;
	private Company company;
	private String SellSituation;
	private Container<Chairs> chairs;
	private Container<BranchEmployee> branchEmployee;
	private Container<bookcases> bookcasess;
	private Container<officeCabinets> officecabinets;
	private	Container<meetingTable> meetingtables;
	private Container<Desks> desks;
	private Container<productClass> Products;
}
