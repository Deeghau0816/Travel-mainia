package BookingPackage;

public class BookingModel {

	private int id;
	private String name;
	private String place;
	private String date;
	private String guide;
	private String numofpeople;

	//PARAMETERIZED CONSTRUCTOR
	public BookingModel(int id,String name, String place, String date, String guide,String numofpeople) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
		this.date = date;
		this.guide = guide;
		this.numofpeople = numofpeople;
		
	}

	//SETTERS & GETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}

	public String getNumofpeople() {
		return numofpeople;
	}

	public void setNumofpeople(String numofpeople) {
		this.numofpeople = numofpeople;
	}
	
	
	
	
}
