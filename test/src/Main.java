import java.util.*;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int num=0;
        if(n<10) System.out.println(n);
        else {
            String s = String.valueOf(n);
            for (int j = 1; j < s.length(); j++) {
                num += j * 9 * Math.pow(10, j - 1);
            }
            n = n -(int)(Math.pow(10, s.length() - 1))+1;
            num += n  * s.length();

            System.out.println(num);
        }
    }
}