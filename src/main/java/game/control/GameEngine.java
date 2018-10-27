package game.control;
import game.model.Dice;
import game.model.Message;
import game.model.DiceCup;
import game.model.Player;
import gui_main.GUI;

public class GameEngine {

    public GameEngine(){ }

    //The method from where the game runs.
    public void playGame(){
        //View
        GUI gui = new GUI();

        //Model
        Dice die1 = new Dice();
        Dice die2 = new Dice();
        DiceCup diceCup = new DiceCup();
        Player player1 = new Player();
        Player player2 = new Player();

        //Controller
        DiceController diceController1 = new DiceController(die1);
        DiceController diceController2 = new DiceController(die2);
        DiceCupController diceCupController = new DiceCupController(diceCup, diceController1, diceController2);
        Message message = new Message();

        PlayerController playerController1 = new PlayerController(player1, diceCupController, diceController1,
                diceController2, gui);
        PlayerController playerController2 = new PlayerController(player2, diceCupController, diceController1,
                diceController2, gui);
        MessageController messageController = new MessageController(message, player1, player2, gui);

        //Method that gives an introduction to the game. Rules, etc.
        messageController.startGame();

        //Set player 1 name
        messageController.enterNamePlayer1();
        player1.setName(gui.getUserString(""));
        //Set player 2 name
        messageController.enterNamePlayer2();
        player2.setName(gui.getUserString(""));

        //Start the main game
        do {
            messageController.player1sTurn();
            playerController1.playerRoll();
            //gui.setDice(diceCup1.getFaceValueDie1(), diceCup1.getFaceValueDie2());

            if (player1.getWon()){
                break;
            }
            messageController.player2sTurn();
            playerController2.playerRoll();
            //gui.setDice(diceCup1.getFaceValueDie1(), diceCup1.getFaceValueDie2());

            if (player2.getWon()){
                break;
            }
        }
        //End the game when one of the players get 40 and a double - or to double 6.
        while(!player1.getWon() || !player2.getWon());

        //Give a message about who won the game
        messageController.playerHasWon();

        String svar = gui.getUserString("Vil du spille igen? tast ja/nej");
        if (svar.equals("ja"))
            playGame();
        else
            gui.showMessage("Farvel");
    }
}