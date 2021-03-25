import java.util.*;

public class Sort2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++)
            list.add(sc.nextInt());

        Collections.sort(list);

        for(int item : list){
            sb.append(item).append('\n');
        }
        System.out.println(sb);
    }
}
