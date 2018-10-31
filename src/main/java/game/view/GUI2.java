package game.view;

import game.control.*;
import game.model.DiceCup;
import game.model.Message;
import game.model.Player;
import gui_fields.GUI_Car;
import gui_fields.GUI_Car.Type;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static gui_fields.GUI_Car.Type.CAR;

public class GUI2{

    PlayerController player1, player2;
    MessageController message;
    DiceCupController diceCup;
    DiceController diceController1, diceController2;


    public GUI2(PlayerController player1, PlayerController player2, MessageController message,
                DiceCupController diceCup, DiceController diceController1, DiceController diceController2){
        this.player1 = player1;
        this.player2 = player2;
        this.message = message;
        this.diceCup = diceCup;
        this.diceController1 = diceController1;
        this.diceController2 = diceController2;

    }

    public void guiCreator(){
        GUI_Field[] felter = new GUI_Field[12];
        GUI gui = new GUI(felter);
        //GUI_Field
        //GUI.setNull_fields_allowed(true);
        for (int i = 0; i < felter.length; i++){
            felter[i]= new GUI_Street(""+i, "", "", "", Color.YELLOW, Color.BLACK);
        }

        //GUI_Car
        GUI_Car[] car = new GUI_Car[2];
        for (int i = 0; i < car.length; i++) {
            car[i]=new GUI_Car();
        }
        //Type.RACECAR; hvordan sættes typen af bil?

        car[0].setPrimaryColor(Color.BLACK);
        car[1].setPrimaryColor(Color.BLUE);

        //GUI_Player
        GUI_Player guiPlayer1 = new GUI_Player(player1.getName(), player1.getBalance(), car[0]);
        GUI_Player guiPlayer2 = new GUI_Player(player2.getName(), player2.getBalance(), car[1]);


    //    felter[0].hasCar(guiPlayer1);
    felter[player1.getSum()].setCar(guiPlayer1, true);
    felter[player2.getSum()].setCar(guiPlayer2, true);

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

    public void setGuiCar(){

    }

   public void startGameGui(){
       gui.showMessage(message.startGame());
   }

   public void enterNamePlayer1(){
       gui.showMessage(message.enterNamePlayer1());
       player1.setName(gui.getUserString(""));

   }
    public void enterNamePlayer2(){
    message.enterNamePlayer2();
    player2.setName(gui.getUserString(""));
    }
    public void setDiceGui(){
        gui.setDice(diceController1.getFaceValue(), diceController2.getFaceValue());
    }

    public void player1TurnGui(){
        gui.showMessage(message.player1sTurn());
    }
    public void player2TurnGui(){
        gui.showMessage(message.player2sTurn());
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
