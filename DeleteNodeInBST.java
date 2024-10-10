import javax.swing.tree.TreeCellRenderer;

public class DeleteNodeInBST {
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

   public static TreeNode Delete(TreeNode root,int key){
    if(root == null){
        return root;
    }
    if(root.data == key){
         //case 1  0 child
         if(root.left == null && root.right == null){
            root = null;
            return null;
         }

         // child 1
         if(root.left != null && root.right == null){
            TreeNode temp=root.left;
            root =null;
            return temp;
         }

         if(root.left == null && root.right != null){
            TreeNode temp=root.right;
             root=null;
            return temp;
         }

         //child 2
         if(root.left != null && root.right != null){
            int minval=FindMin(root.right).data;
            root.data=minval;
            root.right=Delete(root.right,minval);
            return root;
         }

    }

    else if(root.data > key){
        root.left=Delete(root.left, key);
        return root;
    
    }
    else{
        root.right=Delete(root.right, key);
        return root;
    }
    return root;
   }

static TreeNode FindMin(TreeNode root){

    if(root.left == null ){
        return root;
    }
   return FindMin(root.left);
}

static void Inorder(TreeNode root){

    if(root == null){
        return ;
    }
    Inorder(root.left);
    System.out.print(root.data+" ");
    Inorder(root.right);

}
    public static void main(String args[]){

        TreeNode Tree=new TreeNode(5);
        Tree.left=new TreeNode(3);
        Tree.right=new TreeNode(7);
        Tree.left.left=new TreeNode(2);
        Tree.left.right=new TreeNode(4);
        Tree.right.left=new TreeNode(6);
        Tree.right.right=new TreeNode(8);

        Inorder(Tree);

        int k=6;
       TreeNode tree= Delete(Tree,k);

       System.out.println();
       Inorder(tree);

        
    }
}
