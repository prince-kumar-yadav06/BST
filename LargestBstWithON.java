
import java.util.*;
public class LargestBstWithON {

static class TreeNode{
    
        int data;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int d){
            this.data=d;
            this.left=null;
            this.right=null;
        }
        
    }
    static class Info{
        public int min;
        public int max;
        public int size;

       
    
        
        Info(int max,int min,int size){
            
            this.min=min;
            this.max=max;
            this.size=size;
          
        
        }
    };

   

    static Info largestBST(TreeNode root) {
        if (root == null) {
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE,0);
        }

        

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        

        if (leftInfo.max < root.data && rightInfo.min > root.data) {
          
            return new Info(Math.min(leftInfo.min,root.data),Math.max(rightInfo.max,root.data),1+ leftInfo.size+ rightInfo.size);
        }

      return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE,Math.max(leftInfo.size,rightInfo.size));

        
    }

   static  int FindLargestBSt(TreeNode root){

        return largestBST(root).size;
    }
    public static void main(String args[]){

       
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(20);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.left.left = new TreeNode(65);
        root.right.left.right = new TreeNode(80);

       



        System.out.println(FindLargestBSt(root));
    }
}
