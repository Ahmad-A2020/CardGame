package mid_term;

import mid_term.Card;
import mid_term.Player;

import java.util.Arrays;
import java.util.Scanner;

public class CardGame {
    private static Card[] cards;
    public static void main(String[] args) {


        Player user = new Player("User");
        Player computer = new Player("Computer");

        // create the cards array including all options
        cards = new Card[52];
        String [] cardNumberRange= {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String [] cardType= {"Heart", "Club", "Diamond" ,"Spade"};
        int cardIndex=0;

        for (int i=0;i<13;i++){

            for(int j=0;j<4;j++){

                Card newCard= new Card(cardNumberRange[i], cardType[j]);
                cards[cardIndex]=newCard;
                cardIndex++;
            }
        }

        // create the implementation
//
        double betValue;
        int turn=0;
        int randValue1;
        int randValue2;
        int randValue3;
        Card randCard1;
        Card randCard2;
        Card randCard3;
        String input="";
        Scanner inputValue= new Scanner(System.in);
        System.out.println("Game Start");
        System.out.println("---------------------");

        GameFrame gameFrame = new GameFrame(user, computer, cards);

//        while(! input.equals("X")){
//
////            System.out.println("Your balance is : "+user.getBalance());
////            System.out.println("Computer is : "+computer.getBalance());
//
////            gameFrame.setBalance();
//
////            randValue1= (int)(Math.random()*(52));
////            randCard1= cards[randValue1];
//
////            randValue2= (int)(Math.random()*(52));
////            randCard2= cards[randValue2];
//
//            if(turn %2==0){
////                System.out.println("It your turn, your current balance is "+user.getBalance()+
////                        "; your cards are :"+randCard1.getCardNum()+"("+randCard1.getCardType()+")" +
////                        " and "+randCard2.getCardNum()+"("+randCard2.getCardType()+")");
//
//
//                gameFrame.userTurnMessage(randCard1,randCard2);
////                System.out.println("Bet or Fold");
////                input= inputValue.nextLine();
//                betValue= gameFrame.getBelt()+(turn/2)*0.5;
//                if(input.equals("X")){
//                    System.out.println("Game Finish");
//                    break;
//                }else if(input.equals("B")){
//
////                    randValue3= randValue();
////                    randCard3= cards[randValue3];
////
////                    System.out.println("Cool! how mush do you want to bet ? ");
////                    betValue=inputValue.nextDouble();
////                    if(betValue<1){
////                        betValue=1;
////                    }
////                    System.out.println("your bet "+betValue+" $"+" and the new card is "+randCard3.getCardNum()+"("
////                            +randCard3.getCardType()+")");
//
//                    // comparison
//                    if(randCard3.getCardValue()>randCard1.getCardValue() && randCard2.getCardValue()>randCard3.getCardValue()){
//                        System.out.println("Congrats ! you win ");
//
//                        if(betValue<computer.getBalance()){
//                            user.setBalance(user.getBalance()+betValue);
//                        }else{
//                            user.setBalance(user.getBalance()+computer.getBalance());
//                        }
//
//                        System.out.println("Your balance is "+user.getBalance());
//                        System.out.println("Computer  balance is "+computer.getBalance());
//                    }else{
//                        System.out.println("You lose !");
//                        computer.setBalance(computer.getBalance()+betValue);
//                    }
//
//
//
//                }else if(input.equals("F")){
//                    user.setBalance(user.getBalance()-0.5);
//
//
//                }
//
//            }else{
//                System.out.println("It is computer turn; computer was given "+randCard1.getCardNum()+"("+randCard1.getCardType()+")" +
//                        " and "+randCard2.getCardNum()+"("+randCard2.getCardType()+")");
//                System.out.println("computer folds");
//            }
//
//
//        }







    }

    public static int randValue(){
       return (int)(Math.random()*(52));
    }

    public static Card randCard(){
        int randValue= (int)(Math.random()*(52));
        Card randCard= cards[randValue];
        return randCard;

    }
}
