import java.io.*;
import java.util.*;

public class Zero{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        int testcase = Integer.parseInt(st.nextToken());
        for(int i=0; i<testcase; i++){
            st = new StringTokenizer(br.readLine());
            int current = Integer.parseInt(st.nextToken());
            if(current != 0){
                stack.push(current);
            }else{
                stack.pop();
            }
        }

        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        System.out.println(answer);
    }
}
