
public class CDoctor {

	//Объявляем переменные (атрибуты) для объектов
	private String name;
	private String surName;
	private String specialize;
	private String lastName;
	
	private int cabNumber;
	
	public CDoctor (String surName, String name,  String lastName, String specialize, int cabnumber) {
		this.setSurName(surName);
		this.setName(name);
		this.setLastName(lastName);
		this.setCabNumber(cabnumber);
		this.setSpecialize(specialize);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSpecialize() {
		return specialize;
	}

	public void setSpecialize(String specialize) {
		this.specialize = specialize;
	}

	public int getCabNumber() {
		return cabNumber;
	}

	public void setCabNumber(int cabNumber) {
		this.cabNumber = cabNumber;
	}	
}
