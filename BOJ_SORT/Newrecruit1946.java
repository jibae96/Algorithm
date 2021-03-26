import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Newrecruit1946 {
    static class Applicant{
        int paper;
        int interview;
        public Applicant(int paper, int interview){
            this.paper=paper;
            this.interview=interview;
        }
    }
    public void solution(ArrayList<Applicant> list){
        Collections.sort(list, (a1,a2)->{
            return a1.paper-a2.paper;
        });
        int answer = list.size();
        int score = list.get(0).interview;
        for(int i=1; i<list.size(); i++){
            int current = list.get(i).interview;
            if(score<current) answer--;
            if(current<score) score=current;
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Newrecruit1946 success = new Newrecruit1946();
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int m=Integer.parseInt(st.nextToken());
            ArrayList<Applicant> list = new ArrayList<>();
            for(int j=0; j<m; j++){
                st=new StringTokenizer(br.readLine());
                int paper=Integer.parseInt(st.nextToken());
                int interview=Integer.parseInt(st.nextToken());
                list.add(new Applicant(paper,interview));
            }
            success.solution(list);
        }
    }
}
