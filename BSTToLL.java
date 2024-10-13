import java.util.LinkedList;

public class BSTToLL {
 static class  TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int data){
        this.data=data;
        this.left=null;
        this.right=null;

    }
 } 

 static TreeNode head=new TreeNode(-1);
 static TreeNode temp=head;


 static TreeNode sol(TreeNode root){

    if(root == null){
        return null;
    }

   

    sol(root.left);
    TreeNode node=new TreeNode(root.data);
    temp.next=node;
    temp=node;

    sol(root.right);

    return head.next;

 }
 static void print(TreeNode root){
        
    while(root != null){
        System.out.print(root.data+" ");
        root=root.next;
    }
}
 public static void main(String args[]){

    TreeNode root=new TreeNode(12);
    root.left=new TreeNode(9);
    root.left.left=new TreeNode(6);
    root.left.right=new TreeNode(11);


    TreeNode root2=new TreeNode(2);
    root2.left=new TreeNode(1);
    root2.right=new TreeNode(3);
    root2.right.right=new TreeNode(7);
    root2.right.right.left=new TreeNode(6);


   


    print(sol(root));
    head=new TreeNode(-1);
    temp=head;
    System.out.println();
    print(sol(root2));
 }
 
}
