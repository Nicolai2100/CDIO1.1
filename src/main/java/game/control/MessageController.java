package game.control;

import game.model.Message;
import game.model.Player;
import gui_main.GUI;

public class MessageController {

    Message model;
    Player player1,player2, theVictor;

        public MessageController(Message model, Player player1, Player player2){
            this.model = model;
            this.player1 = player1;
            this.player2 = player2;
        }


        public void playerHasWon(){
            if (player1.getWon()){
                theVictor = player1;
            } else {
                theVictor = player2;
            }
            String playerWonString = "Congratulations " + theVictor.getName() + "! You are victorious!";
        }
        public String player1sTurn(){ String returnString = ("It's " + player1.getName() + "'s turn! Press Enter to roll!");
        return returnString;
        }

        public String player2sTurn(){
            String returnString = ("It's " + player2.getName() + "'s turn! Press enter to roll!");
            return returnString;
        }

        public String startGame(){
            String returnString = (model.getStartGameS());
            return returnString;
        }

        public String enterNamePlayer1(){
            String returnString = (model.getEnterNamePlayer1());return returnString;
        }

        public String enterNamePlayer2(){
            String returnString = (model.getEnterNamePlayer2());return returnString;
        }

        public void playerWon()
        {
            String returnString = (model.getPlayerWon());
        }
        public void playerHaveAnExtraTurn(){
            String returnString = (model.getPlayerHaveAnExtraTurn());
        }
        public void playerExtraTurnButLosePoints(){
            String returnString = (model.getPlayerExtraTurnButLosePoints());
        }


}

