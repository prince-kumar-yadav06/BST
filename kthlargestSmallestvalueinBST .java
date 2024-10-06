import java.util.ArrayList;

public class kthlargestSmallestvalueinBST {
    
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


    static ArrayList<Integer> arr=new ArrayList<>();
    static void KthLargest(TreeNode root){

        if(root == null){
            return ;
        }
        KthLargest(root.left);
        arr.add(root.data);
        KthLargest(root.right);


    }

   


    static int KthlargestSmallest(TreeNode root,int K){


        KthLargest(root);

        return arr.get(arr.size()-K);  //for Lagest value
        // return arr.get(K-1);    //for smallest value

    }
    public static void main(String args[]){

        TreeNode r=new TreeNode(5);
        r.left=new TreeNode(3);
        r.right=new TreeNode(7);
        r.left.left=new TreeNode(1);
        r.left.right=new TreeNode(4);
        r.left.left.right=new TreeNode(2);
        r.right.left=new TreeNode(6);
        r.right.right=new TreeNode(8);


       System.out.println( KthlargestSmallest(r,3));

    }
}
