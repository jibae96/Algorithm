import java.util.*;

public class Qindex13333 {
    public void solution(int[] array){
        Arrays.sort(array);
        for(int i=array[array.length-1]; i>=0; i--){
            int count=0;
            for(int j=0; j<array.length; j++){
                if(array[j]>=i && array[j]!=0) count++;
            }
            if(count>=i){
                System.out.println(i);
                return;
            }
        }
        System.out.println("0");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for(int i=0; i<N; i++){
            array[i]=sc.nextInt();
        }
        Qindex13333 qindex = new Qindex13333();
        qindex.solution(array);
    }
}
