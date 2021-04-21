import java.io.*;
import java.util.*;

public class Expression2 {
    public static void main(String[] args) throws IOException {
      
        /*
        char ch = 'A';
        int temp = 'A';
        System.out.println(Character.toChars(ch+1));
        System.out.println(temp);
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testcase = Integer.parseInt(st.nextToken());
        String expression = br.readLine();

        HashMap<Character,Integer> hm = new HashMap<>();
        Stack<Double> stack = new Stack<>();

        int firstAlphbet = 'A';

        for(int i=0; i<testcase; i++){
            st = new StringTokenizer(br.readLine());
            hm.put(Character.toChars(firstAlphbet)[0],Integer.parseInt(st.nextToken()));
            System.out.println(hm.get(Character.toChars(firstAlphbet)[0]));
            firstAlphbet++;
        }

        for(int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i);
            if(ch>='A' && ch<='Z'){
                stack.push((double)hm.get(ch));
            }else{
                double a = (double)stack.pop();
                double b = (double)stack.pop();
                double result = 0;

                if(ch=='+') result = b+a;
                else if(ch=='-') result = b-a;
                else if(ch=='/') result = b/a;
                else result = b*a;

                stack.push(result);
            }
        }
        double answer = stack.pop();
        String str = String.format("%.2f",answer);
        System.out.println(str);

    }
}
