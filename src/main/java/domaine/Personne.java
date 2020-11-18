package domaine;

import java.util.Date;

public class Personne {
	
	private Long id;
	private String first_name;
	private String last_name;
	private String mail;
	private String address;
	private String phone;
	private Date dob;
	
	

	public Personne(String first_name, String last_name, String mail, String address, String phone, Date dob) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.mail = mail;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
	}

	public Personne() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	

}
