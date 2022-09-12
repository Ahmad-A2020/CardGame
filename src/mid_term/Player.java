package mid_term;

public class Player {

    private String playerName;
    private double balance;
    private String status;


    public Player(String playerNam) {
        this.playerName = playerName;
        this.balance = 5;
        this.status = status;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlayerName() {
        return playerName;
    }

    public double getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }
}
