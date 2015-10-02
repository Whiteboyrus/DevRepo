
public class CPatient {
	
	//Объявляем переменные (атрибуты)
	private String pName;
	private String pSurName;
	private String pLastName;
	private String diagnosis;
	
	private int pNumber;
	
	public CPatient(int pNumber, String pName, String pSurName, String pLastName, String diagnosis) {
		// TODO Auto-generated constructor stub
		this.setpSurName(pSurName);
		this.setpName(pName);
		this.setpLastName(pLastName);
		this.setpNumber(pNumber);
		this.setDiagnosis(diagnosis);
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpSurName() {
		return pSurName;
	}

	public void setpSurName(String pSurName) {;
		this.pSurName = pSurName;
	}

	public String getpLastName() {
		return pLastName;
	}

	public void setpLastName(String pLastName) {
		this.pLastName = pLastName;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public int getpNumber() {
		return pNumber;
	}

	public void setpNumber(int pNumber) {
		this.pNumber = pNumber;
	}
}
