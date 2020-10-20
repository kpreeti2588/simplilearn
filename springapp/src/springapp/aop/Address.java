package springapp.aop;

public class Address {

	public Address() {
		// TODO Auto-generated constructor stub
	}

	private int aid;
	private String street;
	private String city;
	private String country;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Address(int aid, String street, String city, String country) {
		super();
		this.aid = aid;
		this.street = street;
		this.city = city;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", street=" + street + ", city=" + city + ", country=" + country + "]";
	}
	
	
}
