import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Score10825 {
    static class Student{
        String name;
        int language;
        int english;
        int math;
        public Student(String name, int language, int english, int math){
            this.name = name;
            this.language = language;
            this.english = english;
            this.math = math;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Student [] array = new Student[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int language = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            array[i]=new Student(name,language,english,math);
        }
        Arrays.sort(array,(s1,s2)->{
           if(s1.language==s2.language && s1.english==s2.english && s1.math==s2.math)
               return s1.name.compareTo(s2.name);
           else if(s1.language==s2.language && s1.english==s2.english)
               return s2.math-s1.math;
           else if(s1.language==s2.language)
               return s1.english-s2.english;
           else return s2.language-s1.language;
        });
        for(int i=0; i<n; i++){
            System.out.println(array[i].name);
        }
    }
}
