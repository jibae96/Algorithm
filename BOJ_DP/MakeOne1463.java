import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeOne1463 {
    static Integer[] d;
    static int dp(int n){
        if(d[n]==null){
            if(n%6==0){
                d[n] = Math.min(dp(n-1),Math.min(dp(n/3),dp(n/2)))+1;
            }else if(n%3==0){
                d[n] = Math.min(dp(n/3),dp(n-1))+1;
            }else if(n%2==0){
                d[n] = Math.min(dp(n/2), dp(n-1))+1;
            }else{
                d[n] = dp(n-1)+1;
            }
        }
        return d[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new Integer[n+1];
        d[0]=d[1]=0;
        System.out.println(dp(n));
    }
}
