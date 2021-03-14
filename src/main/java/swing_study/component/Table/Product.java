package swing_study.component.Table;

public class Product {
	//Fields
	private String pCode;
	private String pName;
	private int price;
	private int stockAmount;
	
	//Constructor
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String pCode) {
		this.pCode = pCode;
	}
	public Product(String pCode, String pName, int price, int stockAmount) {
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.stockAmount = stockAmount;
	}
	
	//Getter / Setter
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStockAmount() {
		return stockAmount;
	}
	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}

	
	//toString
	@Override
	public String toString() {
		return String.format("Product [pCode=%s, pName=%s, price=%s, stockAmount=%s]", pCode, pName, price,
				stockAmount);
	}
	
	
	
	
}
