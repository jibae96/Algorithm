import java.util.ArrayList;

// HashSet
// ArrayList : 중복 허용
public class SkillTrees {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int count = skill.length();
        ArrayList<Character> list = new ArrayList<>();
        boolean flag;

        for(int i=0; i<count; i++){
            list.add(skill.charAt(i));
        }

        for(String temp : skill_trees){
            int level = 0;
            flag = false;
            for(int i=0; i<temp.length(); i++){
                char myskill = temp.charAt(i);
                if(list.contains(myskill)){
                    if(myskill==list.get(level)){
                        level++;
                    }else{
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        SkillTrees skillTrees = new SkillTrees();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        skillTrees.solution(skill,skill_trees);
    }
}
