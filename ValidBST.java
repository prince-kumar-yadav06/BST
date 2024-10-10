public class ValidBST {
    
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

    static boolean ans=false;
    static boolean IsBst(TreeNode root){

        if(root ==null){
            return false;
        }

        if( root.left != null && root.data > root.left.data ){
            ans=true;
            IsBst(root.left);
        }
        else{
            return false;
        }

        if (root.right != null && root.data < root.right.data ){
            ans=true;
            IsBst(root.right);
        }
        else{
            return ans=false;
        }

       return ans;
    }

    public static void main(String args[]){

        TreeNode r=new TreeNode(5);
        r.left=new TreeNode(1);
        r.right=new TreeNode(4);
        r.right.left=new TreeNode(3);
        r.right.right=new TreeNode(6);

        System.out.println(IsBst(r));
    }
}
