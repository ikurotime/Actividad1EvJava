package programa;
import java.util.Arrays;
import java.util.Scanner;
/**
 * main
 */
public class program {
    public static void mainMenu(String firstOption, int[][]maleRunners, int[][]femaleRunners,int m,int f, Scanner sc) {
        switch (firstOption) {
            case "0":
            functions.setOptionDisplay(firstOption, sc);
                break;
            case "1":
            functions.setOptionDisplay(firstOption, sc);
            System.out.println("Introduce el número de corredores masculinos inscritos:");
                m = sc.nextInt();
                maleRunners = new int[m][5];
                //System.out.println(Arrays.deepToString(maleRunners).replace("], ", "]\n"));
            System.out.println("Introduce el número de corredoras femeninas inscritas:");
                f = sc.nextInt();
                femaleRunners = new int[f][5]; 

            functions.fillRunnerData(maleRunners, m, sc, "corredor");
            functions.fillRunnerData(femaleRunners, f, sc, "corredora");
                break;
            default:
            while (!firstOption.equals("1")) {
                System.out.println("¡No hay datos para mostrar!");
                firstOption = sc.nextLine();
                mainMenu(firstOption, maleRunners, femaleRunners, m, f, sc);
                }
                break;
        }
        return;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int[][] maleRunners = null;
        int[][] femaleRunners =  null;
        int m = 0;
        int f = 0;

        // System.out.println(Arrays.deepToString(corredores).replace("], ", "]\n"));
        System.out.println("Bienvenido al programa de la Maratón Cervantina");
        
        functions.Menu();
        String firstOption = sc.nextLine();
        mainMenu(firstOption,maleRunners,femaleRunners,m,f,sc);

    }
}
