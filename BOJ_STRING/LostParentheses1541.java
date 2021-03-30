import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LostParentheses1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        String[] temp = expression.split("-");
        int sum=Integer.MAX_VALUE;
        for(int i=0; i<temp.length; i++){
            int current=0;
            String[] add = temp[i].split("\\+");
            for(int j=0; j<add.length; j++){
                current+=Integer.parseInt(add[j]);
            }
            if(sum==Integer.MAX_VALUE) sum=current;
            else sum-=current;
        }
        System.out.println(sum);
    }
}
