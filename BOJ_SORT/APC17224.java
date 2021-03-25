import java.util.*;

public class APC17224 {
    public void solution(ArrayList<Info> list, int k){
        int total=0;
        Info [] temp = new Info[list.size()];
        for(int i=0; i<temp.length; i++)
            temp[i]=list.get(i);
        Arrays.sort(temp, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o2.level>o1.level) return o2.level-o1.level;
                else if(o2.score>o1.score) return o2.score-o1.score;
                return o2.score-o1.score;
            }
        });

        /*for(int i=0; i<temp.length; i++){
            System.out.println(temp[i].score+"-"+temp[i].level);
        }*/
        for(int i=0; i<k && i<temp.length ; i++){
            if(temp[i].level==2) total+=140;
            else total+=100;
        }
        System.out.println(total);
    }
    static class Info{
        int score;
        int level;
        public Info(int score, int level){
            this.score=score;
            this.level=level;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Info> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(b<=L) list.add(new Info(b,2));
            else if(a<=L && b>L) list.add(new Info(a,1));
        }
        APC17224 apc = new APC17224();
        apc.solution(list,k);
    }
}
