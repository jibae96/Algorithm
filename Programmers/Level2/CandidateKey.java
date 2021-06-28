import java.util.*;

class CandidateKey {
    ArrayList<String> list;
    int size;
    String[][] Relation;
    public int solution(String[][] relation) {

        list = new ArrayList<>();
        size = relation[0].length;
        Relation = relation;

        for(int i=1; i<=size; i++){
            combination(0,i,"");
        }

        return list.size();
    }

    public void combination(int start, int r, String temp){
        if(r==0){
            //System.out.print(temp+" ");

            // 후보키 될 수 없는 경우
            if(!list.isEmpty()){
                for(String s : list){
                    boolean flag = false;
                    for(String ch : s.split("")){
                        if(!temp.contains(ch)){
                            flag = true;
                            break;
                        }
                    }
                    if(!flag) return;
                }
            }

            // 후보키인지 확인
            HashSet<String> hs = new HashSet<>();
            String[] array = temp.split("");
            for(int i=0; i<Relation.length; i++){
                String s="";
                for(int j=0; j<array.length; j++){
                    s += Relation[i][Integer.parseInt(array[j])];
                }
                if(!hs.contains(s)) hs.add(s);
            }

            if(hs.size()==Relation.length) list.add(temp);

        }else{
            for(int i=start; i<size; i++){
                combination(i+1,r-1,temp+i);
            }
        }

    }
}
