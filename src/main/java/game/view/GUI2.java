package game.view;

import game.control.*;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import java.awt.*;

public class GUI2 {

    private PlayerController player1, player2;
    private MessageController message;
    private DiceCupController diceCup;
    private DiceController diceController1, diceController2;
    private static GUI gui;
    private static GUI_Field[] felter;
    private GUI_Player guiPlayer1, guiPlayer2;

    public GUI2(PlayerController player1, PlayerController player2, MessageController message,
                DiceCupController diceCup, DiceController diceController1, DiceController diceController2) {
        felter = new  GUI_Field[12];
        for (int i = 0; i < felter.length; i++) {
            felter[i] = new GUI_Street("" + i, "", "", "", Color.YELLOW, Color.BLACK);
        }
        gui = new GUI(felter);

        this.player1 = player1;
        this.player2 = player2;
        this.message = message;
        this.diceCup = diceCup;
        this.diceController1 = diceController1;
        this.diceController2 = diceController2;
    }

    public static void guiCreator() {
        //felter = new GUI_Field[12];

        //for (int i = 0; i < felter.length; i++) {
        //    felter[i] = new GUI_Street("" + i, "", "", "", Color.YELLOW, Color.BLACK);
        //}
        //gui = new GUI(felter);

        felter[0].setTitle("Start");
        felter[0].setDescription("Start");
        felter[1].setTitle("Tower");
        felter[1].setDescription("+250");
        felter[2].setTitle("Crater");
        felter[2].setDescription("-11");
        felter[3].setTitle("Palace Gates");
        felter[3].setDescription("+100");
        felter[4].setTitle("Cold Desert");
        felter[4].setDescription("-20");
        felter[5].setTitle("Walled City");
        felter[5].setDescription("+180");
        felter[6].setTitle("Monastery");
        felter[7].setTitle("Black Cave");
        felter[8].setTitle("Huts in the mountain");
        felter[9].setTitle("The Werewall");
        felter[10].setTitle("The Pit");
        felter[11].setTitle("Goldmine");
    }

    public void setGameUpGui() {
        guiCreator();
        //GUI_Player
        GUI_Car[] car = new GUI_Car[2];
        for (int i = 0; i < car.length; i++) {
            car[i] = new GUI_Car();
        }
        //Type.RACECAR; hvordan sættes typen af bil?

        car[0].setPrimaryColor(Color.BLACK);
        car[1].setPrimaryColor(Color.BLUE);

        guiPlayer1 = new GUI_Player(player1.getName(), player1.getBalance(), car[0]);
        guiPlayer2 = new GUI_Player(player2.getName(), player2.getBalance(), car[1]);

        //    felter[0].hasCar(guiPlayer1);
        felter[player1.getSum()].setCar(guiPlayer1, true);
        felter[player2.getSum()].setCar(guiPlayer2, true);
    }

    public void startGameGui() {
        gui.showMessage(message.startGame());
    }

    public void enterNamePlayer1() {
        gui.showMessage(message.enterNamePlayer1());
        player1.setName(gui.getUserString(""));
    }

    public void enterNamePlayer2() {
        gui.showMessage(message.enterNamePlayer2());
        player2.setName(gui.getUserString(""));
    }

    public void setDiceGui() {
        gui.setDice(diceController1.getFaceValue(), diceController2.getFaceValue());
    }

    public void player1TurnGui() {
        gui.showMessage(message.player1sTurn());
    }

    public void player2TurnGui() {
        gui.showMessage(message.player2sTurn());
    }

    public void setPlayer1Car() {
        felter[player1.getSum()].setCar(guiPlayer1, true);
    }

    public void setPlayer2Car() {
        felter[player2.getSum()].setCar(guiPlayer2, true);
    }

    public void showScore(PlayerController player) {
        gui.showMessage(player.getName() + " har nu " + player.getSumSofar() + "point");
    }

    public void player1TurnUpdate(PlayerController player) {
        setDiceGui();
        setPlayer1Car();
        showScore(player);
    }

    public void player2TurnUpdate(PlayerController player) {
        setDiceGui();
        setPlayer2Car();
        showScore(player);
    }
    public void playerWonGui(){
        gui.showMessage(message.playerHasWon());
    }
    public void playAgain(){
        String svar = gui.getUserString("Vil du spille igen? tast ja/nej");
        if (svar.equals("ja"))
            GameEngine.playGame();
        else{
            gui.showMessage("Farvel");
            System.exit(1);
        }
    }
    /*Bilag 1 Metoder i GUI'en (teksten er fra javadoc, derfor er den på engelsk)

public static void addPlayer(String name, int balance, int r, int g, int b)
Adds a player to the board.
Max. 6 players.
name : String (Mind the length!) (Unique identifier of the player - no duplicates)
balance : int
r The RED part of the player color
g The GREEN part of the player color
b The BLUE part of the player color

public static void addPlayer(String name, int balance, Color color)
Adds a player to the board.
Max. 6 players.
name : String (Mind the length!) (Unique identifier of the player - no duplicates)
balance : int
color : Color

public static void setBalance(String name, int newBalance)
Sets the balance of a player if the player has been added.
name The name of the player
newBalance : int

public static void setCar(int fieldNumber, String name)
Places a car on the field.
All cars can be placed on the same field.
A car can only be placed if the corresponding player has been added.
If a car is placed on the same field multiple times, nothing more happens.
A car can not be placed on multiple fields simultaneously.
fieldNumber : int [1:40]
name The name of the player

public static void removeCar(int fieldNumber, String name)
Removes a car from the board.
If the car is not on the board, nothing happens.
fieldNumber : int [1:40]
name The name of the player

public static void removeAllCars(String name)
Removes all cars belonging to this player.
name The name of the player.*/

}
