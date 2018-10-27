package game.control;

import game.model.Message;
import game.model.Player;
import gui_main.GUI;

public class MessageController {

    Message model;
    GUI gui;
    Player player1,player2, theVictor;

        public MessageController(Message model, Player player1, Player player2, GUI gui){
            this.model = model;
            this.player1 = player1;
            this.player2 = player2;
            this.gui = gui;
        }

    public void playerHasWon(){
        if (player1.getWon()){
            theVictor = player1;
        } else {
            theVictor = player2;
        }
        gui.showMessage("Congratulations " + theVictor.getName() + "! You are victorious!");
    }

        public void startGame(){
            gui.showMessage(model.getStartGameS());
        }

        public void enterNamePlayer1(){
            gui.showMessage(model.getEnterNamePlayer1());
        }

        public void enterNamePlayer2(){
            gui.showMessage(model.getEnterNamePlayer2());
        }
        public void player1sTurn(){
            gui.showMessage(model.getPlayer1sTurn());
        }
        public void player2sTurn(){
            gui.showMessage(model.getPlayer2sTurn());
        }
        public void playerWon()
        {
            gui.showMessage(model.getPlayerWon());
        }
        public void playerHaveAnExtraTurn(){
            gui.showMessage(model.getPlayerHaveAnExtraTurn());
        }
        public void playerExtraTurnButLosePoints(){
            gui.showMessage(model.getPlayerExtraTurnButLosePoints());
        }

}

