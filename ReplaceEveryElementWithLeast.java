import java.util.*;

public class ReplaceEveryElementWithLeast{

    static class Node {
        int data;
        Node left,right;

        Node(int d){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static Node root;
     static Node succ;

    ReplaceEveryElementWithLeast(){
        root=null;
        succ=null;
    }
    

    static Node insert(Node node,int data){

    if(node == null){
       return node=new Node(data);
    }
    
    if(node.data > data){
       succ=node;
       node.left=insert(node.left,data);
   }
    else if(node.data <data){
        node.right=insert(node.right, data);
    }


    return node;

}
    
public static void Replace(int arr[]){


    for(int i=arr.length-1;i>=0;i--){
   
        
root=insert(root,arr[i]);

if(succ != null){
    arr[i]=succ.data;
}
else{
    arr[i]=-1;
}
       
    }
}
public static void main(String args[]){

    int arr[]={8,58,71,18,31,32,63,92,43,3,91,93,25,80,28};

    Replace(arr);
    for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
    }
}

}
