import java.util.ArrayList;

public class RemoveDup {
    public static void main(String[] args) {
        int arr[] = {10,20,20,30,30,40,50,50};

        ArrayList<Integer> newArray=Cleaner(arr);

        // print the result

        for(int i:newArray){
            System.out.print(i+" ");
        }
    }

    public static ArrayList<Integer> Cleaner(int [] array){
        ArrayList<Integer> newArray= new ArrayList<>();
        for (int i=0;i<array.length-1;i++){

             if (array[i]!=array[i+1]){
                 newArray.add(array[i]);
              }

        }
        newArray.add(array[array.length-1]);
        return newArray;

    }
}
