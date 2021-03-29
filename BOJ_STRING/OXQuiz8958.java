import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OXQuiz8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            int total=0;
            int score=0;
            for(int j=0; j<temp.length(); j++){
                if(temp.substring(j,j+1).equals("O")) score++;
                else score=0;
                total+=score;
            }
            System.out.println(total);
        }
    }
}
