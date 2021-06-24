import java.util.*;

class MenuRenewal {
    ArrayList<String> list;
    public void combination(char[] array, boolean[] visited, int start, int len){
        if(len==0){
            print(array, visited);
            return;
        }else{
            for(int i=start; i<array.length; i++){
                visited[i] = true;
                combination(array,visited,i+1,len-1);
                visited[i] = false;
            }
        }

    }

    public void print(char[] array, boolean[] visited){
        String result = "";
        for(int i=0; i<visited.length; i++){
            if(visited[i]) result+=array[i];
        }
        list.add(result);
        //System.out.print(result+" ");
    }
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        list = new ArrayList<>();
        HashMap<String,Integer> hm = new HashMap<>();
        ArrayList<String> all = new ArrayList<>();
        ArrayList<String> answerList = new ArrayList<>();
        
        for(int i=0; i<orders.length; i++){
            char [] orderChar = orders[i].toCharArray();
            boolean [] visited = new boolean[orderChar.length];
            Arrays.sort(orderChar);
            for(int j=0; j<course.length; j++){
                //System.out.println(course[j]+"개 뽑음!");
                combination(orderChar, visited, 0, course[j]);
                //System.out.println();
            }
        }
        
        for(String temp : list){
            hm.put(temp,hm.getOrDefault(temp,0)+1);
            if(!all.contains(temp)) all.add(temp);
        }

        /*
        for(String temp : all){
            System.out.println(temp+"-"+hm.get(temp));
        }
        */
        
        Collections.sort(all,(o1,o2)->{
            return hm.get(o2)-hm.get(o1);
        });
        /*
        for(String tmp : all){
            System.out.println(tmp+" "+hm.get(tmp));
        }
        */
        for(int i=0; i<course.length; i++){
            int max = 0;
            for(String temp : all){
                if(temp.length()==course[i] && hm.get(temp)>=2){
                    if(hm.get(temp)>=max){
                        answerList.add(temp);
                        max = hm.get(temp);
                    }
                }
            }
        }
        
        Collections.sort(answerList);
        answer = new String[answerList.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
