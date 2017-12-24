package model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;





@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@Column(name="idEmployee")
	private int idPersoneel;
	@Transient
	private String lastName;
	@Transient
	private String firstName;
	@Transient
	private String titles;
	@Transient
	private String address;
	@Transient
	private String city;
	@Transient
	private String region;
	@Transient
	private String homePhone;
	
	
	
	
	public Employee() {
		super();
	}
	public Employee(int idPersoneel, String lastName, String firstName, String titles, String address, String city,
			String region, String homePhone) {
		super();
		this.idPersoneel = idPersoneel;
		this.lastName = lastName;
		this.firstName = firstName;
		this.titles = titles;
		this.address = address;
		this.city = city;
		this.region = region;
		this.homePhone = homePhone;
	
	}
	public int getId() {
		return idPersoneel;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFirstname() {
		return firstName;
	}
	public String getTitle() {
		return titles;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getRegion() {
		return region;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setId(int idPersoneel) {
		this.idPersoneel = idPersoneel;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}
	public void setTitle(String titles) {
		this.titles = titles;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	
	
	
	public String toString(){
		String info = idPersoneel + "\n"+ lastName + " \n"+ firstName + "\n" + titles + " \n"+ address + "\n" + region + "\n" + homePhone +"\n\n";
		return info;
	}
	

	public static void main(String[] args) {


		
	}




	
	
}
