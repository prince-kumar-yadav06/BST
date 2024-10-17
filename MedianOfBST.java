public class MedianOfBST {
    
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int d){
            this.data=d;
            this.left=null;
            this.right=null;
        }
    }
    static int countNode(TreeNode root){

        if(root == null){
            return 0;
        }
      int left=  countNode(root.left);
      int right=  countNode(root.right);

        return left+right+1;
    }

        static TreeNode prev=null;
       static TreeNode curr=null;
       static int c=1;

       
        static void solve(TreeNode root
        ,int x,int f ){
            
            if(root == null){
                return ;
            }
    
          solve(root.left,x,f);
    
    
        if(prev == null){
            prev=root;
            c++;
        
        }
        
        else if(c == x){
            curr=root;
            c++;
            f=1;
            return;
        }
        else if(f==0){
            prev=root;
            c++;
        }
          
           solve(root.right,x,f);
        }
    static int FindMedian(TreeNode root){

        int n=countNode(root);

        int median=(n/2)+1;

        
        int f=0;

         solve(root,median,f);

         if(n % 2 ==0){
            int ans=(curr.data+prev.data);
            return ans;
         }
            else{
            int ans=curr.data;
            return ans;
         }
    }
    public static void main(String args[]){

        TreeNode root=new TreeNode(50);
        root.left=new TreeNode(30);
        root.right=new TreeNode(70);
        root.left.left=new TreeNode(20);
        root.left.right=new TreeNode(40);
        root.right.left=new TreeNode(60);
        root.right.right=new TreeNode(80);

       System.out.println(FindMedian(root));
        
    }
}
