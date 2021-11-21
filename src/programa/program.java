package programa;
import java.util.Scanner;
/**
 * main
 */
public class program {
    public static int[][] maleRunners = null;
    public static int[][] femaleRunners =  null;
    public static int m = 0;
    public static int f = 0;
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
       
        int counter = 0;
        System.out.println("Bienvenido al programa de la Maratón Cervantina");

        do {
        functions.selectOptions(maleRunners,femaleRunners,m,f,sc,counter);
        } while (true);
    }
    
    public static void setMaleRunners(int[][] maleRunners) {
        program.maleRunners = maleRunners;
    }
    public static void setFemaleRunners(int[][] femaleRunners) {
        program.femaleRunners = femaleRunners;
    }
    public static void setM(int m) {
        program.m = m;
    }
    public static void setF(int f) {
        program.f = f;
    }
}
