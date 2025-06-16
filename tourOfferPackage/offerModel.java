package tourOfferPackage;

public class offerModel {
	
	
	private int id;
	private String title;
	private String description;
	private String price;
	private String discount;
	private String stdate;
	private String edate;
	
	public offerModel(int id, String title, String description, String price, String discount, String stdate,
			String edate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.stdate = stdate;
		this.edate = edate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getStdate() {
		return stdate;
	}
	public void setStdate(String stdate) {
		this.stdate = stdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	
	

}
