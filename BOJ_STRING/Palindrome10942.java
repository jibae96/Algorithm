import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Palindrome10942 {
    public static boolean[][] answer;
    public static void check(int[] array, int n){
        //i는 시작점 j는 끝점
        for(int i=2; i<n; i++){
            for(int j=1; j<=n-i; j++){
                if(array[j]==array[j+i] && answer[j+1][j+i-1])
                    answer[j][j+i]=answer[j+i][j]=true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] array = new int[n+1];
        for(int i=1; i<=n; i++){
            array[i]=Integer.parseInt(st.nextToken());
        }
        answer = new boolean[n+1][n+1];
        for(int i=1; i<=n; i++)
            answer[i][i]=true;
        for(int i=1; i<n; i++)
            if(array[i]==array[i+1])
                answer[i][i+1]=answer[i+1][i]=true;

        check(array,n);

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result=0;
            if(answer[start][end]) result=1;
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

}
