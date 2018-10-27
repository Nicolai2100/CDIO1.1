package game.model;

public class Message {

    private Player player1, player2, theVictor;

    public Message(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    private String startGameS = "Welcome to the game.Dice Game! \n" +
                "The game.Dice Game is a game between two persons. Each player takes turns throwing two dice in a dice cup.\n" +
                "The sum of the dice is added as points to the players total sum.\n"+
                "The one who gets 40 points and a roll with two dice of equal value wins!\n" +
                "Special rules: If a player rolls two dice with the value of 1, the player looses all points.\n" +
                "If a player roll two dice of equal value, he gets an extra turn.\n" +
                "If a player two times in a row rolls both dice with the value of 6, he wins.\n"+
                "\nTo decide who begins, the players must roll the dice, the youngest person rolls first, then"+
                "\nthe other person rolls. The person with the highest number enters their name first."+
                "\nIf the players get the same number, the youngest person enters their name first.\n";

    public String getStartGameS() {
        return startGameS;
    }


    private String enterNamePlayer1 = "\nPlease enter the name of player 1.";

    public String getEnterNamePlayer1() {
        return enterNamePlayer1;
    }

    private String enterNamePlayer2 = "Please enter the name of player 2.";

    public String getEnterNamePlayer2() {
        return enterNamePlayer2;
    }

    private String player1sTurn = "It's " + player1.getName() + "'s turn! Press Enter to roll!";

    public String getPlayer1sTurn() {
        return player1sTurn;
    }

    private String player2sTurn = "It's " + player2.getName() + "'s turn! Press enter to roll!";

    public String getPlayer2sTurn() {
        return player2sTurn;
    }

    private String playerWon = "You win because you have 40 points and got a double!";

    public String getPlayerWon() {
        return playerWon;
    }

    private String playerHaveAnExtraTurn = "You got two of equals! Roll again!";

    public String getPlayerHaveAnExtraTurn() {
        return playerHaveAnExtraTurn;
    }

    private String playerExtraTurnButLosePoints = "You got two 1's and lose all your points!"+ "\n" + "But you can Roll again!";

    public String getPlayerExtraTurnButLosePoints() {
        return playerExtraTurnButLosePoints;
    }
}