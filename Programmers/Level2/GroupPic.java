import java.util.HashMap;

// dfs

public class GroupPic {
    public String[] d;
    public HashMap<Character,Integer> hm;
    public boolean[] visited;
    public int[] ch;
    public int answer;

    public int solution(int n, String[] data) {
        d=data;
        hm = new HashMap<>();
        visited = new boolean[8];
        ch = new int[8];
        answer=0;
        hm.put('A',0);
        hm.put('C',1);
        hm.put('F',2);
        hm.put('J',3);
        hm.put('M',4);
        hm.put('N',5);
        hm.put('R',6);
        hm.put('T',7);
        dfs(0);
        System.out.println(answer);
        return answer;
    }
    public void dfs(int index){
        if(index==8){
            if(check()) answer++;
        }else{
            for(int i=0; i<8; i++){
                if(!visited[i]){
                    visited[i]=true;
                    ch[index] = i;
                    dfs(index+1);
                    visited[i]=false;
                }
            }
        }
    }
    public boolean check(){
        int a,b,c;
        char op;
        for(String s:d){
            a = ch[hm.get(s.charAt(0))];
            b = ch[hm.get(s.charAt(2))];
            op = s.charAt(3);
            c = Integer.parseInt(s.substring(4,5))+1;

            if(op=='='){
                if(Math.abs(a-b)!=c) return false;
            }else if(op=='>'){
                if(Math.abs(a-b)<=c) return false;
            }else{
                if(Math.abs(a-b)>=c) return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        GroupPic groupPic = new GroupPic();
        int n=2;
        String[] data = {"N~F=0","R~T>2"};
        groupPic.solution(n,data);
    }
}
