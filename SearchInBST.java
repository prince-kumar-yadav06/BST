import java.util.*;

public class SearchInBST {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static void preorder(TreeNode root){
        if(root == null){
            return;
        }

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    static boolean ans;
    // static int min=Integer.MAX_VALUE;
    static boolean SearchKeyInBSt(TreeNode root,int key){


        if(root == null){
            return false ;
        }
        if(root.data == key){
            preorder(root);
            return  ans=true;
        }

        if(root.data < key){
            SearchKeyInBSt(root.right, key);
           
        }
        else{

            SearchKeyInBSt(root.left, key);
        }    

        return ans;

    }

    public static void main(String args[]){
        TreeNode t=new TreeNode(6);

        t.left=new TreeNode(1);
        t.right=new TreeNode(8);
        t.right.left=new TreeNode(7);
        t.right.right=new TreeNode(9);

    System.out.println(SearchKeyInBSt(t, 5));
    }
}
