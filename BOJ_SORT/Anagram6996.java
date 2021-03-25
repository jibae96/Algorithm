import java.util.*;

public class Anagram6996 {
    public void solution(String str1, String str2){
        char [] word1 = str1.toCharArray();
        char [] word2 = str2.toCharArray();
        if(word1.length != word2.length){
            System.out.println(str1+" & "+str2 + " are NOT anagrams.");
            return;
        }
        Arrays.sort(word1);
        Arrays.sort(word2);
        for(int i=0; i<word1.length; i++){
            if(word1[i]!=word2[i]){
                System.out.println(str1+" & "+str2 + " are NOT anagrams.");
                return;
            }
        }
        System.out.println(str1+" & "+str2 + " are anagrams.");
    }
    public static void main(String[] args) {
        Anagram6996 anagram = new Anagram6996();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            String word1 = sc.next();
            String word2 = sc.next();
            anagram.solution(word1,word2);
        }
    }
}
