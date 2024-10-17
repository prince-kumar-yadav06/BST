import java.util.*;

public class LargestBSTinBianrytree {

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

    public static boolean IsBST(TreeNode root,int min,int max){

        if(root == null){
            return true;
        }

        
        if(root.data >= max || root.data <= min){
            return false;
        }

        // agar left subtree ans right subtree dono bst hai to return true

        return  IsBST(root.left,min,root.data) && IsBST(root.right,root.data,max);

    }

    // size to find node count
    static int size(TreeNode root){

        if(root == null){
            return 0;
        }

        int leftsize=size(root.left);    //left subtree node count store hoga
        int rigthsize=size(root.right);    //right subtree node count store hoga


        // sum of left subtree aur right subtree ka count  + root ka count
        return 1 + leftsize + rigthsize;
    }

    //function to find LargeBST
    static int LargeBST(TreeNode root){

        if(root == null){
            return -1;
        }


        //agar whole tree bst hai to size return kr denge whole tree ka
        if(IsBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE)){
            return size(root);
        }

        // left subtree ya right subtree me jo lager bst hoga use return kr denge
        return  Math.max(size(root.left) , size(root.right));
        
}

public static void main(String args[]){

      // Constructed binary tree looks like this:
        //         50
        //       /    \
        //     75      45
        //    /
        //  40

        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(20);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.left.left = new TreeNode(65);
        root.right.left.right = new TreeNode(80);



        System.out.print(LargeBST(root));
}
}
