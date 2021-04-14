import java.io.*;
import java.util.*;

public class IronStick {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        Stack<Character> stack = new Stack<>();

        int count = 0;

        for(int i=0; i<str.length()-1; i++){
            char current = str.charAt(i);
            char next = str.charAt(i+1);
            if(current=='(' && next==')'){
                count += stack.size();
                i++;
            }else if(current=='('){
                stack.push(current);
            }else if(current==')'){
                stack.pop();
                count++;
            }
        }
        System.out.println(count+1);
    }
}
