package programa;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class functions {
    public static void registerData(int[][]maleRunners,int[][]femaleRunners,int m, int f,Scanner sc, int counter,int option) {
        functions.setOptionDisplay(option, sc);
        System.out.println("Introduce el número de corredores masculinos inscritos:");
            m = sc.nextInt();
            maleRunners = new int[m][5];
            //System.out.println(Arrays.deepToString(maleRunners).replace("], ", "]\n"));
        System.out.println("Introduce el número de corredoras femeninas inscritas:");
            f = sc.nextInt();
            femaleRunners = new int[f][5]; 

        functions.fillRunnerData(maleRunners, m, sc, "corredor");
        program.setMaleRunners(maleRunners);
        program.setM(m);
        functions.fillRunnerData(femaleRunners, f, sc, "corredora");
        program.setFemaleRunners(femaleRunners);
        program.setF(f);

    }
    public static void selectOptions(int[][]maleRunners, int[][]femaleRunners,int m,int f, Scanner sc,int counter) {
        functions.Menu();
        int option = sc.nextInt(); 
        sc.nextLine();
        switch (String.valueOf(option)) {
            case "0":
            functions.setOptionDisplay(option, sc);
                break;
            case "1":
            if(maleRunners != null || femaleRunners != null){
                System.out.println("Esto borrará los corredores registrados, ¿Deseas continuar? (S/N)");
                String choice = sc.nextLine();
                switch (choice) {
                    case "S":
                    case "s":
                        registerData(maleRunners, femaleRunners, m, f, sc, counter, option);
                        break;
                    default:
                        break;
                }
            }else{
                registerData(maleRunners, femaleRunners, m, f, sc, counter, option);
            }

                break;
            case "2":
            if(maleRunners == null){
                functions.checkData(maleRunners, femaleRunners, m, f, option, sc,counter);
            }else{
                 int abandoned5km = functions.getRunnerData(counter, maleRunners, 1);
                 int abandoned10km = functions.getRunnerData(counter, maleRunners, 2);
                 int abandoned15km = functions.getRunnerData(counter, maleRunners, 3);
                 int abandoned21km = functions.getRunnerData(counter, maleRunners, 4);
                 System.out.println("Del km 0 al 5 han abandonado "+ abandoned5km +" corredores");
                 System.out.println("Del km 5 al 10 han abandonado "+ abandoned10km +" corredores");
                 System.out.println("Del km 10 al 15 han abandonado "+ abandoned15km +" corredores");
                 System.out.println("Del km 15 al 21 han abandonado "+ abandoned21km +" corredores");
            }
            break;
            case "3":
            if(maleRunners == null){
                functions.checkData(maleRunners, femaleRunners, m, f, option, sc,counter);
            }else{
                int abandoned5km = functions.getRunnerData(counter, femaleRunners, 1);
                int abandoned10km = functions.getRunnerData(counter, femaleRunners, 2);
                int abandoned15km = functions.getRunnerData(counter, femaleRunners, 3);
                int abandoned21km = functions.getRunnerData(counter, femaleRunners, 4);
                System.out.println("Del km 0 al 5 han abandonado "+ abandoned5km +" corredoras");
                System.out.println("Del km 5 al 10 han abandonado "+ abandoned10km +" corredoras");
                System.out.println("Del km 10 al 15 han abandonado "+ abandoned15km +" corredoras");
                System.out.println("Del km 15 al 21 han abandonado "+ abandoned21km +" corredoras");
            }
            break;
            case "4":
            if(maleRunners == null){
                functions.checkData(maleRunners, femaleRunners, m, f, option, sc,counter);
            }else{
                System.out.println("Listado de dorsales inscritos masculinos:");

                functions.getRunnerDorsals(maleRunners, 0, m);
            }
            break;
            case "5":
            if(maleRunners == null){
                functions. checkData(maleRunners, femaleRunners, m, f, option, sc,counter);
            }else{
                System.out.println("Listado de dorsales inscritos femeninos:");
                functions.getRunnerDorsals(femaleRunners, 0, f);
            }
            break;
            case "6":
            if(maleRunners == null){
                functions.checkData(maleRunners, femaleRunners, m, f, option, sc,counter);
            }else{
                functions.getRunnerTime(maleRunners, m);
            }
            break;
            case "7":
            if(maleRunners == null){
                functions.checkData(maleRunners, femaleRunners, m, f, option, sc,counter);
            }else{
                functions.getRunnerTime(femaleRunners, f);
            }
            break;
            case "8":
            if(maleRunners == null){
                functions.checkData(maleRunners, femaleRunners, m, f, option, sc,counter);
            }else{
                getAvgMinPerKm(maleRunners,"masculina");
                getAvgMinPerKm(femaleRunners,"femenina");
            }
            break;
            default:
            
                break;
        }
        return;
    }

    public static void checkData(int[][] maleRunners,int[][] femaleRunners,int m,int f ,int option, Scanner sc,int counter) {
    System.out.println("¡No hay datos para mostrar!");
    selectOptions(maleRunners, femaleRunners, m, f, sc,counter);
    }

    public static int getRunnerData(int counter, int[][]array,int col) {
        counter = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i][col] == 0){
                counter++;
            }
        }
        return counter;
    }

    public static void getRunnerDorsals(int[][]array,int col,int Quantity) {
        int[] dorsal = new int[Quantity];
        for (int i = 0; i < array.length; i++) {
          dorsal[i] = array[i][0];
        }
        Arrays.sort(dorsal);
        for (int i : dorsal) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void getRunnerTime(int[][]array,int Quantity) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = 0;
            for (int j = 1; j < array[i].length; j++) {
                sum += array[i][j];
              }
        if (array[i][4] != 0)
            System.out.println("El dorsal "+ array[i][0]+" ha tardado " + sum + " minutos.");
        }
    }

    public static void getAvgMinPerKm(int[][]array, String category){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = 0;
            for (int j = 1; j < array[i].length; j++) {
                sum += array[i][j];
              }
        if (array[i][4] == 0){
            System.out.println("El corredor en la categoría "+ category +" con el dorsal "+ array[i][0]+" no ha terminado la carrera.");
        }else{
            Double division = (double) sum/21;
            String time = new DecimalFormat("#.##").format(division);
            System.out.println("El corredor en la categoría "+ category +" con el dorsal "+ array[i][0]+" ha corrido la maratón en un tiempo medio de " + time +" minutos/km.");
        }
        }
    }

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

    public static void setOptionDisplay(int option, Scanner sc) {        
        switch (String.valueOf(option)) {
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
            option = sc.nextInt();
            sc.nextLine();
            setOptionDisplay(option , sc);
                break;
        }
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

