import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class NumberJump2210 {
    static int [][] board;
    static int [] goX = {-1,0,1,0};
    static int [] goY = {0,1,0,-1};
    static HashSet<String> hs;
    static StringBuilder sb;
    static void dfs(int x, int y, int count, String s){
        if(count==6){
            hs.add(s);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int cx = x + goX[i];
            int cy = y + goY[i];
            if (cx >= 0 && cy >= 0 && cx < 5 && cy < 5){
                dfs(cx,cy,count+1,s+board[cx][cy]);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int [5][5];
        hs = new HashSet<>();
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j <5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //String s = "";
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                String s = "";
                dfs(i,j,0,s);
            }
        }
        System.out.println(hs.size());
        for(String temp : hs)
            System.out.print(temp+" ");

    }
}
