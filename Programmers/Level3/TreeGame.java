import java.util.*;

class TreeGame {
    class Leaf{
        int index;
        int x;
        int y;
        Leaf left;
        Leaf right;
        public Leaf(int index, int x, int y){
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }
    int[][] answer;
    int index;
    public int[][] solution(int[][] nodeinfo) {
        ArrayList<Leaf> list = new ArrayList<>();
        
        for(int i=0; i<nodeinfo.length; i++){
            list.add(new Leaf(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        Collections.sort(list,(o1,o2)->{
            if(o1.y == o2.y){
                return o1.x-o2.x;
            }
            return o2.y-o1.y;
        });

      
        Leaf root = list.get(0);
        
        for(int i=1; i<list.size(); i++){
            makeNode(root, list.get(i));
        }
        
        answer = new int [2][list.size()];
        
        index = 0;
        preorder(root);
        
        index = 0;
        postorder(root);
        
        return answer;
    }
    
    // 트리 만들기
    public void makeNode(Leaf parent, Leaf child){
        if(child.x < parent.x){
            if(parent.left==null){
                parent.left = child;
            }else makeNode(parent.left, child);
        }else{
            if(parent.right==null){
                parent.right = child;
            }else makeNode(parent.right, child);
        }
    }
    
    // 전위 순회
    public void preorder(Leaf tree){
        if(tree != null){
            answer[0][index++] = tree.index;
            if(tree.left != null) preorder(tree.left);
            if(tree.right != null) preorder(tree.right);
        }
    }
    
  // 후위 순회
    public void postorder(Leaf tree){
        if(tree != null){
            if(tree.left != null) postorder(tree.left);
            if(tree.right != null) postorder(tree.right);
            answer[1][index++] = tree.index;
        }
    }
}
