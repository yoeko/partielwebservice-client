package domaine;

import java.util.Date;

public class User extends Personne{
	
	
	private String login;
	private String password;
	private String profil;
			
	
	public User() {
		super();
	}

	public User(String first_name, String last_name, String mail, String address, String phone, Date dob) {
		super(first_name, last_name, mail, address, phone, dob);
	}

	public User(String first_name, String last_name, String mail, String address, String phone, Date dob,
			String login, String password, String profil) {
		super(first_name, last_name, mail, address, phone, dob);
		this.login = login;
		this.password = password;
		this.profil = profil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

}
