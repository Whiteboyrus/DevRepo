import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Pavlik on 10/6/15.
 */
public class Main extends Creater{

    public static void main(String [] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        boolean chk = false;


            System.out.println(" Введите нужную команду для взаимодействия: \n touch - создать, записать и сохранить новый файл, read - прочитать файл \n delete - удалить выбранный файл, edit - изменить файл, ls -a - просмотреть содержимое локальной директории, exit - выход");
            String cased = sc.nextLine();
            if (cased.equals("exit")) {
                System.exit(0);
            }



            switch (cased) {


                    case "touch": {
                        Creater createmeth = new Creater();
                        createmeth.create();
                        break;
                    }

                    case "read": {
                        Read readmeth = new Read();
                        try {
                            String string = readmeth.fileReader();
                            System.out.printf(string);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;

                    }
                    case "delete": {
                        Delete.delete();
                        break;
                    }

                    case "edit": {
                        Edit upd = new Edit();
                        upd.edit();
                        break;
                    }

                    case "ls -a": {
                        DirList dl = new DirList();
                        dl.list(args);
                        break;
                    }
                    default:
                        System.out.println("Введите корректную команду и не оставляйте поле ввода пустым!");
                }
            }
        }
