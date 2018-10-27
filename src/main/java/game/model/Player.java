package game.model;

import game.control.PlayerController;
import gui_main.GUI;

public class Player {
    private String name = "1";
    private String playerRollSumString;
    private int playerRollSum;
    private int playerSumSoFar = 0;
    private int lastRollSum;
    private boolean doubleSixBool = false;
    private boolean won = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getWon(){
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }
    public int getPlayerSumSoFar() {
        return playerSumSoFar;
    }

    public void setPlayerSumSoFar(int playerSumSoFar) {
        this.playerSumSoFar = playerSumSoFar;
    }

    public int getLastRollSum() {
        return lastRollSum;
    }

    public void setLastRollSum(int lastRollSum) {
        this.lastRollSum = lastRollSum;
    }

    public int getPlayerRollSum() {
        return playerRollSum;
    }

    public void setPlayerRollSum(int playerRollSum) {
        this.playerRollSum = playerRollSum;
    }

    public boolean getDoubleSixBool(){
        return doubleSixBool;
    }

    public void setPlayerRollSumString(String playerRollSumString) {
        this.playerRollSumString = playerRollSumString;
    }
    public String getPlayerRollSumString() {
        return playerRollSumString;
    }
}
