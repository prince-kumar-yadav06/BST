import java.util.ArrayList;

public class MergeTwo {
    
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



    static void Inorder(TreeNode root, ArrayList<Integer> arr){

        if(root == null){
            return ;
        }
        Inorder(root.left,arr);              

        arr.add(root.data);        

        Inorder(root.right,arr);  

    }

static int[] MergeTwoarr(ArrayList<Integer> arr1,ArrayList<Integer> arr2){

    int m=arr1.size();

    int n=arr2.size();

    int sortedarr[]=new int[m+n];

    int k=0;
    int i=0;
    int j=0;

    while(i < m && j < n){

        if(arr1.get(i) < arr2.get(j) ){
            sortedarr[k++]=arr1.get(i);
            i++;
        }
        else{
            sortedarr[k++]=arr2.get(j);
            j++;
        }
    }
    while(i <m){
        
            sortedarr[k++]=arr1.get(i);
            i++;
    }
    while(j < n){
            sortedarr[k++]=arr2.get(j);
            j++;
    }

    return sortedarr;
    }

    static TreeNode  CreateBST(int arr[],int start,int end){

        if(start > end){
            return null;
        }

        int mid=(start+end)/2;

        TreeNode root=new TreeNode(arr[mid]);

        root.left=CreateBST(arr, start, mid-1);
        root.right=CreateBST(arr, mid+1, end);

        return root;
    }
    static TreeNode MergeTWoBST(TreeNode root1,TreeNode root2){

        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();

        Inorder(root1,arr1);
        Inorder(root2,arr2);

        int Finalarr[]= MergeTwoarr(arr1,arr2);

        return CreateBST(Finalarr,0,Finalarr.length-1);

    }


    static void print(TreeNode root){

        if(root == null){
            return;
        }

        print(root.left);
        System.out.println(root.data);
        print(root.right);
    }
    public static void main(String args[]){

        
            TreeNode root1=new TreeNode(12);
            root1.left=new TreeNode(9);
            root1.left.left=new TreeNode(6);
            root1.left.right=new TreeNode(11);


            //second BST
            TreeNode root2=new TreeNode(8);
            root2.left=new TreeNode(5);
            root2.right=new TreeNode(10);
            root2.left.left=new TreeNode(2);

           TreeNode ansroot= MergeTWoBST(root1, root2);

           print(ansroot);
    }

}
