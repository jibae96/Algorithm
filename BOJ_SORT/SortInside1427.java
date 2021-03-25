import java.util.*;

public class SortInside1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int [] array = new int [s.length()];
        for(int i=0; i<s.length(); i++){
            array[i]=Integer.parseInt(s.substring(i,i+1));
        }
        Arrays.sort(array);
        for(int i=array.length-1; i>=0; i--)
            System.out.print(array[i]);
    }
}
