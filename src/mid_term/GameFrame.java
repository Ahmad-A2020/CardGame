package mid_term;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GameFrame extends JFrame  implements ItemListener, ActionListener {
    private int turn;
    private boolean userTurn;
    private double belt;
    private Player user;
    private Player computer;
    private  Card randCard1;
    private  Card randCard2;
    private  Card randCard3;
    private boolean gameOver=false;
    private Card [] cards;
    private int selectedCards;
    private JLabel userOrComputerTurnLabel;
    private JButton proceedButton= new JButton("proceed");

    public Card getRandCard3() {
        return randCard3;
    }

    public double getBelt() {
        return belt;
    }

    JPanel content = new JPanel(new GridLayout(4, 0));



    JPanel panel;

    JPanel balancePanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
    JPanel userOrComputerPanel = new JPanel(new GridLayout());

    JLabel firstMessage = new  JLabel("", SwingConstants.CENTER);
    JLabel secondtMessage = new JLabel("", SwingConstants.CENTER);    // balance labels and text
    JLabel userBalanceLabel= new JLabel("User Balance: ");

    JTextField userBalanceField= new JTextField();
    JLabel computerBalanceLabel= new JLabel("Computer Balance: ");
    JTextField computerBalanceField= new JTextField();
    JLabel winLabel= new JLabel("Congrats ! you win ");


    JButton betButton = new JButton("Bet");

    JButton foldButton = new JButton("Fold");
    JButton beltSubmit = new JButton("Bet Submit");
    JButton ExitButton = new JButton("Exit");
    JTextField betValue= new JTextField(20);
    JLabel betVlaueLable= new JLabel("Input Bet Value: ");

    public GameFrame(Player user, Player computer, Card [] cards) throws HeadlessException {
        super("Card Game");
        this.user=user;
        this.computer=computer;
        this.cards=cards;
        this.userTurn= true;
        turn =0;
        selectedCards=0;
        iniliizer();

    }

    public  void iniliizer(){
        setSize(800,600);
        setVisible(true);
//        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(50,50,100));
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(content);
//        this.setLayout(new FlowLayout());

         panel= new JPanel();
         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        panel.setLayout(new FlowLayout());
         panel.setAlignmentX(Component.CENTER_ALIGNMENT);
         panel.setAlignmentY(Component.CENTER_ALIGNMENT);
//         panel.setLayout(new GridLayout(4,0));
//        panel.setBackground(Color.GRAY);
//        balancePanel.setSize(800,50);
//        panel.setSize(800,100);
        content.add(balancePanel);
        content.add(userOrComputerPanel);
        content.add(panel);
//        panel.setBounds(0,200,800,300);
        balancePanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));

//        balancePanel.setBounds(0,0,800,20);

        balancePanel.add(userBalanceLabel);
        balancePanel.add(userBalanceField);
        balancePanel.add(computerBalanceLabel);
        balancePanel.add(computerBalanceField);
        balancePanel.add(ExitButton);
        // button size

        betButton.setSize(60,30);
        foldButton.setSize(60,30);
        proceedButton.setSize(60,30);
        panel.add(betButton);
        panel.add(foldButton);
        panel.add(proceedButton);
        betButton.setVisible(false);
        foldButton.setVisible(false);
        proceedButton.setVisible(false);

        // user or computer turn
         userOrComputerTurnLabel= new JLabel("Your Turn", SwingConstants.CENTER);

        userOrComputerPanel.add(userOrComputerTurnLabel);

        // style
