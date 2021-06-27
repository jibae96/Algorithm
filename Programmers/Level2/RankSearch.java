import java.util.*;

class RankSearch {
    
    // string은 만들 수 있는 경우 List<Integer>은 해당 점수
    HashMap<String,List<Integer>> hm;
    int[] answer;

    public void makeInfo(String[] array, int score, int start, int choose, String key){
        if(choose==array.length-1){
            List<Integer> list = hm.getOrDefault(key, new ArrayList<Integer>());
            list.add(score);
            hm.put(key,list);
            return;
        }

        for(int i=start; i<array.length-1; i++){
            makeInfo(array,score,i+1,choose+1,key+array[i]);
            makeInfo(array,score,i+1,choose+1,key+"-");
        }
    }
  
    public void makeQuery(String str, int index){
        String[] array = str.split(" ");
        String temp="";
        int score = Integer.parseInt(array[array.length-1]);

        for(int i=0; i<array.length-1; i++){
            if(array[i].equals("and")) continue;
            temp+=array[i];
        }
        if(hm.containsKey(temp)) answer[index] = counting(temp,score);
    }

    // 이분탐색
    public int counting(String str, int score){
        if(!hm.containsKey(str)) return 0;

        List<Integer> tempList = hm.get(str);
        int start=0;
        int end=tempList.size()-1;
        //System.out.println(tempList+"#");
        while(start<=end){
            int mid = (start+end)/2;
            if(tempList.get(mid)<score)
                start = mid+1;
            else end = mid-1;
        }

        return tempList.size()-start;
    }
  
    public int[] solution(String[] info, String[] query) {
        answer = new int [query.length];
        hm = new HashMap<>();

        for(int i=0; i<info.length; i++){
            String[] temp = info[i].split(" ");
            int score = Integer.parseInt(temp[4]);

            makeInfo(temp,score,0,0,"");
        }

        for(List<Integer> li : hm.values()){
            Collections.sort(li);
        }

        for(int i=0; i<query.length; i++){
            makeQuery(query[i],i);
        }
        return answer;
    }

}
