package linkedlist;

public class Product implements Comparable<Product>{
	String id;
	String product_name;
	String product_category_tree;
	String price;
	String discounted_price; 
	String description;
	String trader;
	public Product(String id, String product_name, String product_category_tree, String price, String discounted_price,
			String description, String trader) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.product_category_tree = product_category_tree;
		this.price = price;
		this.discounted_price = discounted_price;
		this.description = description;
		this.trader = trader;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_category_tree() {
		return product_category_tree;
	}
	public void setProduct_category_tree(String product_category_tree) {
		this.product_category_tree = product_category_tree;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscounted_price() {
		return discounted_price;
	}
	public void setDiscounted_price(String discounted_price) {
		this.discounted_price = discounted_price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTrader() {
		return trader;
	}
	public void setTrader(String trader) {
		this.trader = trader;
	}
	@Override
	public int compareTo(Product o) {
		if(this.id.compareTo(o.id)<0) {
			return -1;
		}
		if(this.id.compareTo(o.id)>0) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", product_category_tree="
				+ product_category_tree + ", price=" + price + ", discounted_price=" + discounted_price
				+ ", description=" + description + ", trader=" + trader + "]" +"\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}
	
}
