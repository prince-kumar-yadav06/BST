import java.util.*;

public class PreorderToBst {
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

    static TreeNode PreToBst(int[] arr,int range,int i[]){

        if(arr.length == i[0] || arr[i[0]] > range){
            return null;
        }
        // create node
        TreeNode root=new TreeNode(arr[i[0]++]);
        root.left=PreToBst(arr, root.data, i);
        root.right=PreToBst(arr, range, i);
        return root;
    }

    static TreeNode CreateBst(int arr[]){

        int max=Integer.MAX_VALUE;
        int[] i={0};
        return PreToBst(arr,max,i);

    }

    static void postorder(TreeNode root){

        if(root == null){
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void main(String args[]){

        int arr[]={40,30,35,80,100};

        TreeNode ansroot=CreateBst(arr);

        postorder(ansroot);
    }
}
