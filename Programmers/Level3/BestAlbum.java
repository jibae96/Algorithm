import java.util.*;

class BestAlbum {
    class Music{
        String genre;
        int count;
        int index;
        public Music(String genre, int count, int index){
            this.genre = genre;
            this.count = count;
            this.index = index;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        ArrayList<Integer> result = new ArrayList<>();
        
        HashSet<Music> hs = new HashSet<>();
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            Music temp = new Music(genres[i],plays[i],i);
            hs.add(temp);
            hm.put(genres[i],hm.getOrDefault(genres[i],0)+plays[i]);
        }
    
        Music [] allMusic = new Music [hm.size()];
        int index = 0;
        
        for(String str : hm.keySet()){
            //System.out.println(hm.get(str));
            allMusic[index++] = new Music(str,hm.get(str),-1);
        }
        
        Arrays.sort(allMusic,(o1,o2)->{
            return o2.count-o1.count;
        });
        
        index = 0;
        
        for(Music m : allMusic){
            ArrayList<Music> list = new ArrayList<>();
            for(Music current : hs){
                if(current.genre.equals(m.genre)){
                    list.add(current);
                }
            }
            Collections.sort(list,(o1,o2)->{
                if(o1.count==o2.count){
                    return o1.index-o2.index;
                }
                else return o2.count-o1.count;
            });
            
            for(int i=0; i<2; i++){
                result.add(list.get(i).index);
                if(list.size()==1){ 
                    break;
                }
            }
        }
        
        answer = new int [result.size()];
        for(int i=0; i<result.size(); i++)
            answer[i] = result.get(i);

        return answer;
    }
}
