import java.util.*;

public class Atm11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int count=0;
        int total=0;
        for(int i=0; i<N; i++) {
            count += arr[i];
            total += count;
        }
        System.out.println(total);
    }
}
