public class CountBSTNode{
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    
    public static int Count(TreeNode root,int L,int H){

        if(root == null){
            return 0;
        }

      
        //left subtree

        if(root.data >= L && root.data <= H){
        
            return 1 + Count(root.left,L,H)+
            Count(root.right,L,H);
        }
        else if(root.data > L){
           return Count(root.left,L,H);
        }

        else{

          return  Count(root.right,L,H);
        }
        
        }
    
public static void main(String args[]){

    // TreeNode root=new TreeNode(10);
    // root.left=new TreeNode(5);
    // root.right=new TreeNode(50);
    // root.left.left=new TreeNode(1);
    // root.right.left=new TreeNode(40);
    // root.right.right=new TreeNode(100);


    // int L=5;
    // int H=45;


    //second input

    TreeNode root=new TreeNode(5);
    root.left=new TreeNode(4);
    root.right=new TreeNode(6);
    root.left.left=new TreeNode(3);
    root.right.right=new TreeNode(7);

    int L=2;
    int H=8;

   int ans= Count(root,L,H);

   System.out.println(ans);
}
}
