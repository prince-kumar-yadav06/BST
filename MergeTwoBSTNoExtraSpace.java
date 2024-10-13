

//Using linked List

import java.util.*;
public class MergeTwoBSTNoExtraSpace {
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

  static  TreeNode head1=new TreeNode(-1);
  static  TreeNode temp1=head1;


    public static TreeNode ConvertBStToLL(TreeNode root){

       
    if(root == null){
        return null;
    }

    
    ConvertBStToLL(root.left);
    TreeNode node=new TreeNode(root.data);
    temp1.next=node;
    temp1=node;
    
    ConvertBStToLL(root.right);

    return head1.next;

    

        }
       

    static TreeNode mergeTwoLL(TreeNode head1,TreeNode head2){

    TreeNode head=new TreeNode(-1);
    TreeNode temp=head;

    while(head1 != null && head2!= null){
        if(head1.data < head2.data){

                temp.next=head1;
                temp=head1;
                head1=head1.next;
           
        }
        else{
                temp.next=head2;
                temp=head2;
                head2=head2.next;
              
        }
    }
    
    while(head1 != null){
        temp.next=head1;
        temp=head1;
        head1=head1.next;
    }

    while(head2 != null){
        temp.next=head2;
        temp=head2;
        head2=head2.next;
    }
    return head.next;
    }
 

    static TreeNode MergeBST(TreeNode root1,TreeNode root2){

       

        TreeNode LL1= ConvertBStToLL(root1);

        head1=new TreeNode(-1);
        temp1=head1;

        TreeNode LL2= ConvertBStToLL(root2);

       TreeNode head= mergeTwoLL(LL1,LL2);

       return head;
 
    }

    static void print(TreeNode root){
        
        while(root != null){
            System.out.print(root.data+" ");
            root=root.next;
        }
    }
    public static void main(String args[]){

        TreeNode root1=new TreeNode(5);
        root1.left=new TreeNode(3);
        root1.right=new TreeNode(6);
        root1.left.left=new TreeNode(2);
        root1.left.right=new TreeNode(4);


        TreeNode root2=new TreeNode(2);
        root2.left=new TreeNode(1);
        root2.right=new TreeNode(3);
        root2.right.right=new TreeNode(7);
        root2.right.right.left=new TreeNode(6);


       TreeNode ans= MergeBST(root1,root2);
    
    
      print(ans);
     
  
    }
}
