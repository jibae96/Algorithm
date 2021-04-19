import java.io.*;
import java.util.*;

public class Expression{
    public static int getPriority(char ch){
        if(ch=='(') return 0;
        else if(ch=='+' || ch=='-') return 1;
        else return 2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        Stack<Character> stack = new Stack<>();
        String answer = "";

        for(int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i);
            if(ch>='A' && ch<='Z'){
                answer += ch;
            }else if(ch=='('){
                stack.push(ch);
            }else if(ch==')'){
                while(!stack.isEmpty()){
                    char temp = stack.pop();
                    System.out.println("temp="+temp);
                    if(temp=='(') {
                        System.out.println("here");
                        break;
                    }
                    answer += temp;
                }
            }else{
                while(!stack.isEmpty() && getPriority(stack.peek())>=getPriority(ch)){
                    answer += stack.pop();
                }
                stack.push(ch);
            }
            System.out.println("@"+stack);
        }
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        System.out.print(answer);
    }
}