//        balancePanel.setBackground(new Color());
        userBalanceLabel.setFont(new Font("Ink Free",Font.BOLD,25));
        userBalanceLabel.setForeground(new Color(0, 208, 255));
        userBalanceField.setFont(new Font("Ink Free",Font.BOLD,25));
        userBalanceField.setForeground(new Color(255, 0, 242));

        computerBalanceLabel.setFont(new Font("Ink Free",Font.BOLD,25));
        computerBalanceLabel.setForeground(new Color(0, 208, 255));
        computerBalanceField.setFont(new Font("Ink Free",Font.BOLD,25));
        computerBalanceField.setForeground(new Color(255, 0, 242));

        ExitButton.setSize(50,20);
        ExitButton.setFont(new Font("Verdana",Font.BOLD,25));
        ExitButton.setBackground(new Color(152, 52, 74));

        betButton.setSize(50,20);
        betButton.setFont(new Font("Verdana",Font.BOLD,25));
        betButton.setBackground(new Color(152, 52, 74));

        beltSubmit.setSize(50,20);
        beltSubmit.setFont(new Font("Verdana",Font.BOLD,25));
        beltSubmit.setBackground(new Color(152, 52, 74));

        foldButton.setSize(50,20);
        foldButton.setFont(new Font("Verdana",Font.BOLD,25));
        foldButton.setBackground(new Color(152, 52, 74));

        proceedButton.setSize(50,20);
        proceedButton.setFont(new Font("Verdana",Font.BOLD,25));
        proceedButton.setBackground(new Color(152, 52, 74));

        userOrComputerTurnLabel.setFont(new Font("Verdana",Font.BOLD,30));
        userOrComputerPanel.setBackground(new Color(87, 86, 86));

        panel.add(winLabel);
        winLabel.setVisible(false);
        panel.add(firstMessage);

        firstMessage.setFont(new Font("Verdana",Font.BOLD,13));
        firstMessage.setForeground(new Color(29, 46, 100));
        firstMessage.setSize(800,50);

        secondtMessage.setFont(new Font("Verdana",Font.BOLD,13));
        secondtMessage.setForeground(new Color(29, 46, 100));
        secondtMessage.setSize(800,50);

        winLabel.setFont(new Font("Verdana",Font.BOLD,13));
        winLabel.setForeground(new Color(29, 46, 100));
        winLabel.setSize(800,50);

        betVlaueLable.setFont(new Font("Verdana",Font.BOLD,13));
        betVlaueLable.setForeground(new Color(29, 46, 100));

        betValue.setFont(new Font("Ink Free",Font.BOLD,25));
        betValue.setForeground(new Color(72, 66, 66, 247));

        foldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.setBalance(user.getBalance() - 0.5);
                foldButton.setVisible(false);
                betButton.setVisible(false);
                firstMessage.setVisible(false);
                userTurn=false;
                secondtMessage.setText("you folded");
                panel.add(secondtMessage);
                secondtMessage.setVisible(true);
                userOrComputerTurnLabel.setText("Computer Turn");
                setBalance();
                System.out.println("from fold"+user.getBalance());
