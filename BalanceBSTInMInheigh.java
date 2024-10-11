import java.util.*;

public class BalanceBSTInMInheight {
   static class TreeNode{
    
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode next;
        
        TreeNode(int data){
                this.data=data;
                this.left=null;
                this.right=null;
                this.next=null;
            }
        }


        static ArrayList<Integer> arr=new ArrayList<>();
        static void InorderTraversal(TreeNode root){
            if(root == null){
                return ;
            }
            InorderTraversal(root.left);
            arr.add(root.data);
            InorderTraversal(root.right);

        }

       static TreeNode BalanceBST(TreeNode root){

        InorderTraversal(root);

       return BSTbalanace(arr,0,arr.size()-1);
        }


     static TreeNode BSTbalanace(ArrayList<Integer> sortedArr,int start,int end){

        if(start > end){
            return null;
        }
        int mid=(start +end)/2;

        TreeNode Newroot=new TreeNode(sortedArr.get(mid));
        Newroot.left=BSTbalanace(sortedArr, start, mid-1);
        Newroot.right=BSTbalanace(sortedArr, mid+1, end);

        return Newroot;
     }


     static void print(TreeNode root){

        if(root == null){
            return;
        }
        print(root.left);
        System.out.print(root.data+"->");
        print(root.right);
     }
     public static void main(String args[]){


         TreeNode root = new TreeNode(10);
         root.left = new TreeNode(5);
         root.left.left = new TreeNode(2);
         root.left.left.left = new TreeNode(1);
         root.right = new TreeNode(15);
         root.right.right = new TreeNode(20);

         TreeNode ansroot=BalanceBST(root);

         print(ansroot);
     }

}
