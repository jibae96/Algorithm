import java.io.*;
import java.util.*;

public class GoodWord{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        int answer = 0;

        for(int i=0; i<testcase; i++){
            String temp = br.readLine();
            for(int j=0; j<temp.length(); j++){
                char ch = temp.charAt(j);
                if(!stack.isEmpty()){
                    if(ch==stack.peek()){
                        stack.pop();
                    }else stack.push(ch);
                }
                else stack.push(ch);
            }
            if(stack.isEmpty()) answer++;
            else stack.clear();
        }

        System.out.println(answer);
    }
}
