import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Olympic8979 {
    static class Medal{
        int num;
        int gold;
        int silver;
        int bronze;
        public Medal(int num, int gold, int silver, int bronze){
            this.num=num;
            this.gold=gold;
            this.silver=silver;
            this.bronze=bronze;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int here = Integer.parseInt(st.nextToken());
        Medal[] array = new Medal[n+1];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            array[i]=new Medal(num,gold,silver,bronze);
        }
        array[n]=new Medal(0,0,0,0);
        Arrays.sort(array, (o1,o2)->{
            if(o1.gold==o2.gold && o1.silver==o2.silver)
                return o2.bronze-o1.bronze;
            else if(o1.gold==o2.gold)
                return o2.silver-o1.silver;
            else return o2.gold-o1.gold;
        });

        for(int i=0;i<n+1; i++) {
            System.out.println(array[i].num);
        }
        int level=1;
        int jump=0;
        for(int i=1; i<n+1; i++){
            if(array[i-1].num==here) break;
            if(array[i-1].gold==array[i].gold && array[i-1].silver==array[i].silver && array[i-1].bronze==array[i].bronze) {
                jump++;
                //continue;
            }
            else {
                level+=(jump+1);
                jump=0;
            }
        }

        System.out.println(level);
    }
}
