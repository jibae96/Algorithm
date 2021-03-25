import java.util.*;

public class Contest5576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = new int [10];
        int[] arr2 = new int [10];
        int total1=0;
        int total2=0;

        for(int i=0; i<10; i++){
            arr1[i]=sc.nextInt();
        }
        for(int i=0; i<10; i++){
            arr2[i]=sc.nextInt();
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=9; i>6; i--){
            total1+=arr1[i];
            total2+=arr2[i];
        }
        System.out.println(total1+" "+total2);
    }
}
