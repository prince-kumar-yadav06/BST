import java.util.*;
public class FlattenBSTtosortedlist {
    
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

    static ArrayList<Integer> ans=new ArrayList();

    static ArrayList<Integer> Solution(TreeNode root){

        if(root == null)
    {
        return null;
    }

    //inorder traversal
    Solution(root.left);
    ans.add(root.data);
    Solution(root.right);

    return ans;

    }

    public static void main(String args[]){

    //     5 
    //     /   \ 
    //    3     7 
    //   / \   / \ 
    //  2   4 6   8
        // TreeNode root=new TreeNode(5);
        // root.left=new TreeNode(3);
        // root.right=new TreeNode(7);
        // root.left.left=new TreeNode(2);
        // root.left.right=new TreeNode(4);
        // root.right.left=new TreeNode(6);
        // root.right.right=new TreeNode(8);


        
    //   1
    //    \
    //     2
    //      \
    //       3
    //        \
    //         4
    //          \
    //           5

    TreeNode root=new TreeNode(1);
    root.right=new TreeNode(2);
    root.right.right=new TreeNode(3);
    root.right.right.right=new TreeNode(4);
    root.right.right.right.right=new TreeNode(5);
    
        ArrayList<Integer> retAns=Solution(root);

        for(int i=0;i<retAns.size();i++){
            System.out.print(retAns.get(i)+" ");
        }

    }
}
