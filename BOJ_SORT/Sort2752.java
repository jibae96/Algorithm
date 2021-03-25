import java.util.*;

public class Sort2752 {
    public static void main(String[] args) {
        int [] array = new int [3];
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<3; i++){
            array[i]=sc.nextInt();
        }
        Arrays.sort(array);
        for(int i=0; i<3; i++)
            System.out.print(array[i]+" ");
    }
}
