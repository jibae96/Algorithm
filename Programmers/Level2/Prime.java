import java.util.*;

public class Prime {
    public HashSet<Integer> set;
    public int solution(String numbers) {
        set = new HashSet<>();
        char [] array = numbers.toCharArray();
        boolean[] select = new boolean[numbers.length()];

        for(int i=0; i<numbers.length(); i++){
            select[i]=true;
            makeNumber(array,select,numbers.length(),String.valueOf(array[i]));
            select[i]=false;
        }
        return set.size();
    }
    public void makeNumber(char[] array, boolean[] select, int r, String str){
        if(r==-1) return;
        if(isPrime(Integer.parseInt(str))){
            set.add(Integer.parseInt(str));
        }
        for(int i=0; i<array.length; i++){
            if(!select[i]){
                select[i]=true;
                makeNumber(array,select,r-1,str+array[i]);
                select[i]=false;
            }
        }
    }
    public boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2; i<=n/2; i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Prime prime = new Prime();
        String num = "17";
        prime.solution(num);
    }
}
