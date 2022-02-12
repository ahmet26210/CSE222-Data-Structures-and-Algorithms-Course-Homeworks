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
		branchEmployee = new ArrayList<>();
		bookcasess = new HybridList<>(10);
		officecabinets = new HybridList<>(10);
		meetingtables = new HybridList<>(10);
		desks = new HybridList<>(10);
		chairs = new HybridList<>(10);
		Products=new HybridList<>(5);
		initFunction();
	}
	public int getBranchCode() {
		return branchCode;
	}
	public ArrayList<BranchEmployee> getBranchEmployee() {
		return branchEmployee; 
	}
	public void initFunction() {
		int number=0,number1=0;
		Products.add(new Chairs(1,1));
		Products.add(new bookcases(1,1));
		Products.add(new officeCabinets(1,1));
		Products.add(new meetingTable(1,1));
		Products.add(new Desks(1,1));
		for(int i=0;i<5;i++) {
			number=Products.get(i).getMaxModel();
			number1=Products.get(i).getMaxColor();
			for(int j=0;j<number;j++) {
				if(i==1) {
					bookcasess.add(new bookcases(j+1,1));
				}
				if(i==2) {
					officecabinets.add(new officeCabinets(j+1,1));
				}
				for(int k=0;k<number1;k++) {
					if(i==0) {
						chairs.add(new Chairs(j+1,k+1));
					}
					if(i==3) {
						meetingtables.add(new meetingTable(j+1,k+1));
					}
					if(i==4) {
						desks.add(new Desks(j+1,k+1));
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
	
    public HybridList<Chairs> getChairs() {
		return chairs;
	}
	public void setChairs(HybridList<Chairs> chairs) {
		this.chairs = chairs;
	}
	public HybridList<bookcases> getBookcasess() {
		return bookcasess;
	}
	public HybridList<officeCabinets> getOfficecabinets() {
		return officecabinets;
	}
	public HybridList<meetingTable> getMeetingtables() {
		return meetingtables;
	}
	public HybridList<Desks> getDesks() {
		return desks;
	}
	public HybridList<productClass> getProducts() {
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
	private HybridList<Chairs> chairs;
	private ArrayList<BranchEmployee> branchEmployee;
	private HybridList<bookcases> bookcasess;
	private HybridList<officeCabinets> officecabinets;
	private	HybridList<meetingTable> meetingtables;
	private HybridList<Desks> desks;
	private HybridList<productClass> Products;
}
