package domaine;

import java.util.Collection;

public class Cours {
	
	private Long Id;
	private String themeCourse;
	private int numberHours;
	private Collection<Etudiant> etudiants;
	
		
	public Cours() {
		super();
	}

	public Cours(String themeCourse, int numberHours) {
		super();
		this.themeCourse = themeCourse;
		this.numberHours = numberHours;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getThemeCourse() {
		return themeCourse;
	}

	public void setThemeCourse(String themeCourse) {
		this.themeCourse = themeCourse;
	}

	public int getNumberHours() {
		return numberHours;
	}

	public void setNumberHours(int numberHours) {
		this.numberHours = numberHours;
	}

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
		
}
