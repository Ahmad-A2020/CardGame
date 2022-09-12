package mid_term;

public class Card {
    private String cardNum;
    private int cardValue;
    private String cardType;

    public int getCardValue() {
        if(cardNum.equals("A")){
            return 1;
        }else if(cardNum.equals("J")){
            return 11;
        }else if(cardNum.equals("Q")){
            return 12;
        }else if(cardNum.equals("K")){
            return 13;
        }else{
            return Integer.parseInt(cardNum);
        }
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }

    public Card(String cardNum, String cardType) {
        this.cardNum = cardNum;
        this.cardType = cardType;
    }
}