//                    panel.add(proceedButton);
                proceedButton.setVisible(true);
                if(user.getBalance()<1){
                    gameOver();
                }
                proceed();

            }

        });


        gameGenerator();

    }
    public void setBalance(){
//        System.out.println(user.getBalance()+" $");
        userBalanceField.setText(user.getBalance()+" $");
        computerBalanceField.setText(computer.getBalance()+" $");

    }

    public  void gameGenerator(){

            setBalance();
            exitGame();
            randCard1= randCard();
            randCard2= randCard();


            if(selectedCards>=51){
                gameOver();

            }
            if(user.getBalance()<1 || computer.getBalance()<1){
                gameresult();


            }
            if(userTurn==true){

//                userOrComputerTurnLabel.setText("Your Turn");
                userTurnMessage(randCard1, randCard2);

//                betValue= getBelt()+(turn/2)*0.5;
            }else{

//                System.out.println("computer turn");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }

                computerTurn();
            }






    }

    public void userTurnMessage(Card card1, Card card2) {
//        panel.add(userTurn);
        winLabel.setVisible(false);
        proceedButton.setVisible(false);
        userOrComputerTurnLabel.setText("Your Turn");
        System.out.println("You turn");

        secondtMessage.setVisible(false);

        firstMessage.setText("It is your Turn and your cards are:" + card1.getCardNum() + "(" + card1.getCardType() + ")" +
                " and " + card2.getCardNum() + "(" + card2.getCardType() + ")" + " .please select to bet or fold ");
//        userTurn.setSize(700,70);
        panel.add(firstMessage);
        firstMessage.setVisible(true);

//        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 120));
        panel.setSize(800,200);

//        panel.add(betButton);
        betButton.setVisible(true);
        panel.validate();
//        betButton.setBounds(250,120);
//        panel.add(foldButton);
        foldButton.setVisible(true);
        panel.validate();
//        proceedButton.setVisible(true);


            betButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    firstMessage.setText("It is your Turn and your cards are:" + card1.getCardNum() + "(" + card1.getCardType() + ")" +
                            " and " + card2.getCardNum() + "(" + card2.getCardType() + ").");
                    panel.add(betVlaueLable);
                    panel.add(betValue);
                    betValue.setText("");
                    betValue.setVisible(true);
                    foldButton.setVisible(false);
                    betButton.setVisible(false);
//                    firstMessage.setVisible(false);
                    panel.add(beltSubmit);
                    beltSubmit.setVisible(true);
                    panel.validate();

                }
            });

            beltSubmit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("from bet");
                    userTurn=false;

                    belt = Double.parseDouble(betValue.getText());
                    if (belt < 1) {
                        belt = 1;
                    }
                    betVlaueLable.setVisible(false);
                    beltSubmit.setVisible(false);
                    betValue.setVisible(false);
                    randCard3 = CardGame.randCard();
                    secondtMessage.setText("The new card is " + randCard3.getCardNum() + "(" + randCard3.getCardType() + ")");
                    panel.add(secondtMessage);
                    firstMessage.setText("First Card:"+ card1.getCardNum() + "(" + card1.getCardType() + ")" +
                            " and Second Card:" + card2.getCardNum() + "(" + card2.getCardType() + ")");;
                    secondtMessage.setVisible(true);

                    int smallerCard = Math.min(randCard1.getCardValue(), randCard2.getCardValue());
                    int biggerCard = Math.max(randCard1.getCardValue(), randCard2.getCardValue());

                    if (randCard3.getCardValue() > smallerCard && biggerCard > randCard3.getCardValue()) {
                        panel.add(winLabel);
                        winLabel.setVisible(true);
                        panel.validate();


                        System.out.println("bet"+belt+"computer"+computer.getBalance()+"ueru"+user.getBalance());

                        if (belt < computer.getBalance()) {
                            user.setBalance(user.getBalance() + belt);
                            computer.setBalance(computer.getBalance() - belt);
                        } else {
                            user.setBalance(user.getBalance() + computer.getBalance());
                            computer.setBalance(0);

                        }
                        if(computer.getBalance()<1){
                            user.setBalance(0);
                            gameOver();
                            return;
                        }

                        setBalance();
                        userTurn=false;
                    } else {
                        winLabel.setText("You loss !");
                        winLabel.setVisible(true);
                        panel.validate();

//                        try {
//                            Thread.sleep(2000);
//                        } catch (InterruptedException ex) {
//                            ex.printStackTrace();
//                        }
//                        winLabel.setVisible(false);


                        computer.setBalance(computer.getBalance() + belt);
                        user.setBalance(user.getBalance() - belt);
                        if(user.getBalance()<1){
                            user.setBalance(0);
                            gameOver();
                            return;
                        }
                        System.out.println("bet"+belt+"computer"+computer.getBalance()+"ueru"+user.getBalance());

                        setBalance();
                        userTurn=false;
                    }
                    panel.validate();


                    userOrComputerTurnLabel.setText("Computer Turn");
