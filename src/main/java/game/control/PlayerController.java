package game.control;

import game.model.DiceCup;
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
    private Message message;

    //Construktor
    public PlayerController(Player model, DiceCupController diceCup, DiceController diceController1,
                            DiceController diceController2, GUI gui){
        this.model = model;
        this.diceCup = diceCup;
        this.gui = gui;
        this.diceController1 = diceController1;
        this.diceController2 = diceController2;
        messageController = new MessageController(message, ref1, ref2, gui);

    }

    //The method of the game that helps control the game flow.
    public void playerRoll(){
        //The method call the method diceCup.rollSum() to roll the dice after the player pushes the return key.
        //The values of each die is printed and the rest of the method is valuating this result.
        diceCup.rollSum();
        gui.setDice(diceCup.die1.getFaceValue(), diceCup.die2.getFaceValue());
        gui.showMessage(model.getName() +"'s nuværende score: "+(model.getPlayerSumSoFar()
                +diceCup.getSum()));

        if (diceController1.getFaceValue() == diceController2.getFaceValue()){
            playerGotTwoOfEqualValue();
        }
        //If the player doesn't roll two dice of equal value, the sum of the dice will be saved in the playerSumSoFar.
        else {
            model.setPlayerRollSum(diceCup.getSum());
            model.setPlayerSumSoFar(model.getPlayerSumSoFar()+model.getPlayerRollSum());
            model.setLastRollSum(model.getPlayerRollSum());
            //Prints out the output of the turn.

            model.setPlayerRollSumString( model.getName() + "'s sum is " + model.getPlayerRollSum()
                    + ". Current score: " + model.getPlayerSumSoFar() + "\n");
            gui.showMessage(model.getPlayerRollSumString());
        }
    }
    //Valuates what to do if the player rolls two dice of equal value.
    public void playerGotTwoOfEqualValue(){
        if (model.getPlayerRollSum() >= 40){
            model.setWon(true);
            model.setPlayerRollSum(diceCup.getSum());
            model.setPlayerSumSoFar(model.getPlayerSumSoFar()+model.getPlayerRollSum());
            model.setLastRollSum(model.getPlayerRollSum());

            model.setPlayerRollSumString(model.getName()+ "'s sum is " + model.getLastRollSum() + ". " +
                    "Current score: " + model.getPlayerSumSoFar()+ "\n");
            gui.showMessage(model.getPlayerRollSumString());
            messageController.playerWon();}

        else if ( diceController1.getFaceValue() == 1 && 1 == diceController2.getFaceValue()) {
            model.setPlayerSumSoFar(0);
            messageController.playerExtraTurnButLosePoints();

            model.setPlayerRollSumString(model.getName() + "'s" + ". Current score: " + "0");
            gui.showMessage(model.getPlayerRollSumString());
            playerRoll();
        }
        else if (diceCup.die1.getFaceValue() == 6 && diceCup.die2.getFaceValue() == 6){
            model.setPlayerRollSum(diceCup.getSum());
            model.setPlayerSumSoFar(model.getPlayerSumSoFar()+model.getPlayerRollSum());

            model.setPlayerRollSumString(model.getName()+ "'s sum is " + model.getLastRollSum() + ". " +
                    "Current score: " + model.getPlayerSumSoFar()+ "\n");
            gui.showMessage(model.getPlayerRollSumString());
            playerWonByDoubleSix();
            model.setLastRollSum(model.getPlayerRollSum());
        }
        //(playerSumSoFar < 40)
        else{
            model.setPlayerRollSum(diceCup.getSum());
            model.setPlayerSumSoFar(model.getPlayerSumSoFar()+model.getPlayerRollSum());
            model.setLastRollSum(model.getPlayerRollSum());

            model.setPlayerRollSumString(model.getName()+ "'s sum is " + model.getLastRollSum() + ". " +
                    "Current score: " + model.getPlayerSumSoFar()+ "\n");
            gui.showMessage(model.getPlayerRollSumString());
            messageController.playerHaveAnExtraTurn();
            playerRoll();
        }
    }
    //If the player rolled 12 last turn and this turn, he wins!
    public void playerWonByDoubleSix(){
        if (model.getPlayerRollSum() == 12 && model.getLastRollSum() == 12){
            model.setWon(true);
            gui.showMessage("You win because you got two double sixes in a row!!!");
        }
        else{
            messageController.playerHaveAnExtraTurn();
            playerRoll();
        }
    }
}
