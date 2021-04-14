import java.io.*;
import java.util.*;

public class StackSeries{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int num = 1;
        int mySize = Integer.parseInt(st.nextToken());
        int [] array = new int [mySize];
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(int i=0; i<mySize; i++){
            st = new StringTokenizer(br.readLine());
            array[i]=Integer.parseInt(st.nextToken());
        }
        stack.push(num++);
        sb.append("+").append("\n");
        while(mySize>index){
            if(stack.isEmpty()){
                stack.push(num++);
                sb.append("+").append("\n");
                continue;
            }
            int current = stack.peek();
            if(current==array[index]){
                stack.pop();
                index++;
                sb.append("-").append("\n");
            }else if(current>array[index]){
                flag = false;
                break;
            }else {
                stack.push(num++);
                sb.append("+").append("\n");
            }
        }
        if(flag && mySize==index){
            System.out.println(sb.toString());
        }else System.out.println("NO");
    }
}
