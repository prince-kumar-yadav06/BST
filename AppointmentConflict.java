import java.util.*;

public class AppointmentConflict {
    static class Pair{
        int key;
        int value;

        Pair(int key,int v){
            this.key=key;
            this.value=v;
        }
    }
    static void Solution(ArrayList<Pair> list){

        for(int i=1;i<list.size();i++){
            for(int j=0;j<i;j++){
                if(list.get(i).key > list.get(j).key && list.get(i).key < list.get(j).value){
                    Pair pair=list.get(i);
                    Pair pair1=list.get(j);
                    System.out.println("{"+ pair.key +","+ pair.value +"}"+ ":" + "{" + pair1.key +":" + pair1.value +"}");
                    break;
                }
            }
        }
    }

    public static void main(String args[]){

        ArrayList<Pair> list=new ArrayList<>();
        list.add(new Pair(1, 5));
        list.add(new Pair(3, 7));
        list.add(new Pair(2, 6));
        list.add(new Pair(10, 15));
        list.add(new Pair(5, 6));
        list.add(new Pair(4, 100));

        Solution(list);
    }
}
