import java.util.Arrays;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String linie = scanner.nextLine();

        String[] s=linie.split("\\s");

        if(s.length < 5)
        {
            System.out.println("nu sunt indeajuns numere");
            return;
        }

        Integer[] v= new Integer[s.length];
        for ( int i=0; i< v.length;i++)
        {
            v[i]=Integer.parseInt(s[i]);
        }

        System.out.println(Arrays.toString(v));
        int nr=v[0];
        Arrays.sort(v);
        System.out.println(Arrays.toString(v));

        int poz=Arrays.binarySearch(v,nr);

        System.out.println(poz);


    }
}
