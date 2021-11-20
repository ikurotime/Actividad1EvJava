package programa;
import java.util.Scanner;

public class functions {

    public static void clearConsole() {
        System.out.print("\u001b[2J");
        System.out.flush();
    }
    public static void Menu() {
        String format = "| %-26s | %-6d |%n";
        String[] options = {"Registrar corredores","Informes de abandonos (M)",
         "Informes de abandonos (F)","Listado de Inscritos (M)","Listado de inscritos(F)",
         "Tiempo total de carrera(M)","Tiempo total de carrera(F)",
         "Tiempo medio minutos/km","Salir"};
        System.out.format("+----------------------------+--------+%n");
        System.out.format("|  Maratón Cervantina        | Opción |%n");
        System.out.format("+----------------------------+--------+%n");

        for (int i = 0; i < options.length; i++) {
            if ("Salir".equals(options[i])) {
                System.out.format(format, options[i] , 0);
            } else {
                System.out.format(format, options[i] , i + 1);
            }
        }
        System.out.format("+----------------------------+--------+%n");
    }
    public static void setOptionDisplay(String option, Scanner sc) {        
        switch (option) {
            case "1":
                System.out.format("+-------------------------------------+%n");
                System.out.format("|  1.REGISTRAR CORREDORES             |%n");
                System.out.format("+-------------------------------------+%n");
                break;
            case "2":
                System.out.format("+-------------------------------------+%n");
                System.out.format("|  2.INFORMES DE ABANDONOS (M)        |%n");
                System.out.format("+-------------------------------------+%n"); 
                break;
            case "3":
                System.out.format("+-------------------------------------+%n");
                System.out.format("|  3.INFORMES DE ABANDONOS (F)        |%n");
                System.out.format("+-------------------------------------+%n"); 
                break;
            case "4":
                System.out.format("+-------------------------------------+%n");
                System.out.format("|  4.LISTADO DE INSCRITOS (M)         |%n");
                System.out.format("+-------------------------------------+%n"); 
                break;
            case "5":
                System.out.format("+-------------------------------------+%n");
                System.out.format("|  5.LISTADO DE INSCRITOS (F)         |%n");
                System.out.format("+-------------------------------------+%n"); 
                break; 
            case "6":
                System.out.format("+-------------------------------------+%n");
                System.out.format("|  6.TIEMPO TOTAL DE CARRERA (M)      |%n");
                System.out.format("+-------------------------------------+%n"); 
                break;  
            case "7":
                System.out.format("+-------------------------------------+%n");
                System.out.format("|  7.TIEMPO TOTAL DE CARRERA (F)      |%n");
                System.out.format("+-------------------------------------+%n"); 
                break; 
            case "8":
                System.out.format("+-------------------------------------+%n");
                System.out.format("|  8.TIEMPO MEDIO MINUTOS/KM          |%n");
                System.out.format("+-------------------------------------+%n"); 
                break;           
            case "0":
                System.out.format("+-------------------------------------+%n");
                System.out.format("|  0.SALIR                            |%n");
                System.out.format("+-------------------------------------+%n");       
                System.exit(0);        
                break;
            default:
            System.out.println("Por favor, selecciona una opción válida");
            option = sc.nextLine();
            setOptionDisplay(option , sc);
                break;
        }
        return;
    }
    public static void fillRunnerData(int[][]runnerArray, int Quantity, Scanner sc,String gender) {
            int numDorsal = 0;
            for (int i = 0; i < Quantity; i++) {
            System.out.println("Introduce el número de dorsal de \"" + gender + "\": " + (i + 1));
            numDorsal = sc.nextInt();
            for (int j = 0; j < runnerArray.length; j++) {
                if (runnerArray[j][0] == numDorsal) {
                    while (runnerArray[j][0] == numDorsal) {
                        System.out.println("¡Ese número ya está asignado! Introduce otro:");
                        numDorsal = sc.nextInt();
                    }
                }
            }
            runnerArray[i][0] = numDorsal; 
            for (int j = 1; j < runnerArray[i].length; j++) {
            switch (j) {
                case 1:
                    System.out.println("Introduce los minutos a los 5km de \"" + gender + "\": " + (i + 1));
                    runnerArray[i][1] = sc.nextInt();
                    break;
                case 2:
                    System.out.println("Introduce los minutos a los 10km de \"" + gender + "\": " + (i + 1));
                    runnerArray[i][2] = sc.nextInt();
                    break;       
                case 3:
                    System.out.println("Introduce los minutos a los 15km de \"" + gender + "\": "+ (i + 1));
                    runnerArray[i][3] = sc.nextInt();
                    break;
                case 4:
                    System.out.println("Introduce los minutos a los 21km de \"" + gender + "\": " + (i + 1));
                    runnerArray[i][4] = sc.nextInt();    
                    break;    
                default:
                    break;
            }
            }
        }
    }
    }