//                    panel.add(proceedButton);
                    proceedButton.setVisible(true);
                    panel.validate();
                    proceed();


                }

            });




    }
    public void computerTurn(){
        secondtMessage.setVisible(false);
        winLabel.setVisible(false);
        firstMessage.setText("It is computer turn; computer was given "+randCard1.getCardNum()+"("+randCard1.getCardType()+")" +
                " and "+randCard2.getCardNum()+"("+randCard2.getCardType()+")");

        panel.add(firstMessage);
        firstMessage.setVisible(true);
        panel.validate();

        if(Math.abs(randCard1.getCardValue()-randCard2.getCardValue())>5){
            belt=1;
            randCard3= CardGame.randCard();
            secondtMessage.setText("computer belt, and the new card is:"+randCard3.getCardNum()+"("+randCard3.getCardType()+")" );
            panel.add(firstMessage);
            secondtMessage.setVisible(true);
            panel.validate();

            int smallerCard= Math.min(randCard1.getCardValue(),randCard2.getCardValue());
            int biggerCard= Math.max(randCard1.getCardValue(),randCard2.getCardValue());

            if(randCard3.getCardValue()>smallerCard && biggerCard>randCard3.getCardValue()){
                winLabel.setText("Computer Win!");
                panel.add(winLabel);

                if(belt<user.getBalance()){
                    computer.setBalance(computer.getBalance()+belt);
                    user.setBalance(user.getBalance()-belt);
                }else{
                    computer.setBalance(user.getBalance()+computer.getBalance());
                    user.setBalance(0);
                }

                setBalance();
            }else{
                panel.add(winLabel);
                winLabel.setText("Computer loss !");

                user.setBalance(computer.getBalance()+belt);
                computer.setBalance(computer.getBalance()-belt);
                setBalance();
            }


        }else{
            computer.setBalance(computer.getBalance() - 0.5);
           secondtMessage.setText("computer fold.");
           setBalance();
           panel.add(secondtMessage);
           secondtMessage.setVisible(true);


        }
        userTurn=true;

//        panel.add(proceedButton);
        proceedButton.setVisible(true);
        proceed();

    }


//    public  int randValue(int range){
//        return (int)(Math.random()*(range));
//    }

    public  Card randCard(){
        int randValue= (int)(Math.random()*(52-selectedCards-1));
        Card randCard= cards[randValue];

        cards[randValue]=cards[52-selectedCards-1];
        selectedCards++;

        return randCard;

    }

    public void gameresult(){
        JLabel gameResilt= new JLabel();
        if (user.getBalance()>computer.getBalance()){
            gameResilt.setText("You win the game; ");
        }else{
            gameResilt.setText("Computer win the game; ");

        }
        panel.add(gameResilt);
    }

    public void proceed(){
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameGenerator();
            }
        });

    }
    public void  gameOver(){
        panel.setVisible(false);
        String winner;
        if(computer.getBalance()>user.getBalance()){
            winner="Computer";
        }else {
            winner="User";
        }
        userOrComputerTurnLabel.setText("Game over; "+winner+" is win");
    }
    public void exitGame(){
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                userOrComputerTurnLabel.setText("Game over; Computer is win");

            }
        });
    }


    public void itemStateChanged(ItemEvent e)
    {

        // if the state of checkbox1 is changed
        if (e.getSource() == foldButton) {
            user.setBalance(user.getBalance() - 0.5);
            foldButton.setVisible(false);
            betButton.setVisible(false);
            firstMessage.setVisible(false);
            userTurn=false;
            secondtMessage.setText("you folded");
            panel.add(secondtMessage);
            secondtMessage.setVisible(true);
            userOrComputerTurnLabel.setText("Computer Turn");
            setBalance();
            System.out.println("from fold"+user.getBalance());
//                    panel.add(proceedButton);
            proceedButton.setVisible(true);
            if(user.getBalance()<1){
                gameOver();
            }
            proceed();
        }


    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == foldButton){




//            ExitButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    panel.setVisible(false);
//                    JLabel gameResilt= new JLabel();
//                    gameResilt.setText("Computer win the game; ");
//                    panel.add(gameResilt);
//                }
//            });
        }


    }
}
