package game.control;

import game.model.Message;
import game.model.Player;
import gui_main.GUI;

public class PlayerController {
    private GUI gui;
    private Player model;
    private static Player ref1, ref2;
    private DiceCupController diceCup;
    private DiceController diceController1, diceController2;
    private MessageController messageController;
    private Message message = new Message();

    //Construktor
    public PlayerController(Player model, DiceCupController diceCup, DiceController diceController1,
                            DiceController diceController2){
        this.model = model;
        this.diceCup = diceCup;
        //this.gui = gui;
        this.diceController1 = diceController1;
        this.diceController2 = diceController2;
        messageController = new MessageController(message, ref1, ref2);
    }

    public void playerRoll(){
        diceCup.rollSum();
        gui.setDice(diceController1.getFaceValue(), diceController2.getFaceValue());

        if (diceController1.getFaceValue() == diceController2.getFaceValue()){
            playerGotTwoOfEqualValue();
        }
        else {
                updatePlayerSum();
        }
    }

    public void playerGotTwoOfEqualValue(){
        if (model.getPlayerSumSoFar() >= 40){
            model.setWon(true);
            updatePlayerSum();
            messageController.playerWon();}

        else if ( diceController1.getFaceValue() == 1 && 1 == diceController2.getFaceValue()) {
            model.setPlayerSumSoFar(0);
            messageController.playerExtraTurnButLosePoints();
            String returnString = (model.getName() + "'s" + ". Current score: " + "0");
            playerRoll();
        }
        else if (diceCup.die1.getFaceValue() == 6 && diceCup.die2.getFaceValue() == 6){
            playerWonByDoubleSix();
        }
        //(playerSumSoFar < 40)
        else{
            updatePlayerSum();
            messageController.playerHaveAnExtraTurn();
            playerRoll();
        }
    }
    //If the player rolled 12 last turn and this turn, he wins!
    public void playerWonByDoubleSix(){
        if (model.getPlayerRollSum() == 12 && model.getLastRollSum() == 12){
            model.setWon(true);
            String returnString = ("You win because you got two double sixes in a row!!!");
        }
        else{
            updatePlayerSum();
            messageController.playerHaveAnExtraTurn();
            playerRoll();
        }
    }
    public void updatePlayerSum(){
        model.setPlayerRollSum(diceCup.getSum());
        model.setPlayerSumSoFar((model.getPlayerSumSoFar()+model.getPlayerRollSum()));
        model.setLastRollSum(model.getPlayerRollSum());

        //Prints out the output of the turn.
        String returnString = (model.getName() + "'s sum is " + model.getPlayerRollSum()
                + ". Current score: " + model.getPlayerSumSoFar() + "\n");
    }
    public String getName(){
        return model.getName();
    }

    public void setBalance(int balance){
        model.setBalance((model.getBalance()+balance));
    }
    public int getBalance(){
        return model.getBalance();
    }
    public int getSum(){
        return model.getPlayerRollSum();
    }
    public void setName(String name){
        model.setName(name);
    }
}
