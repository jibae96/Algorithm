import java.util.*;

class NewsCluster {
    public int solution(String str1, String str2) {
        int answer = 0;
        HashMap<String,Integer> hmA = new HashMap<>();
        HashMap<String,Integer> hmB = new HashMap<>();
        HashMap<String,Integer> hm = new HashMap<>();


        for(int i=0; i<str1.length()-1; i++){
            String temp = str1.substring(i,i+2).toUpperCase();
            if(temp.charAt(0)>='A'&&temp.charAt(0)<='Z'&&temp.charAt(1)>='A'&&temp.charAt(1)<='Z'){
                hmA.put(temp, hmA.getOrDefault(temp,0)+1);
            }
        }
        for(int i=0; i<str2.length()-1; i++){
            String temp = str2.substring(i,i+2).toUpperCase();
            if(temp.charAt(0)>='A'&&temp.charAt(0)<='Z'&&temp.charAt(1)>='A'&&temp.charAt(1)<='Z'){
                hmB.put(temp, hmB.getOrDefault(temp,0)+1);
            }
        }

        for(String key : hmA.keySet()){
            System.out.println(key+"@"+hmA.get(key));
            hm.put(key,hmA.get(key));
        }

        for(String key : hmB.keySet()){
            if(hm.containsKey(key) && hmB.get(key)>hm.get(key)){
                hm.put(key,hmB.get(key));
            }else if(!hm.containsKey(key)) hm.put(key,hmB.get(key));
        }

        System.out.println(hmA.size()+"-"+hmB.size()+"-"+hm.size());
        for(String tmp : hm.keySet()){
            System.out.println(tmp+"="+hm.get(tmp));
        }
        int count = 0;
        int total = 0;

        for(String key : hm.keySet()){
            if(hmA.containsKey(key) && hmB.containsKey(key)){
                count += hmA.get(key) < hmB.get(key) ? hmA.get(key) : hmB.get(key);
            }
            total += hm.get(key);
        }

        System.out.println(count+" "+total);

        if(total==0) answer = 65536;
        else answer = (int)(((double)count/(double)total) * 65536);

        return answer;
    }
}
