import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ary = new int[n];
        int m = sc.nextInt();
        int l = sc.nextInt();
        int play = 0;
        int location = 0;
        while (true) {
            ary[location]++;
            if(ary[location] == m){
                break;
            }
            if (ary[location] % 2 == 0) {
                location = (location + l) % n;
            } else {
                location = (n + location - l) % n;
            }
            play++;
        }
        System.out.println(play);
    }
}