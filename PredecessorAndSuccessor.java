public class PredecessorAndSuccessor {
    
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

    static int Pred;
    static int Succ=Integer.MAX_VALUE;

    static void PredAndSucc(TreeNode root,int key){

        if(root == null){
            return ;
        }
        if(root.data < key && root.data >Pred){
            Pred =root.data;
        }
        if(root.data > key && root.data < Succ){
            Succ = root.data;
        }

        PredAndSucc(root.left, key);
        PredAndSucc(root.right, key);

        
    }
    public static void main(String args[]){
         TreeNode t=new TreeNode(10);
         t.left=new TreeNode(2);
         t.right=new TreeNode(11);
         t.left.left=new TreeNode(1);
         t.left.right=new TreeNode(5);
         t.left.right.left=new TreeNode(3);
         t.left.right.right=new TreeNode(6);
         t.left.right.left.right=new TreeNode(4);


        int key=5;

        PredAndSucc(t, key);

        System.out.println(Pred);
        if(Succ == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{

            System.out.println(Succ);
        }
    }
}
