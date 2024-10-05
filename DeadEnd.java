import java.util.*;

public class DeadEnd {

    static class TreeNode{
        int data;
        TreeNode left ,right =null;
    

    TreeNode(int d){
        this.data=d;
        this.left=null;
        this.right=null;
    }
    }
   public static boolean CheckDead(TreeNode root,int low,int up){

        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){

        
            if( (root.data - low) == 1 && (up - root.data) == 1 ){
            return true;
        }
             else{
                return false;
        }
    }
      return   CheckDead(root.left, low,root.data)|| CheckDead(root.right, root.data, up);

        
    }

    public static boolean ISDeadEnd(TreeNode root){


        int up=Integer.MAX_VALUE;
       return CheckDead(root,0,up);
    }
     

    public static void main(String args[]){

        TreeNode t=new TreeNode(8);
        t.left=new TreeNode(5);
        t.right=new TreeNode(11);
        t.left.left=new TreeNode(2);
        t.left.right=new TreeNode(7);
        t.left.left.right=new TreeNode(3);
        t.left.left.right.right=new TreeNode(4);

        System.out.println(ISDeadEnd(t));

    }
}
