import java.util.Scanner;

public class SalespersonSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        Salesperson [] salers = new Salesperson[3];

        // input the salepersons details
        System.out.println("plz Enter the first Salesperson ID");
        int Salesperson1ID= scanner.nextInt();
        System.out.println("plz Enter the first Salesperson sales values:");
        double Salesperson1sales= scanner.nextDouble();
        Salesperson salesperson1 = new Salesperson(Salesperson1ID,Salesperson1sales);
        salers[0]= salesperson1;

        System.out.println("plz Enter the second Salesperson ID");
        int Salesperson2ID= scanner.nextInt();
        System.out.println("plz Enter the second Salesperson sales values:");
        double Salesperson2sales= scanner.nextDouble();
        Salesperson salesperson2 = new Salesperson(Salesperson2ID,Salesperson2sales);
        salers[1]= salesperson2;

        System.out.println("plz Enter the third Salesperson ID");
        int Salesperson3ID= scanner.nextInt();
        System.out.println("plz Enter the third Salesperson sales values:");
        double Salesperson3sales= scanner.nextDouble();
        Salesperson salesperson3 = new Salesperson(Salesperson3ID,Salesperson3sales);
        salers[2]= salesperson3;

        System.out.println("plz select how do you want to sort the sale persons:\n 1:By ID \n 2:By sales amount");
        int sort = scanner.nextInt();
        // sort the sale persons
        if (sort==1){
            for(int i=0;i<salers.length;i++){
                Salesperson tempSaleperson;
                for(int j=i; j<salers.length;j++){
                    if(salers[i].getID()>salers[j].getID()){
                        tempSaleperson=salers[i];
                        salers[i]=salers[j];
                        salers[j]=tempSaleperson;
                    }
                }
            }

        }else if (sort==2){

            for(int i=0;i<salers.length;i++){
                Salesperson tempSaleperson;
                for(int j=i; j<salers.length;j++){
                    if(salers[i].getAnnyalSalesAmount()>salers[j].getAnnyalSalesAmount()){
                        tempSaleperson=salers[i];
                        salers[i]=salers[j];
                        salers[j]=tempSaleperson;
                    }
                }
            }


        }else {
            System.out.println("Invalid input !!");
        }

        // print the sale persons
        for (int i=0;i<salers.length;i++){
            System.out.println(i+"-The Id of the salesperson is:"+salers[i].getID()+" , and sales amount are "+salers[i].getAnnyalSalesAmount());
        }



    }
}
