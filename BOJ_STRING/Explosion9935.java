import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Explosion9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<word.length(); i++){
            stack.push(word.charAt(i));
            if(stack.size()>=bomb.length()){
                boolean flag = true;
                for(int j=0; j<bomb.length(); j++){
                    if(stack.get(stack.size()-bomb.length()+j)!=bomb.charAt(j)){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    for(int j=0; j<bomb.length(); j++)
                        stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }
        if(sb.length()>0) System.out.println(sb);
        else System.out.println("FRULA");
    }
}
