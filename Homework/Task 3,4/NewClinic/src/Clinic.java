
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Clinic {
	
	private Random rand;
	
	//Создаём списки для докторов и пациентов
	
	private List<CDoctor> doctorsList;
	private List<CPatient> patientsList;
	
	//Объявляем  массив констант для дальнейшего рандомайзинга
	private final String [] names = {"Иван", "Купрей", "Вадим", "Максим", "Павел", "Виктор", "Игнат"};
	private final String [] surNames = {"Купреев", "Сыроежкин", "Дотик", "Галич", "Чернов", "Добролюб"};
	private final String [] lastNames = {"Степанович", "Васильевич", "Иванович", "Павлович", "Игнатьевич"};
	private final String [] specializes = {"Врач-Хирург","Оториноларинголог","Терапевт", "Участковый терапевт","Кардиолог"};
	private final String [] diseases = {"Проблемы с сердцем", "Сломал руку", "Болит голова", "Болят глаза", "Ушиб ногу", "Избил кота"};
	
	private String randomizeString(String[] strings)
	{
		String string;
		string = strings[rand.nextInt(strings.length)];
	
		return string;
	}
	
	private String strInp (String msg, Scanner sc) {
		
		Matcher matchstr;
		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
		boolean check = false;
		String strInp = "";
		
		while (!check) 
		{
			System.out.printf("%s", msg );
			
			strInp = sc.nextLine();
			matchstr = pattern.matcher(strInp);
			
			if (strInp.toLowerCase().equals("exit")) 
			{
				System.exit(-1);
			} 
			else if (matchstr.matches())
			{
				check = true;
			} 
		}
		return strInp;
}

	//Конструктор
	public Clinic() {
		
		doctorsList = new ArrayList<CDoctor>();
		patientsList = new ArrayList<CPatient>();
		
		rand = new Random();
	}
	
	public void PatientsCreater( String lastName, String name, String surName, int pNumber, String diagnosis) {
		
		CPatient patient = new CPatient(pNumber, name, surName, lastName, diagnosis);
		patientsList.add(patient);
		
	}
	
	//Метод ввода пациентов вручную
	
	public void genericPatients(Scanner sc) {
		this.PatientsCreater(this.strInp("Введите Фамилию пациента: ", sc),this.strInp("Введите имя пациента:", sc),this.strInp("Введите отчество:",sc),rand.nextInt(115),this.randomizeString(diseases));
		
	}

	public void DocCreate(String name, String surName, String lastName, String specialize, int cabnumber)
	{
		CDoctor doctor = new CDoctor(name, surName, lastName, specialize, cabnumber);
		
		doctorsList.add(doctor);
	}
	
	//Случайное создание атрибутов для докторов
	
	public void randomDocCreater () {
		this.DocCreate(this.randomizeString(surNames), this.randomizeString(names), this.randomizeString(lastNames), this.randomizeString(specializes), rand.nextInt(300)); 
	}
	
	//Map-коллекция
	public Map<CPatient, List<CDoctor>> getMatches() {
		Map<CPatient, List<CDoctor>> matches = new HashMap<CPatient, List<CDoctor>>();
		Iterator<CPatient> iteratorForPatient = patientsList.iterator();
		
		CDoctor doc;
		CPatient patient;
		
		while(iteratorForPatient.hasNext())  
		{
			patient = iteratorForPatient.next();
			
			List<CDoctor> docs = new ArrayList<CDoctor>();
			Iterator<CDoctor>  iteratorForDoctor  = doctorsList.iterator();
			
			while(iteratorForDoctor.hasNext())
			{
				doc = iteratorForDoctor.next();
				
				if(patient.getDiagnosis().equals(doc.getSpecialize()))
				{
					docs.add(doc);
				}
			}
		matches.put(patient, docs);
	}
		return matches;
	}

	public void outputPatients() {
		CPatient patient;
Iterator<CPatient> pIterator = patientsList.iterator();
		
		System.out.println("Пациенты: ");
		while(pIterator.hasNext())  {
			patient = pIterator.next();
			   System.out.printf("Фамилия пациента - %s, Имя пациента - %s, Отчество пациента - %s, Номер - %d, Диагноз - %s \n", patient.getpSurName(),patient.getpName(),patient.getpLastName(),patient.getpNumber(),patient.getDiagnosis());
		}
	}
	
	public void outputDocs() {
		CDoctor doc;
Iterator<CDoctor> dIterator = doctorsList.iterator();
		while(dIterator.hasNext())  {
			doc = dIterator.next();
			   System.out.printf("Фамилия доктора - %s, Имя доктора - %s, Отчество доктора - %s, Номер кабинета - %d, Должность - %s \n", doc.getSurName(), doc.getName(), doc.getLastName(), doc.getCabNumber(), doc.getSpecialize());
		}
	}

	public List<CDoctor> getDoctorsList() {
		return doctorsList;
	}

	public void setDoctorsList(List<CDoctor> doctorsList) {
		this.doctorsList = doctorsList;
	}

	public List<CPatient> getPatientsList() {
		return patientsList;
	}

	public void setPatientsList(List<CPatient> patientsList) {
		this.patientsList = patientsList;
	}
	
}