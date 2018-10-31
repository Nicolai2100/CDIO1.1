package game.control;
import game.model.Dice;
import game.model.Message;
import game.model.DiceCup;
import game.model.Player;
import game.view.GUI2;
import gui_main.GUI;

public class GameEngine {

    public GameEngine(){ }

    //The method from where the game runs.
    public void playGame(){


        /*

        (Man kan ikke slå 1 med to terninger)
        Tower 		+250
        Crater 		-100
        Palace gates		+100
        Cold Desert	 	-20
        Walled city 		+180
        Monastery 		0
        Black cave 		-70
        Huts in the mountain 		+60
        The Werewall (werewolf-wall)		-80,	men spilleren får en ekstra tur.
                The pit 		-50
        Goldmine 		+650
*/


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


        //Controller
        PlayerController playerController1 = new PlayerController(player1, diceCupController, diceController1,
                diceController2);
        PlayerController playerController2 = new PlayerController(player2, diceCupController, diceController1,
                diceController2);
        MessageController messageController = new MessageController(message, player1, player2);


        //View
        GUI2 guiKlasse = new GUI2(playerController1, playerController2, messageController, diceCupController);
        //    GUI gui = guiKlasse.guiCreator();
        //Method that gives an introduction to the game. Rules, etc.
        guiKlasse.startGameGui();

        //Set player 1 name
        guiKlasse.enterNamePlayer1();
        //Set player 2 name
        guiKlasse.enterNamePlayer2();
        //player2.setName(gui.getUserString(""));

        //Start the main game
        do {
           // messageController.player1sTurn();
            playerController1.playerRoll();
            //gui.setDice(diceCup1.getFaceValueDie1(), diceCup1.getFaceValueDie2());

            if (player1.getWon()){
                break;
            }
            //messageController.player2sTurn();
            playerController2.playerRoll();
            //gui.setDice(diceCup1.getFaceValueDie1(), diceCup1.getFaceValueDie2());

            if (player2.getWon()){
                break;
            }
        }
        //End the game when one of the players get 40 and a double - or to double 6.
        while(!player1.getWon() || !player2.getWon());

        //Give a message about who won the game
        //messageController.playerHasWon();

        /*String svar = gui.getUserString("Vil du spille igen? tast ja/nej");
        if (svar.equals("ja"))
            playGame();
        else{
            gui.showMessage("Farvel");
            System.exit(1);

        }*/
    }
}