import java.util.*;

class BannedUser {
    HashSet<Set<String>> hs;
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        hs = new HashSet<>();
        
        dfs(user_id, banned_id, new LinkedHashSet<>());
        
        return hs.size();
    }
    
    public void dfs(String[] user_id, String[] banned_id, Set<String> set){
        if(set.size()==banned_id.length){
            if(check(banned_id, set)){
                hs.add(new LinkedHashSet<>(set));
                //System.out.println(set);
                return;
            }
        }
        
        for(String temp : user_id){
            if(!set.contains(temp)){
                set.add(temp);
                dfs(user_id, banned_id, set);
                set.remove(temp);
            }
        }
    }
    
    public boolean check(String[] banned_id, Set<String> set){
        int index = 0;
        
        for(String id : set){
            String banned = banned_id[index++];
            if(id.length()==banned.length()){
                for(int i=0; i<id.length(); i++){
                    if(banned.charAt(i)!='*' && banned.charAt(i)!=id.charAt(i))
                        return false;
                }
            }else return false;
        }
        return true;
    }
}
