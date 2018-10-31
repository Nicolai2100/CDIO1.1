package game.control;

import game.model.Dice;
import game.model.Message;
import game.model.DiceCup;
import game.model.Player;
import game.view.GUI2;

public class GameEngine {

    public GameEngine(){ }

    //The method from where the game runs.
    public static void playGame(){

        //Model
        Dice die1 = new Dice();
        Dice die2 = new Dice();
        DiceCup diceCup = new DiceCup();
        Player player1 = new Player();
        Player player2 = new Player();
        Message message = new Message();

        //Controller
        DiceController diceController1 = new DiceController(die1);
        DiceController diceController2 = new DiceController(die2);
        DiceCupController diceCupController = new DiceCupController(diceCup, diceController1, diceController2);
        PlayerController playerController1 = new PlayerController(player1, diceCupController, diceController1,
                diceController2);
        PlayerController playerController2 = new PlayerController(player2, diceCupController, diceController1,
                diceController2);
        MessageController messageController = new MessageController(message, player1, player2);

        //View
        GUI2 gui = new GUI2(playerController1, playerController2, messageController,
                diceCupController, diceController1, diceController2);

        gui.setGameUpGui();
        gui.startGameGui();

        //Set player names
        gui.enterNamePlayer1();
        gui.enterNamePlayer2();

        //Start the main game
        do {
            gui.player1TurnGui();
            playerController1.playerRoll();
            gui.player1TurnUpdate(playerController1);
            if (player1.getWon()){
                break;
            }
            gui.player2TurnGui();
            playerController2.playerRoll();
            gui.player2TurnUpdate(playerController2);
            if (player2.getWon()){
                break;
            }
        }
        //End the game when one of the players get 40 and a double - or to double 6.
        while(!player1.getWon() || !player2.getWon());

        //Give a message about who won the game
        gui.playerWonGui();
        gui.playAgain();
    }
}