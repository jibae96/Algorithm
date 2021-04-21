import java.util.*;
import java.io.*;

public class Stick{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<testcase; i++){
            int current = Integer.parseInt(br.readLine());
            while(!stack.isEmpty()){
                int temp = stack.peek();
                if(current>=temp){
                    stack.pop();
                }else{
                    stack.push(current);
                    break;
                }
            }
            if(stack.isEmpty())
                stack.push(current);
        }

        System.out.println(stack.size());
    }
}
