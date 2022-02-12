package linkedlist;

import java.io.IOException;

public interface TraderInterface {
	public boolean CheckTrader(String name,String ID ,String Password) throws IOException;
	public boolean addProducts(Product product) throws IOException;
	public boolean removeProduct(String ID) throws IOException;
	public boolean editProduct(Product product,String ChangedItem,int i) throws IOException;
	public boolean seeCustomerOrder(Customer customer) throws IOException;
	public boolean MeetOrder(Customer customer ,String ID) throws IOException;
	public boolean CancelOrder(Customer customer,String ID) throws IOException;
	public boolean CheckCustomer(String name)  throws IOException;
}
