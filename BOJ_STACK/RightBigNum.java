import java.util.*;
import java.io.*;

public class RightBigNum{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testcase = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int [] array = new int [testcase];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<testcase; i++){
            array[i]=Integer.parseInt(st.nextToken());
        }


        for(int i=0; i<testcase; i++){
            while(!stack.isEmpty() && array[stack.peek()]>array[i]){
                array[stack.pop()]=array[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            array[stack.pop()]=-1;
        }

        for(int i=0; i<testcase; i++)
            System.out.print(array[i]+" ");
    }
}
