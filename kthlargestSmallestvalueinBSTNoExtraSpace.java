import java.util.ArrayList;

public class kthlargestSmallestvalueinBSTNoExtraSpace {
    
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

    // smalllest value function

    static int KthSmallestVal(TreeNode root,int[] count,int k){
        
        if(root == null){
            return -1;
        }
        
        int leftval =KthSmallestVal(root.left,count,k);
        if(leftval != -1){
            return leftval;
        }
        
        count[0]++;
        if(count[0] == k){
            return root.data;
        }
        
        return KthSmallestVal(root.right,count,k);
    }
   

    // Largest value function
    static int KthLargest(TreeNode root ,int[] count,int k){

        if(root == null){
            return -1 ;
        }

        int l=KthLargest(root.right, count, k);

        if(l != -1){
            return l;
        }

        count[0]++;
        if(count[0] == k){
            return root.data;
        }
       return KthLargest(root.left, count, k);
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

        int count[]={0};
         System.out.println("KthSmallest Value :"+ KthSmallestVal(r, count, 3));

        count[0]=0; // do coutn 0 for largest 
        System.out.println("KthLargest Value :"+ KthLargest(r,count,3));

    }
}
