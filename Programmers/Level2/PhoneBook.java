import java.util.*;

class PhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hs = new HashSet<>();

        for(String str : phone_book){
            hs.add(str);
        }

        for(int i=0; i<phone_book.length; i++){
            for(int j=1; j<phone_book[i].length(); j++){
                if(hs.contains(phone_book[i].substring(0,j))) return false;
            }
        }
        return true;
    }
}
