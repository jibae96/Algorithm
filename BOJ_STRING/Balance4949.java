import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Balance4949 {
    static String solution(String temp){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<temp.length(); i++){
            if(temp.charAt(i)=='(' || temp.charAt(i)=='[')
                stack.push(temp.charAt(i));
            else if(temp.charAt(i)==')'){
                if(stack.isEmpty() || stack.peek()!='(') return "no";
                else stack.pop();
            }
            else if(temp.charAt(i)==']'){
                if(stack.isEmpty() || stack.peek()!='[')return "no";
                else stack.pop();
            }
        }
        if(stack.isEmpty()) return "yes";
        else return "no";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String temp = br.readLine();
            if(temp.equals(".")) {
                break;
            }
            sb.append(solution(temp)).append('\n');
        }
        System.out.print(sb);
    }
}
