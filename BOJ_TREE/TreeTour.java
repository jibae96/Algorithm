import java.io.*;
import java.util.*;

public class TreeTour{
    public static class Node{
        char data;
        Node left;
        Node right;
        public Node(char data){
            this.data = data;
        }
    }

    public static class Tree{
        Node root;

        public void createNode(char data, char leftData, char rightData){
            if(root==null){ // 초기 상태
                root = new Node(data);

                if(leftData!='.'){
                    root.left = new Node(leftData);
                }
                if(rightData!='.'){
                    root.right = new Node(rightData);
                }
            }else{
                searchNode(root, data, leftData, rightData);
            }
        }

        public void searchNode(Node root, char data, char leftData, char rightData){
            if(root==null) return;
            else if(root.data==data){
                if(leftData != '.'){
                    root.left = new Node(leftData);
                }
                if(rightData != '.'){
                    root.right = new Node(rightData);
                }
            }else{
                searchNode(root.left, data, leftData, rightData);
                searchNode(root.right, data, leftData, rightData);
            }
        }

        // 전위
        public void preorder(Node root){
            System.out.print(root.data);
            if(root.left!=null) preorder(root.left);
            if(root.right!=null) preorder(root.right);
        }
        // 중위
        public void inorder(Node root){
            if(root.left!=null) inorder(root.left);
            System.out.print(root.data);
            if(root.right!=null) inorder(root.right);
        }
        //후위
        public void postorder(Node root){
            if(root.left!=null) postorder(root.left);
            if(root.right!=null) postorder(root.right);
            System.out.print(root.data);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for(int i=0; i<testcase; i++){
            char [] temp = br.readLine().replaceAll(" ","").toCharArray();
            tree.createNode(temp[0],temp[1],temp[2]);
        }

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
    }
}
