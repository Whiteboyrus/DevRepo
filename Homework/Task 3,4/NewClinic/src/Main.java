import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		CPatient patient;
		boolean checkDoctors = false;
		Map<CPatient, List<CDoctor>> list = new HashMap<CPatient, List<CDoctor>>();
		
		Clinic clinic = new Clinic();
		System.out.println("Электронная поликлиника\n");
				
		System.out.println("Введите данные пациентов: ");
		
		for (int i = 0; i<5; i++) {
			clinic.genericPatients(sc);
		}
		
		System.out.println("||||||||||||||||||||||||||||||||||Список пациентов:|||||||||||||||||||||||||||||||||||| \n");
		clinic.outputPatients();
		for (int i = 0; i<5; i++) {
		clinic.randomDocCreater();
		}
		
		System.out.println("||||||||||||||||||||||||||||||||||Список доступных врачей:|||||||||||||||||||||||||||||||||||| \n");
		clinic.outputDocs();
		
		list = clinic.getMatches();
		
		for (Entry<CPatient, List<CDoctor>> entry : list.entrySet() ) {
			patient = entry.getKey();
			
			System.out.print("Пациент: ");
			System.out.printf("Фамилия пациента - %s, Имя пациента - %s, Отчество пациента - %s, Номер - %d, Диагноз - %s \n", patient.getpSurName(),patient.getpName(),patient.getpLastName(),patient.getpNumber(),patient.getDiagnosis());
			
			for (CDoctor doctor : entry.getValue()) {
				checkDoctors = true;
				
				System.out.print("\n");
				System.out.print("Врачи: ");
				System.out.printf("Фамилия доктора - %s, Имя доктора - %s, Отчество доктора - %s, Номер кабинета - %d, Специализация - %s\n",doctor.getSurName(),doctor.getName(),doctor.getLastName(),doctor.getCabNumber(),doctor.getSpecialize());
			}
			
			checkDoctors = false;
		}
		sc.close();
	}
}

