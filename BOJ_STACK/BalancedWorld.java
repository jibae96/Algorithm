import java.io.*;
import java.util.*;

public class BalancedWorld{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String sentence = br.readLine();
        Stack<Character> stack = new Stack<>();

        while(!sentence.equals(".")){
            for(int i=0; i<sentence.length(); i++){
                char ch = sentence.charAt(i);
                switch(ch){
                    case '(' :
                        stack.push(ch);
                        break;
                    case '[' :
                        stack.push(ch);
                        break;
                    case ')' :
                        if(stack.isEmpty()){
                            stack.push(ch);
                            break;
                        }
                        char temp1 = stack.peek();
                        if(temp1=='(') stack.pop();
                        else stack.push(ch);
                        break;
                    case ']' :
                        if(stack.isEmpty()){
                            stack.push(ch);
                            break;
                        }
                        char temp2 = stack.peek();
                        if(temp2=='[') stack.pop();
                        else stack.push(ch);
                        break;
                    default :
                        break;
                }
            }
            //System.out.println("@"+stack);
            if(stack.isEmpty())
                sb.append("yes").append("\n");
            else sb.append("no").append("\n");

            stack.clear();
            sentence = br.readLine();
        }
        System.out.println(sb.toString());
    }
}
